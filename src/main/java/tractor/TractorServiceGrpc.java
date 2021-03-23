package tractor;

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
 * The greeting service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: tractor.proto")
public final class TractorServiceGrpc {

  private TractorServiceGrpc() {}

  public static final String SERVICE_NAME = "tractor.TractorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<tractor.TractorRequest,
      tractor.TractorResponse> getTractorDetailsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TractorDetails",
      requestType = tractor.TractorRequest.class,
      responseType = tractor.TractorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<tractor.TractorRequest,
      tractor.TractorResponse> getTractorDetailsMethod() {
    io.grpc.MethodDescriptor<tractor.TractorRequest, tractor.TractorResponse> getTractorDetailsMethod;
    if ((getTractorDetailsMethod = TractorServiceGrpc.getTractorDetailsMethod) == null) {
      synchronized (TractorServiceGrpc.class) {
        if ((getTractorDetailsMethod = TractorServiceGrpc.getTractorDetailsMethod) == null) {
          TractorServiceGrpc.getTractorDetailsMethod = getTractorDetailsMethod = 
              io.grpc.MethodDescriptor.<tractor.TractorRequest, tractor.TractorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "tractor.TractorService", "TractorDetails"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  tractor.TractorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  tractor.TractorResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TractorServiceMethodDescriptorSupplier("TractorDetails"))
                  .build();
          }
        }
     }
     return getTractorDetailsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TractorServiceStub newStub(io.grpc.Channel channel) {
    return new TractorServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TractorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TractorServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TractorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TractorServiceFutureStub(channel);
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static abstract class TractorServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void tractorDetails(tractor.TractorRequest request,
        io.grpc.stub.StreamObserver<tractor.TractorResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getTractorDetailsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getTractorDetailsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                tractor.TractorRequest,
                tractor.TractorResponse>(
                  this, METHODID_TRACTOR_DETAILS)))
          .build();
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class TractorServiceStub extends io.grpc.stub.AbstractStub<TractorServiceStub> {
    private TractorServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TractorServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TractorServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TractorServiceStub(channel, callOptions);
    }

    /**
     */
    public void tractorDetails(tractor.TractorRequest request,
        io.grpc.stub.StreamObserver<tractor.TractorResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTractorDetailsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class TractorServiceBlockingStub extends io.grpc.stub.AbstractStub<TractorServiceBlockingStub> {
    private TractorServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TractorServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TractorServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TractorServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public tractor.TractorResponse tractorDetails(tractor.TractorRequest request) {
      return blockingUnaryCall(
          getChannel(), getTractorDetailsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class TractorServiceFutureStub extends io.grpc.stub.AbstractStub<TractorServiceFutureStub> {
    private TractorServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TractorServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TractorServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TractorServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<tractor.TractorResponse> tractorDetails(
        tractor.TractorRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getTractorDetailsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TRACTOR_DETAILS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TractorServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TractorServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TRACTOR_DETAILS:
          serviceImpl.tractorDetails((tractor.TractorRequest) request,
              (io.grpc.stub.StreamObserver<tractor.TractorResponse>) responseObserver);
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

  private static abstract class TractorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TractorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return tractor.TractorServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TractorService");
    }
  }

  private static final class TractorServiceFileDescriptorSupplier
      extends TractorServiceBaseDescriptorSupplier {
    TractorServiceFileDescriptorSupplier() {}
  }

  private static final class TractorServiceMethodDescriptorSupplier
      extends TractorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TractorServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TractorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TractorServiceFileDescriptorSupplier())
              .addMethod(getTractorDetailsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
