class PremiumAccount extends Account {
    private int installmentsPaid;

    public PremiumAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
        this.installmentsPaid = 0;
    }

    public void deposit(double amount) {
        balance += amount;
        installmentsPaid++;
        calculateInterest();
    }

    public boolean withdraw(double amount) {
        if (installmentsPaid >= 5 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void calculateInterest() {
        if (installmentsPaid >= 5) {
            balance += balance * 0.07;
        }
    }

    public int getInstallmentsPaid() {
        return installmentsPaid;
    }
}