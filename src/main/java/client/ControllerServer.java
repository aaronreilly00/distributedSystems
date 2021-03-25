package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

public class ControllerServer {
    public static void main(String[] args) throws IOException {
        int port = 9090;
        JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

        // Register a service
        ServiceInfo serviceInfo = ServiceInfo.create("_smartFarming._tcp.local.", "date", port, "Client Server will give you the current date");
        jmdns.registerService(serviceInfo);
        System.out.println("Starting the client server");

       
        ServerSocket listener = new ServerSocket(9090);
        try {
            while (true) {
                Socket socket = listener.accept();
                try {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println(new Date().toString());
                } finally {
                    socket.close();
                }
            }
        } finally {
            listener.close();
        }
    }

}
