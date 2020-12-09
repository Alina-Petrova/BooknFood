import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

//import java.util.Scanner;

public class Carrello {
    ArrayList<Integer> prodottiCarrello = new ArrayList<Integer>();
    private Calendar dataAcquisto;
    
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    //---------------------Costruttore-----------
    Carrello(Calendar dataAcquisto, ArrayList<Integer> prodottiCarrello) {
        this.dataAcquisto = dataAcquisto;
        for(int i=0; i<prodottiCarrello.size(); i++)
            this.prodottiCarrello.add(prodottiCarrello.get(i));
    }

    //--------------------------Metodi get-set---------------

    public Calendar getDataAcquisto() {
        return dataAcquisto;
    }
    //------------------Metodi--------------------
    
    //------------------------------Metodi altri------------
    void stampaRiga(String riga) {
        System.out.print(riga);
    }
}
