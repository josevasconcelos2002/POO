package Vintage;

import java.io.ObjectOutputStream;
import java.util.Scanner;

public class ControllerStats {
    public static void run(Vintage vintage){

        boolean exit = false;
        Scanner input = new Scanner(System.in);
        while(!exit){
            int opcao = -1;
            while (opcao < 0 || opcao > 8){
                opcao = Menu.menuStats();
            }

            switch(opcao){
                case 1:
                    Menu.limpaTerminal();
                    System.out.println("Todos os utilizadores:\n");
                    String resultado = vintage.printAllUsers();
                    System.out.println(resultado);
                    input.nextLine();
                    Menu.pressToContinue();
                    break;
                case 2:
                    Menu.limpaTerminal();
                    System.out.println("Todos os artigos disponiveis para venda:\n");
                    String produtos = vintage.produtosVendaUsers();
                    System.out.println(produtos);
                    input.nextLine();
                    Menu.pressToContinue();
                    break;
                case 3:
                    Menu.limpaTerminal();
                    System.out.println("Lista de Transportadoras:\n\n");
                    String transportadoras = vintage.printTransportadoras();
                    System.out.println(transportadoras);
                    input.nextLine();
                    Menu.pressToContinue();
                case 4:
                    Menu.limpaTerminal();
                    System.out.println("Não implementado");
                    break;
                case 5:
                    Menu.limpaTerminal();
                    System.out.println("Não implementado");
                    break;
                case 6:
                    Menu.limpaTerminal();
                    System.out.println("Não implementado");
                    break;
                case 7:
                    Menu.limpaTerminal();
                    System.out.println("Não implementado");
                    break;
                case 8:
                    Menu.limpaTerminal();
                    System.out.println("Não implementado");
                    break;
                case 0:
                    exit = true;
                    Menu.limpaTerminal();
                    break;
            }
        }
    }
}
