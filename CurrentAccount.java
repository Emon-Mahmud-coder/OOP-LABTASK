class CurrentAccount extends Account {
    public CurrentAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void calculateInterest() {
        // No interest
    }
}