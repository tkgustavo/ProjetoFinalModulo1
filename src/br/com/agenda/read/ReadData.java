package br.com.agenda.read;

import br.com.agenda.Enum.FuncoesMenu;
import br.com.agenda.validacoes.Validacoes;

import java.util.Scanner;

public class ReadData {
    public static final int NAMELENGTH = 20;
    static Scanner scanner = new Scanner(System.in);

    public static FuncoesMenu readMenu () {
        System.out.println("Escolha uma opção: ");
        try{
            int opcao = Integer.parseInt(scanner.nextLine().trim());
            for (FuncoesMenu funcao : FuncoesMenu.values()) {
                if (opcao == funcao.ordinal() + 1) {
                    return funcao;
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
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
        System.out.println("Informe o e-mail do Contato ou ENTER para continuar sem  e-mail: ");//acho que não é necessário sempre informar o e-mail para ter um contato então é bom ficar como optativo.
        String email = scanner.nextLine();
        if (email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$") || email.isBlank()) {
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
