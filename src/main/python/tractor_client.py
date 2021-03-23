from __future__ import print_function
import logging

import grpc

import tractor_pb2
import tractor_pb2_grpc


def run():
    # NOTE(gRPC Python Team): .close() is possible on a channel and should be
    # used in circumstances in which the with statement does not fit the needs
    # of the code.
    with grpc.insecure_channel('localhost:50067') as channel:
        stub = tractor_pb2_grpc.TractorServiceStub(channel)
        response = stub.TractorDetails(tractor_pb2.TractorRequest(name='Kubota'))
        print("Tractor details received: " + response.message)

if __name__ == '__main__':
    logging.basicConfig()
    run()



