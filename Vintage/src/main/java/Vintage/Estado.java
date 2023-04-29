package Vintage;

import Vintage.Artigos.Artigos;
import Vintage.Encomendas.Encomendas;
import Vintage.Users.Users;

public class Estado {
    private Users listaDeUtilizadores;
    private Encomendas listaDeEncomendas;
    private Artigos listaDeArtigos;
    //private Transportadoras listaDeTransportadoras;

    public Estado(){
        this.listaDeUtilizadores = new Users();
        this.listaDeEncomendas = new Encomendas();
        this.listaDeArtigos = new Artigos();
    }

    public int getNewUserCode(){
        return listaDeUtilizadores.size() + 1;
    }
    // AQUI VÃO ESTAR AS FUNÇÕES SOBRE OS LOGS E FICHEIROS... GUARDAR OS USERS, ETC.
}
