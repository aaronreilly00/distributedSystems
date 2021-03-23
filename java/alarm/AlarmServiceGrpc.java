package alarm;

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
    comments = "Source: alarm.proto")
public final class AlarmServiceGrpc {

  private AlarmServiceGrpc() {}

  public static final String SERVICE_NAME = "alarm.AlarmService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<alarm.Point,
      alarm.RouteNote> getRouteTrackingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "routeTracking",
      requestType = alarm.Point.class,
      responseType = alarm.RouteNote.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<alarm.Point,
      alarm.RouteNote> getRouteTrackingMethod() {
    io.grpc.MethodDescriptor<alarm.Point, alarm.RouteNote> getRouteTrackingMethod;
    if ((getRouteTrackingMethod = AlarmServiceGrpc.getRouteTrackingMethod) == null) {
      synchronized (AlarmServiceGrpc.class) {
        if ((getRouteTrackingMethod = AlarmServiceGrpc.getRouteTrackingMethod) == null) {
          AlarmServiceGrpc.getRouteTrackingMethod = getRouteTrackingMethod = 
              io.grpc.MethodDescriptor.<alarm.Point, alarm.RouteNote>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "alarm.AlarmService", "routeTracking"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  alarm.Point.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  alarm.RouteNote.getDefaultInstance()))
                  .setSchemaDescriptor(new AlarmServiceMethodDescriptorSupplier("routeTracking"))
                  .build();
          }
        }
     }
     return getRouteTrackingMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AlarmServiceStub newStub(io.grpc.Channel channel) {
    return new AlarmServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AlarmServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AlarmServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AlarmServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AlarmServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class AlarmServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<alarm.Point> routeTracking(
        io.grpc.stub.StreamObserver<alarm.RouteNote> responseObserver) {
      return asyncUnimplementedStreamingCall(getRouteTrackingMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRouteTrackingMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                alarm.Point,
                alarm.RouteNote>(
                  this, METHODID_ROUTE_TRACKING)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class AlarmServiceStub extends io.grpc.stub.AbstractStub<AlarmServiceStub> {
    private AlarmServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AlarmServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlarmServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AlarmServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<alarm.Point> routeTracking(
        io.grpc.stub.StreamObserver<alarm.RouteNote> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getRouteTrackingMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class AlarmServiceBlockingStub extends io.grpc.stub.AbstractStub<AlarmServiceBlockingStub> {
    private AlarmServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AlarmServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlarmServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AlarmServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class AlarmServiceFutureStub extends io.grpc.stub.AbstractStub<AlarmServiceFutureStub> {
    private AlarmServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AlarmServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlarmServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AlarmServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_ROUTE_TRACKING = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AlarmServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AlarmServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ROUTE_TRACKING:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.routeTracking(
              (io.grpc.stub.StreamObserver<alarm.RouteNote>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class AlarmServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AlarmServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return alarm.AlarmServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AlarmService");
    }
  }

  private static final class AlarmServiceFileDescriptorSupplier
      extends AlarmServiceBaseDescriptorSupplier {
    AlarmServiceFileDescriptorSupplier() {}
  }

  private static final class AlarmServiceMethodDescriptorSupplier
      extends AlarmServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AlarmServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AlarmServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AlarmServiceFileDescriptorSupplier())
              .addMethod(getRouteTrackingMethod())
              .build();
        }
      }
    }
    return result;
  }
}
