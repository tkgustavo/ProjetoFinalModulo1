package br.com.agenda.read;

import java.util.Scanner;

public class ReadData {
    static final int NAMELENGTH = 20;
    static Scanner scanner = new Scanner(System.in);
    public static int readMenu () {
        System.out.println("Escolha uma opção: ");
        //modificar para next line e tratar caso o usuário digite algo fora do menu
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer
        if(opcao>=1 && opcao<=6)
            return opcao;
        else
            return readMenu();//repetição da chamada de comando até que o usuário insira um comando valido
    }
    public static String readName () {
        System.out.println("Informe o nome do Contato (20 characters): ");
        String name = scanner.nextLine();
        if(name.length()>20)
            //trunca o nome em 20 characteres
            return name.substring(0, NAMELENGTH);
        return name;
    }
    public static String readPhone () {
        System.out.println("Informe o número de telefone do Contato: ");
        String phone = scanner.nextLine();
        if(phone.length() == 11)
            return phone;
        return readPhone();
    }
    public static String readMail () {
        System.out.println("Informe o e-mail do Contato: ");
        return scanner.nextLine();
    }
    public static void closeScanner() {
        scanner.close();
    }
}
