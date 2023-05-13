package Vintage;

import java.io.ObjectOutputStream;
import java.util.Objects;
import java.util.Scanner;

import Vintage.Users.User;

public class ControllerPerfil {
    public static void run(Vintage vintage, User user, String email){
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        while(!exit){
            int opcao = -1;
            while (opcao < 0 || opcao > 4){
                opcao = Menu.menuGerirPerfil(user); //alterar para o user em estado
            }

            switch(opcao){
                case 1:
                    Menu.limpaTerminal();
                    String sb = "\t\t\t\t\t -Alterar NOME-\n\n" +
                            "NOME atual: " + user.getNome() + "\n\n" +
                            "Introduza o seu novo NOME: ";
                    System.out.println(sb);
                    String newName = scanner.nextLine();
                    user.setNome(newName);
                    if(Objects.equals(newName, user.getNome())){
                        Menu.success(1);
                        try{
                            Thread.sleep(1000);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    else {
                        Menu.errors(8);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    Menu.limpaTerminal();
                    String sb1 = "\t\t\t\t\t -Alterar MORADA-\n\n" +
                            "MORADA atual: " + user.getMorada() + "\n\n" +
                            "Introduza a sua nova MORADA: ";
                    System.out.println(sb1);
                    String newMorada = scanner.nextLine();
                    user.setMorada(newMorada);
                    if(Objects.equals(newMorada,user.getMorada())){
                        Menu.success(2);
                        try{
                            Thread.sleep(1000);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    else {
                        Menu.errors(9);
                        try{
                            Thread.sleep(1000);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    Menu.limpaTerminal();
                    String sb2 = "\t\t\t\t\t -Alterar NIF-\n\n" +
                            "NIF atual: " + user.getNif() + "\n\n" +
                            "Introduza o seu novo NIF: ";
                    System.out.println(sb2);
                    int newNIF = scanner.nextInt();
                    user.setNif(newNIF);
                    if(newNIF == user.getNif()){
                        Menu.success(3);
                        try{
                            Thread.sleep(1000);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    else {
                        Menu.errors(10);
                        try{
                            Thread.sleep(1000);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    break;
                case 4:
                    vintage.getEstado().getListaDeUtilizadores().getUsers().put(user.getEmail(),user); // substitui no map o user que tinha email igual
                    Menu.limpaTerminal();
                    Menu.success(4);
                    try{
                        Thread.sleep(1000);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    Menu.pressToContinue();
                    // isto tem haver com fazer alterações no clone e ir ao map dos users e colocar o novo perfil lá
                    break;
                case 0:
                    exit = true;
                    Menu.limpaTerminal();
                    break;
            }
        }
    }
}
