package account;

public class Account {
    private final int accountNumber;
    protected double balance;
    static private int accountNumberMax = 0;

    public Account() {
        this.accountNumber = ++accountNumberMax;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            System.out.printf("Сумма пополнения (%s) должна быть больше нуля\n", amount);
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.printf("Сумма снятия (%s) должна быть больше нуля\n", amount);
        } else if (amount <= this.balance) {
                this.balance -= amount;
        } else {
            System.out.printf("Сумма снятия (%s) должна быть больше баланса (%s)\n", amount, this.balance);
        }
    }

    public void displayInfo() {
        System.out.printf("Баланс счета %s: %s\n", this.accountNumber, this.balance);
    }

    protected int getAccount() {
        return this.accountNumber;
    }
}
