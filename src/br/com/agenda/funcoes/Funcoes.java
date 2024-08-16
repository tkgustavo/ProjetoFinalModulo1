package br.com.agenda.funcoes;

import java.util.Scanner;

public class Funcoes {

    public void cadastrarContato() {
        Scanner scanner = new Scanner(System.in);
        String email;

/*Esse TRUE dentro do While mantém o laço funcionando
Até que seja interrompido por algo dentro dele mesmo
(como o BREAK depois do if - aprendido na última aula) */

        while (true) {
            System.out.print("Digite um email válido: ");
            email = scanner.nextLine();

//Aqui comparo se o email não é nulo, não é vazio e tem o caracter '@'
             if (email != null && !email.isEmpty() && email.contains("@")

// e Se o '@' não éstá no início da palavra, nem no final (email.length()-1
                && email.indexOf('@') > 0 && email.indexOf('@') < email.length() - 1) {

//se todas as condições forem verdadeiras cai nesse println e dá um break no loop.
                System.out.println("Contato cadastrado com sucesso!");
                break;

//Se um única condição for falsa cai aqui no else e o loop volta a pedir um email válido.
            } else {
                System.out.println("Email inválido. Por favor, digite um email válido.");
            }
        }
    }


    public void listarContatos() {System.out.println("Contatos listados com sucesso!");}
    public void buscarContato() {System.out.println("Contato encontrado com sucesso!");}
    public void editarContato() {System.out.println("Contato editado com sucesso!");}
    public void excluirContato() {System.out.println("Contato excluído com sucesso!");}
    public void imprimirAgenda() {System.out.println("Agenda vazia!");System.out.println("Exemplo!");
    }

}
