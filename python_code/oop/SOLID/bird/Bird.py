from abc import ABC, abstractmethod
import BirdType

class Bird(ABC):
	def __init__(self, weight: int, colour: str, size: int, beakType : str, birdType : BirdType) -> None:
		self.__weight = weight
		self.__colour = colour
		self.__size = size
		self.__beakType = beakType
		self.__birdType = birdType

	@abstractmethod
	def makeSound(self) -> None:
		...