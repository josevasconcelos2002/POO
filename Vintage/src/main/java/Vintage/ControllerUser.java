package Vintage;

import Vintage.Artigos.Artigo;
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
                    Menu.menuComprarArtigo(vintage.getUserNameByKey(email));
                    System.out.println("Não implementado (Gerir compras)");
                    break;
                case 2:
                    Menu.limpaTerminal();
                    int i = Menu.menuVenderArtigo(vintage.getUserNameByKey(email));
                    if(i == 1){
                        // listar Artigos disponíveis para venda e pedir para o user dizer qual quer vender
                    }
                    if (i == 2) {
                        System.out.println("Artigos vendidos pelo utilizador: \n");
                        vintage.printProdutosUser(email);
                    }
                    
                    break;
                case 3:
                    Menu.limpaTerminal();
                    ControllerPerfil.run(vintage, vintage.getUserByEmail(email), email);
                    break;
                case 0:
                    exit = true;
                    vintage.logout();
                    Menu.limpaTerminal();
                    Menu.menuPrincipal();
                    break;
            }
        }
    }
}
