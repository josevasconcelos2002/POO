package Vintage;

import java.io.ObjectOutputStream;
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
                    StringBuilder sb = new StringBuilder("\t\t\t\t\t -Alterar NOME-\n\n");
                    sb.append("NOME atual: " + user.getNome() + "\n\n");
                    sb.append("Introduza o seu novo NOME: ");
                    System.out.println(sb.toString());
                    String newName = scanner.nextLine();
                    user.setNome(newName);
                    if(newName == user.getNome()){
                        Menu.success(1);
                        try{
                            Thread.sleep(1000);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    else 
                        Menu.errors(8);
                        try{
                            Thread.sleep(1000);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    break;

                case 2:

                    Menu.limpaTerminal();
                    StringBuilder sb1 = new StringBuilder("\t\t\t\t\t -Alterar MORADA-\n\n");
                    sb1.append("MORADA atual: " + user.getMorada() + "\n\n");
                    sb1.append("Introduza a sua nova MORADA: ");
                    System.out.println(sb1.toString());
                    String newMorada = scanner.nextLine();
                    user.setMorada(newMorada);
                    if(newMorada == user.getMorada()){
                        Menu.success(2);
                        try{
                            Thread.sleep(1000);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    else 
                        Menu.errors(9);
                        try{
                            Thread.sleep(1000);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    break;

                case 3: 

                    Menu.limpaTerminal();
                    StringBuilder sb2 = new StringBuilder("\t\t\t\t\t -Alterar NIF-\n\n");
                    sb2.append("NIF atual: " + user.getNif() + "\n\n");
                    sb2.append("Introduza o seu novo NIF: ");
                    System.out.println(sb2.toString());
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
                    else 
                        Menu.errors(10);
                        try{
                            Thread.sleep(1000);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    break;

                case 4:
                    vintage.addUser(vintage.getUserByEmail(email)); // substitui no map o user que tinha email igual
                    Menu.success(4);
                    // isto tem haver com fazer alterações no clone e ir ao map dos users e colocar o novo perfil lá
                    break;

                case 0:
                    Menu.limpaTerminal();
                    Menu.menuUser(user.getNome());
                    break;
            }
        }
    }
}
