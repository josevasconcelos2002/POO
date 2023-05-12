package Vintage;

import Vintage.Transportadoras.Transportadora;
import Vintage.Users.User;

import java.util.Scanner;

public class ControllerCriarArtigo {
        public static void run(Vintage vintage){
            boolean exit = false;
            Scanner input = new Scanner(System.in);
            try {
                while (!exit) {
                    int opcao = -1;
                    while (opcao < 0 || opcao > 3) {
                        opcao = Menu.menuCriarArtigo();
                    }

                    switch (opcao) {

                        case 1:
                            Menu.limpaTerminal();
                            User novoUser = Menu.registarNovoUser(vintage.newUserCode());
                            vintage.addUser(novoUser);
                            if(vintage.estado.existeEmail(novoUser.getEmail())) {
                                vintage.estado.escreverLog(Menu.success(6).replace("\n", " ") + " " + vintage.estado.getTempoAtual() + " \n");
                                vintage.estado.escreverLog("Novo user-> " + novoUser.getEmail() + " " + vintage.estado.getTempoAtual() +"\n");
                            }
                            else
                                vintage.estado.escreverLog(Menu.errors(20).replace("\n"," ")+ " " + vintage.estado.getTempoAtual() + " \n");
                            break;

                        case 2:
                            Menu.limpaTerminal();
                            // menu para escolher o tipo de artigo
                            // depois, outro "menu" para o utilizador inserir os dados do Artigo

                        case 3:
                            Menu.limpaTerminal();
                            // menu para inserir dados da Transportadora
                            Transportadora t = Menu.registarNovaTransportadora();
                            vintage.addTransportadora(t);
                            if(vintage.estado.existeTransportadoraNome(t.getNome())){
                                vintage.estado.escreverLog(Menu.success(5).replace("\n"," ")+ " " + vintage.estado.getTempoAtual() + "\n");
                                vintage.estado.escreverLog("Nova transportadora-> " + t.getNome() + " " + vintage.estado.getTempoAtual() + "\n");
                            }
                            else
                                vintage.estado.escreverLog(Menu.errors(19).replace("\n"," ")+ " " + vintage.estado.getTempoAtual() + "\n");
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
            catch(java.util.InputMismatchException e){
                Menu.errors(7);
            }
        }
}
