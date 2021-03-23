package lighting;
import java.io.IOException;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerServiceDefinition;
import io.grpc.stub.StreamObserver;
import lighting.LightServiceGrpc.LightServiceImplBase;
import io.grpc.stub.StreamObserver;



public class LightingServer extends LightServiceImplBase{

	private static final Logger logger = Logger.getLogger(LightingServer.class.getName());
	
	public static void main(String[] args) throws IOException,InterruptedException {
		//Create a server, port 5055
		LightingServer lightingServer = new LightingServer();
		
		int port = 50055;
	    Server server = ServerBuilder.forPort(port)
	        .addService(lightingServer)
	        .build()
	        .start();
	    
	    logger.info("Server started, listening on " + port);
	    		    
	    server.awaitTermination();

	}
	
	public void switchPower(PowerRequest request, StreamObserver<PowerResponse> responseObserver) {
		// Print a message stating the function has been invoked
        System.out.println("Receiving request for power!");
        // Get the switch variable
        Boolean power = request.getSwitch();
        if (power) {
        	System.out.println("Setting power to on!");
        }
        else {
        	System.out.println("Setting power to off!");
        }
        
        // Send a response with power value back
        PowerResponse response = PowerResponse.newBuilder().setSwitch(power).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

	}
	public StreamObserver<LightRequest> changeLight(final StreamObserver<LightResponse> responseObserver) {
		
		return new StreamObserver<LightRequest>() {
			// Setting a variable to be used
			int light = 0;
			
			public void onNext(LightRequest value) {
				// Print the request when receieved
				light = value.getLight();
				System.out.println("Request to turn brightness to -> " + light);
				
			}
			
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			public void onCompleted() {
				// Send the response
				LightResponse response = LightResponse.newBuilder().setLight(light).build();
				responseObserver.onNext(response);
				responseObserver.onCompleted();
			}
		};
	}

}
