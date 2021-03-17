package scr;

import java.util.Scanner;

public class BancoAppV3 {
    public static Scanner entrada;

    public static void mostrarInfo(BankAccount[] contas) {
        System.out.println("\nContas de todos os clientes:");
        for (int i = 0; i < contas.length; i++) {
            System.out.println("[" + i + "]" + contas[i].toString());
        }
        System.out.println("");
    }

    public static void interacaoSacar(BankAccount[] contas) {
        boolean clienteValido = false;
        int indiceConta = -1;
        while (!clienteValido) {
            mostrarInfo(contas);
            System.out.print("O saque será efetuado na conta de qual cliente? (0 a " + (contas.length - 1) + "): ");
            indiceConta = entrada.nextInt();
            if (indiceConta >= 0 && indiceConta < contas.length) {
                clienteValido = true;
            } else {
                System.out.println("Índice de cliente inválido!");
            }
        }

        System.out.print("Qual o valor do saque? ");
        double saque = entrada.nextDouble();
        contas[indiceConta].withDraw(saque);
        System.out.println("Saque finalizado.\n");
    }

    public static void interacaoDepositar(BankAccount[] contas) {
        System.out.println("Em construção...");
    }

    public static void main(String[] args) {
        BankAccount[] contas = new BankAccount[5];
        contas[0] = new BankAccount("Marcos", 1000.00);
        contas[1] = new BankAccount("Júlia", 250.00);

        contas[2] = new BankAccount("João", 2500.00);
        contas[3] = new BankAccount("Roberto", 3000.00);
        contas[4] = new BankAccount("Janaína", 4500.00);

        entrada = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("Escolha uma operação:");
            System.out.println("(1) mostrar informações de todas as contas");
            System.out.println("(2) sacar");
            System.out.println("(3) depositar");
            System.out.println("(4) sair");
            System.out.print("Opção escolhida: ");
            int escolha = entrada.nextInt();
            System.out.println();
            switch (escolha) {
            case 1:
                mostrarInfo(contas);
                break;
            case 2:
                interacaoSacar(contas);
                break;
            case 3:
                interacaoDepositar(contas);
                break;
            case 4:
                sair = true;
                break;
            default:
                System.out.println("Opção inválida!");
            }
            System.out.println();
        }
        System.out.println("Fim do programa!");
    }
}