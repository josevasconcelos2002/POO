package Vintage;

import Vintage.Users.User;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN =  "\u001B[32m";
    static Scanner input = new Scanner(System.in);
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
        String sb = """
                \t\t\t\t\t -MENU INICIAL-

                [1] - Iniciar a sessao.
                [2] - Registar conta.
                [3] - Mostrar Logs.
                [4] - Guardar estado.
                [5] - Carregar estado.
                [6] - Estatisticas.
                [0] - Sair.

                Selecione a opcao pretendida:\s""";
        System.out.println(sb);
        try{
            i = input.nextInt();
        }
        catch(java.util.InputMismatchException e){
            Menu.errors(7);
        }
        return i;
    }
    

    public static int menuStats(){
        limpaTerminal();
        int i = 0;
        String sb = """
                \t\t\t\t\t -MENU ESTATISTICAS-

                [1] - Listar utilizadores.
                [2] - Listar Artigos.
                [3] - Qual o vendedor que mais facturou num período ou desde sempre.
                [4] - Qual o transportador com maior volume de facturacao.
                [5] - Listar as encomendas emitidas por um vendedor.
                [6] - Fornecer uma ordenacao dos maiores compradores/vendedoresdo sistema durante um período a determinar.
                [7] - Determinar quanto dinheiro ganhou o Vintage.Vintage no seu funcionamento.
                [0] - Sair.

                Selecione a opcao pretendida:\s""";
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
        input.nextLine();
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

    public static int menuGerirPerfil(User user){
        int i = 0;
        limpaTerminal();
        String sb = "\t\t\t\t\t -GERIR PERFIL-\n\n" + "DADOS DO UTILIZADOR: \n\n" +
                "EMAIL: " + user.getEmail() + "\n\n" +
                "NOME: " + user.getNome() + "\n\n" +
                "MORADA: " + user.getMorada() + "\n\n" +
                "NIF: " + user.getNif() + "\n\n" +
                "[1] Alterar NOME.\n" +
                "[2] Alterar MORADA.\n" +
                "[3] Alterar NIF.\n" +
                "[4] Salvar alterações.\n" +
                "[0] Voltar.\n\n" +
                "Selecione a opcao pretendida: ";
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

    public static void pressToContinue(){
        System.out.println("Para continuar pressione qualquer tecla...");
        input.nextLine();
    }

    public static int menuUser(String name){
        limpaTerminal();
        int i = 0;
        String sb = "\t\t\t\t\t -MENU UTILIZADOR (Nome: " + name + ")-\n\n" + "[1] Gerir vendas.\n" +
                "[2] Gerir compras.\n" +
                "[3] Gerir perfil.\n" +
                "[0] Logout.\n\n" +
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

    public static User registarNovoUser(int codigo){
        input.nextLine();
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

    public static int nifValido(int nif){
        System.out.println("\nNIF: ");
        input.nextLine();
        try{
            if(input.hasNextInt())
                nif = input.nextInt();
        }
        catch(java.util.InputMismatchException e){
            Menu.errors(11);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e1){
                e.printStackTrace();
            }
        }
        return nif;
    }

    public static int menuVenderArtigo(String name){
        limpaTerminal();
        int i = 0;
        String sb = "\t\t\t\t\t -MENU VENDAS (Nome: " + name + ")-\n\n" + "[1] Vender Artigo.\n" +
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
        String sb = "\t\t\t\t\t -MENU COMPRAS (Nome: " + name + ")-\n\n" + "[1] Listar os artigos que pode comprar." +
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
        if(input.hasNextLine())
            save = input.nextLine();
        return save;
    }

    public static String load(){
        String load = " ";
        System.out.println("Escreve o nome do ficheiro de onde vao ser carregados os dados: ");
        if(input.hasNextLine())
            load = input.nextLine();
        return load;
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
        else if(i == 8) sb.append(ANSI_RED).append("!!!! Erro ao atualizar o NOME !!!!\n").append(ANSI_RESET);
        else if(i == 9) sb.append(ANSI_RED).append("!!!! Erro ao atualizar a MORADA !!!!\n").append(ANSI_RESET);
        else if(i == 10) sb.append(ANSI_RED).append("!!!! Erro ao atualizar o NIF !!!!\n").append(ANSI_RESET);
        else if(i == 11) sb.append(ANSI_RED).append("!!!! Volte a introduzir o NIF !!!!\n").append(ANSI_RESET);
        System.out.println(sb);
    }

    public static void success(int i){
        limpaTerminal();
        StringBuilder sb = new StringBuilder();
        if (i == 1) sb.append(ANSI_GREEN).append("--- NOME atualizado com sucesso! ---\n").append(ANSI_RESET);
        else if(i == 2) sb.append(ANSI_GREEN).append("--- MORADA atualizado com sucesso! ---\n").append(ANSI_RESET);
        else if(i == 3) sb.append(ANSI_GREEN).append("--- NIF atualizado com sucesso! ---\n").append(ANSI_RESET);
        //else if(i == 4) sb.append(ANSI_GREEN).append("!!!! Erro associado a classes !!!!\n").append(ANSI_RESET);
        //else if(i == 5) sb.append(ANSI_GREEN).append("!!!! Não foi possivel carregar o estado !!!!\n").append(ANSI_RESET);
        //else if(i == 6) sb.append(ANSI_GREEN).append("!!!! Email nao encontrado !!!!\n").append(ANSI_RESET);
        //else if(i == 7) sb.append(ANSI_GREEN).append("!!!! Introduza uma opção valida !!!!\n").append(ANSI_RESET);
        //else if(i == 8) sb.append(ANSI_GREEN).append("!!!! Erro ao atualizar o NOME !!!!\n").append(ANSI_RESET);
        //else if(i == 9) sb.append(ANSI_GREEN).append("!!!! Erro ao atualizar a MORADA !!!!\n").append(ANSI_RESET);
        //else if(i == 10) sb.append(ANSI_GREEN).append("!!!! Erro ao atualizar o NIF !!!!\n").append(ANSI_RESET);
        System.out.println(sb);
    }
}
