package Vintage;

import Vintage.Users.User;

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
}
