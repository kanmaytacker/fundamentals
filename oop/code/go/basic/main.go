package main

import (
	"basic/bank"
	"fmt"
)

func main() {
	acc1 := bank.NewBankAccount(1, "abhi", 10000.00)
	acc2 := bank.NewBankAccount(2, "ankit", 0.00)

	fmt.Println("Before Balance")
	acc1.PrintBalance()
	acc2.PrintBalance()

	acc1.Transfer(acc2, 5000.00)

	fmt.Println("After Balance")
	acc1.PrintBalance()
	acc2.PrintBalance()
}
