class User:
	def __init__(self, name, email):
		self.__name = name
		self.__email = email

	def change_email(self):
		self.__email = email

	def get_name(self):
		return self.__name

	def print_details(self):
		print("Print with no args")

	def print_details(self, title):
		print("\n In User:", title, self.get_name())