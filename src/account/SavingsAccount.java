package account;

public class SavingsAccount extends Account{
    private final double withdrawLimit = 1000.0;
    private final double interestRate = 20.0;

    @Override
    public void withdraw(double amount) {
        if (amount > this.withdrawLimit) {
            System.out.printf("Сумма снятия (%s) не должна превышать допустимый лимит (%s)\n", amount, this.withdrawLimit);
            return;
        }

        super.withdraw(amount);
    }

    public void applyInterest() {
        this.balance += this.balance * this.interestRate / 100.0;
    }

    @Override
    public void displayInfo() {
        System.out.printf("Баланс сберегательного счета %s: %s\n", this.getAccount(), this.balance);
    }
}
