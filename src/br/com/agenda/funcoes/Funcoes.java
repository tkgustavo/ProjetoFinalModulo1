package br.com.agenda.funcoes;

import br.com.agenda.read.ReadData;

public class Funcoes {

    static int NUMERO_LINHAS = 100;
    static final int NUMERO_COLUNAS = 3;
    static final int IDLENGTH = 4;
    static final int NAMELENGTH = ReadData.NAMELENGTH;
    static final int PHONELENGTH = 11;
    static final String ID = "ID";
    static final String NAME = "NOME";
    static final String PHONE = "TELEFONE";
    static final String MAIL = "E-MAIL";

    static final String NEGRITO = "\033[1m";
    static final String RESET = "\033[0m";

    static String[][] contatos = new String[NUMERO_LINHAS][NUMERO_COLUNAS];
    static int espacoContatos = 0;

    static {
        for (String[] contato : contatos) {
            for (int j = 0; j < contato.length; j++) {
                contato[j] = "";
            }
        }
    }

    public static void cadastrarContato() {
        if (espacoContatos == NUMERO_LINHAS) {
            expandirMatrizContatos();
        }

        int posicaoVazia = encontrarPosicaoVazia();

        String nome = ReadData.readName();
        if (nome.isEmpty()) return;

        String telefone = ReadData.readPhone();
        if (telefone.isEmpty()) return;

        String email = ReadData.readMail();

        contatos[posicaoVazia][0] = nome;
        contatos[posicaoVazia][1] = telefone;
        contatos[posicaoVazia][2] = email;

        espacoContatos++;
        System.out.println("Contato cadastrado com sucesso!");
    }

    public static void listarContatos() {
        exibirCabecalho("CONTATOS");

        System.out.printf("%-" + IDLENGTH + "s\t|\t%-" + NAMELENGTH + "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", ID, NAME, PHONE, MAIL);
        int id = 1;

        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i][0] != null && !contatos[i][0].isEmpty()) { // Verifica se o nome do contato não é nulo ou vazio
                System.out.printf("%-" + IDLENGTH + "d\t|\t%-" + NAMELENGTH + "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", id, contatos[i][0], contatos[i][1], contatos[i][2]);
                id++;
            }
        }

        if (id == 1) {
            System.out.println("Nenhum contato encontrado.");
        }
    }

    public static void buscarContato() {
        String numeroContato = ReadData.readPhone();
        if (numeroContato.isEmpty()) return;

        int posicaoContato = encontrarContatoPorNumero(numeroContato);

        if (posicaoContato == -1) {
            System.out.println("Contato não encontrado!");
        } else {
            exibirContato(posicaoContato + 1);
        }
    }

    public static void editarContato() {
        String numeroContato = ReadData.readPhone();

        // Retorna ao menu caso o usuário tenha saído antes de informar um número
        if (numeroContato.equals("")) {
            return;
        }

        int posicaoContato = -1;
        for (int i = 0; i < contatos.length; i++) {
            if (numeroContato.equals(contatos[i][1])) { // Verifica se o número de telefone é igual ao informado
                posicaoContato = i;
                break;
            }
        }

        if (posicaoContato == -1) { // Caso não encontre o contato
            System.out.println("Contato não encontrado!");
        } else {
            System.out.println("Editando o contato:");
            System.out.printf("Nome atual: %s\n", contatos[posicaoContato][0]);
            System.out.printf("Telefone atual: %s\n", contatos[posicaoContato][1]);
            System.out.printf("E-mail atual: %s\n", contatos[posicaoContato][2]);

            // Solicita novos dados para o contato
            String novoNome = ReadData.readName();
            String novoTelefone = ReadData.readPhone();
            String novoEmail = ReadData.readMail();

            // Atualiza o contato apenas se houver novos dados válidos
            if (!novoNome.equals("")) {
                contatos[posicaoContato][0] = novoNome;
            }
            if (!novoTelefone.equals("")) {
                contatos[posicaoContato][1] = novoTelefone;
            }
            if (!novoEmail.equals("")) {
                contatos[posicaoContato][2] = novoEmail;
            }

            System.out.println("Contato editado com sucesso!");
            System.out.printf("%-" + IDLENGTH + "s\t|\t%-" + NAMELENGTH + "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", ID, NAME, PHONE, MAIL);
            System.out.printf("%-" + IDLENGTH + "d\t|\t%-" + NAMELENGTH + "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", posicaoContato + 1, contatos[posicaoContato][0], contatos[posicaoContato][1], contatos[posicaoContato][2]);
        }
    }


    public static void excluirContato() {
        String numeroContato = ReadData.readPhone();
        if (numeroContato.isEmpty()) return;

        int posicaoContato = encontrarContatoPorNumero(numeroContato);

        if (posicaoContato == -1) {
            System.out.println("Contato não encontrado!");
        } else {
            contatos[posicaoContato][0] = "";
            contatos[posicaoContato][1] = "";
            contatos[posicaoContato][2] = "";
            espacoContatos--;

            if (espacoContatos <= NUMERO_LINHAS / 2 - 10) {
                reduzirMatrizContatos();
            }

            System.out.println("Contato excluído com sucesso!");
        }
    }

    private static void expandirMatrizContatos() {
        NUMERO_LINHAS *= 2;
        String[][] aux = new String[NUMERO_LINHAS][NUMERO_COLUNAS];

        for (int i = 0; i < contatos.length; i++) {
            System.arraycopy(contatos[i], 0, aux[i], 0, contatos[i].length);
        }

        contatos = aux;
    }

    private static void reduzirMatrizContatos() {
        NUMERO_LINHAS /= 2;
        String[][] aux = new String[NUMERO_LINHAS][NUMERO_COLUNAS];
        int posicaoAux = 0;

        for (String[] contato : contatos) {
            if (!contato[1].isEmpty()) {
                aux[posicaoAux] = contato;
                posicaoAux++;
            }
        }

        contatos = aux;
    }

    private static int encontrarPosicaoVazia() {
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i][1].isEmpty()) {
                return i;
            }
        }
        return -1;
    }

    private static int encontrarContatoPorNumero(String numeroContato) {
        for (int i = 0; i < contatos.length; i++) {
            if (numeroContato.equals(contatos[i][1])) {
                return i;
            }
        }
        return -1;
    }

    private static void exibirCabecalho(String titulo) {
        System.out.println("");
        System.out.println("##############################################################################################");
        System.out.println("###########################################" + NEGRITO + titulo + RESET + "##########################################");
        System.out.println("##############################################################################################");
    }

    private static void exibirContato(int id) {
        System.out.printf("%-" + IDLENGTH + "s\t|\t%-" + NAMELENGTH + "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", ID, NAME, PHONE, MAIL);
        System.out.printf("%-" + IDLENGTH + "d\t|\t%-" + NAMELENGTH + "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", id, contatos[id - 1][0], contatos[id - 1][1], contatos[id - 1][2]);
    }
}
