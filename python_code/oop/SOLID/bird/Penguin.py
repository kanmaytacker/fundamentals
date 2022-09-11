from Bird import *
from BirdType import *
from interfaces.SwimmableInterface import *
from interfaces.FlyingBehaviourInterface import *

class Penguin(Bird, SwimmableInterface):
    def __init__(self, weight: int, colour: str, size: int, beakType: str, birdType: BirdType) -> None:
        super().__init__(weight, colour, size, beakType, birdType)
    
    def fly(self) -> None:
        self.__flyingBehaviour.makeFly()
        
    def makeSound(self) -> None:
        ...