package lighting;

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
    comments = "Source: lighting.proto")
public final class LightServiceGrpc {

  private LightServiceGrpc() {}

  public static final String SERVICE_NAME = "lighting.LightService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<lighting.PowerRequest,
      lighting.PowerResponse> getSwitchPowerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "switchPower",
      requestType = lighting.PowerRequest.class,
      responseType = lighting.PowerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<lighting.PowerRequest,
      lighting.PowerResponse> getSwitchPowerMethod() {
    io.grpc.MethodDescriptor<lighting.PowerRequest, lighting.PowerResponse> getSwitchPowerMethod;
    if ((getSwitchPowerMethod = LightServiceGrpc.getSwitchPowerMethod) == null) {
      synchronized (LightServiceGrpc.class) {
        if ((getSwitchPowerMethod = LightServiceGrpc.getSwitchPowerMethod) == null) {
          LightServiceGrpc.getSwitchPowerMethod = getSwitchPowerMethod = 
              io.grpc.MethodDescriptor.<lighting.PowerRequest, lighting.PowerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lighting.LightService", "switchPower"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lighting.PowerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lighting.PowerResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightServiceMethodDescriptorSupplier("switchPower"))
                  .build();
          }
        }
     }
     return getSwitchPowerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<lighting.LightRequest,
      lighting.LightResponse> getChangeLightMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "changeLight",
      requestType = lighting.LightRequest.class,
      responseType = lighting.LightResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<lighting.LightRequest,
      lighting.LightResponse> getChangeLightMethod() {
    io.grpc.MethodDescriptor<lighting.LightRequest, lighting.LightResponse> getChangeLightMethod;
    if ((getChangeLightMethod = LightServiceGrpc.getChangeLightMethod) == null) {
      synchronized (LightServiceGrpc.class) {
        if ((getChangeLightMethod = LightServiceGrpc.getChangeLightMethod) == null) {
          LightServiceGrpc.getChangeLightMethod = getChangeLightMethod = 
              io.grpc.MethodDescriptor.<lighting.LightRequest, lighting.LightResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "lighting.LightService", "changeLight"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lighting.LightRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lighting.LightResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightServiceMethodDescriptorSupplier("changeLight"))
                  .build();
          }
        }
     }
     return getChangeLightMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LightServiceStub newStub(io.grpc.Channel channel) {
    return new LightServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LightServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LightServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LightServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LightServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class LightServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void switchPower(lighting.PowerRequest request,
        io.grpc.stub.StreamObserver<lighting.PowerResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSwitchPowerMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<lighting.LightRequest> changeLight(
        io.grpc.stub.StreamObserver<lighting.LightResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getChangeLightMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSwitchPowerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lighting.PowerRequest,
                lighting.PowerResponse>(
                  this, METHODID_SWITCH_POWER)))
          .addMethod(
            getChangeLightMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                lighting.LightRequest,
                lighting.LightResponse>(
                  this, METHODID_CHANGE_LIGHT)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class LightServiceStub extends io.grpc.stub.AbstractStub<LightServiceStub> {
    private LightServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightServiceStub(channel, callOptions);
    }

    /**
     */
    public void switchPower(lighting.PowerRequest request,
        io.grpc.stub.StreamObserver<lighting.PowerResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSwitchPowerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<lighting.LightRequest> changeLight(
        io.grpc.stub.StreamObserver<lighting.LightResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getChangeLightMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class LightServiceBlockingStub extends io.grpc.stub.AbstractStub<LightServiceBlockingStub> {
    private LightServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public lighting.PowerResponse switchPower(lighting.PowerRequest request) {
      return blockingUnaryCall(
          getChannel(), getSwitchPowerMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class LightServiceFutureStub extends io.grpc.stub.AbstractStub<LightServiceFutureStub> {
    private LightServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<lighting.PowerResponse> switchPower(
        lighting.PowerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSwitchPowerMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SWITCH_POWER = 0;
  private static final int METHODID_CHANGE_LIGHT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LightServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LightServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SWITCH_POWER:
          serviceImpl.switchPower((lighting.PowerRequest) request,
              (io.grpc.stub.StreamObserver<lighting.PowerResponse>) responseObserver);
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
        case METHODID_CHANGE_LIGHT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.changeLight(
              (io.grpc.stub.StreamObserver<lighting.LightResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class LightServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LightServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return lighting.LightServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LightService");
    }
  }

  private static final class LightServiceFileDescriptorSupplier
      extends LightServiceBaseDescriptorSupplier {
    LightServiceFileDescriptorSupplier() {}
  }

  private static final class LightServiceMethodDescriptorSupplier
      extends LightServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LightServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (LightServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LightServiceFileDescriptorSupplier())
              .addMethod(getSwitchPowerMethod())
              .addMethod(getChangeLightMethod())
              .build();
        }
      }
    }
    return result;
  }
}
