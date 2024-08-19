package br.com.agenda.read;

import br.com.agenda.Enum.FuncoesMenu;

import java.util.Scanner;

public class ReadData {
    public static final int NAMELENGTH = 20;
    static Scanner scanner = new Scanner(System.in);

    public static FuncoesMenu readMenu() {
        FuncoesMenu escolha = null;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Escolha uma opção: ");
                int opcao = Integer.parseInt(scanner.nextLine().trim());

                for (FuncoesMenu funcao : FuncoesMenu.values()) {
                    if (opcao == funcao.ordinal() + 1) {
                        escolha = funcao;
                        validInput = true;
                        break;
                    }
                }

                if (!validInput) {
                    System.out.println("Opção inválida! Por favor, insira um número entre 1 e 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Por favor, insira um número.");
            }
        }

        return escolha;
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
        if((phone.length() == 11 && phone.matches("\\d+")) || phone.isBlank()){
            return phone;
        }
        System.out.println("Telefone inválido!");
        return readPhone();
    }
    public static String readMail () {
        //E-mail optativo
        System.out.println("Informe o e-mail do Contato ou ENTER para continuar sem  e-mail: ");
        String email = scanner.nextLine();
        if (email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$") || email.isBlank()) {
            return email;
        }
        System.out.println("Email inválido. Por favor, digite um email válido.");
        return readMail();
    }

    public static boolean readConfirmar () {
        System.out.println("Deseja cadastrar este telefone como novo contato? (S/N)");
        String confirmar = scanner.nextLine();
        return confirmar.equalsIgnoreCase("S".trim());
    }
    //fecha o scanner
    public static void closeScanner() {
        scanner.close();
    }
}
