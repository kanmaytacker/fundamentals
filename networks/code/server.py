import socket
import argparse
import time


def main(host: str, port: int) -> None:

    # Create a socket object
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    # Bind the socket to the address
    sock.bind((host, port))

    # Listen for incoming connections
    sock.listen()

    print(f"Listening at {sock.getsockname()}")

    while True:
        # Accept connections
        conn, _ = sock.accept()
        print(f"Connection from {conn.getsockname()} to {conn.getpeername()}")

        # Receive data
        data = conn.recv(1024)

        # Print data
        print(f"Received {data}")

        # Wait for some time
        time.sleep(5)

        # Send echo
        conn.sendall(data.upper())

        # Close the connection
        conn.close()


if __name__ == "__main__":

    # Declare arguments
    parser = argparse.ArgumentParser(description="Socket server")
    parser.add_argument("-p", "--port", help="Port to bind to", required=True, type=int)
    parser.add_argument(
        "-H", "--host", help="Host to bind to", default="127.0.0.1", type=str
    )

    # Parse arguments
    args = parser.parse_args()
    host, port = args.host, args.port
    main(host, port)
