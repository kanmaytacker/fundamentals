package bank

import "fmt"

type BankAccount struct {
	AccountNumber int64
	Name          string
	Balance       float64
}

type BankAccountOps interface {
	GetAccountNumber() (int64, error)
	GetName() (string, error)
	GetBalance() (float64, error)
	Deposit(amount float64) error
	Withdraw(amount float64) error
	Transfer(destiantion *BankAccount, amount float64) error
	PrintBalance()
}

func NewBankAccount(number int64, name string, balance float64) *BankAccount {
	return &BankAccount{AccountNumber: number, Name: name, Balance: balance}
}

func (b *BankAccount) GetAccountNumber() (int64, error) {
	return b.AccountNumber, nil
}

func (b *BankAccount) GetName() (string, error) {
	return b.Name, nil
}

func (b *BankAccount) GetBalance() (float64, error) {
	return b.Balance, nil
}

func (b *BankAccount) Deposit(amount float64) error {
	b.Balance += amount
	return nil
}

func (b *BankAccount) Withdraw(amount float64) error {
	b.Balance -= amount
	return nil
}

func (b *BankAccount) Transfer(destiantion *BankAccount, amount float64) error {
	b.Withdraw(amount)
	destiantion.Deposit(amount)

	return nil
}

func (b *BankAccount) PrintBalance() {
	fmt.Println(b.AccountNumber, b.Name, b.Balance)
}
