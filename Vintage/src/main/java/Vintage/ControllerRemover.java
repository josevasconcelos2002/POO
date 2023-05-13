package Vintage;

//import java.util.Scanner;

public class ControllerRemover {
    public static void run(Vintage vintage) {
        boolean exit = false;
        //Scanner input = new Scanner(System.in);
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
                        if(vintage.getEstado().existeEmail(email)){
                            vintage.getEstado().getListaDeUtilizadores().removeUser(vintage.getEstado().getUserByEmail(email));
                            Menu.success(10);
                            vintage.getEstado().escreverLog(Menu.success(10).replace("\n"," ")+ " " + vintage.getEstado().getTempoAtual() + "\n");
                            vintage.getEstado().escreverLog("User removido-> " + email + " " + vintage.getEstado().getTempoAtual() + "\n");
                        }
                        else{
                            Menu.errors(16);
                            vintage.getEstado().escreverLog(Menu.errors(16).replace("\n"," ")+ " " + vintage.getEstado().getTempoAtual() + "\n");
                        }
                        break;

                    case 2:
                        // Remove Artigo
                        Menu.limpaTerminal();
                        String codigo = Menu.removerArtigo();
                        if(vintage.getEstado().getListaDeArtigos().getListaDeArtigos().containsKey(codigo)){
                            vintage.getEstado().getListaDeArtigos().removeArtigo(vintage.getEstado().getListaDeArtigos().getArtigoByCodigo(codigo));
                            Menu.success(11);
                            vintage.getEstado().escreverLog(Menu.success(11).replace("\n"," ")+ " " + vintage.getEstado().getTempoAtual() + "\n");
                            vintage.getEstado().escreverLog("Artigo removido-> " + codigo + " " + vintage.getEstado().getTempoAtual() + "\n");
                        }
                        else{
                            Menu.errors(17);
                            vintage.getEstado().escreverLog(Menu.errors(17).replace("\n"," ")+ " " + vintage.getEstado().getTempoAtual() + "\n");
                        }
                        break;
                    case 3:
                        // Remove Transportadora
                        Menu.limpaTerminal();
                        String nome = Menu.removerTransportadora();
                        if(vintage.getEstado().getListaDeTransportadoras().getTransportadoras().containsKey(nome)){
                            vintage.getEstado().removeTransportadora(vintage.getEstado().getListaDeTransportadoras().getTransportadoraByName(nome));
                            Menu.success(9);
                            vintage.getEstado().escreverLog(Menu.success(9).replace("\n"," ")+ " " + vintage.getEstado().getTempoAtual() + "\n");
                            vintage.getEstado().escreverLog("Transportadora removida-> " + nome + " " + vintage.getEstado().getTempoAtual() + "\n");
                        }
                        else{
                            Menu.errors(15);
                            vintage.getEstado().escreverLog(Menu.errors(15).replace("\n"," ")+ " " + vintage.getEstado().getTempoAtual() + "\n");
                        }
                        break;
                    case 4:
                        Menu.limpaTerminal();
                        // menu para inserir dados da Encomenda

                    case 0:
                        exit = true;
                        Menu.limpaTerminal();
                        break;
                }
            }
        }
        catch (java.util.InputMismatchException e) {
            Menu.errors(7);
            Menu.pressToContinue();
        }
    }
}
