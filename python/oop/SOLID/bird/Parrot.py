from Bird import *
from BirdType import *

class Parrot(Bird):
	def __init__(self, weight, colour, size, beakType, birdType):
		super().__init__(weight, colour, size, beakType, birdType)

	def fly(self):
		print("Parrot is flying")