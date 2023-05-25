public class Semaforo {
    private int valore;

    public Semaforo(int valore) {
        this.valore = valore;
    }

    public synchronized void P() {
        while (valore == 0) {
            try {
                System.out.println("------- " + Thread.currentThread().getName() + " in attesa al box ------");
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        valore--;
    }

    public synchronized void V() {
        valore++;
        notify();
    }
    
}
