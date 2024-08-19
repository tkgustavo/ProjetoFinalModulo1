package br.com.agenda.menu;

import br.com.agenda.Enum.FuncoesMenu;
import br.com.agenda.funcoes.Funcoes;
import br.com.agenda.read.ReadData;

import static br.com.agenda.funcoes.Funcoes.exibirCabecalho;

public class Menu {

    // Exibe a tela inicial do menu da agenda
    public static void inicializador() {
        exibirCabecalho("Menu da Agenda");
        System.out.println("1 - Adicionar Contato");
        System.out.println("2 - Listar Contatos");
        System.out.println("3 - Buscar Contato");
        System.out.println("4 - Editar Contato");
        System.out.println("5 - Remover Contato");
        System.out.println("6 - Sair");
    }

    public static void menu() {
        FuncoesMenu escolha;
        do {
            inicializador();
            escolha = ReadData.readMenu();

            if (escolha == null) {
                System.out.println("\nOpção inválida. Tente novamente.");
                continue;
            }

            switch (escolha) {
                case ADICIONAR -> Funcoes.cadastrarContato();
                case LISTAR -> Funcoes.listarContatos();
                case DETALHAR -> Funcoes.buscarContato();
                case EDITAR -> Funcoes.editarContato();
                case REMOVER -> Funcoes.excluirContato();
                case SAIR -> System.out.println("Saindo...");
                default -> System.out.println("\nOpção inválida! Tente novamente.");
            }
        } while (escolha != FuncoesMenu.SAIR);
        // Fecha o scanner da classe ReadData
        ReadData.closeScanner();
    }
}
