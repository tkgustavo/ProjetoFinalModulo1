package br.com.agenda.menu;
import br.com.agenda.Enum.FuncoesMenu;
import br.com.agenda.funcoes.Funcoes;
import br.com.agenda.read.ReadData;

public class Menu {
    /*
    Essa função printa a tela inicial da agenda
    INTERAR O ENUN
     */
    public static void inicializador() {
        System.out.println("");
        System.out.println(">>>>>>Menu da Agenda<<<<<<");
        System.out.println("1 - Adicionar Contato");
        System.out.println("2 - Listar Contatos");
        System.out.println("3 - Buscar Contato");
        System.out.println("4 - Editar Contato");
        System.out.println("5 - Remover Contato");
        System.out.println("6 - Sair");
    }
    public static void menu() {
        FuncoesMenu escolha = null;
        do {
            Funcoes.imprimirAgenda();
            inicializador();
            //Cases
            switch (ReadData.readMenu()) {
                case 1:
                    Funcoes.cadastrarContato();
                    break;
                case 2:
                    Funcoes.listarContatos();
                    break;
                case 3:
                    Funcoes.buscarContato();
                    break;
                case 4:
                    Funcoes.editarContato();
                    break;
                case 5:
                    Funcoes.excluirContato();
                    break;
                case 6:
                    escolha = FuncoesMenu.SAIR;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente");
            }
        } while (escolha != FuncoesMenu.SAIR);
        //Feacha o scanner da classe ReadData
        ReadData.closeScanner();
    }
}


