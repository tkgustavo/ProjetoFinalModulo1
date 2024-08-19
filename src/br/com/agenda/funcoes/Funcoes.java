package br.com.agenda.funcoes;

import br.com.agenda.read.ReadData;

public class Funcoes {

    static int NUMERO_MIN_LINHAS = 100;
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

        String telefone;

        while (true) {
            telefone = ReadData.readPhone();
            if (telefone.isEmpty()) return;
            if (telefoneDuplicado(telefone)) {
                System.out.println("Telefone já cadastrado.");
            } else {
                break;
            }
        }

        String email = ReadData.readMail();

        contatos[posicaoVazia][0] = nome;
        contatos[posicaoVazia][1] = telefone;
        contatos[posicaoVazia][2] = email;

        espacoContatos++;
        System.out.println("Contato cadastrado com sucesso!");
    }

    public static void cadastrarContatoComTelefone(String telefone) {
        if (telefone.isBlank()) return;
        if (espacoContatos == NUMERO_LINHAS) {
            expandirMatrizContatos();
        }

        int posicaoVazia = encontrarPosicaoVazia();

        String nome = ReadData.readName();
        if (nome.isEmpty()) return;

        String email = ReadData.readMail();

        contatos[posicaoVazia][0] = nome;
        contatos[posicaoVazia][1] = telefone;
        contatos[posicaoVazia][2] = email;

        espacoContatos++;
        System.out.println("Contato cadastrado com sucesso!");
    }

    public static void listarContatos() {
        if (espacoContatos == 0) {
            System.out.println("\nAinda não há contatos nesta agenda.");
            return;
        }
        exibirCabecalho("CONTATOS");

        System.out.printf("%-" + IDLENGTH + "s\t|\t%-" + NAMELENGTH + "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", ID, NAME, PHONE, MAIL);
        int id = 1;

        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i][0] != null && !contatos[i][0].isEmpty()) { // Verifica se o nome do contato não é nulo ou vazio
                System.out.printf("%-" + IDLENGTH + "d\t|\t%-" + NAMELENGTH + "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", id, contatos[i][0], contatos[i][1], contatos[i][2]);
                id++;
            }
        }

    }

    public static void buscarContato() {
        if (espacoContatos == 0) {
            System.out.println("\nAinda não há contatos nesta agenda.");
            return;
        }

        String numeroContato = ReadData.readPhone();
        if (numeroContato.isEmpty()) return;

        int posicaoContato = encontrarContatoPorNumero(numeroContato);

        if (posicaoContato == -1) {
            System.out.println("Contato não encontrado!");
            if (ReadData.readConfirmar()){
                cadastrarContatoComTelefone(numeroContato);
            }
        } else {
            exibirContato(posicaoContato + 1);
        }
    }



    public static void editarContato() {
        if (espacoContatos == 0) {
            System.out.println("\nAinda não há contatos nesta agenda.");
            return;
        }

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
            if (ReadData.readConfirmar()){
                cadastrarContatoComTelefone(numeroContato);
            }
        } else {
            System.out.println("Editando o contato:");
            System.out.printf("Nome atual: %s\n", contatos[posicaoContato][0]);
            System.out.printf("Telefone atual: %s\n", contatos[posicaoContato][1]);
            System.out.printf("E-mail atual: %s\n", contatos[posicaoContato][2]);

            // Solicita novos dados para o contato
            String novoNome = ReadData.readName();

            String novoTelefone;
            while (true) {
                novoTelefone = ReadData.readPhone();
                if (novoTelefone.isEmpty()) break;
                if (novoTelefone.equalsIgnoreCase(contatos[posicaoContato][1].trim())){
                    System.out.println("Este é o telefone atual!");
                }else if (telefoneDuplicado(novoTelefone)) {
                    System.out.println("Telefone já cadastrado.");
                } else {
                    break;
                }
            }

            String novoEmail = ReadData.readMail();

            // Atualiza o contato apenas se houver novos dados válidos
            boolean editado = false;
            if (!novoNome.equals("")) {
                contatos[posicaoContato][0] = novoNome;
                editado = true;
            }
            if (!novoTelefone.equals("")) {
                contatos[posicaoContato][1] = novoTelefone;
                editado = true;
            }
            if (!novoEmail.equals("")) {
                contatos[posicaoContato][2] = novoEmail;
                editado = true;
            }

            if (editado) {
                System.out.println("Contato editado com sucesso!\n");
            }else {
                System.out.println("Nenhum dado foi alterado!\n");
            }
            exibirContato(posicaoContato+1);
            //System.out.printf("%-" + IDLENGTH + "s\t|\t%-" + NAMELENGTH + "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", ID, NAME, PHONE, MAIL);
            //System.out.printf("%-" + IDLENGTH + "d\t|\t%-" + NAMELENGTH + "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", posicaoContato + 1, contatos[posicaoContato][0], contatos[posicaoContato][1], contatos[posicaoContato][2]);


        }
    }


    public static void excluirContato() {
        if (espacoContatos == 0) {
            System.out.println("\nAinda não há contatos nesta agenda.");
            return;
        }

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

            if (espacoContatos <= NUMERO_LINHAS / 2 - 10 && NUMERO_LINHAS > NUMERO_MIN_LINHAS) {
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
        for (int i = contatos.length; i < aux.length; i++) {
            aux[i] = new String[]{"", "", ""};
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
        for (int i = posicaoAux; i < aux.length; i++) {
            aux[i] = new String[]{"", "", ""};
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

    private static boolean telefoneDuplicado(String telefone){
        return encontrarContatoPorNumero(telefone) != -1;
    }

    public static void exibirCabecalho(String titulo) {
        System.out.println("\n>>>> " + NEGRITO + titulo + RESET + " <<<<");
    }

    private static void exibirContato(int id) {
        System.out.printf("%-" + IDLENGTH + "s\t|\t%-" + NAMELENGTH + "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", ID, NAME, PHONE, MAIL);
        System.out.printf("%-" + IDLENGTH + "d\t|\t%-" + NAMELENGTH + "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", id, contatos[id - 1][0], contatos[id - 1][1], contatos[id - 1][2]);
    }
    public static void cabecalho() {
        System.out.println("##############################################################################################");
        System.out.println("##########################################  "+NEGRITO+"AGENDA"+RESET+"  ##########################################");
        System.out.println("##############################################################################################");
        System.out.println("#########################################  "+NEGRITO+"EXEMPLOS"+RESET+"  #########################################");
        System.out.printf("%-" + IDLENGTH + "s\t|\t%-" + NAMELENGTH + "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", "1", "Diogenes Viana", "11111111111", "diogenes.carvalho.viana@gmail.com");
        System.out.printf("%-" + IDLENGTH + "s\t|\t%-" + NAMELENGTH + "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", "2", "Fernando Diniz", "22222222222", "diniz.rocha82@gmail.com");
        System.out.printf("%-" + IDLENGTH + "s\t|\t%-" + NAMELENGTH + "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", "3", "Gustavo Miranda", "33333333333", "gustavohenrique.miranda@hotmail.com");
        System.out.printf("%-" + IDLENGTH + "s\t|\t%-" + NAMELENGTH + "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", "4", "Kevin Silva", "44444444444", "kevin.silva2010.ks@gmail.com");
        System.out.printf("%-" + IDLENGTH + "s\t|\t%-" + NAMELENGTH + "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", "5", "Luiz Oliveira", "55555555555", "luizoliveirautonomo@gmail.com");
        System.out.printf("%-" + IDLENGTH + "s\t|\t%-" + NAMELENGTH + "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", "5", "Mário Duarte", "66666666666", "mcbd.eng@gmail.com");
    }

}
