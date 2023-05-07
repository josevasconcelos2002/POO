package Vintage;

import java.io.FileNotFoundException;
import java.io.IOException;

import Vintage.Users.User;

public class ControllerVintage {
    public static void run() {
        Vintage vintage = new Vintage();

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
                        User novoUser = Menu.registarNovoUser(vintage.newUserCode());
                        vintage.addUser(novoUser);
                        break;
                    case 3:
                        //Vintage.mostrarLogs();
                        Menu.pressToContinue();
                        break;
                    case 4:
                        Menu.limpaTerminal();
                        String saveName = Menu.save();
                        try{vintage.guardaEstado(saveName);System.out.println("Ficheiros salvos com sucesso!!!\n");}
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
                        try {vintage.carregaEstado(loadName);System.out.println("Ficheiros carregados com sucesso!!!\n");}
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