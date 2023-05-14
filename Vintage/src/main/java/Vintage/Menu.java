package Vintage;

import Vintage.Artigos.Mala;
import Vintage.Artigos.Sapatilha;
import Vintage.Artigos.TShirt;
import Vintage.Transportadoras.Transportadora;
import Vintage.Users.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//import java.time.LocalDate;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static Vintage.ControllerTempo.dataValida;

public class Menu {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN =  "\u001B[32m";
    public static final String ANSI_GOLD = "\u001B[38;5;220m";
    static Scanner input = new Scanner(System.in);
    public static void printLogo(){
        Logo.logo();
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static int menuPrincipal(Vintage vintage){
        limpaTerminal();
        Scanner input = new Scanner(System.in);
        int i = -1; // default value for i
        String sb = "\t\t\t\t\t -MENU INICIAL-  \t\t\t Data atual: " + vintage.getEstado().getTempoAtual() + "\n\n\n" +

                "[1] - Iniciar a sessao.\n" +
                "[2] - Criar (User, etc...).\n" +
                "[3] - Remover.\n" +
                "[4] - Avancar tempo.\n" +
                "[5] - Mostrar Logs.\n" +
                "[6] - Guardar estado.\n" +
                "[7] - Carregar estado.\n" +
                "[8] - Estatisticas.\n" +
                "[0] - Sair.\n" +

                "\n\nSelecione a opcao pretendida: ";
        System.out.println(sb);
        try{
                i = input.nextInt();
        }
        catch(java.util.InputMismatchException e){
            Menu.limpaTerminal();
            Menu.errors(7);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e1){
                e.printStackTrace();
            }
            Menu.pressToContinue();
        }
        return i;
    }

    public static int menuAvancarTempo(Vintage vintage){
        limpaTerminal();
        int i = -1; // default value for i
        String sb = "\t\t\t\t\t -MAQUINA DO TEMPO-  \t\t\t Data atual: " + vintage.getEstado().getTempoAtual() + "\n\n\n" +

                "[1] - Avancar 1 dia.\n" +
                "[2] - Avancar 5 dias.\n" +
                "[3] - Avancar para uma determinada data.\n" +
                "[0] - Voltar.\n" +

                "\n\nSelecione a opcao pretendida: ";
        System.out.println(sb);
        try{
            i = input.nextInt();
        }
        catch(java.util.InputMismatchException e){
            Menu.limpaTerminal();
            Menu.errors(7);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e1){
                e.printStackTrace();
            }
            Menu.pressToContinue();
        }
        return i;
    }

    public static void menuAvancarData(Vintage vintage){
        limpaTerminal();
        String s;
        String sb = "\t\t\t\t\t -MAQUINA DO TEMPO-  \t\t\t Data atual: " + vintage.getEstado().getTempoAtual() + "\n\n\n"+

                "Introduza a data pretendida (YYYY-MM-DD): ";
        System.out.println(sb);
        s = input.nextLine();
        Menu.limpaTerminal();
        if(!dataValida(s,vintage.getEstado().getTempoAtual()))
            Menu.errors(24);
        else{
            LocalDate data;
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
            data = LocalDate.parse(s, formatter);
            vintage.getEstado().setTempoAtual(data);
            vintage.getEstado().escreverLog("Data avancou para o dia : " + vintage.getEstado().getTempoAtual() + "\n");
        }
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        Menu.pressToContinue();
    }

    

    public static int menuStats(){
        limpaTerminal();
        Scanner input = new Scanner(System.in);
        int i = 0;
        String sb = """
                \t\t\t\t\t -MENU ESTATISTICAS-

                [1] - Listar Utilizadores.
                [2] - Listar Artigos disponiveis para venda.
                [3] - Listar Transportadoras.
                [4] - Qual o vendedor que mais facturou num período ou desde sempre.
                [5] - Qual o transportador com maior volume de facturacao.
                [6] - Listar as encomendas emitidas por um vendedor.
                [7] - Fornecer uma ordenacao dos maiores compradores/vendedoresdo sistema durante um período a determinar.
                [8] - Determinar quanto dinheiro ganhou o Vintage no seu funcionamento.
                [0] - Voltar.

                Selecione a opcao pretendida:\s""";
        System.out.println(sb);
        try{
            if(input.hasNextInt())
                i = input.nextInt();
        }
        catch(java.util.InputMismatchException e){
            Menu.errors(7);
            Menu.pressToContinue();
        }
        return i;
    }

    public static void limpaTerminal(){
        try{
            if(System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {
            // handle exceptions (fazer depois)
        }
    }

    public static String login(){
        String resultado = null;
        System.out.println("Introduza o seu email: ");
        try{
            if(input.hasNextLine())
                resultado = input.nextLine();
        }
        catch(java.util.NoSuchElementException e){
            errors(6);
        }
        return resultado;
    }

    public static int menuCriarArtigo(){
        int i = 0;
        limpaTerminal();
        String sb = """
                \t\t\t\t\t -CRIAR-\s

                [1] Criar SAPATILHA.
                [2] Criar MALA.
                [3] Criar T-SHIRT.
                [0] Voltar.
                """;
        System.out.println(sb);
        try{
            if(input.hasNextInt())
                i  = input.nextInt();
        }
        catch(java.util.InputMismatchException e){
            Menu.errors(7);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e1){
                e.printStackTrace();
            }
        }
        return i;
    }


    public static int menuCriar(){
        limpaTerminal();
        Scanner input = new Scanner(System.in);
        int i = 0;
        String sb = """
                \t\t\t\t\t -CRIAR-\s

                [1] Criar USER.
                [2] Criar ARTIGO.
                [3] Criar TRANSPORTADORA.
                [4] Criar ENCOMENDA.
                [0] Voltar.
                """;
        System.out.println(sb);
        try{
            if(input.hasNextInt())
                i  = input.nextInt();
        }
        catch(java.util.InputMismatchException e){
            Menu.errors(7);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e1){
                e.printStackTrace();
            }
        }
        return i;
    }

    public static int menuRemover(){
        limpaTerminal();
        Scanner input = new Scanner(System.in);
        int i = 0;
        String sb = """
                \t\t\t\t\t -REMOVER-\s

                [1] Remover USER.
                [2] Remover ARTIGO.
                [3] Remover TRANSPORTADORA.
                [4] Remover ENCOMENDA.
                [0] Voltar.
                """;
        System.out.println(sb);
        try{
            if(input.hasNextInt())
                i  = input.nextInt();
        }
        catch(java.util.InputMismatchException e){
            Menu.errors(7);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e1){
                e.printStackTrace();
            }
        }
        return i;
    }

    public static int tipoArtigo(){
        limpaTerminal();
        Scanner input = new Scanner(System.in);
        int i = 0;
        String sb = """
                \t\t\t\t\t -ESCOLHER TIPO-\s

                [1] Adicionar Usado.
                [2] Adicionar Novo.
                [0] Voltar.
                """;
        System.out.println(sb);
        try{
            if(input.hasNextInt())
                i  = input.nextInt();
        }
        catch(java.util.InputMismatchException e){
            Menu.errors(7);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e1){
                e.printStackTrace();
            }
        }
        return i;
    }

    public static Sapatilha criarSapatilhaNova(String codigo) {
        limpaTerminal();
        System.out.println("\t\t\t\t\t -CRIAR SAPATILHA (NOVA)-\n\n");
        System.out.println("Introduza os dados pedidos.\n\n");
        input.nextLine();
        String descricao = lerString("Descricao: ");
        String marca = lerString("Marca: ");
        double preco = lerDouble("Preco: ");
        int tamanho = lerInteiro("Tamanho: ");
        boolean atacadores = lerBooleano("Tem atacadores? [true/false]: ");
        String cor = lerString("Cor: ");
        LocalDate dataColecao = lerData("Data da Colecao [YYYY-MM-DD]: ");

        Sapatilha.Edicao edicao = Sapatilha.Edicao.STANDARD; // se houver tempo ver opcao primium...

        return new Sapatilha(codigo, descricao, marca, preco, tamanho, atacadores, cor, dataColecao, 0, edicao);
    }

    public static Sapatilha criarSapatilhaUsada(String codigo) {
        limpaTerminal();
        System.out.println("\t\t\t\t\t -CRIAR SAPATILHA (USADA)-\n\n");
        System.out.println("Introduza os dados pedidos.\n\n");

        double avaliacao = lerDouble("Avaliacao: ");
        int nDonos = lerInteiro("Numero de Donos: ");
        String descricao = lerString("Descricao: ");
        String marca = lerString("Marca: ");
        double preco = lerDouble("Preco: ");
        int tamanho = lerInteiro("Tamanho: ");
        boolean atacadores = lerBooleano("Tem atacadores? [true/false]: ");
        String cor = lerString("Cor: ");
        LocalDate dataColecao = lerData("Data da Colecao [YYYY-MM-DD]: ");
        int desconto = lerInteiro("Desconto: ");

        Sapatilha.Edicao edicao = Sapatilha.Edicao.STANDARD; // se houver tempo ver opcao primium...

        return new Sapatilha(codigo, avaliacao, nDonos, descricao, marca, preco, null, tamanho, atacadores, cor, dataColecao, desconto, edicao);
    }

    public static Mala criarMalaNova(String codigo){
        limpaTerminal();
        System.out.println("\t\t\t\t\t -CRIAR MALA (NOVA)-\n\n");
        System.out.println("Introduza os dados pedidos.\n\n");
        input.nextLine();
        String descricao = lerString("Descricao: ");
        String marca = lerString("Marca: ");
        double preco = lerDouble("Preco: ");
        double largura = lerDouble("largura: ");
        double altura = lerDouble("Altura: ");
        String tamanho = lerString("Material: ");
        LocalDate dataColecao = lerData("Data da Colecao [YYYY-MM-DD]: ");

        Mala.Edicao edicao = Mala.Edicao.STANDARD;

        return new Mala(codigo,descricao,marca,preco,largura,altura,0,tamanho,dataColecao,edicao);
    }

    public static Mala criarMalaUsada(String codigo){
        limpaTerminal();
        System.out.println("\t\t\t\t\t -CRIAR MALA (USADA)-\n\n");
        System.out.println("Introduza os dados pedidos.\n\n");

        double avaliacao = lerDouble("Avaliacao: ");
        int nDonos = lerInteiro("Numero de Donos: ");
        String descricao = lerString("Descricao: ");
        String marca = lerString("Marca: ");
        double preco = lerDouble("Preco: ");
        double largura = lerDouble("largura: ");
        double altura = lerDouble("Altura: ");
        String tamanho = lerString("Material: ");
        LocalDate dataColecao = lerData("Data da Colecao [YYYY-MM-DD]: ");
        int desconto = lerInteiro("Desconto: ");

        Mala.Edicao edicao = Mala.Edicao.STANDARD;

        return new Mala(codigo,avaliacao,nDonos,descricao,marca,preco,null,largura,altura,desconto,tamanho,dataColecao,edicao);
    }


    public static TShirt criarTShirtNova(String codigo){
        limpaTerminal();
        System.out.println("\t\t\t\t\t -CRIAR TSHIRT (NOVA)-\n\n");
        System.out.println("Introduza os dados pedidos.\n\n");

        String descricao = lerString("Descricao: ");
        String marca = lerString("Marca: ");
        double preco = lerDouble("Preco: ");


        //LocalDate dataColecao = lerData("Data da Colecao [YYYY-MM-DD]: ");

        int desconto = lerInteiro("Desconto: ");

        TShirt.Padrao padrao = TShirt.Padrao.LISO;
        TShirt.Tamanho tamanho = TShirt.Tamanho.M;

        return new TShirt(codigo,descricao,marca,preco,null,tamanho,padrao,desconto);
    }


    public static TShirt criarTShirtUsada(String codigo){
        limpaTerminal();
        System.out.println("\t\t\t\t\t -CRIAR TSHIRT (USADA)-\n\n");
        System.out.println("Introduza os dados pedidos.\n\n");

        double avaliacao = lerDouble("Avaliacao: ");
        int nDonos = lerInteiro("Numero de Donos: ");
        String descricao = lerString("Descricao: ");
        String marca = lerString("Marca: ");
        double preco = lerDouble("Preco: ");


        //LocalDate dataColecao = lerData("Data da Colecao [YYYY-MM-DD]: ");

        int desconto = lerInteiro("Desconto: ");

        TShirt.Padrao padrao = TShirt.Padrao.LISO;
        TShirt.Tamanho tamanho = TShirt.Tamanho.M;

        return new TShirt(codigo,avaliacao,nDonos,descricao,marca,preco,null,tamanho,padrao,desconto);
    }

    private static double lerDouble(String prompt) {
        System.out.println(prompt);
        while (!input.hasNextDouble()) {
            input.nextLine(); // Limpa o buffer de entrada
            System.out.println("Entrada invalida. Digite um numero decimal.");
            System.out.println(prompt);
        }
        double valor = input.nextDouble();
        input.nextLine(); // Limpa o buffer de entrada
        return valor;
    }

    private static int lerInteiro(String prompt) {
        System.out.println(prompt);
        while (!input.hasNextInt()) {
            input.nextLine(); // Limpa o buffer de entrada
            System.out.println("Entrada invalida. Digite um numero inteiro.");
            System.out.println(prompt);
        }
        int valor = input.nextInt();
        input.nextLine(); // Limpa o buffer de entrada
        return valor;
    }

    private static boolean lerBooleano(String prompt) {
        System.out.println(prompt);
        while (!input.hasNextBoolean()) {
            input.nextLine(); // Limpa o buffer de entrada
            System.out.println("Entrada invalida. Digite 'true' ou 'false'.");
            System.out.println(prompt);
        }
        boolean valor = input.nextBoolean();
        input.nextLine(); // Limpa o buffer de entrada
        return valor;
    }

    private static String lerString(String prompt) {
        System.out.println(prompt);
        return input.nextLine();
    }

    private static LocalDate lerData(String prompt) {
        System.out.println(prompt);
        String dataString = input.nextLine();
        return ControllerTempo.dataConverter(dataString);
    }

    public static String removerArtigo(){
        input.nextLine();
        System.out.println("\t\t\t\t\t -REMOVER ARTIGO-\n\n");
        System.out.println("Introduza os dados pedidos.\n\n");
        System.out.println("Codigo: ");
        String codigo = "---";
        if(input.hasNextLine())
            codigo = input.nextLine();
        return codigo;
    }

    public static String removerUser(){
        Scanner input = new Scanner(System.in);
        System.out.println("\t\t\t\t\t -REMOVER UTILIZADOR-\n\n");
        System.out.println("Introduza os dados pedidos.\n\n");
        System.out.println("Email: ");
        String email = "---";
        if(input.hasNextLine())
            email = input.nextLine();
        return email;
    }


    public static User registarNovoUser(int codigo){
        Scanner input = new Scanner(System.in);
        System.out.println("\t\t\t\t\t -REGISTAR NOVO UTILIZADOR-\n\n");
        System.out.println("Introduza os dados pedidos.\n\n");
        System.out.println("Email: ");
        String email = "---";
        if(input.hasNextLine())
            email = input.nextLine();

        System.out.println("\nNome: ");
        String nome = "---";
        if(input.hasNextLine())
            nome = input.nextLine();

        System.out.println("\nMorada: ");
        String morada = "---";

        if(input.hasNextLine())
            morada = input.nextLine();

        int nif = 0;
        while (nif <= 0){
            nif = nifValido(nif);
        }
        return new User(codigo, email, nome, morada, nif);
    }

    public static String removerTransportadora(){
        Scanner input = new Scanner(System.in);
        System.out.println("\t\t\t\t\t -REMOVER TRANSPORTADORA-\n\n");
        System.out.println("Introduza os dados pedidos.\n\n");
        System.out.println("Nome: ");
        String nome = "---";
        if(input.hasNextLine())
            nome = input.nextLine();
        return nome;
    }

    public static Transportadora registarNovaTransportadora(){
        Scanner input = new Scanner(System.in);
        System.out.println("\t\t\t\t\t -REGISTAR NOVA TRANSPORTADORA-\n\n");
        System.out.println("Introduza os dados pedidos.\n\n");
        System.out.println("Nome: ");
        String nome = "---";
        if(input.hasNextLine())
            nome = input.nextLine();
        return new Transportadora(nome);
    }

    // Registar Encomenda -> ver com mais calma
    /*
    public static Encomenda registarNovaEncomenda(){
        input.nextLine();
        System.out.println("\t\t\t\t\t -REGISTAR NOVA ENCOMENDA-\n\n");
        System.out.println("Introduza os dados pedidos.\n\n");

        System.out.println("Preço final: ");
        Double precoFinal = 0.0;
        if(input.hasNextDouble())
            precoFinal = input.nextDouble();


        return new Encomenda();
    }*/



    public static int menuGerirPerfil(User user){
        int i = -1;
        limpaTerminal();
        String sb = "\t\t\t\t\t -GERIR PERFIL-\n\n" +
                "DADOS DO UTILIZADOR: \n\n" +
                "EMAIL: " + user.getEmail() + "\n\n" +
                "NOME: " + user.getNome() + "\n\n" +
                "MORADA: " + user.getMorada() + "\n\n" +
                "NIF: " + user.getNif() + "\n\n" +
                "[1] Alterar NOME.\n" +
                "[2] Alterar MORADA.\n" +
                "[3] Alterar NIF.\n" +
                "[4] Salvar alteracoes.\n" +
                "[0] Voltar.\n\n" +
                "Selecione a opcao pretendida: ";
        System.out.println(sb);
        try{
                i  = input.nextInt();
        }
        catch(java.util.InputMismatchException e){
            Menu.limpaTerminal();
            Menu.errors(7);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e1){
                e.printStackTrace();
            }
            Menu.pressToContinue();
        }
        return i;
    }

    public static void pressToContinue(){
        System.out.println("Para continuar pressione qualquer tecla...");
        input.nextLine();
    }

    public static int menuUser(String name){
        limpaTerminal();
        Scanner input = new Scanner(System.in);
        int i = -1;
        String sb = "\t\t\t\t\t -MENU UTILIZADOR (Nome: " + name + ")-\n\n" +
                "[1] Gerir vendas.\n" +
                "[2] Gerir compras.\n" +
                "[3] Gerir perfil.\n" +
                "[0] Logout.\n\n" +
                "Selecione a opcao pretendida: ";
        System.out.println(sb);
        try{
                i = input.nextInt();
        }
        catch(java.util.InputMismatchException e){
            Menu.limpaTerminal();
            Menu.errors(7);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e1){
                e.printStackTrace();
            }
            Menu.pressToContinue();
        }
        return i;
    }

    public static int nifValido(int nif){
        Scanner input = new Scanner(System.in);
        System.out.println("\nNIF: ");
        try{
            nif = input.nextInt();
        }
        catch(java.util.InputMismatchException e){
            Menu.errors(11);
        }
        return nif;
    }

    public static int menuVenderArtigo(String name){
        limpaTerminal();
        int i = 0;
        String sb = "\t\t\t\t\t -MENU VENDAS (Nome: " + name + ")-\n\n" +
                "[1] Vender Artigo.\n" +
                "[2] Listar Artigos vendidos por mim.\n" +
                "[0] Cancelar.\n\n" +
                "Selecione a opcao pretendida: ";
        System.out.println(sb);
        try{
            if(input.hasNextInt())
                i = input.nextInt();
        }
        catch(java.util.InputMismatchException e){
            Menu.errors(7);
        }
        return i;
    }

    //public static 

    public static int menuComprarArtigo(String name){
        limpaTerminal();
        int i = 0;
        String sb = "\t\t\t\t\t -MENU COMPRAS (Nome: " + name + ")-\n\n" +
                "[1] Listar os artigos que pode comprar.\n" +
                "[0] Cancelar.\n\n";
        System.out.println(sb);
        try{
            if(input.hasNextInt())
                i = input.nextInt();
        }
        catch(java.util.InputMismatchException e){
            Menu.errors(7);
        }
        return i;
    }

    public static String save(){
        String save = " ";
        System.out.println("Escreve o nome do ficheiro onde vao ser guardados os dados: ");
        input.nextLine();
        if(input.hasNextLine())
            save = input.nextLine();
        return save;
    }

    public static String load(){
        String load = " ";
        System.out.println("Escreve o nome do ficheiro de onde vao ser carregados os dados: ");
        input.nextLine();
        if(input.hasNextLine())
            load = input.nextLine();
        return load;
    }

    public static String printLogs() {
        StringBuilder logs = new StringBuilder();
        try {
            FileReader fileReader = new FileReader("logs/logs.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                logs.append(linha).append("\n");
            }

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return logs.toString();
    }


    public static String errors(int i){
        limpaTerminal();
        StringBuilder sb = new StringBuilder();
        if (i == 1) sb.append(ANSI_RED).append("!!!! Email ja existe !!!!\n").append(ANSI_RESET);
        else if(i == 2) sb.append(ANSI_RED).append("!!!! Erro a encotrar o ficheiro !!!!\n").append(ANSI_RESET);
        else if(i == 3) sb.append(ANSI_RED).append("!!!! Nao foi possivel guardar o estado !!!!\n").append(ANSI_RESET);
        else if(i == 4) sb.append(ANSI_RED).append("!!!! Erro associado a classes !!!!\n").append(ANSI_RESET);
        else if(i == 5) sb.append(ANSI_RED).append("!!!! Não foi possivel carregar o estado !!!!\n").append(ANSI_RESET);
        else if(i == 6) sb.append(ANSI_RED).append("!!!! Email nao encontrado !!!!\n").append(ANSI_RESET);
        else if(i == 7) sb.append(ANSI_RED).append("!!!! Introduza uma opcao valida !!!!\n").append(ANSI_RESET);
        // Erro ao atualizar
        else if(i == 8) sb.append(ANSI_RED).append("!!!! Erro ao atualizar o NOME !!!!\n").append(ANSI_RESET);
        else if(i == 9) sb.append(ANSI_RED).append("!!!! Erro ao atualizar a MORADA !!!!\n").append(ANSI_RESET);
        else if(i == 10) sb.append(ANSI_RED).append("!!!! Erro ao atualizar o NIF !!!!\n").append(ANSI_RESET);
        else if(i == 11) sb.append(ANSI_RED).append("!!!! Volte a introduzir o NIF !!!!\n").append(ANSI_RESET);
        else if (i == 12) sb.append(ANSI_RED).append("!!!! Nome de Transportadora ja existe !!!!\n").append(ANSI_RESET);
        // Erro Estado
        else if (i == 13) sb.append(ANSI_RED).append("!!!! Erro ao salvar estado !!!!\n").append(ANSI_RESET);
        else if (i == 14) sb.append(ANSI_RED).append("!!!! Erro ao carregar estado !!!!\n").append(ANSI_RESET);
        // Erro ao remover
        else if(i == 15) sb.append(ANSI_RED).append("--Erro ao remover Transportadora!--\n").append(ANSI_RESET);
        else if(i == 16) sb.append(ANSI_RED).append("--Erro ao remover Utilizador!--\n").append(ANSI_RESET);
        else if(i == 17) sb.append(ANSI_RED).append("--Erro ao remover Artigo!--\n").append(ANSI_RESET);
        else if(i == 18) sb.append(ANSI_RED).append("--Erro ao remover Encomenda!--\n").append(ANSI_RESET);
        // Erro ao criar
        else if(i == 19) sb.append(ANSI_RED).append("--Erro ao criar Transportadora!--\n").append(ANSI_RESET);
        else if(i == 20) sb.append(ANSI_RED).append("--Erro ao criar Utilizador!--\n").append(ANSI_RESET);
        else if(i == 21) sb.append(ANSI_RED).append("--Erro ao criar Artigo!--\n").append(ANSI_RESET);
        else if(i == 22) sb.append(ANSI_RED).append("--Erro ao criar Encomenda!--\n").append(ANSI_RESET);
        else if(i == 23) sb.append(ANSI_RED).append("--Utilizador com esse email nao existe!--\n").append(ANSI_RESET);
        else if(i == 24) sb.append(ANSI_RED).append("--Data invalida!--\n").append(ANSI_RESET);
        System.out.println(sb);
        return sb.toString();
    }

    public static String success(int i){
        limpaTerminal();
        StringBuilder sb = new StringBuilder();
        // atualizar
        if (i == 1) sb.append(ANSI_GREEN).append("--- NOME atualizado com sucesso! ---\n").append(ANSI_RESET);
        else if(i == 2) sb.append(ANSI_GREEN).append("--- MORADA atualizado com sucesso! ---\n").append(ANSI_RESET);
        else if(i == 3) sb.append(ANSI_GREEN).append("--- NIF atualizado com sucesso! ---\n").append(ANSI_RESET);
        else if(i == 4) sb.append(ANSI_GREEN).append("--- Alteracoes guardadas com sucesso! ---\n").append(ANSI_RESET);
        // Criar
        else if(i == 5) sb.append(ANSI_GREEN).append("--Transportadora adicionada com successo!--\n").append(ANSI_RESET);
        else if(i == 6) sb.append(ANSI_GREEN).append("--Utilizador adicionado com successo!--\n").append(ANSI_RESET);
        else if(i == 7) sb.append(ANSI_GREEN).append("--Artigo adicionado com successo!--\n").append(ANSI_RESET);
        else if(i == 8) sb.append(ANSI_GREEN).append("--Encomenda adicionada com successo!--\n").append(ANSI_RESET);
        // Remover
        else if(i == 9) sb.append(ANSI_GREEN).append("--Transportadora removida com successo!--\n").append(ANSI_RESET);
        else if(i == 10) sb.append(ANSI_GREEN).append("--Utilizador removido com successo!--\n").append(ANSI_RESET);
        else if(i == 11) sb.append(ANSI_GREEN).append("--Artigo removido com successo!--\n").append(ANSI_RESET);
        else if(i == 12) sb.append(ANSI_GREEN).append("--Encomenda removida com successo!--\n").append(ANSI_RESET);
        // Guardar / Carregar
        else if(i == 13) sb.append(ANSI_GREEN).append("--Estado salvo com successo!--\n").append(ANSI_RESET);
        else if(i == 14) sb.append(ANSI_GREEN).append("--Ficheiro carregado com successo!--\n").append(ANSI_RESET);
        else if(i == 15) sb.append(ANSI_GREEN).append("\n--Programa terminado com sucesso!--\n").append(ANSI_RESET);
        // Perfil User
        else if(i == 16) sb.append(ANSI_GREEN).append("\n--Seja bem-vindo!--\n").append(ANSI_RESET);
        System.out.println(sb);
        return sb.toString();
    }
}
