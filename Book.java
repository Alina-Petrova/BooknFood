public class Book extends Prodotto {
    private String nomeAutore;
    private int numeroPagine;
    private int indiceProdotto;

//------------------------------------Costruttore----------

    Book(String nomeProdotto, float prezzoProdotto, String nomeAutore, int numeroPagine, int indiceProdotto) {
        super(nomeProdotto, prezzoProdotto, "B");
        this.nomeAutore = nomeAutore;
        this.numeroPagine = numeroPagine;
        this.indiceProdotto = indiceProdotto;
    }

    //-------------------------------Metodi get-set--------------------------------

    public String getNomeAutore() {
        return nomeAutore;
    }
    public int getNumeroPagine() {
        return numeroPagine;
    }
    public int getIndiceProdotto() {
        return indiceProdotto;
    }
    public void setNomeAutore(String nomeAutore) {
        this.nomeAutore = nomeAutore;
    }
    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    //--------------------------Metodi-------------------

    String getinfoBook() {
        String ris;
        ris = "Libro " + getNomeProdotto() + " dell'autore " + nomeAutore + " ha " + numeroPagine + " pagine e costa " + getPrezzoProdotto() + "\n";
        return ris;
    }
}