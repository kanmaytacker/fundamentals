from Bird import *
from BirdType import *
from interfaces.FlyableInterface import *
from interfaces.FlyingBehaviourInterface import *

class Parrot(Bird, FlyableInterface):
    __flyingBehaviour: FlyingBehaviourInterface = None
    def __init__(self, weight: int, colour: str, size: int, beakType: str, birdType: BirdType, flyingBehaviour: FlyingBehaviourInterface) -> None:
        super().__init__(weight, colour, size, beakType, birdType)
        self.__flyingBehaviour = flyingBehaviour
    
    def fly(self) -> None:
        self.__flyingBehaviour.makeFly()
        
    def makeSound(self) -> None:
        ...