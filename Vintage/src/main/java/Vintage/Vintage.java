package Vintage;

import Vintage.Users.User;
import Vintage.Users.Users;

public class Vintage {
    private User user;
    private Estado estado;

    public Vintage(){
        this.estado = new Estado();
        this.user = null;
    }

    public int newUserCode(){
        return estado.getNewUserCode();
    }

    public void addUser(User u){
        if(!estado.existeEmail(u.getEmail())){
            estado.addUser(u);
            System.out.println("--User adicionado com successo!--");
            Menu.pressToContinue();
        } else {
            Menu.limpaTerminal();
            Menu.errors(1);
        }
    }

    public String printAllUsers(){
        return estado.printAllUsers();
    }

    /*public void mostrarLogs() {
        estado.loadEstadoLogs();
    }*/
}
