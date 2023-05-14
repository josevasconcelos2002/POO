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
                    int i;
                    while (opcao < 0 || opcao > 3) {
                        opcao = Menu.menuCriarArtigo();
                    }

                    switch (opcao) {

                        case 1:
                            Menu.limpaTerminal();
                            i = Menu.tipoArtigo();
                            if(i == 1){
                                Sapatilha newSapatilha = Menu.criarSapatilhaUsada(vintage.newArtigoCode());
                                vintage.addProdutoVenda(newSapatilha);
                            } else if (i == 2) {
                                Sapatilha usedSapatilha = Menu.criarSapatilhaNova(vintage.newArtigoCode());
                                vintage.addProdutoVenda(usedSapatilha);
                            }
                            break;
                        case 2:
                            Menu.limpaTerminal();
                            i = Menu.tipoArtigo();
                            if(i == 1){
                                Mala newMala = Menu.criarMalaUsada(vintage.newArtigoCode());
                                vintage.addProdutoVenda(newMala);
                            } else if (i == 2) {
                                Mala usedMala = Menu.criarMalaNova(vintage.newArtigoCode());
                                vintage.addProdutoVenda(usedMala);
                            }
                            break;
                        case 3:
                            Menu.limpaTerminal();
                            i = Menu.tipoArtigo();
                            if(i == 1){
                                TShirt newTShirt = Menu.criarTShirtUsada(vintage.newArtigoCode());
                                vintage.addProdutoVenda(newTShirt);
                            } else if (i == 2) {
                                TShirt usedTShirt = Menu.criarTShirtNova(vintage.newArtigoCode());
                                vintage.addProdutoVenda(usedTShirt);
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
