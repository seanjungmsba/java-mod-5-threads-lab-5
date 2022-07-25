public class Main {
    public static void main(String[] args) throws InterruptedException {

        SavingsAccount account1 = new SavingsAccount("Example-Account-1");
        SavingsAccount account2 = new SavingsAccount("Example-Account-2");

        new Thread(account1::printThread).start(); // Thread-0
        new Thread(account2::printThread).start(); // Thread-1

    }
}
