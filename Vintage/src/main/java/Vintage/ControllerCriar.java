package Vintage;

import Vintage.Transportadoras.Transportadora;
import Vintage.Users.User;

//import java.util.Scanner;

public class ControllerCriar {
    public static void run(Vintage vintage){
        boolean exit = false;

        try {
            while (!exit) {
                int opcao = -1;
                while (opcao < 0 || opcao > 4) {
                    opcao = Menu.menuCriar();
                }

                switch (opcao) {

                    case 1:
                        Menu.limpaTerminal();
                        User novoUser = Menu.registarNovoUser(vintage.newUserCode());
                        vintage.addUser(novoUser);
                        if(vintage.getEstado().existeEmail(novoUser.getEmail())) {
                            vintage.getEstado().escreverLog(Menu.success(6).replace("\n", " ") + " " + vintage.getEstado().getTempoAtual() + " \n");
                            vintage.getEstado().escreverLog("Novo user -> " + novoUser.getEmail() + " " + vintage.getEstado().getTempoAtual() +"\n");
                        }
                        else
                            vintage.getEstado().escreverLog(Menu.errors(20).replace("\n"," ")+ " " + vintage.getEstado().getTempoAtual() + " \n");
                        break;
                    case 2:
                        Menu.limpaTerminal();
                        // menu para escolher o tipo de artigo
                        // depois, outro "menu" para o utilizador inserir os dados do Artigo
                        break;
                    case 3:
                        Menu.limpaTerminal();
                        // menu para inserir dados da Transportadora
                        Transportadora t = Menu.registarNovaTransportadora();
                        vintage.addTransportadora(t);
                        if(vintage.getEstado().existeTransportadoraNome(t.getNome())){
                            vintage.getEstado().escreverLog(Menu.success(5).replace("\n"," ")+ " " + vintage.getEstado().getTempoAtual() + "\n");
                            vintage.getEstado().escreverLog("Nova transportadora -> " + t.getNome() + " " + vintage.getEstado().getTempoAtual() + "\n");
                        }
                        else
                            vintage.getEstado().escreverLog(Menu.errors(19).replace("\n"," ")+ " " + vintage.getEstado().getTempoAtual() + "\n");
                        break;
                    case 4:
                        Menu.limpaTerminal();
                        // menu para inserir dados da Encomenda
                        break;
                    case 0:
                        exit = true;
                        Menu.limpaTerminal();
                        break;
                }
            }
        }
        catch(java.util.InputMismatchException e){
            Menu.errors(7);
            Menu.pressToContinue();
        }
    }
}
