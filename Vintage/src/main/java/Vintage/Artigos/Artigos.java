package Vintage.Artigos;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Artigos implements Serializable {
    private Map<String, Artigo> listaDeArtigos;

    public Artigos(){
        this.listaDeArtigos = new HashMap<String,Artigo>();
    }

    public Artigos(Map<String,Artigo> listaDeArtigos){
        this.listaDeArtigos = new HashMap<>(listaDeArtigos);
    }

}
