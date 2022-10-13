from Bird import *
from BirdType import *
from interfaces.FlyingBehaviourInterface import *

class GlidingBehaviour(FlyingBehaviourInterface):
    def makeFly(self) -> None:
        print("Gliding")