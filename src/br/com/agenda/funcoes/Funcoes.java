package br.com.agenda.funcoes;

import java.util.Scanner;

public class Funcoes {
    static final int LENGTH = 10;

    /*
    Adiciona contatos
     */
    public static int cadastrarContato(String[][] contatos, int espacoContatos, Scanner scanner) {
        int posicaoVazia = 0;
        if (contatos != null) {
            for (int i = 0; i < contatos.length; i++) {
                if (contatos[i][1].isEmpty()) {
                    posicaoVazia = i;
                    break;
                }
            }
        }
        System.out.println("Informe o nome do Contato: ");
        contatos[posicaoVazia][0] = scanner.nextLine();
        System.out.println("Informe o número do Contato: ");
        contatos[posicaoVazia][1] = scanner.nextLine();
        System.out.println("Informe o e-mail do Contato: ");
        contatos[posicaoVazia][2] = scanner.nextLine();
        espacoContatos++;
        System.out.println("Contato cadastrado com sucesso!");
        return espacoContatos;
    }

    /*
    Lista contatos
     */
    public static void listarContatos(String[][] contatos) {
        System.out.println("Contatos listados com sucesso!");
    }

    /*
    Busca contatos
     */
    public static void buscarContato(String[][] contatos, Scanner scanner) {
        System.out.println("Informe o número do contato que deseja detalhar:");
        String numeroContato = scanner.nextLine();
        int posicaoContato = 0;
        for (int i = 0; i < contatos.length; i++) {
            if (numeroContato.equals(contatos[i][1])) {
                posicaoContato = i+1;
                break;
            }
        }
        if (posicaoContato == 0) {
            System.out.println("Contato não encontrado!");
            return;
        } else {
            System.out.println("Contato encontrado com sucesso!");
            System.out.println("\nID\t|\tNOME\t|\tTELEFONE\t|\tE-MAIL\n");
            System.out.printf("%d\t|\t%-" + LENGTH + "s\t|\t%-" + LENGTH + "s\t|\t%-" + LENGTH + "s\n", posicaoContato, contatos[posicaoContato-1][0], contatos[posicaoContato-1][1], contatos[posicaoContato-1][2]);
        }
    }

    /*
    Edita contatos
     */
    public static void editarContato(String[][] contatos, Scanner scanner) {
        System.out.println("Informe o número do contato que deseja editar:");
        String numeroContato = scanner.nextLine();
        int posicaoContato = 0;
        for(int i = 0; i<contatos.length;i++) {
            if (numeroContato.equals(contatos[i][1])) {
                posicaoContato = i+1;
                break;
            }
        }
        if(posicaoContato ==0) {
            System.out.println("Contato não encontrado!");
            return;
        }else {
            System.out.println("Informe o nome do Contato: ");
            contatos[posicaoContato-1][0] = scanner.nextLine();
            System.out.println("Informe o número do Contato: ");
            contatos[posicaoContato-1][1] = scanner.nextLine();
            System.out.println("Informe o e-mail do Contato: ");
            contatos[posicaoContato-1][2] = scanner.nextLine();
            System.out.println("\nID\t|\tNOME\t|\tTELEFONE\t|\tE-MAIL\n");
            System.out.printf("%d\t|\t%-" + LENGTH + "s\t|\t%-" + LENGTH + "s\t|\t%-" + LENGTH + "s\n", posicaoContato, contatos[posicaoContato-1][0], contatos[posicaoContato-1][1], contatos[posicaoContato-1][2]);
            System.out.println("Contato excluído com sucesso!");
        }
    }

    /*
    Exclui contato
     */
    public static int excluirContato(String[][] contatos, int espacoContatos, Scanner scanner) {
        System.out.println("Informe o número do contato que deseja excluir:");
        String numeroContato = scanner.nextLine();
        int posicaoContato = 0;
        for(int i = 0; i<contatos.length;i++) {
            if (numeroContato.equals(contatos[i][1])) {
                posicaoContato = i+1;
                break;
            }
        }
        if(posicaoContato ==0) {
            System.out.println("Contato não encontrado!");
            return espacoContatos;
        }else {
            contatos[posicaoContato-1][0] = "";
            contatos[posicaoContato-1][1] = "";
            contatos[posicaoContato-1][2] = "";
            System.out.println("\nID\t|\tNOME\t|\tTELEFONE\t|\tE-MAIL\n");
            System.out.printf("%d\t|\t%-" + LENGTH + "s\t|\t%-" + LENGTH + "s\t|\t%-" + LENGTH + "s\n", posicaoContato, contatos[posicaoContato-1][0], contatos[posicaoContato-1][1], contatos[posicaoContato-1][2]);
        }
        espacoContatos--;
        System.out.println("Contato excluído com sucesso!");
        return espacoContatos;
}
    /*
    Acho que vai precisar da printAgenda também
     */
    public static void imprimirAgenda(String[][] contatos, int espacoContatos) {
        if (espacoContatos == 0) {
            System.out.println("################");
            System.out.println("##Agenda vazia##");
            System.out.println("################");
            System.out.println("Exemplo!");
            System.out.println("Exemplo!");
            System.out.println("Exemplo!");
        } else {
            System.out.println("################");
            System.out.println("#####AGENDA#####");
            System.out.println("################");

            System.out.println("\nID\t|\tNOME\t|\tTELEFONE\t|\tE-MAIL\n");
            int id = 1;
            for (int i = 0; i < contatos.length; i++) {
                if (!contatos[i][1].isEmpty()) {
                    System.out.printf("%d\t|\t%-" + LENGTH +"s\t|\t%-" + LENGTH +"s\t|\t%-" + LENGTH +"s\n", id, contatos[i][0], contatos[i][1], contatos[i][2]);
                    id++;
                }
            }
        }
    }
}
