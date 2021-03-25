from concurrent import futures
import logging

import grpc

import tractor_pb2
import tractor_pb2_grpc

class TractorService(tractor_pb2_grpc.TractorServiceServicer):

    def TractorDetails(self, request, context):
        return tractor_pb2.TractorResponse(message='Brand, %s needs to be serviced!' % request.name)
        

def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    tractor_pb2_grpc.add_TractorServiceServicer_to_server(TractorService(), server)
    server.add_insecure_port('[::]:50067')
    server.start()
    server.wait_for_termination()


if __name__ == '__main__':
    logging.basicConfig()
    serve()

   