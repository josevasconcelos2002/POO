package Vintage.Artigos;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Artigos implements Serializable {
    private Map<Object, Object> listaDeArtigos;

    public Artigos(){
        this.listaDeArtigos = new HashMap<Object,Object>();
    }

    public Artigos(Map<String, Artigo> listaDeArtigos){
        this.setListaDeArtigos(listaDeArtigos);
    }

    public Artigos(Artigos as){
        this.listaDeArtigos = as.getListaDeArtigos();
    }

    public int getNewCode(){
        return 0;
    }

    public Map<Object, Object> getListaDeArtigos() {
        return this.listaDeArtigos.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a,b) -> a, HashMap::new));
    }

    public void setListaDeArtigos(Map<String, Artigo> listaDeArtigos){
        this.listaDeArtigos = listaDeArtigos.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().clone(), (a,b)->a, HashMap::new));
    }

    public void addArtigo(Artigo a){
        this.listaDeArtigos.put(a.getCodigo(), (Artigo) a.clone());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de artigos {\n");
        for (Object artigo : listaDeArtigos.values()) {
            sb.append("\t").append(artigo.toString()).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }

    public Artigos clone(){
        return new Artigos(this);
    }

    public Artigo getArtigoByCodigo(String codigo){
        if (this.listaDeArtigos.containsKey(codigo))
            return (Artigo) this.listaDeArtigos.get(codigo).clone();
        return null;
    }
    /*
    public Artigo getUserByCode(int code){
        User conta = this.users.values().stream()
                .reduce(null, (acc, x) -> (x.getCodigo() == code) ? x : acc);
        if(conta != null) return conta.clone();
        else return null;
    }
    */

    public boolean existeCodigo(String codigo){
        return this.listaDeArtigos.containsKey(codigo);
    }

    public int size(){
        return listaDeArtigos.size();
    }

}
