package Vintage;

import java.io.*;
import java.util.Scanner;

import Vintage.Artigos.Artigo;
import Vintage.Artigos.Mala;
import Vintage.Artigos.Sapatilha;
import Vintage.Artigos.TShirt;
import Vintage.Transportadoras.Transportadora;
import Vintage.Users.User;

public class ControllerVintage {
    public static void run() throws IOException {
        Vintage vintage = new Vintage();
        Scanner input = new Scanner(System.in);
        // colocar isto num ficheiro à parte?
        User user1 = new User(1,"pedro02@gmail.com","Pedro","---", 264333300);
        Transportadora t = new Transportadora("DHL", 5.0);
        File file = new File("logs/logs.txt");
        file.delete();
        vintage.addUser(user1);
        if(vintage.getEstado().existeEmail(user1.getEmail())) {
            vintage.getEstado().escreverLog(Menu.success(6).replace("\n", " ") + " " + vintage.getEstado().getTempoAtual() + " \n");
            vintage.getEstado().escreverLog("Novo user-> " + user1.getEmail() + " " + vintage.getEstado().getTempoAtual() +"\n");
        }
        else {
            vintage.getEstado().escreverLog(Menu.errors(1).replace("\n", " ") + " " + vintage.getEstado().getTempoAtual() + " \n");
        }
        vintage.addTransportadora(t);
        if(vintage.getEstado().existeTransportadoraNome(t.getNome())) {
            vintage.getEstado().escreverLog(Menu.success(5).replace("\n", " ") + " " + vintage.getEstado().getTempoAtual() + " \n");
            vintage.getEstado().escreverLog("Nova transportadora-> " + t.getNome() + " " + vintage.getEstado().getTempoAtual() + "\n");
        }
        else {
            vintage.getEstado().escreverLog(Menu.errors(12).replace("\n", " ") + vintage.getEstado().getTempoAtual() + " \n");
        }
        Artigo artigo1 = new Mala();
        vintage.getEstado().escreverLog("Nova Mala-> codigo: " + artigo1.getCodigo() + " "+ vintage.getEstado().getTempoAtual() + " \n");
        Artigo artigo2 = new TShirt();
        vintage.getEstado().escreverLog("Nova TShirt-> codigo: " + artigo2.getCodigo()+ " " + vintage.getEstado().getTempoAtual() + " \n");
        Artigo artigo3 = new Sapatilha();
        vintage.getEstado().escreverLog("Nova Sapatilha-> codigo: " + artigo3.getCodigo()+ " " + vintage.getEstado().getTempoAtual() +" \n");
        vintage.addProdutoComprado(artigo1,user1.getEmail());
        vintage.addProdutoVendido(artigo2,user1.getEmail());
        vintage.addProdutoVenda(artigo3,user1.getEmail());
        Menu.printLogo();

        while (true) {
            try{
                int opcao = -1;
                while (opcao < 0 || opcao > 9) {
                    opcao = Menu.menuPrincipal(vintage);
                }
                switch (opcao) {
                    case 1:
                        Menu.limpaTerminal();
                        String email = Menu.login();
                        if(vintage.getEstado().getListaDeUtilizadores().getUsers().containsKey(email)){
                            Menu.limpaTerminal();
                            Menu.success(16);
                            Menu.pressToContinue();
                            ControllerUser.run(vintage, email);
                        }
                        else {
                            Menu.limpaTerminal();
                            Menu.errors(23);
                            Menu.pressToContinue();
                        }
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
                        ControllerTempo.run(vintage);
                        break;
                    case 5:
                        Menu.limpaTerminal();
                        System.out.println("\t\t\t\t\t - LOGS -\n\n" + Menu.printLogs());
                        input.nextLine();
                        Menu.pressToContinue();
                        break;
                    case 6:
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
                    case 7:
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
                    case 8:
                        Menu.limpaTerminal();
                        ControllerStats.run(vintage);
                        break;
                    case 0:
                        Menu.success(15);
                        try{
                            Thread.sleep(1000);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        Menu.limpaTerminal();
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