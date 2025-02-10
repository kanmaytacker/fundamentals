package main

import (
	"basic/bird"
)

func main() {
	bird1 := bird.NewBird(6.5, 2.1, "brown")
	eagle := &bird.Eagle{Bird: bird1}

	bird2 := bird.NewBird(15.0, 1.2, "black and white")
	penguin := &bird.Penguin{Bird: bird2}

	bird3 := bird.NewBird(2.5, 0.8, "white")
	duck := &bird.Duck{Bird: bird3}

	eagle.Fly()
	penguin.Swim()
	duck.Fly()
	duck.Swim()
}
