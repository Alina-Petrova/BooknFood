import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;
//import java.text.SimpleDateFormat;

public class BooknFood {
    private String nomeNegozio;
    private String indirizzo;
    ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
    ArrayList<Book> books = new ArrayList<Book>();
    ArrayList<Food> foods = new ArrayList<Food>();
    ArrayList<Carrello> carrelli = new ArrayList<Carrello>();

//---------------------Costruttore------------------

    BooknFood(String nomeNegozio, String indirizzo) {
        this.nomeNegozio = nomeNegozio;
        this.indirizzo = indirizzo;
    }

//------------------------------Metodi get-set-------------

    public String getNomeNegozio() {
        return nomeNegozio;
    }
    public String getIndirizzo() {
        return indirizzo;
    }
    public void setNomeNegozio(String nomeNegozio) {
        this.nomeNegozio = nomeNegozio;
    }
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

//--------------------METODI-----------------------
    
    void creaNuovoProdotto() {
        String tipoProdotto;
        String nomeProdotto, nomeAutore="";
        int peso=0, numeroPagine=0;
        int giorno, mese, anno;
        Calendar dataScadenza=new GregorianCalendar();
        float prezzoProdotto;
        Prodotto newProdotto;
        Book newBook;
        Food newFood;
        Scanner lettore = new Scanner(System.in);
    //-------------Raccolta dati------------------------------------------------------
        stampaRiga("Che tipo di prodotto vuole inserire? (F - cibo, B - libro) ");
        tipoProdotto = lettore.nextLine();
        if(tipoProdotto.equals("F")) {
            stampaRiga("Nome del prodotto: ");
            nomeProdotto = lettore.nextLine();
            stampaRiga("Il peso di " + nomeProdotto + " = ");
            peso = lettore.nextInt();
            stampaRiga("Inserisca la data di scadenza \n giorno(1-31): ");
            giorno = lettore.nextInt();
            stampaRiga("mese(1-12): ");
            mese = lettore.nextInt();
            stampaRiga("anno(>2021): ");
            anno = lettore.nextInt();
            dataScadenza = new GregorianCalendar(anno, (mese-1) , giorno);
        } else {
            stampaRiga("Titolo del libro: ");
            nomeProdotto = lettore.nextLine();
            stampaRiga("Autore: ");
            nomeAutore = lettore.nextLine();
            stampaRiga("Quante pagine ha il libro? ");
            numeroPagine = lettore.nextInt();
        }
        stampaRiga("Inserisca il prezzo: ");
        prezzoProdotto = lettore.nextFloat();
    
        //--------------------------------Creazione del prodotto-----------------

        newProdotto = new Prodotto(nomeProdotto, prezzoProdotto, tipoProdotto);
        aggiungereProdotto(newProdotto);
        if(tipoProdotto.equals("F")) {
            newFood = new Food(nomeProdotto, prezzoProdotto, peso, dataScadenza, prodotti.size()-1);
            aggiungereCibo(newFood);
        } else {
            newBook = new Book(nomeProdotto, prezzoProdotto, nomeAutore, numeroPagine, prodotti.size()-1);
            aggiungereLibro(newBook);
        }
    }

    void riempiCarello() {
        Scanner lettore = new Scanner(System.in);
        Calendar dataAcquisto = new GregorianCalendar();
        Carrello newCarrello;
        ArrayList<Integer> prodottiCarrello = new ArrayList<Integer>();
        String acquisto="";

        //--------------Raccolta dati di acquisti----------------
        do {
        stampaRiga("Inserisca il nome del prodotto o il titolo del libro che desidera acquistare: ");
        int i=0;
        acquisto = lettore.nextLine();
        while(!(prodotti.get(i).getNomeProdotto().equals(acquisto)) && i<prodotti.size())
            i++;
        if(i<prodotti.size()) {
            prodottiCarrello.add(i);
            stampaRiga("Desidera fare un altro acquisto? Y/N ");
        }    
        else
            stampaRiga("Questo prodotto non esiste. Vuole riprovare? (Y/N) ");
        acquisto = lettore.nextLine();
        } while(acquisto.equals("Y"));
        newCarrello = new Carrello(dataAcquisto, prodottiCarrello);
        aggiungereCarrello(newCarrello);
    }
//-------------------------------------------Metodi piccoli-----------------------------
    String listaLibri() {
        String ris = "";
        for(int i=0; i<books.size(); i++) {
            ris += books.get(i).getNomeProdotto() + " scritto da " + books.get(i).getNomeAutore() + "\n";
        }
        return ris;
    }
    //----------------------------------------------
    String listaCibi() {
        String ris = "";
        for(int i=0; i<foods.size(); i++) {
            ris += foods.get(i).getNomeProdotto() + " pesa " + foods.get(i).getPeso() + "\n";
        }
        return ris;
    }
    //--------------------------------------------
    float totaleCarrelliData(Calendar data) {
        float ris = 0;
        int i = 0;
      
            while(!data.equals(carrelli.get(i).getDataAcquisto()) && i<carrelli.size())
                i++;
            do {    
                if(i<carrelli.size()){
                    for(int j=0; j<carrelli.get(i).prodottiCarrello.size(); j++) {
                        ris += prodotti.get(carrelli.get(i).prodottiCarrello.get(j)).getPrezzoProdotto();
                    }
                }
                i++;
            } while(data.equals(carrelli.get(i).getDataAcquisto()) && i<carrelli.size());   
        
        return ris;
    }
    //-------------------------------------------------
    float totaleCarrello(int num) {
        float ris = 0;
        for(int j=0; j<carrelli.get(num).prodottiCarrello.size(); j++) {
                ris += prodotti.get(carrelli.get(num).prodottiCarrello.get(j)).getPrezzoProdotto();
        }
        return ris;
    }
    //----------------------------------------------------
    float totaleEntrateNegozio() {
        float ris = 0;
        for(int i=0; i<carrelli.size(); i++) {
            ris += totaleCarrello(i); 
        }
        return ris;
    }
    //------------------------------------------------------
    String infoCarrello(int num) {
        String ris = "";
        int indexProdotto, i=0;
        for(int j=0; j<carrelli.get(num).prodottiCarrello.size(); j++) {
            indexProdotto = carrelli.get(num).prodottiCarrello.get(j);
            if(prodotti.get(indexProdotto).getTipoProdotto().equals("F")) {
                while(foods.get(i).getIndiceProdotto()!=indexProdotto)
                    i++;
                ris += foods.get(i).infoFood();  
            } else {
                while(books.get(i).getIndiceProdotto()!=indexProdotto)
                    i++;
                ris += books.get(i).getinfoBook(); 
            }
        
        }
        return ris;

    }
    //-------------------------------------------------------------------
    void stampaRiga(String riga) {
        System.out.print(riga);
    }
    void aggiungereProdotto(Prodotto prodotto) {
        prodotti.add(prodotto);
    }
    void aggiungereLibro(Book book) {
        books.add(book);
    }
    void aggiungereCibo(Food food) {
        foods.add(food);
    }
    void aggiungereCarrello(Carrello carrello) {
        carrelli.add(carrello);
    }
}
