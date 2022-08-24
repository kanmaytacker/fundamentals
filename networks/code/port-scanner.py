import argparse
import socket
from colorama import init, Fore

def is_port_open(host: str, port: int) -> bool:
    """
    Checks if a port is open on a host.
    """
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    try:
        sock.connect((host, port))
        sock.settimeout(0.5)
    except:
        return False
    else:
        return True


if __name__ == '__main__':
    
    init() # initialize colorama

    # Declare arguments
    parser = argparse.ArgumentParser(description='Port Scanner')
    parser.add_argument('-H', '--host', help='Host to scan', required=True, type=str)
    parser.add_argument('-s', '--start', help='Starting port', default=1, type=int)
    parser.add_argument('-e', '--end', help='Ending port', default=1024, type=int)

    # Parse arguments
    args = parser.parse_args()
    host, start, end = args.host, args.start, args.end

    for port in range(start, end):
        if not is_port_open(host, port):
            print(f'{Fore.RED}Port {port} is closed{Fore.RESET}')
            continue
        print(f'{Fore.GREEN}Port {port} is open{Fore.RESET}')        



