from abc import ABC, abstractmethod
import BirdType

class Bird(ABC):
	def __init__(self, weight, colour, size, beakType, birdType):
		self.weight = weight
		self.colour = colour
		self.size = size
		self.beakType = beakType
		self.birdType = birdType

	@abstractmethod
	def fly(self):
		pass