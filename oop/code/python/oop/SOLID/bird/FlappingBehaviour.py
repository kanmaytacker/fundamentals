from Bird import *
from BirdType import *
from interfaces.FlyingBehaviourInterface import *

class FlappingBehaviour(FlyingBehaviourInterface):
    def makeFly(self) -> None:
        print("Flapping")