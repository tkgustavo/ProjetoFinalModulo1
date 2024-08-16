package br.com.agenda.validacoes;

public class Validacoes {
    public boolean isEmail(String email) {
        //TODO método aceita dois '@', adicionar verificação

        //Verifica se o email não é nulo, nem vazio e possui '@'
        //Verifica se o '@' não está no início da palavra, nem no final (ao meio sa string)
        return email != null &&
                email.contains("@") &&
                email.indexOf('@') > 0 &&
                email.indexOf('@') < email.length() - 1;
    }

}
