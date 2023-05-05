package Vintage;

import Vintage.Users.User;
public class ControllerUser {
    public static void run(Vintage vintage, String email){

        boolean exit = false;

        while(!exit){
            int opcao = -1;
            while (opcao < 0 || opcao > 3){
                opcao = Menu.menuUser(vintage.getUserNameByKey(email)); //alterar para o user em estado
            }

            switch(opcao){
                case 1:
                    Menu.limpaTerminal();
                    Menu.comprarArtigo(vintage.getUserNameByKey(email));
                    System.out.println("Não implementado (Gerir compras)");
                    break;
                case 2:
                    Menu.limpaTerminal();
                    int i = Menu.venderArtigo(vintage.getUserNameByKey(email));
                    if(i == 1){
                        System.out.println("adicionar mala");
                    } else if(i == 2) {
                        System.out.println("adicionar t-shirt");
                    } else if(i == 3) {
                        System.out.println("adicionar sapatilha");
                    }
                    System.out.println("Não implementado (Gerir vendas)");
                    break;
                case 3:
                    Menu.limpaTerminal();
                    ControllerPerfil.run(vintage, vintage.getUserByEmail(email));
                    break;
                case 0:
                    exit = true;
                    vintage.logout();
                    Menu.limpaTerminal();
                    break;
            }
        }
    }
}
