package Vintage;

import Vintage.Users.User;

import java.util.Scanner;

public class ControllerCriar {
    public static void run(Vintage vintage){
        boolean exit = false;
        Scanner input = new Scanner(System.in);
        try {
            while (!exit) {
                int opcao = -1;
                while (opcao < 0 || opcao > 4) {
                    opcao = Menu.menuCriar(vintage);
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
        catch(java.util.InputMismatchException e){
            Menu.errors(7);
        }
    }
}
