package br.com.agenda.menu;
import br.com.agenda.Enum.FuncoesMenu;
import br.com.agenda.funcoes.Funcoes;

import java.util.Scanner;

public class Menu {
    /*
    Essa função printa a tela inicial da agenda
     */
    public static void inicializador(){
        System.out.println("----Menu da Agenda----");
        System.out.println("1 - Adicionar Contato");
        System.out.println("2 - Listar Contatos");
        System.out.println("3 - Buscar Contato");
        System.out.println("4 - Editar Contato");
        System.out.println("5 - Remover Contato");
        System.out.println("6 - Sair");
    }
    public static void menu() {
        String[][] contatos = new String[100][3];
        // Inicializar a matriz com strings vazias
        for (int i = 0; i < contatos.length; i++) {
            for (int j = 0; j < contatos[i].length; j++) {
                contatos[i][j] = "";
            }
        }
        int espacoContatos=0;
        Scanner scanner = new Scanner(System.in);
        FuncoesMenu escolha = null;
        do {
            Funcoes.imprimirAgenda(contatos, espacoContatos);
            inicializador();
            System.out.println("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer
            //Cases
            switch (opcao) {
                case 1:
                    espacoContatos = Funcoes.cadastrarContato(contatos, espacoContatos, scanner);
                    break;
                case 2:
                    Funcoes.listarContatos(contatos);
                    break;
                case 3:
                    Funcoes.buscarContato(contatos, scanner);
                    break;
                case 4:
                    Funcoes.editarContato(contatos, scanner);
                    break;
                case 5:
                    espacoContatos = Funcoes.excluirContato(contatos, espacoContatos, scanner);
                    break;
                case 6:
                    escolha = FuncoesMenu.SAIR;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente");
            }
        }while(escolha != FuncoesMenu.SAIR);
        scanner.close();
    }
}


