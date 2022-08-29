import argparse
import random
from typing import List
from urllib import request, error
import json
from models import Students

API_URL = "https://randomuser.me/api"


def generate_user(count: int):
    url = API_URL + f"?results={count}"
    users = json.loads(request.urlopen(url).read())
    return users['results']

def to_student(user: dict) -> Students:
    student = Students()
    student.first_name = user['name']['first']
    student.last_name = user['name']['last']
    student.email = user['email']
    # random choice from batches 1 - 6
    student.batch = random.randint(1, 6)
    student.address = f"{user['location']['city']}, {user['location']['state']}, {user['location']['country']}"
    student.birth_date = user['dob']['date'].split("T")[0]
    return student

def main(count: int, filename: str) -> None:
    with open(filename, "w") as f:
        users = generate_user(count)
        print(f"Generated {len(users)} users")

        students: List[Students] = [to_student(user) for user in users]
        Students.bulk_create(students, batch_size=100)
        print(f"Saved {len(students)} students")

if __name__ == "__main__":

    # Declare arguments
    parser = argparse.ArgumentParser(description="Student generator")
    parser.add_argument(
        "-n", "--number", type=int, default=10, help="Number of students to generate"
    )
    parser.add_argument(
        "-f", "--file", type=str, default="students.txt", help="File to write to"
    )
    args = parser.parse_args()

    students_count, file_name = args.number, args.file
    main(students_count, file_name)
