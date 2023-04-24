package Vintage;
//import Vintage.Artigos.Artigo;


public interface IArtigo {
    public String getCodigo();
    //public Artigo.Estado getEstado();
    public double getAvaliacao();
    public int getnDonos();
    public String getDescricao();
    public String getMarca();
    public double getPrecoBase();
    public double getPrecoCorrigido();
}