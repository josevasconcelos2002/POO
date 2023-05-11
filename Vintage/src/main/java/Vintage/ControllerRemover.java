package Vintage;

import Vintage.Users.User;

import java.util.Scanner;

public class ControllerRemover {
    public static void run(Vintage vintage) {
        boolean exit = false;
        Scanner input = new Scanner(System.in);
        try {
            while (!exit) {
                int opcao = -1;
                while (opcao < 0 || opcao > 4) {
                    opcao = Menu.menuRemover();
                }

                switch (opcao) {

                    case 1:
                        // Remove User
                        Menu.limpaTerminal();
                        String email = Menu.removerUser();
                        if(vintage.estado.existeEmail(email)){
                            vintage.estado.getListaDeUtilizadores().removeUser(vintage.estado.getUserByEmail(email));
                            Menu.success(10);
                        }
                        else{
                            Menu.errors(16);
                        }
                        break;

                    case 2:
                        // Remove Artigo
                        Menu.limpaTerminal();
                        String codigo = Menu.removerArtigo();
                        if(vintage.estado.getListaDeArtigos().getListaDeArtigos().containsKey(codigo)){
                            vintage.estado.getListaDeArtigos().removeArtigo(vintage.estado.getListaDeArtigos().getArtigoByCodigo(codigo));
                            Menu.success(11);
                        }
                        else{
                            Menu.errors(17);
                        }
                        break;
                    case 3:
                        // Remove Transportadora
                        Menu.limpaTerminal();
                        String nome = Menu.removerTransportadora();
                        if(vintage.estado.getListaDeTransportadoras().getTransportadoras().containsKey(nome)){
                            vintage.estado.removeTransportadora(vintage.estado.getListaDeTransportadoras().getTransportadoraByName(nome));
                            Menu.success(9);
                        }
                        else{
                            Menu.errors(15);
                        }
                        break;
                    case 4:
                        Menu.limpaTerminal();
                        // menu para inserir dados da Encomenda

                    case 0:
                        exit = true;
                        Menu.limpaTerminal();
                        Menu.menuPrincipal();

                }
            }
        }
        catch (java.util.InputMismatchException e) {
            Menu.errors(7);
        }
    }
}
