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

    public Estado(Estado es) {
        this.listaDeUtilizadores = es.listaDeUtilizadores;
        this.listaDeEncomendas = es.listaDeEncomendas;
        this.listaDeArtigos = es.listaDeArtigos;
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
    public void guardarEstado(String nomeFicheiro) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(nomeFicheiro);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(this);
        out.close();
        fileOut.close();

        System.out.println("Estado guardado com sucesso!!");
    }

    public void carregaEstado(String nomeFicheiro) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(nomeFicheiro);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        Estado estado = (Estado) in.readObject();
        in.close();
        fileIn.close();

        this.listaDeUtilizadores = estado.listaDeUtilizadores;
        this.listaDeEncomendas = estado.listaDeEncomendas;
        this.listaDeArtigos = estado.listaDeArtigos;
    }
}
