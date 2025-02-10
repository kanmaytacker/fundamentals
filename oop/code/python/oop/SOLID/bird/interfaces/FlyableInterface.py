from abc import ABC, abstractmethod

class FlyableInterface(ABC):
    @abstractmethod
    def fly() -> None:
        ...