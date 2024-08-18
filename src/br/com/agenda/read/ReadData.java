package br.com.agenda.read;

import br.com.agenda.validacoes.Validacoes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadData {
    public static final int NAMELENGTH = 20;
    static Scanner scanner = new Scanner(System.in);
    public static int readMenu () {
        int opcao = -1;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
                if (opcao >= 1 && opcao <= 6) {
                    validInput = true;
                } else {
                    System.out.println("Opção inválida! Por favor, insira um número entre 1 e 6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, insira um número.");
                scanner.next(); // Limpa a entrada inválida do scanner
            }
        }
        return opcao;
    }



    public static String readName () {
        System.out.println("Informe o nome do Contato (20 characters) ou enter para cancelar: ");
        String name = scanner.nextLine();
        if(name.length()>20)
            //trunca o nome em 20 characteres
            return name.substring(0, NAMELENGTH);
        return name;
    }
    public static String readPhone () {
        System.out.println("Informe o número de telefone do Contato ou ENTER para cancelar: ");
        String phone = scanner.nextLine();
        if((phone.length() == 11 && phone.matches("\\d+")) || phone.equals("")){
            return phone;
        }
        System.out.println("Telefone inválido!");
        return readPhone();
    }
    public static String readMail () {
        System.out.println("Informe o e-mail do Contato ou ENTER para continuar sem  e-mail: ");//acho que não é necessário sempre informar o e-mail para ter um contato então é bom ficar como optativo.
        String email = scanner.nextLine();
        if (Validacoes.isEmail(email) || email.equals("")) {
            return email;
        }
        System.out.println("Email inválido. Por favor, digite um email válido.");
        return readMail();
    }
    //fecha o scanner
    public static void closeScanner() {
        scanner.close();
    }
}
