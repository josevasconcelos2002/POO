package Vintage;

import Vintage.Artigos.Artigos;
import Vintage.Encomendas.Encomendas;
import Vintage.Users.User;
import Vintage.Users.Users;

import java.io.*;

public class Estado implements Serializable {
    private Users listaDeUtilizadores;
    private Encomendas listaDeEncomendas;
    private Artigos listaDeArtigos;
    //private Transportadoras listaDeTransportadoras;

    // AQUI VÃO ESTAR AS FUNÇÕES SOBRE OS LOGS E FICHEIROS E ESTADO DO PROGRAMA... GUARDAR OS USERS, CRIAR ARTIGOS, ETC.

    public Estado(){
        this.listaDeUtilizadores = new Users();
        this.listaDeEncomendas = new Encomendas();
        this.listaDeArtigos = new Artigos();
    }

    public int getNewUserCode(){
        return listaDeUtilizadores.size() + 1;
    }

    public void addUser(User u){
        listaDeUtilizadores.addUser(u);
    }

    public boolean existeEmail(String email){
        return listaDeUtilizadores.existeEmail(email);
    }

    public String printAllUsers(){
        return listaDeUtilizadores.toString();
    }

    // Função que guarda o estado da aplicação(guarda os objetos)
    public void guardarEstado(String nomeFicheiro){
        FileOutputStream fileOut = new FileOutputStream(nomeFicheiro);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

    }
}
