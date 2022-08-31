public class OopBankAccount {
    private Integer number;
    private Integer balance;

    public OopBankAccount(Integer number, Integer balance) {
        this.number = number;
        this.balance = balance;
    }

    void deposit(Integer amount) {
        this.balance  += amount;
    }

    void withdraw(Integer amount) {
        this.balance  += amount;
    }

    void transfer(OopBankAccount destination, Integer amount) {
        this.withdraw(amount);
        destination.deposit(amount);
    }

}
