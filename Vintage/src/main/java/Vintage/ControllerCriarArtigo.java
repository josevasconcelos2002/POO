package Vintage;

import Vintage.Artigos.Mala;
import Vintage.Artigos.Sapatilha;
import Vintage.Artigos.TShirt;
import Vintage.Transportadoras.Transportadora;
import Vintage.Users.User;

import java.util.Scanner;

public class ControllerCriarArtigo {
        public static void run(Vintage vintage, String email){
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
                            if(Menu.tipoArtigo() == 1){
                                Sapatilha newSapatilha = Menu.criarSapatilhaUsada(vintage.newArtigoCode());
                                vintage.addProdutoVenda(newSapatilha);
                            } else if (Menu.tipoArtigo() == 2) {
                                Sapatilha usedSapatilha = Menu.criarSapatilhaNova(vintage.newArtigoCode());
                                vintage.addProdutoVenda(usedSapatilha);
                            }
                            break;
                        case 2:
                            Menu.limpaTerminal();
                            if(Menu.tipoArtigo() == 1){
                                Mala newMala = Menu.criarMalaUsada(vintage.newArtigoCode());
                                vintage.addProdutoVenda(newMala);
                            } else if (Menu.tipoArtigo() == 2) {
                                Mala usedMala = Menu.criarMalaNova(vintage.newArtigoCode());
                                vintage.addProdutoVenda(usedMala);
                            }
                            break;
                        case 3:
                            Menu.limpaTerminal();
                            if(Menu.tipoArtigo() == 1){
                                TShirt newSapatilha = Menu.criarTShirtUsada(vintage.newArtigoCode());
                                vintage.addProdutoVenda(newSapatilha);
                            } else if (Menu.tipoArtigo() == 2) {
                                TShirt usedSapatilha = Menu.criarTShirtNova(vintage.newArtigoCode());
                                vintage.addProdutoVenda(usedSapatilha);
                            }
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
