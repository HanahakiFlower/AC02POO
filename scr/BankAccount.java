package scr;

public class BankAccount {
    private static int lastAccountNumber = 1000; // Último número utilizado de conta
    private String owner;
    private int accountNumber; // número da conta
    private double balance; // saldo da conta

    public BankAccount(String owner) {
        // chama outro construtor dessa classe com os valores owner e 0, para saldo
        this(owner, 0);
    }

    public BankAccount(String owner, double balance) {
        accountNumber = lastAccountNumber++;
        this.balance = balance;
        this.owner = owner;
    }

    public void deposit(double amount) {
        double newBalance = balance + amount;
        balance = newBalance;
    }

    public void withDraw(double amount) {
        double newBalance = balance - amount;
        balance = newBalance;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String toString() {
        return "Conta de " + owner + " - Saldo de R$ " + balance;
    }
}