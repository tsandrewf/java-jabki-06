package account;

import java.util.UUID;

public class Account {
    private final UUID accountNumber;
    protected double balance;

    public Account() {
        this.accountNumber = UUID.randomUUID();
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

    public UUID getAccount() {
        return this.accountNumber;
    }
}
