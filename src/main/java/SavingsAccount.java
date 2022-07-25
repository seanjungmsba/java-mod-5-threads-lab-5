public class SavingsAccount implements Runnable {

    private long total = 0;
    private final String name;

    public SavingsAccount(String name) {
        this.name = name;
        this.total = 0;
    }

    public boolean withdraw(long amount) {
        if (amount <= this.total) {
            this.total -= amount;
            return true;
        } else {
            return false;
        }
    }

    public void deposit(long amount) {
        this.total += amount;
    }

    public long getTotal() {
        return this.total;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void run() {
        String curThreadName = Thread.currentThread().getName();
        System.out.println(curThreadName + " before depositing and withdrawing = " + total);
        this.deposit(50_000);
        this.withdraw(30_000);
        System.out.println(curThreadName + " after depositing and withdrawing = " + total);
    }

    public synchronized void printThread() {
        String curThreadName = Thread.currentThread().getName();
        System.out.println(curThreadName + " entering printThread method of " + name + " with balance of $" + total);
        System.out.println("STATUS: Depositing $50,000");
        this.deposit(50_000);
        System.out.println("STATUS: Withdrawing $20,000");
        this.withdraw(20000);
        System.out.println(curThreadName + " exiting printThread method of " + name  + " with balance of $" + total);
    }
}