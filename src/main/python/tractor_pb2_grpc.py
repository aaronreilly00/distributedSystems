# Generated by the gRPC Python protocol compiler plugin. DO NOT EDIT!
"""Client and server classes corresponding to protobuf-defined services."""
import grpc

import tractor_pb2 as tractor__pb2


class TractorServiceStub(object):
    """The greeting service definition.
    """

    def __init__(self, channel):
        """Constructor.

        Args:
            channel: A grpc.Channel.
        """
        self.TractorDetails = channel.unary_unary(
                '/tractor.TractorService/TractorDetails',
                request_serializer=tractor__pb2.TractorRequest.SerializeToString,
                response_deserializer=tractor__pb2.TractorResponse.FromString,
                )


class TractorServiceServicer(object):
    """The greeting service definition.
    """

    def TractorDetails(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')


def add_TractorServiceServicer_to_server(servicer, server):
    rpc_method_handlers = {
            'TractorDetails': grpc.unary_unary_rpc_method_handler(
                    servicer.TractorDetails,
                    request_deserializer=tractor__pb2.TractorRequest.FromString,
                    response_serializer=tractor__pb2.TractorResponse.SerializeToString,
            ),
    }
    generic_handler = grpc.method_handlers_generic_handler(
            'tractor.TractorService', rpc_method_handlers)
    server.add_generic_rpc_handlers((generic_handler,))


 # This class is part of an EXPERIMENTAL API.
class TractorService(object):
    """The greeting service definition.
    """

    @staticmethod
    def TractorDetails(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/tractor.TractorService/TractorDetails',
            tractor__pb2.TractorRequest.SerializeToString,
            tractor__pb2.TractorResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)
