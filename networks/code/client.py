import socket
import argparse

def main(host: str, port: int) -> None:

    # Create a socket object
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    # Connect to the server
    sock.connect((host, port))

    print(f'Connected from {sock.getsockname()} to {sock.getpeername()}')

    # Send data
    sock.sendall(b'Hello, world')

    # Receive data
    data = sock.recv(1024)

    # Print data
    print(f'Received {data}')

if __name__ == '__main__':

    # Declare arguments
    parser = argparse.ArgumentParser(description='Socket server')
    parser.add_argument('-H', '--host', help='Target host', default='127.0.0.1', type=str)
    parser.add_argument('-p', '--port', help='Target port', required=True, type=int)

    # Parse arguments
    args = parser.parse_args()
    host, port = args.host, args.port

    main(host, port)