package Vintage;

import java.io.*;

import Vintage.Artigos.Artigo;
import Vintage.Artigos.Mala;
import Vintage.Artigos.Sapatilha;
import Vintage.Artigos.TShirt;
import Vintage.Transportadoras.Transportadora;
import Vintage.Users.User;

public class ControllerVintage {
    public static void run() throws IOException {
        Vintage vintage = new Vintage();

        // colocar isto num ficheiro à parte?
        User user1 = new User(1,"pedro02@gmail.com","Pedro","---", 264333300);
        Transportadora t = new Transportadora("DHL", 5.0);
        File file = new File("logs/logs.txt");
        file.delete();
        vintage.addUser(user1);
        if(vintage.estado.existeEmail(user1.getEmail()))
            vintage.estado.escreverLog(Menu.success(6)+ " " + vintage.estado.getTempoAtual() + " \n");
        else
            vintage.estado.escreverLog(Menu.errors(1)+ " " + vintage.estado.getTempoAtual() + " \n");
        vintage.addTransportadora(t);
        if(vintage.estado.existeTransportadoraNome(t.getNome()))
            vintage.estado.escreverLog(Menu.success(5)+ " " + vintage.estado.getTempoAtual() + " \n");
        else
            vintage.estado.escreverLog(Menu.errors(12) + vintage.estado.getTempoAtual() + " \n");
        Artigo artigo1 = new Mala();
        vintage.estado.escreverLog("Nova Mala-> codigo: " + artigo1.getCodigo() + " "+ vintage.estado.getTempoAtual() + " \n");
        Artigo artigo2 = new TShirt();
        vintage.estado.escreverLog("Nova TShirt-> codigo: " + artigo2.getCodigo()+ " " + vintage.estado.getTempoAtual() + " \n");
        Artigo artigo3 = new Sapatilha();
        vintage.estado.escreverLog("Nova Sapatilha-> codigo: " + artigo3.getCodigo()+ " " + vintage.estado.getTempoAtual() +" \n");
        vintage.addProdutoComprado(artigo1,user1.getEmail());
        vintage.addProdutoVendido(artigo2,user1.getEmail());
        vintage.addProdutoVenda(artigo3,user1.getEmail());
        //boolean Erro = false;

        Menu.printLogo();

        while (true) {
            try{
                int opcao = -1;
                while (opcao < 0 || opcao > 8) {
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
                        Menu.limpaTerminal();
                        ControllerRemover.run(vintage);
                        break;
                    case 4:
                        Menu.limpaTerminal();
                        System.out.println(Menu.printLogs());
                        //Menu.printLogs();
                        //Menu.pressToContinue();
                        break;
                    case 5:
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
                    case 6:
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
                    case 7:
                        Menu.limpaTerminal();
                        ControllerStats.run(vintage);
                        break;
                    case 0:
                        System.exit(0);
                        Menu.success(15);
                        break;
                }
            }
            catch(java.util.InputMismatchException e){
                Menu.errors(7);
            }
        }
    }
}