import Vintage.Users.User;
import Vintage.Users.Users;

public class ControllerVintage {
    public static void run(){
        Vintage vintage = new Vintage();

        //boolean Erro = false; //Em caso de termos erros

        int opcao = -1;
        while(opcao < 0 || opcao > 7){
            opcao = Menu.menuPrincipal();
        }
        switch(opcao){
            case 1:
                // Iniciar sessao;
                System.out.println("Falta implementar(Iniciar sessão)");
                break;
            case 2:
                User novoUser = Menu.registarNovoUser(Users.getNewCode);

                System.out.println("Falta implementar(Registar conta)");
                break;
            case 3:
                // Mostrar logs
                System.out.println("Falta implementar(Mostrar logs)");
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
