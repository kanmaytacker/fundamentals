from distutils.ccompiler import gen_lib_options
from Parrot import *
from Eagle import *
from Penguin import *
from BirdType import *
from interfaces.FlyableInterface import *
from interfaces.SwimmableInterface import *
from FlappingBehaviour import *
from GlidingBehaviour import *

#import FlappingBehaviour gives error bcoz bird is package

parrot = Parrot(10, "Green", "Small", "Sharp", BirdType.Parrot, FlappingBehaviour())
parrot.fly()

eagle = Eagle(20, "Brown", "Medium", "Sharp", BirdType.Eagle, GlidingBehaviour())
eagle.fly()

penguin = Penguin(30, "Black", "Large", "Sharp", BirdType.Penguin)
penguin.makeSound()