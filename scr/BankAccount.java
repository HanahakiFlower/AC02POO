package scr;

import java.util.Random;

public class BankAccount {
    private static int lastAccountNumber = 1000; // Último número utilizado de conta
    private String owner;
    private int accountNumber; // número da conta
    private double balance; // saldo da conta
    private double cpmf;
    private String senha;

    public BankAccount(String owner) {
        // chama outro construtor dessa classe com os valores owner e 0, para saldo
        this(owner, 0);
    }

    public BankAccount(String owner, double balance) {
        accountNumber = lastAccountNumber++;
        this.balance = balance;
        this.owner = checkName(owner);
        this.senha = makePassword();
        this.cpmf = 0;
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

    public void transfer(double valor, BankAccount target) {
        double newBalance = this.balance;
        newBalance -= valor;
        this.balance = newBalance;
        target.balance += valor;
    }

    private static String checkName(String owner) {
        boolean valida = owner.matches("\\w+[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ]*");
        if (valida == true) {
            return owner;
        } else {
            System.exit(0);
            return null;
        }
    }

    public static String makePassword() {
        String str = "abcdefghijklmnopqrstuvwxyz";
        Random gerador = new Random();
        String senha = "";

        for (int i = 0; i < 3; i++) {
            int x = gerador.nextInt(10);
            senha = senha + str.charAt(x);
        }

        for (int i = 0; i < 4; i++) {
            int x = gerador.nextInt(10);
            senha = senha + x;
        }
        return senha;
    }

    public double getCpmf() {
        return cpmf;
    }

    public void setCpmf(double cpmf) {
        this.cpmf = cpmf;
    }
}