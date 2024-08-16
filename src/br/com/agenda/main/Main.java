package br.com.agenda.main;
import br.com.agenda.funcoes.Funcoes;
import br.com.agenda.menu.Menu;


public class Main {
    public static void main(String[] args) {

        //----------------------Teste da validação simples de email -------------

        Funcoes funcoes = new Funcoes();
        System.out.println(funcoes.cadastrarContato("outrogmail.com"));


    }

}


