package br.com.agenda.funcoes;

<<<<<<< HEAD
import br.com.agenda.read.ReadData;
=======
import br.com.agenda.validacoes.Validacoes;
>>>>>>> db64e24b04571151ec664468d61186cabad594ed

import java.util.Scanner;

public class Funcoes {
<<<<<<< HEAD
    static final int IDLENGTH = 4;
    static final int NAMELENGTH = 20;
    static final int PHONELENGTH = 11;
    static final String ID  = "ID";
    static final String NAME  = "NOME";
    static final String PHONE  = "TELEFONE";
    static final String MAIL  = "E-MAIL";
    //Mandar para uma classe de contatos
    static String[][] contatos = new String[100][3];
    // Bloco estático para inicializar a matriz de contatos com strings vazias
    static {
        for (int i = 0; i < contatos.length; i++) {
            for (int j = 0; j < contatos[i].length; j++) {
                contatos[i][j] = "";
            }
        }
    }
    static int espacoContatos=0;
    /*
    Adiciona contatos
     */
    public static int cadastrarContato() {
        int posicaoVazia = 0;
        if (contatos != null) {
            for (int i = 0; i < contatos.length; i++) {
                if (contatos[i][1].isEmpty()) {
                    posicaoVazia = i;
                    break;
                }
            }
        }
        contatos[posicaoVazia][0] = ReadData.readName();
        contatos[posicaoVazia][1] = ReadData.readPhone();
        contatos[posicaoVazia][2] = ReadData.readMail();
        espacoContatos++;
        System.out.println("Contato cadastrado com sucesso!");
        return espacoContatos;
    }

    /*
    Lista contatos
     */
    public static void listarContatos() {
        System.out.println("Contatos listados com sucesso!");
    }

    /*
    Busca contatos
     */
    public static void buscarContato() {
        String numeroContato = ReadData.readPhone();
        int posicaoContato = 0;
        for (int i = 0; i < contatos.length; i++) {
            if (numeroContato.equals(contatos[i][1])) {
                posicaoContato = i+1;
                break;
            }
        }
        if (posicaoContato == 0) {
            System.out.println("Contato não encontrado!");
            return;
        } else {
            System.out.println("Contato encontrado com sucesso!");
            System.out.printf("%-" + IDLENGTH + "s\t|\t%-" + NAMELENGTH+ "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", ID, NAME, PHONE, MAIL);
            System.out.printf("%-" + IDLENGTH + "d\t|\t%-" + NAMELENGTH + "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", posicaoContato, contatos[posicaoContato-1][0], contatos[posicaoContato-1][1], contatos[posicaoContato-1][2]);
        }
    }

    /*
    Edita contatos
     */
    public static void editarContato() {
        String numeroContato = ReadData.readPhone();
        int posicaoContato = 0;
        for(int i = 0; i<contatos.length;i++) {
            if (numeroContato.equals(contatos[i][1])) {
                posicaoContato = i+1;
                break;
            }
        }
        if(posicaoContato ==0) {
            System.out.println("Contato não encontrado!");
            return;
        }else {
            contatos[posicaoContato-1][0] = ReadData.readName();
            contatos[posicaoContato-1][1] = ReadData.readPhone();
            contatos[posicaoContato-1][2] = ReadData.readMail();
            System.out.printf("%-" + IDLENGTH + "s\t|\t%-" + NAMELENGTH + "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", ID, NAME, PHONE, MAIL);
            System.out.printf("%-" + IDLENGTH + "d\t|\t%-" + NAMELENGTH + "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", posicaoContato, contatos[posicaoContato-1][0], contatos[posicaoContato-1][1], contatos[posicaoContato-1][2]);
            System.out.println("Contato excluído com sucesso!");
        }
    }

    /*
    Exclui contato
     */
    public static int excluirContato() {
        String numeroContato = ReadData.readPhone();
        int posicaoContato = 0;
        for(int i = 0; i<contatos.length;i++) {
            if (numeroContato.equals(contatos[i][1])) {
                posicaoContato = i+1;
                break;
            }
        }
        if(posicaoContato ==0) {
            System.out.println("Contato não encontrado!");
            return espacoContatos;
        }else {
            contatos[posicaoContato-1][0] = "";
            contatos[posicaoContato-1][1] = "";
            contatos[posicaoContato-1][2] = "";
            System.out.printf("%-" + IDLENGTH + "s\t|\t%-" + NAMELENGTH + "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", ID, NAME, PHONE, MAIL);
            System.out.printf("%-" + IDLENGTH + "d\t|\t%-" + NAMELENGTH + "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", posicaoContato, contatos[posicaoContato-1][0], contatos[posicaoContato-1][1], contatos[posicaoContato-1][2]);
        }
        espacoContatos--;
        System.out.println("Contato excluído com sucesso!");
        return espacoContatos;
}
    /*
    Acho que vai precisar da printAgenda também
     */
    public static void imprimirAgenda() {
        if (espacoContatos == 0) {
            System.out.println("################");
            System.out.println("##Agenda vazia##");
            System.out.println("################");
            System.out.println("Exemplo!");
            System.out.println("Exemplo!");
            System.out.println("Exemplo!");
        } else {
            System.out.println("################");
            System.out.println("#####AGENDA#####");
            System.out.println("################");

            System.out.printf("%-" + IDLENGTH + "s\t|\t%-" + NAMELENGTH + "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", ID, NAME, PHONE, MAIL);
            int id = 1;
            for (int i = 0; i < contatos.length; i++) {
                if (!contatos[i][1].isEmpty()) {
                    System.out.printf("%-" + IDLENGTH + "d\t|\t%-" + NAMELENGTH + "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", id, contatos[i][0], contatos[i][1], contatos[i][2]);
                    id++;
                }
            }
        }
    }
=======
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

>>>>>>> db64e24b04571151ec664468d61186cabad594ed
}
