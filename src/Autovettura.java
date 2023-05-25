/**
 * @author Riccardo Grandi
 * classe Autovettura - estende la classe Thread
 */
public class Autovettura extends Thread{
    /** Attributi della classe */
    /** int numero = numero identificativo dell'auto*/
    private int numero;
    /** String scuderia = nome della scuderia */
    private String scuderia;
    /** String pilota = nome del pilota dell'auto */
    private String pilota;
    /** Semaforo semaforo =  classe semaforo che gestisce l'accesso alla risorsa*/
    private Semaforo semaforo;
    /** Box box = classe condivisa */
    private Box box;

    /**
     * 
     * @param name = nome del pilota dell'auto
     * @param numero = numero identificativo dell'auto
     * @param scuderia = nome della scuderia
     * @param semaforo = semaforo di Dijkstra che gestisce l'accesso alla risorsa
     * @param box = risorsa condivisa
     */
    public Autovettura(String name, int numero, String scuderia, Semaforo semaforo, Box box) {
        super(name);
        this.numero = numero;
        this.scuderia = scuderia;
        this.pilota = name;
        this.semaforo = semaforo;
        this.box = box;
    }

    /**
     * override del metodo run() della classe Thread
     * tramite un ciclo for gestisce la gara in corso
     * ogni 3 giri il thread prova ad utilizzare la risorsa condivisa
     * accesso al box gestisto tramite il semaforo
     * @return
     *  */    
    @Override
    public void run() {
        int giro = (int) (Math.random()*4+1);

        int cambio = (int) (Math.random()*5+1);

        for (int i = 1; i < 11; i++) {
            try {
                Thread.sleep(giro);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (i == 3 || i == 6 || i == 9) {
                semaforo.P();
                box.entra();
                try {
                    Thread.sleep(cambio);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                box.esci();
                semaforo.V();
            }
            System.out.println("GIRO-" + i + " Completato " + pilota);
        }
    }

}