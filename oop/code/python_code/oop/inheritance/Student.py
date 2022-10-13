from oop.inheritance.User import *
from oop.inheritance.StudentStatus import *

class Student(User):

	__status = StudentStatus.ACTIVE

	def __init__(self, name: str, email: str, batch_name: str, psp: int) -> None:
		super().__init__(name, email)
		self.__batch_name = batch_name
		
		if (psp < 0 or psp > 100):
			raise Exception("PSP should be between 0 and 100")
		self.__psp = psp

	def print_details(self) -> None:
		print("In Student", self.get_name(), self.__batch_name)

	def change_batch(self, batch_name: str) -> None:
		self.batch_name = batch_name
