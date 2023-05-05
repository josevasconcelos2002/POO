package Vintage;

import Vintage.Artigos.Artigo;
import Vintage.Users.User;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void printLogo(){
        Logo.logo();
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static int menuPrincipal(){
        limpaTerminal();
        int i = 0; // default value for i
        try{
            StringBuilder sb = new StringBuilder("\t\t\t\t\t -MENU INICIAL-\n\n");
            sb.append("[1] - Iniciar a sessao.\n");
            sb.append("[2] - Registar conta.\n");
            sb.append("[3] - Mostrar Logs.\n");
            sb.append("[4] - Guardar estado.\n");
            sb.append("[5] - Carregar estado.\n");
            sb.append("[6] - Estatisticas.\n");
            sb.append("[0] - Sair.\n\n");
            sb.append("Selecione a opcao pretendida: ");
            System.out.println(sb.toString());
            try (Scanner input = new Scanner(System.in)) {
                i = input.nextInt();
            }
        }
        catch(java.util.InputMismatchException e){
            Menu.errors(7);
        }
        return i;
    }
    

    public static int menuStats(){
        limpaTerminal();
        int i = 0;
        try{
            StringBuilder sb = new StringBuilder("\t\t\t\t\t -MENU ESTATISTICAS-\n\n");
            sb.append("[1] - Listar utilizadores.\n");
            sb.append("[2] - Listar Artigos.\n");
            sb.append("[3] - Qual o vendedor que mais facturou num período ou desde sempre.\n");
            sb.append("[4] - Qual o transportador com maior volume de facturacao.\n");
            sb.append("[5] - Listar as encomendas emitidas por um vendedor.\n");
            sb.append("[6] - Fornecer uma ordenacao dos maiores compradores/vendedores" +
                    "do sistema durante um período a determinar.\n");
            sb.append("[7] - Determinar quanto dinheiro ganhou o Vintage.Vintage no seu funcionamento.\n");
            sb.append("[0] - Sair.\n\n");
            sb.append("Selecione a opcao pretendida: ");
            System.out.println(sb.toString());
            try (Scanner input = new Scanner(System.in)) {
                i = input.nextInt();
            }
        }
        catch(java.util.InputMismatchException e){
            Menu.errors(7);
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
        System.out.println("Introduza o seu email: ");
        try (Scanner input = new Scanner(System.in)) {
            return input.nextLine();
        }
    }

    public static int menuGerirPerfil(User user){
        int i = 0;
        StringBuilder sb = new StringBuilder("\t\t\t\t\t -GERIR PERFIL-\n\n");
        sb.append("\t DADOS DO UTILIZADOR: \n");
        sb.append("Email: " + user.getEmail() + "\n");
        sb.append("Nome: " + user.getNome() + "\n");
        sb.append("Morada: " + user.getMorada() + "\n");
        sb.append("[1] Alterar nome.\n");
        sb.append("[2] Alterar morada.\n");
        sb.append("[3] Alterar NIF.\n");
        sb.append("[4] Salvar alterações.\n");
        sb.append("[0] Voltar.\n\n");
        sb.append("Selecione a opcao pretendida: ");
        System.out.println(sb.toString());
        try (Scanner scanner = new Scanner(System.in)) {
            i  = scanner.nextInt();
        }
        catch(java.util.InputMismatchException e){
            Menu.errors(7);
        }
        return i;
    }

    public static String pressToContinue(){
        System.out.println("Para continuar pressione qualquer tecla...");
        try (Scanner input = new Scanner(System.in)) {
            return input.nextLine();
        }
    }

    public static int menuUser(String name){
        limpaTerminal();
        int i = 0;
        try{
            StringBuilder sb = new StringBuilder("\t\t\t\t\t -MENU UTILIZADOR (Nome: " + name + ")-\n\n");
            sb.append("[1] Gerir vendas.\n");
            sb.append("[2] Gerir compras.\n");
            sb.append("[3] Gerir perfil.\n");
            sb.append("[0] Logout.\n\n");
            sb.append("Selecione a opcao pretendida: ");
            System.out.println(sb.toString());
            try (Scanner scanner = new Scanner(System.in)) {
                i = scanner.nextInt();
            }
        }
        catch(java.util.InputMismatchException e){
            Menu.errors(7);
        }
        return i;
    }

    public static User registarNovoUser(int codigo){
        StringBuilder sb = new StringBuilder("\t\t\t\t\t -REGISTAR NOVO UTILIZADOR-\n\n");

        try (Scanner input = new Scanner(System.in)) {
            sb.append("Introduza os dados pedidos.\n\n");
            sb.append("Email: ");
            System.out.println(sb.toString());
            String email = input.nextLine();

            System.out.println("Nome: ");
            String nome = input.nextLine();

            System.out.println("Morada: ");
            String morada = input.nextLine();

            int nif = 0;
            while (nif <= 0){
                nif = nifValido(nif);
            }
            return new User(codigo, email, nome, morada, nif);
        }
    }

    public static int nifValido(int nif){
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("NIF: ");
            try{
                nif = input.nextInt();
            }
            catch(java.util.InputMismatchException e){
                Menu.errors(8);
            }
        }
        return nif;
    }

    public static int venderArtigo(String name){
        limpaTerminal();
        int i = 0;
        try{
            StringBuilder sb = new StringBuilder("\t\t\t\t\t -MENU UTILIZADOR (Nome: " + name + ")-\n\n");
            sb.append("[1] Vender Mala.\n");
            sb.append("[2] Vender T-Shirt.\n");
            sb.append("[3] Vender Sapatilha.\n");
            sb.append("[0] Cancelar.\n\n");
            sb.append("Selecione a opcao pretendida: ");
            System.out.println(sb.toString());
            try (Scanner scanner = new Scanner(System.in)) {
                i = scanner.nextInt();
            }
        }
        catch(java.util.InputMismatchException e){
            Menu.errors(7);
        }
        return i;
    }

    public static int comprarArtigo(String name){
        limpaTerminal();
        int i = 0;
        try{
            StringBuilder sb = new StringBuilder("\t\t\t\t\t -MENU UTILIZADOR (Nome: " + name + ")-\n\n");
            sb.append("[1] Listar os artigos que pode comprar.");
            sb.append("[0] Cancelar.\n\n");
            System.out.println(sb.toString());
            try (Scanner scanner = new Scanner(System.in)) {
                i = scanner.nextInt();
            }
        }
        catch(java.util.InputMismatchException e){
            Menu.errors(7);
        }
        return i;
    }

    public static String save(){
        System.out.println("Escreve o nome do ficheiro onde vao ser guardados os dados: ");
        try (Scanner input = new Scanner(System.in)) {
            return input.nextLine();
        }
    }

    public static String load(){
        System.out.println("Escreve o nome do ficheiro de onde vao ser carregados os dados: ");
        try (Scanner input = new Scanner(System.in)) {
            return input.nextLine();
        }
    }

    public static void errors(int i){
        limpaTerminal();
        StringBuilder sb = new StringBuilder();
        if (i == 1) sb.append(ANSI_RED).append("!!!! Email ja existe !!!!\n").append(ANSI_RESET);
        else if(i == 2) sb.append(ANSI_RED).append("!!!! Erro a encotrar o ficheiro !!!!\n").append(ANSI_RESET);
        else if(i == 3) sb.append(ANSI_RED).append("!!!! Nao foi possivel guardar o estado !!!!\n").append(ANSI_RESET);
        else if(i == 4) sb.append(ANSI_RED).append("!!!! Erro associado a classes !!!!\n").append(ANSI_RESET);
        else if(i == 5) sb.append(ANSI_RED).append("!!!! Não foi possivel carregar o estado !!!!\n").append(ANSI_RESET);
        else if(i == 6) sb.append(ANSI_RED).append("!!!! Email nao encontrado !!!!\n").append(ANSI_RESET);
        else if(i == 7) sb.append(ANSI_RED).append("!!!! Introduza uma opção valida !!!!\n").append(ANSI_RESET);
        else if(i == 8) sb.append(ANSI_RED).append("!!!! NIF invalido. Altere este campo. !!!!\n").append(ANSI_RESET);
        else if(i == 9) sb.append(ANSI_RED).append("!!!! Erro ao atualizar o nome !!!!\n").append(ANSI_RESET);
        System.out.println(sb.toString());
        if(i != 8)pressToContinue();
    }
}
