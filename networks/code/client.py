from concurrent.futures import thread
import socket
import argparse
from threading import Thread
import time

def main(host: str, port: int, index: int) -> None:

    # Create a socket object
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    sock.connect((host, port))
    print(f"Connected socket {sock.getsockname()} to {sock.getpeername()}")

    data_to_send = bytes(f"Hello, world {index}".encode('utf-8'))
    print(f"Sending data: {data_to_send}")
    sock.sendall(data_to_send)

    data = sock.recv(1024)
    print(f"Received data: {data} \n")

    sock.close()


if __name__ == '__main__':
    
    # Declare arguments
    parser = argparse.ArgumentParser(description='Socket server')
    parser.add_argument('-H', '--host', help='Target host', default='127.0.0.1', type=str)
    parser.add_argument('-p', '--port', help='Target port', required=True, type=int)

    # Parse arguments
    args = parser.parse_args()
    host, port = args.host, args.port

    for index in range(10):
        thread = Thread(target=main, args=(host, port, index + 1))
        thread.start()
        time.sleep(0.2)
