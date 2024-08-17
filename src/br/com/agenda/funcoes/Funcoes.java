package br.com.agenda.funcoes;
import br.com.agenda.read.ReadData;
import br.com.agenda.validacoes.Validacoes;

public class Funcoes {
    static int NUMERO_LINHAS = 100;
    static final int NUMERO_COLUNAS = 3;
    static final int IDLENGTH = 4;
    static final int NAMELENGTH = ReadData.NAMELENGTH;
    static final int PHONELENGTH = 11;
    static final String ID  = "ID";
    static final String NAME  = "NOME";
    static final String PHONE  = "TELEFONE";
    static final String MAIL  = "E-MAIL";
    // Código ANSI para negrito
    static final String negrito = "\033[1m";
    static final String reset = "\033[0m";
    //Mandar para uma classe de contatos
    static String[][] contatos = new String[NUMERO_LINHAS][NUMERO_COLUNAS];
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
    public static void cadastrarContato() {
        //não testei essa lógica
        if(espacoContatos == NUMERO_LINHAS) {
            String name = ReadData.readName();
            //retorna ao menu caso o usuário tenha saído antes de cadastrar
            if (name.equals("")) {
                return;
            }
            String phone = ReadData.readPhone();
            //aqui pode ser melhor inverter a ordem para não ter que limpar o nome caso o usuário não insira o nome;
            if (phone.equals("")) {
                return;
            }
            String email = ReadData.readMail();
            espacoContatos++;
            NUMERO_LINHAS = NUMERO_LINHAS*2;
            String[][] aux = new String[NUMERO_LINHAS][NUMERO_COLUNAS];
            for (int i = 0; i < contatos.length; i++){
                for (int j = 0; j < contatos[i].length; j++) {
                    aux[i][j] = contatos[i][j];
                }
            }
            contatos = aux;
            contatos[NUMERO_LINHAS/2][0] = name;
            contatos[NUMERO_LINHAS/2][1] = phone;
            contatos[NUMERO_LINHAS/2][2] = email;
            return;
        }
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
        //retorna ao menu caso o usuário tenha saído antes de cadastrar
        if (contatos[posicaoVazia][0].equals("")) {
            return;
        }
        contatos[posicaoVazia][1] = ReadData.readPhone();
        //aqui pode ser melhor inverter a ordem para não ter que limpar o nome caso o usuário não insira o nome;
        if (contatos[posicaoVazia][1].equals("")) {
            contatos[posicaoVazia][0] = "";
            return;
        }
        contatos[posicaoVazia][2] = ReadData.readMail();
        espacoContatos++;
        System.out.println("Contato cadastrado com sucesso!");
        return;
    }

    /*
    Lista contatos
     */
    public static void listarContatos() {
        System.out.println("");
        System.out.println("##############################################################################################");
        System.out.println("###########################################"+negrito+"CONTATOS"+reset+"###########################################");
        System.out.println("##############################################################################################");

        System.out.printf("%-" + IDLENGTH + "s\t|\t%-" + NAMELENGTH + "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", ID, NAME, PHONE, MAIL);
        int id = 1;
        for (int i = 0; i < contatos.length; i++) {
            if (!contatos[i][1].isEmpty()) {
                System.out.printf("%-" + IDLENGTH + "d\t|\t%-" + NAMELENGTH + "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", id, contatos[i][0], contatos[i][1], contatos[i][2]);
                id++;
            }
        }
    }

    /*
    Busca contatos
     */
    public static void buscarContato() {
        String numeroContato = ReadData.readPhone();
        //retorna ao menu caso o usuário tenha saído antes de informar um número
        if (numeroContato.equals("")) {
            return;
        }
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
        //retorna ao menu caso o usuário tenha saído antes de informar um número
        if (numeroContato.equals("")) {
            return;
        }
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
    public static void excluirContato() {
        String numeroContato = ReadData.readPhone();
        //retorna ao menu caso o usuário tenha saído antes de informar um número
        if (numeroContato.equals("")) {
            return;
        }
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
            contatos[posicaoContato-1][0] = "";
            contatos[posicaoContato-1][1] = "";
            contatos[posicaoContato-1][2] = "";
            System.out.printf("%-" + IDLENGTH + "s\t|\t%-" + NAMELENGTH + "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", ID, NAME, PHONE, MAIL);
            System.out.printf("%-" + IDLENGTH + "d\t|\t%-" + NAMELENGTH + "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", posicaoContato, contatos[posicaoContato-1][0], contatos[posicaoContato-1][1], contatos[posicaoContato-1][2]);
            espacoContatos--;
            //não testei essa lógica, retirar o -10 para testar com uns 3 contatos
            if(espacoContatos == ((NUMERO_LINHAS/2)-10)) {//só reduz a matriz se ela tiver mais de 10 espacos vagos
                NUMERO_LINHAS = NUMERO_LINHAS/2;
                String[][] aux = new String[NUMERO_LINHAS][NUMERO_COLUNAS];
                int posicaoAux = 0;
                for (int i = 0; i < contatos.length; i++){
                    if(!contatos[i][1].isEmpty()){
                        aux[posicaoAux][0] = contatos[i][0];
                        aux[posicaoAux][1] = contatos[i][1];
                        aux[posicaoAux][2] = contatos[i][2];
                        posicaoAux++;
                    }
                }
                contatos = aux;
            }
        }
        System.out.println("Contato excluído com sucesso!");
        return;
}
    /*
    Acho que vai precisar da printAgenda também
     */
    public static void imprimirAgenda() {
        if (espacoContatos == 0) {
            System.out.println("");
            System.out.println("##############################################################################################");
            System.out.println("############################################"+negrito+"AGENDA"+reset+"############################################");
            System.out.println("##############################################################################################");
            System.out.println("###########################################"+negrito+"EXEMPLOS"+reset+"###########################################");
            System.out.printf("%-" + IDLENGTH + "s\t|\t%-" + NAMELENGTH + "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", "1", "Diogenes Viana", "11111111111", "diogenes.carvalho.viana@gmail.com");
            System.out.printf("%-" + IDLENGTH + "s\t|\t%-" + NAMELENGTH + "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", "2", "Fernando Diniz", "22222222222", "diniz.rocha82@gmail.com");
            System.out.printf("%-" + IDLENGTH + "s\t|\t%-" + NAMELENGTH + "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", "3", "Gustavo Miranda", "33333333333", "gustavohenrique.miranda@hotmail.com");
            System.out.printf("%-" + IDLENGTH + "s\t|\t%-" + NAMELENGTH + "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", "4", "Kevin Silva", "44444444444", "kevin.silva2010.ks@gmail.com");
            System.out.printf("%-" + IDLENGTH + "s\t|\t%-" + NAMELENGTH + "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", "5", "Luiz Oliveira", "55555555555", "luizoliveirautonomo@gmail.com");
            System.out.printf("%-" + IDLENGTH + "s\t|\t%-" + NAMELENGTH + "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", "5", "Mário Duarte", "66666666666", "mcbd.eng@gmail.com");
        } /*else {
            System.out.println("");
            System.out.println("##############################################################################################");
            System.out.println("############################################"+negrito+"AGENDA"+reset+"############################################");
            System.out.println("##############################################################################################");

            System.out.printf("%-" + IDLENGTH + "s\t|\t%-" + NAMELENGTH + "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", ID, NAME, PHONE, MAIL);
            int id = 1;
            for (int i = 0; i < contatos.length; i++) {
                if (!contatos[i][1].isEmpty()) {
                    System.out.printf("%-" + IDLENGTH + "d\t|\t%-" + NAMELENGTH + "s\t|\t%-" + PHONELENGTH + "s\t|\t%s\n", id, contatos[i][0], contatos[i][1], contatos[i][2]);
                    id++;
                }
            }
        }*/
    }
}


