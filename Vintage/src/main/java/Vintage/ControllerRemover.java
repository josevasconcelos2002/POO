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
                        Menu.limpaTerminal();
                        User novoUser = Menu.registarNovoUser(vintage.newUserCode());
                        vintage.addUser(novoUser);
                        break;

                    case 2:
                        Menu.limpaTerminal();
                        // menu para escolher o tipo de artigo
                        // depois, outro "menu" para o utilizador inserir os dados do Artigo

                    case 3:
                        Menu.limpaTerminal();
                        // menu para inserir dados da Transportadora
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
