package Vintage;

import java.io.FileNotFoundException;
import java.io.IOException;

import Vintage.Artigos.Artigo;
import Vintage.Artigos.Mala;
import Vintage.Artigos.Sapatilha;
import Vintage.Artigos.TShirt;
import Vintage.Transportadoras.Transportadora;
import Vintage.Users.User;

public class ControllerVintage {
    public static void run() {
        Vintage vintage = new Vintage();
        // colocar isto num ficheiro à parte?
        User user1 = new User(1,"pedro02@gmail.com","Pedro","---", 264333300);
        Transportadora t = new Transportadora("DHL", 5.0);
        vintage.addUser(user1);
        vintage.addTransportadora(t);
        Artigo artigo1 = new Mala();
        Artigo artigo2 = new TShirt();
        Artigo artigo3 = new Sapatilha();
        vintage.addProdutoComprado(artigo1,user1.getEmail());
        vintage.addProdutoVendido(artigo2,user1.getEmail());
        vintage.addProdutoVenda(artigo3,user1.getEmail());
        //boolean Erro = false;

        Menu.printLogo();

        while (true) {
            try{
                int opcao = -1;
                while (opcao < 0 || opcao > 7) {
                    opcao = Menu.menuPrincipal();
                }
                switch (opcao) {
                    case 1:
                        Menu.limpaTerminal();
                        String email = Menu.login();
                        ControllerUser.run(vintage, email);
                        break;
                    case 2:
                        Menu.limpaTerminal();
                        ControllerCriar.run(vintage);
                        break;
                    case 3:
                        //Vintage.mostrarLogs();
                        Menu.pressToContinue();
                        break;
                    case 4:
                        Menu.limpaTerminal();
                        String saveName = Menu.save();
                        try{vintage.guardaEstado(saveName);Menu.success(7);}
                        catch (FileNotFoundException e) {
                            Menu.errors(2);}
                        catch (IOException e) {
                            Menu.errors(3);
                        }
                        Menu.pressToContinue();
                        break;
                    case 5:
                        Menu.limpaTerminal();
                        String loadName = Menu.load();
                        try {vintage.carregaEstado(loadName);Menu.success(8);}
                        catch (FileNotFoundException e) {
                            Menu.errors(2);
                        }
                        catch (IOException e) {
                            Menu.errors(4);
                        }
                        catch (ClassNotFoundException e) {
                            Menu.errors(5);
                        }
                        Menu.pressToContinue();
                        break;
                    case 6:
                        Menu.limpaTerminal();
                        ControllerStats.run(vintage);
                        break;
                    case 0:
                        System.exit(0);
                        break;
                }
            }
            catch(java.util.InputMismatchException e){
                Menu.errors(7);
            }
        }
    }
}