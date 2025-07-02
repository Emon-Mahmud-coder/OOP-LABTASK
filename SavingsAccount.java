class SavingsAccount extends Account {
    public SavingsAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    public void deposit(double amount) {
        balance += amount;
        calculateInterest();
    }

    public boolean withdraw(double amount) {
        if ((balance - amount) >= 1000) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void calculateInterest() {
        balance += balance * 0.025;
    }
}