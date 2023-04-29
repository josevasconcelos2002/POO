package Vintage;

import Vintage.Users.User;
import Vintage.Users.Users;
import Vintage.Vintage;

public class ControllerVintage {
    public static void run() {
        Vintage vintage = new Vintage();

        //boolean Erro = false; //Em caso de termos erros

        while (true) {
            int opcao = -1;
            while (opcao < 0 || opcao > 7) {
                opcao = Menu.menuPrincipal();
            }
            switch (opcao) {
                case 1:
                    // Iniciar sessao;
                    System.out.println("Falta implementar(Iniciar sessão)");
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
                    // Guardar estado
                    System.out.println("Falta implementar(Guardar estado)");
                    break;
                case 5:
                    // Carregar estado
                    System.out.println("Falta implementar(Carregar estado)");
                    break;
                case 6:
                    // Estatisticas
                    System.out.println("Falta implementar(Estatisticas)");
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }
}
