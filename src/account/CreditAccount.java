package account;

public class CreditAccount extends Account {
    private final double creditLimit = 100000.0;

    @Override
    public void withdraw(double amount) {
        if (amount <= this.balance) {
            super.withdraw(amount);
        } else if (amount <= this.balance + this.creditLimit) {
            this.balance -= amount;
        } else {
            System.out.printf("Баланс счета %s после снятия (%s) не должен превышать кредитный лимит (%s)\n", this.getAccount(), this.balance - amount, this.creditLimit);
        }
    }
}
