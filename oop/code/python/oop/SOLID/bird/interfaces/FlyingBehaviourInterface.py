from abc import ABC, abstractmethod

class FlyingBehaviourInterface(ABC):
    @abstractmethod
    def makeFly() -> None:
        ...