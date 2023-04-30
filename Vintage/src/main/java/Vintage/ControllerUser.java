package Vintage;


public class ControllerUser {
    public static void run(Vintage vintage){

        boolean exit = false;

        while(!exit){
            int opcao = -1;
            while (opcao < 0 || opcao > 3){
                opcao = Menu.menuUser();
            }

            switch(opcao){
                case 1:
                    System.out.println("Não implementado (Gerir compras)");
                    break;
                case 2:
                    System.out.println("Não implementado (Gerir vendas)");
                    break;
                case 3:
                    System.out.println("Não implementado (Gerir perfil)");
                    break;
                case 0:
                    exit = true;
                    Menu.limpaTerminal();
                    break;
            }
        }
    }
}
