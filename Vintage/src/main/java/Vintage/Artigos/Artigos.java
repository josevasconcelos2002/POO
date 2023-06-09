package Vintage.Artigos;

import Vintage.Users.User;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class Artigos implements Serializable {
    private Map<String, Artigo> listaDeArtigos;

    public Artigos(){
        this.listaDeArtigos = new HashMap<>();
    }

    public Artigos(Map<String, Artigo> listaDeArtigos){
        this.setListaDeArtigos(listaDeArtigos);
    }

    public Artigos(Artigos as){
        this.listaDeArtigos = as.getListaDeArtigos();
    }

    public String getNewCode(){
        String codigoCompleto;
        String codigo;

        do {
            codigoCompleto = UUID.randomUUID().toString();
            codigo = codigoCompleto.replaceAll("-", "").substring(0, 15);
        } while (listaDeArtigos.containsKey(codigo));

        return codigo;
    }

    public Map<String, Artigo> getListaDeArtigos() {
        return this.listaDeArtigos.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a,b) -> a, HashMap::new));
    }

    public void setListaDeArtigos(Map<String, Artigo> listaDeArtigos){
        this.listaDeArtigos = listaDeArtigos.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().clone(), (a,b)->a, HashMap::new));
    }

    public void addArtigo(Artigo a){
        this.listaDeArtigos.put(a.getCodigo(), (Artigo) a.clone());
    }

    public void removeArtigo(Artigo a){
        this.listaDeArtigos.remove(a.getCodigo());
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
