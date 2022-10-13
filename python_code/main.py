from oop.basic.OopBankAccount import OopBankAccount

from oop.inheritance.Student import *
from oop.inheritance.User import *
from oop.inheritance.StudentStatus import *

def main():
	#oop - basic
	abhi = OopBankAccount(100, 1)
	bob = OopBankAccount(200, 2)

	abhi.transfer(bob, 50)

	print(abhi.getBalance())

	#oop - inheritance

	sam = Student("sam", "abhi@a.cm", 25, "khulri", "Oct", 90, StudentStatus.ACTIVE)
	sam.print_details()

	# oop - inheritance and polymorphism

	student = Student("Student", "stu@scaler", "batch", 100)
	student.__class__ = User
	student.print_details()

	user = User("user", "user@gmail")
	# user.print_details() Python does not support method overloading like java or C++
	# we need to define method with default arguments
if __name__ == '__main__':
	main()