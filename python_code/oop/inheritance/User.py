class User:
	def __init__(self, name: str, email: str) -> None:
		self.__name = name
		self.__email = email

	def change_email(self, email: str) -> None:
		self.__email = email

	def get_name(self) -> str:
		return self.__name

	def print_details(self) -> None:
		print("Print with no args")

	def print_details(self, title: str) -> None:
		print("\n In User:", title, self.get_name())