public class Sapatilha{

    private String codigo;
    private int tamanho;
    private boolean novo;
    private int n_donos; // 0 ou n
    private float avaliaçao; // 0 a 5 ?
    private boolean premium;
    private String marca;
    private String descriçao;
    private int desconto;
    private float preço;

    public Sapatilha(){
        this.tamanho = 0;
        this.n_donos = 0;
        //this.avaliaçao = 0;
        this.premium = false;
        this.desconto = 0;
        this.preço = 0;
    }

    public Sapatilha(Sapatilha umaSapatilha){
        this.codigo = umaSapatilha.getCodigo();
        this.tamanho = umaSapatilha.getTamanho();
        this.novo = umaSapatilha.getNovo();
        this.n_donos = umaSapatilha.getNdonos();
        this.avaliaçao = umaSapatilha.getAvaliaçao();
        this.premium = umaSapatilha.getPremium();
        this.marca = umaSapatilha.getMarca();
        this.descriçao = umaSapatilha.getDescriçao();
        this.desconto = umaSapatilha.getDesconto();
        this.preço = umaSapatilha.getPreço(); 
    }

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    public void setTamanho(int tamanho){
        this.tamanho = tamanho;
    }

    public void setNovo(Boolean novo){
        if(this.getNdonos() > 0 && novo == false){
            this.novo = novo;
        }
        if(novo == true && this.getNdonos()>0){
            this.novo = novo;
            this.n_donos = 0;
        }
        if(novo == false && this.getNdonos() == 0){
            this.novo = novo;
            this.n_donos = 1;   //depois o utilizador tem que atualizar este valor
        }
    }


    public void setNdonos(int n_donos){
        if(!this.getNovo() && n_donos > 0){
            this.n_donos = n_donos;
        }
    }

    public String getCodigo(){
        return this.codigo;
    }

    public int getTamanho(){
        return this.tamanho;
    }

    public int getNdonos(){
        return this.n_donos;
    }

    public int getDesconto(){
        return this.desconto;
    }

    public float getPreço(){
        return this.preço;
    }

    public float getAvaliaçao(){
        return this.avaliaçao;
    }

    public boolean getPremium(){
        return this.premium;
    }

    public boolean getNovo(){
        return this.novo;
    }

    public String getDescriçao(){
        return this.descriçao;
    }

    public String getMarca(){
        return this.marca;
    }
} 