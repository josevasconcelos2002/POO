package Vintage;

public class ControllerStats {
    public static void run(Vintage vintage){

        boolean exit = false;

        while(!exit){
            int opcao = -1;
            while (opcao < 0 || opcao > 7){
                opcao = Menu.menuStats();
            }

            switch(opcao){
                case 1:
                    Menu.limpaTerminal();
                    System.out.println("Todos os utilizadores:\n");
                    System.out.println(vintage.printAllUsers());
                    Menu.pressToContinue();
                    break;
                case 2:
                    Menu.limpaTerminal();
                    System.out.println("Todos os artigos:\n");
                    System.out.println(vintage.printAllUsers());
                    Menu.pressToContinue();
                    break;
                case 3:
                    Menu.limpaTerminal();
                    System.out.println("Não implementado");
                    break;
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
                case 0:
                    exit = true;
                    Menu.limpaTerminal();
                    break;
            }
        }
    }
}
