public class SavingsAccount {
    // saving the instance variable that is of type long or double as 'volatile'
    // and make the critical methods as synchronized method
    private volatile long total = 0;
    private final String name;

    public SavingsAccount(String name) {
        this.name = name;
        this.total = 0;
    }

    public synchronized boolean withdraw(long amount) {
        // synchronized method here prevents another thread from modifying the underlying data
        // without this method, we don't really know what happens between line 15 and 16
        if (amount <= this.total) {
            this.total -= amount;
            return true;
        } else {
            return false;
        }
    }

    public synchronized void deposit(long amount) {
        this.total += amount;
    }

    public synchronized long getTotal() {
        return this.total;
    }

    public String getName() {
        return this.name;
    }

}