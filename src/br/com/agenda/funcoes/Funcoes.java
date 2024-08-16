package br.com.agenda.funcoes;

import br.com.agenda.validacoes.Validacoes;

import java.util.Scanner;

public class Funcoes {
    Validacoes validacoes = new Validacoes();

    public void cadastrarContato() {
        Scanner scanner = new Scanner(System.in);
        String email;

        while (true) {
            System.out.print("Digite um email válido: ");
            email = scanner.nextLine();

            if (validacoes.isEmail(email)) {
                System.out.println("Contato cadastrado com sucesso!");
                break;
            }
            System.out.println("Email inválido. Por favor, digite um email válido.");
        }
    }


    public void listarContatos() {System.out.println("Contatos listados com sucesso!");}
    public void buscarContato() {System.out.println("Contato encontrado com sucesso!");}
    public void editarContato() {System.out.println("Contato editado com sucesso!");}
    public void excluirContato() {System.out.println("Contato excluído com sucesso!");}
    public void imprimirAgenda() {System.out.println("Agenda vazia!");System.out.println("Exemplo!");
    }

}
