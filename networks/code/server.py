import socket
import argparse
from threading import Thread

def handleConnection(conn) -> None:
    print(f"Connection from {conn.getsockname()} to {conn.getpeername()}")
        
    data = conn.recv(1024)
    print(f"Received data: {data}")
        
    conn.sendall(data.upper())
    conn.close()

def main(host: str, port:int) -> None:

    # Create a socket object
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    # Bind the socket to the port
    try:
        sock.bind((host, port))
    except socket.error as e :
        print(f"Error in binding host and port: {e}")

    # Listen for incoming connections
    sock.listen()
    print(f"Server is listening on port {port}")

    while True:
        # Accept connections from outside
        conn, _ = sock.accept()

        # Delegate the connection to a thread
        thread = Thread(target=handleConnection, args=(conn,))
        thread.start()



if __name__ == '__main__':
    
    # Declare arguments
    parser = argparse.ArgumentParser(description='Socket server')
    parser.add_argument('-p', '--port', help='Port to bind to', required=True, type=int)
    parser.add_argument('-H', '--host', help='Host to bind to', default='127.0.0.1', type=str)

    # Parse arguments
    args = parser.parse_args()
    host, port = args.host, args.port

    main(host, port)

