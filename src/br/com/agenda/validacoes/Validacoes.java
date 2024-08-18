package br.com.agenda.validacoes;

public class Validacoes {
    public static boolean isEmail(String email) {
        //TODO método aceita dois '@', adicionar verificação

        //Tá feio, mas verifica se o email tem dois @.
        int counter = 0;
        for (int i = 0; i < email.length(); i++) {
            char letra = email.charAt(i);
            if (letra == '@') {
                counter++; // letra = 2
            }
        }
        if(counter == 2){
            System.out.println("Você digitou o email errado, favor corrigir.");
        }

        //Verifica se o email não é nulo, nem vazio e possui '@'
        //Verifica se o '@' não está no início da palavra, nem no final (ao meio da string)
        return  email != null &&
                email.contains("@") &&
                email.indexOf('@') > 0 &&
                email.indexOf("@") > 0 &&
                email.indexOf('@') < email.length() - 1 &&
                counter < 2;

    }



}
