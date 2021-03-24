package livestock;

import java.io.IOException;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import livestock.LivestockServiceGrpc.LivestockServiceImplBase;

public class LivestockServer extends LivestockServiceImplBase{

	public static void main(String[] args) throws InterruptedException, IOException {
		LivestockServer livestockService = new LivestockServer();

		int port = 50051;

		Server server = ServerBuilder.forPort(port).addService(livestockService).build().start();

		System.out.println("Service-1 started, listening on " + port);

		server.awaitTermination();
	}

	//@Override
	public void livestock(LivestockRequest request, StreamObserver<LivestockResponse> responseObserver) {

		// prepare the value to be set back
		String tag = request.getTag();

		// preparing the response message
		LivestockResponse reply = LivestockResponse.newBuilder().setTag(tag).setGender("female").setDob("09/08/2020").setTemperature("37")
				.setFeedTime("15:00").setLatitude(57.5555D).setLongitude(-1.1111D).build();

		responseObserver.onNext(reply);

		responseObserver.onCompleted();

	}
}