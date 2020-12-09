import java.util.Calendar;
//import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class Food extends Prodotto {
    private int peso;
    private Calendar dataScadenza;
    private int indiceProdotto;

//---------------------------Costruttore---------------

    Food(String nomeProdotto, float prezzoProdotto, int peso, Calendar dataScadenza, int indiceProdotto) {
        super(nomeProdotto, prezzoProdotto, "F");
        this.peso = peso;
        this.dataScadenza = dataScadenza;
        this.indiceProdotto = indiceProdotto;
    }

    //--------------------------Metodi get-set------------------

    public Calendar getDataScadenza() {
        return dataScadenza;
    }
    public int getPeso() {
        return peso;
    }
    public int getIndiceProdotto() {
        return indiceProdotto;
    }
    public void setDataScadenza(Calendar dataScadenza) {
        this.dataScadenza = dataScadenza;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }

    //---------------------------Metodi---------------

    String infoFood() {
        String ris;
        SimpleDateFormat dateFormat = new SimpleDateFormat("d/MM/yyyy");
        ris = getNomeProdotto() + " pesa " + peso + ", scade " + dateFormat.format(dataScadenza.getTime()) + " e costa " + getPrezzoProdotto() + "\n";
        return ris;
    }
}