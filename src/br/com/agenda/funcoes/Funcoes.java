package br.com.agenda.funcoes;

public class Funcoes {
    public void cadastrarContato() {
        System.out.println("Contato cadastrado com sucesso!");
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

    /*
    Acho que vai precisar da printAgenda também
     */
    public void imprimirAgenda() {
        System.out.println("Agenda vazia!");
        System.out.println("Exemplo!");
    }

    //Método para verificar se o email é válido ou não//
    //Explicando: Se o símbolo do @ existe e não está nem no começo, nem no final, então é válido.
    //é a forma mais simples que consegui pensar.
    //para chamar é só digitar verificadorEmail(digitar uma String email)

    public static String verificadorEmail(String email) {
        int verificador = email.indexOf("@");
        String mensagem = "";
        if (verificador <= 0 || verificador == email.length() - 1) {
            mensagem = "--------------------------------------------------" +
                    "\nEmail inválido. Por favor, digite um email válido. " +
                    "\n--------------------------------------------------\n";
        }
        return mensagem;
    }

}
