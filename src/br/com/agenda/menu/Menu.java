package br.com.agenda.menu;
import br.com.agenda.Enum.FuncoesMenu;
<<<<<<< HEAD
import br.com.agenda.funcoes.Funcoes;
import br.com.agenda.read.ReadData;

import java.util.Scanner;
=======
>>>>>>> db64e24b04571151ec664468d61186cabad594ed

public class Menu {
    /*
    Essa função printa a tela inicial da agenda
    INTERAR O ENUN
     */
    public static void inicializador(){

    }
<<<<<<< HEAD
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
        }while(escolha != FuncoesMenu.SAIR);
        //Feacha o scanner da classe ReadData
        ReadData.closeScanner();
=======
    public void menu(){
        inicializador();
>>>>>>> db64e24b04571151ec664468d61186cabad594ed
    }
}


