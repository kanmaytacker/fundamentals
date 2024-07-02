package bird

import "fmt"

type Bird struct {
	weight float64
	colour string
	size   float64
}

func NewBird(weight, size float64, colour string) *Bird {
	return &Bird{
		weight: weight,
		colour: colour,
		size:   size,
	}
}

type FlyingBehaviour interface {
	Fly()
}

type SwimmingBehaviour interface {
	Swim()
}

type Eagle struct {
	*Bird
}

func (e *Eagle) Fly() {
	fmt.Println("Eagle is flying")
}

type Penguin struct {
	*Bird
}

func (p *Penguin) Swim() {
	fmt.Println("Penguin is swimming")
}

type Duck struct {
	*Bird
}

func (d *Duck) Fly() {
	fmt.Println("Duck is flying")
}

func (d *Duck) Swim() {
	fmt.Println("Duck is swimming")
}
