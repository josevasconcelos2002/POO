package Vintage.Encomendas;

import java.io.Serializable;
import java.util.ArrayList;

public class Encomendas implements Serializable {
    private ArrayList<Encomenda> encomendas;  //pode ser um arrayList em que é colocado por data

    public Encomendas(){
        this.encomendas = new ArrayList<Encomenda>();
    }

    public Encomendas(ArrayList<Encomenda> encomendas){
        this.setEncomendas(encomendas);
    }

    public Encomendas(Encomendas encomendas){
        this.setEncomendas(encomendas.getEncomendas());
    }

    public ArrayList<Encomenda> getEncomendas(){
        return this.encomendas;
    }

    public void setEncomendas(ArrayList<Encomenda> encomendas){
        this.encomendas = encomendas;
    }

    public void addEncomenda(Encomenda encomenda){
        this.encomendas.add(encomenda);
    }

    public void removeEncomenda(Encomenda encomenda){
        this.encomendas.remove(encomenda);
    }

    public String printEncomendas(){
            StringBuilder sb = new StringBuilder();
            sb.append("Encomendas: \n\n");
            for (Encomenda e : encomendas) {
                sb.append("\t").append(e.stringEncomenda()).append("\n");
            }
            return sb.toString();
    }
}
