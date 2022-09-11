from abc import ABC, abstractmethod

class SwimmableInterface:
    @abstractmethod
    def swim() -> None:
        ...