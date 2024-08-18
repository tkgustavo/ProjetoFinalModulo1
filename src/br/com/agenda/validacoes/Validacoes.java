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

        return  email != null &&
                email.contains("@") &&
                email.indexOf('@') > 0 &&
                email.indexOf("@") > 0 &&
                email.indexOf('@') < email.length() - 1 &&
                counter < 2;

    }

    public static void main(String[] args) {
        System.out.println(isEmail("outroluiz@@@gmail.com"));
    }


}
