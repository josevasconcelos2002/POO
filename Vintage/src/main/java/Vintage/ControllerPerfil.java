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
                opcao = Menu.menuGerirPerfil(user);
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
                    vintage.setUser(user);
                    Menu.limpaTerminal();
                    Menu.success(4);
                    try{
                        Thread.sleep(1000);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    Menu.pressToContinue();
                    break;
                case 0:
                    exit = true;
                    Menu.limpaTerminal();
                    break;
            }
        }
    }
}
