package Vintage;

import Vintage.Users.User;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
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
        StringBuilder sb = new StringBuilder("\t\t\t\t\t -MENU INICIAL-\n\n");
        sb.append("[1] - Iniciar a sessao.\n");
        sb.append("[2] - Registar conta.\n");
        sb.append("[3] - Mostrar Logs.\n");
        sb.append("[4] - Guardar estado.\n");
        sb.append("[5] - Carregar estado.\n");
        sb.append("[6] - Estatisticas.\n");
        sb.append("[0] - Sair.\n\n");
        sb.append("Seleciona o numero pretendido: ");
        System.out.println(sb.toString());
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public static int menuStats(){
        limpaTerminal();
        StringBuilder sb = new StringBuilder("\t\t\t\t\t -MENU ESTATISTICAS-\n\n");
        sb.append("[1] - Qual o vendedor que mais facturou num período ou desde sempre.\n");
        sb.append("[2] - Qual o transportador com maior volume de facturação.\n");
        sb.append("[3] - Listar as encomendas emitidas por um vendedor.\n");
        sb.append("[4] - Fornecer uma ordenação dos maiores compradores/vendedores" +
                  "do sistema durante um período a determinar.\n");
        sb.append("[5] - Determinar quanto dinheiro ganhou o Vintage.Vintage no seu funcionamento.");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
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
            // handle exception
        }
    }

    public static String pressToContinue(){
        System.out.println("Para continuar pressione qualquer tecla...");
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static int menuUser(){
        StringBuilder sb = new StringBuilder("\t\t\t\t\t -MENU UTILIZADOR-\n\n");
        sb.append("1) Gerir vendas.\n");
        sb.append("2) Gerir compras.\n");
        sb.append("3) Gerir perfil.\n");
        sb.append("0) Logout.\n\n");
        sb.append("Selecione a opção pretendida: ");
        System.out.println(sb.toString());
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static User registarNovoUser(int codigo){
        StringBuilder sb = new StringBuilder("\t\t\t\t\t -REGISTAR NOVO UTILIZADOR-\n\n");

        Scanner input = new Scanner(System.in);

        sb.append("Introduza os dados pedidos.\n\n");
        sb.append("Email: ");
        System.out.println(sb.toString());
        String email = input.nextLine();

        System.out.println("Nome: ");
        String nome = input.nextLine();

        System.out.println("Morada: ");
        String morada = input.nextLine();

        System.out.println("NIF: ");
        String nif = input.nextLine();

        return new User(codigo, email, nome, morada, nif);
    }

    public static void errors(int i){
        limpaTerminal();
        StringBuilder sb = new StringBuilder();
        if (i == 1) sb.append("***Email ja existe***\n");
        System.out.println(sb.toString());
        pressToContinue();
    }
}
