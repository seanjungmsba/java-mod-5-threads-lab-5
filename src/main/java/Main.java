public class Main {
    public static void main(String[] args) throws InterruptedException {

        SavingsAccount account = new SavingsAccount("Example-Account");

        new Thread(() -> {
            String curThreadName = Thread.currentThread().getName();
            System.out.println(curThreadName + " entering printThread method of " + account.getName() + " with balance of $" + account.getTotal());
            System.out.println(curThreadName + " STATUS: Depositing $50,000");
            account.deposit(50_000);
            System.out.println(curThreadName + " STATUS: Withdrawing $20,000");
            account.withdraw(20_000);
            System.out.println(curThreadName + " exiting printThread method of " + account.getName() + " with balance of $" + account.getTotal());
        } ).start();

        new Thread(() -> {
            String curThreadName = Thread.currentThread().getName();
            System.out.println(curThreadName + " entering printThread method of " + account.getName() + " with balance of $" + account.getTotal());
            System.out.println(curThreadName + " STATUS: Depositing $50,000");
            account.deposit(50_000);
            System.out.println(curThreadName + " STATUS: Withdrawing $20,000");
            account.withdraw(20_000);
            System.out.println(curThreadName + " exiting printThread method of " + account.getName() + " with balance of $" + account.getTotal());
        } ).start();

    }
}
