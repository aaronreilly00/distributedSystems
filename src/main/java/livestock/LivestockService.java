package livestock;

import java.io.IOException;

import livestock.LivestockRequest;
import livestock.LivestockResponse;
import livestock.LivestockServiceGrpc.LivestockServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerServiceDefinition;
import io.grpc.stub.StreamObserver;

public class LivestockService extends LivestockServiceImplBase{

	public static void main(String[] args) throws InterruptedException, IOException {
		LivestockService livestockService = new LivestockService();

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
		LivestockResponse reply = LivestockResponse.newBuilder().setTag(tag).build();

		responseObserver.onNext(reply);

		responseObserver.onCompleted();

	}
}