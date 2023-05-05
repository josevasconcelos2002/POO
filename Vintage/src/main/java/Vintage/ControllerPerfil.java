package Vintage;

import java.util.Scanner;

import Vintage.Users.User;

public class ControllerPerfil {
    public static void run(Vintage vintage, User user){
        boolean exit = false;

        while(!exit){
            int opcao = -1;
            while (opcao < 0 || opcao > 4){
                opcao = Menu.menuGerirPerfil(user); //alterar para o user em estado
            }

            switch(opcao){
                case 1:
                    Menu.limpaTerminal();
                    StringBuilder sb = new StringBuilder("\t\t\t\t\t -Alterar nome-\n\n");
                    sb.append("Nome atual: " + user.getNome() + "\n");
                    sb.append("Introduza o novo nome: ");
                    System.out.println(sb.toString());
                    Scanner scanner = new Scanner(System.in);
                    String newName = scanner.nextLine();
                    user.setNome(newName);
                    if(newName == user.getNome())
                        System.out.println("\nNome atualizado com sucesso!\n");
                    else 
                        Menu.errors(9);
                case 2:
            }
        }
    }
}
