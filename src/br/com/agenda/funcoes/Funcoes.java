package br.com.agenda.funcoes;

public class Funcoes {
    public String cadastrarContato(String email) {

            if (email == null || !email.contains("@") || email.indexOf('@') == 0 || email.indexOf('@') == email.length() - 1) {
                return "--------------------------------------------------\n" +
                        "Email inválido. Por favor, digite um email válido.\n" +
                        "--------------------------------------------------\n";
            }
            return "Contato cadastrado com sucesso!";
    }
    public void listarContatos() {
        System.out.println("Contatos listados com sucesso!");
    }
    public void buscarContato() {
        System.out.println("Contato encontrado com sucesso!");
    }
    public void editarContato() {
        System.out.println("Contato editado com sucesso!");
    }
    public void excluirContato() {
        System.out.println("Contato excluído com sucesso!");
    }
    public void imprimirAgenda() {
        System.out.println("Agenda vazia!");
        System.out.println("Exemplo!");
    }

}
