class OopBankAccount:
	def __init__(self, balance, number):
		self.__number = number
		self.__balance = balance

	def getNumber(self):
		return self.__number

	def setNumber(self, number):
		self.__number = number 

	def getBalance(self):
		return self.__balance

	def setBalance(self, balance):
		self.__balance = balance

	def deposit(self, amount):
		self.__balance += amount

	def withdraw(self, amount):
		self.__balance -= amount

	def transfer(self, destination, amount):
		self.withdraw(amount)
		destination.deposit(amount)

