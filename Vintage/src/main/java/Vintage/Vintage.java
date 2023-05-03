package Vintage;

import Vintage.Users.User;

import java.io.*;

public class Vintage implements Serializable {
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

    public String getUserNameByKey(String email){
        return this.estado.getUserNameByKey(email);
    }

    public String printAllUsers(){
        return estado.printAllUsers();
    }


    /*public void mostrarLogs() {
        estado.loadEstadoLogs();
    }*/

    public void guardaEstado(String saveName) throws IOException {
        this.estado.guardarEstado(saveName);
    }

    public void carregaEstado(String loadName) throws IOException, ClassNotFoundException {
        this.estado.carregaEstado(loadName);
    }

    public boolean login(String email){
        if(this.estado.existeEmail(email)){
            this.user = this.estado.getUserByEmail(email);
            return true;
        } else {
            return false;
        }
    }

    public void logout(){
        this.user = null;
    }

    public void adicionaArtigoParaVenda(){

    }

    public String printAllArtigos(){
        return estado.printAllArtigos();
    }
}
