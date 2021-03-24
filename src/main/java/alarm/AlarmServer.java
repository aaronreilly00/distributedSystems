package alarm;

import java.io.IOException;
import java.util.logging.Logger;

import alarm.AlarmServiceGrpc.AlarmServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class AlarmServer extends AlarmServiceImplBase{

private static final Logger logger = Logger.getLogger(AlarmServer.class.getName());
	
	public static void main(String[] args) throws IOException, InterruptedException {
		AlarmServer alarmserver = new AlarmServer();
	   
		int port = 50053;
	    Server server = ServerBuilder.forPort(port)
	        .addService(alarmserver)
	        .build()
	        .start();
	    
	    logger.info("Server started, listening on " + port);
	    		    
	    server.awaitTermination();
	}
	
	
	public StreamObserver<Point> routeTracking(final StreamObserver<RouteNote> responseObserver) {
	      return new StreamObserver<Point>() {
	        public void onNext(Point request) {
	            double tracking;
	  
	            tracking = request.getLatitude() + request.getLongitude();
	            System.out.println(tracking);
	            
	        
	            RouteNote reply = RouteNote.newBuilder().setTag("Livestock with TAG ID COW123 is out of bounds").build();
	      
	            responseObserver.onNext(reply);
	          }

	        public void onError(Throwable t) {
	          System.out.println("Error, service stopped");
	        }
	        public void onCompleted() {
	          responseObserver.onCompleted();
	        }
	      };
	    }
}
