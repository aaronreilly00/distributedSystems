package livestock;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Interface exported by the server.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: livestock.proto")
public final class LivestockServiceGrpc {

  private LivestockServiceGrpc() {}

  public static final String SERVICE_NAME = "livestock.LivestockService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<livestock.LivestockRequest,
      livestock.LivestockResponse> getLivestockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "livestock",
      requestType = livestock.LivestockRequest.class,
      responseType = livestock.LivestockResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<livestock.LivestockRequest,
      livestock.LivestockResponse> getLivestockMethod() {
    io.grpc.MethodDescriptor<livestock.LivestockRequest, livestock.LivestockResponse> getLivestockMethod;
    if ((getLivestockMethod = LivestockServiceGrpc.getLivestockMethod) == null) {
      synchronized (LivestockServiceGrpc.class) {
        if ((getLivestockMethod = LivestockServiceGrpc.getLivestockMethod) == null) {
          LivestockServiceGrpc.getLivestockMethod = getLivestockMethod = 
              io.grpc.MethodDescriptor.<livestock.LivestockRequest, livestock.LivestockResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "livestock.LivestockService", "livestock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  livestock.LivestockRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  livestock.LivestockResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LivestockServiceMethodDescriptorSupplier("livestock"))
                  .build();
          }
        }
     }
     return getLivestockMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LivestockServiceStub newStub(io.grpc.Channel channel) {
    return new LivestockServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LivestockServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LivestockServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LivestockServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LivestockServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class LivestockServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void livestock(livestock.LivestockRequest request,
        io.grpc.stub.StreamObserver<livestock.LivestockResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLivestockMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLivestockMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                livestock.LivestockRequest,
                livestock.LivestockResponse>(
                  this, METHODID_LIVESTOCK)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class LivestockServiceStub extends io.grpc.stub.AbstractStub<LivestockServiceStub> {
    private LivestockServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LivestockServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LivestockServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LivestockServiceStub(channel, callOptions);
    }

    /**
     */
    public void livestock(livestock.LivestockRequest request,
        io.grpc.stub.StreamObserver<livestock.LivestockResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getLivestockMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class LivestockServiceBlockingStub extends io.grpc.stub.AbstractStub<LivestockServiceBlockingStub> {
    private LivestockServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LivestockServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LivestockServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LivestockServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<livestock.LivestockResponse> livestock(
        livestock.LivestockRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getLivestockMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class LivestockServiceFutureStub extends io.grpc.stub.AbstractStub<LivestockServiceFutureStub> {
    private LivestockServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LivestockServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LivestockServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LivestockServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_LIVESTOCK = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LivestockServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LivestockServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIVESTOCK:
          serviceImpl.livestock((livestock.LivestockRequest) request,
              (io.grpc.stub.StreamObserver<livestock.LivestockResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class LivestockServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LivestockServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return livestock.LivestockServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LivestockService");
    }
  }

  private static final class LivestockServiceFileDescriptorSupplier
      extends LivestockServiceBaseDescriptorSupplier {
    LivestockServiceFileDescriptorSupplier() {}
  }

  private static final class LivestockServiceMethodDescriptorSupplier
      extends LivestockServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LivestockServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (LivestockServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LivestockServiceFileDescriptorSupplier())
              .addMethod(getLivestockMethod())
              .build();
        }
      }
    }
    return result;
  }
}
