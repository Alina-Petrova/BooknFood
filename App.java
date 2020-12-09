//import java.util.Calendar;
//import java.util.GregorianCalendar;
//import java.text.SimpleDateFormat;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
       String risposta="Y";
       Scanner lettore = new Scanner(System.in);
       String daStampare = "";

       BooknFood newNegozio = new BooknFood("Mio negozio", "Torino");
    //----------------------Ciclo inserimento prodotti-------------------------------   
       stampaRiga("Desidera inserire un prodotto nella lista assortimento? (Y/N) ");
        risposta = lettore.nextLine(); 
        while(risposta.equals("Y")) {
            newNegozio.creaNuovoProdotto();
            stampaRiga("Desidera inserire un prodotto nella lista assortimento? (Y/N) ");
            risposta = lettore.nextLine(); 
        }
        //----------------------Stampa liste assortimento----------------
        daStampare = "Abbiamo seguenti prodotti alimentari a disposizione: \n" + newNegozio.listaCibi();
        stampaRiga(daStampare);
        daStampare = "Abbiamo seguenti libri a disposizione: \n" + newNegozio.listaLibri();
        stampaRiga(daStampare);
        //----------------------Ciclo compere----------------------------
        do {
            stampaRiga("Desidera comprare qualcosa? (Y/N) ");
            risposta = lettore.nextLine(); 
            
            if(risposta.equals("Y")) 
                newNegozio.riempiCarello();
            stampaRiga("C'è qualcuno in coda? (Y/N) "); 
            risposta = lettore.nextLine(); 

        } while(risposta.equals("Y"));
        stampaRiga("Le spese fatte nel negozio " + newNegozio.getNomeNegozio() + ": \n");
        stampaRiga(newNegozio.totaleEntrateNegozio() + "\n");

        
        lettore.close();

    }
    static void stampaRiga(String riga) {
        System.out.print(riga);
    }
}
