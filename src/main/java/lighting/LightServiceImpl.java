// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: lighting.proto

package lighting;

public final class LightServiceImpl {
  private LightServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_lighting_PowerRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_lighting_PowerRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_lighting_PowerResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_lighting_PowerResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_lighting_LightRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_lighting_LightRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_lighting_LightResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_lighting_LightResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016lighting.proto\022\010lighting\"\036\n\014PowerReque" +
      "st\022\016\n\006switch\030\001 \001(\010\"\037\n\rPowerResponse\022\016\n\006s" +
      "witch\030\001 \001(\010\"\035\n\014LightRequest\022\r\n\005light\030\001 \001" +
      "(\005\"\036\n\rLightResponse\022\r\n\005light\030\001 \001(\0052\222\001\n\014L" +
      "ightService\022@\n\013switchPower\022\026.lighting.Po" +
      "werRequest\032\027.lighting.PowerResponse\"\000\022@\n" +
      "\013changeLight\022\026.lighting.LightRequest\032\027.l" +
      "ighting.LightResponse(\001B\036\n\010lightingB\020Lig" +
      "htServiceImplP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_lighting_PowerRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_lighting_PowerRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_lighting_PowerRequest_descriptor,
        new java.lang.String[] { "Switch", });
    internal_static_lighting_PowerResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_lighting_PowerResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_lighting_PowerResponse_descriptor,
        new java.lang.String[] { "Switch", });
    internal_static_lighting_LightRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_lighting_LightRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_lighting_LightRequest_descriptor,
        new java.lang.String[] { "Light", });
    internal_static_lighting_LightResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_lighting_LightResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_lighting_LightResponse_descriptor,
        new java.lang.String[] { "Light", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}