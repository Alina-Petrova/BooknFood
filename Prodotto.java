public class Prodotto {
    private String nomeProdotto;
    private float prezzoProdotto;
    private String tipoProdotto;
//----------------------------------Costruttore--------------------------

Prodotto(String nomeProdotto, float prezzoProdotto, String tipoProdotto) {
    this.nomeProdotto = nomeProdotto;
    this.prezzoProdotto = prezzoProdotto;
    this.tipoProdotto = tipoProdotto;
}

//---------------------------------------Metodi get-set-------------------
    public String getNomeProdotto() {
        return nomeProdotto;
    }
    public float getPrezzoProdotto() {
        return prezzoProdotto;
    }
    public String getTipoProdotto() {
        return tipoProdotto;
    }
    public void setNomeProdotto(String nomeProdotto) {
        this.nomeProdotto = nomeProdotto;
    }
    public void setPrezzoProdotto(float prezzoProdotto) {
        this.prezzoProdotto = prezzoProdotto;
    }
//--------------------------------------------Metodi altri-------------------
    String getinfoProdotto() {
        String ris;
        ris = nomeProdotto + " costa " + prezzoProdotto;
        return ris;
    }
}
