public class Box {

    public Box() {
    }
    
    public void entra() {
        System.out.println("PIT-STOP " + Thread.currentThread().getName() + " cambio gomme in corso");
    }

    public void esci() {
        System.out.println("PIT-STOP " + Thread.currentThread().getName() + " FINITO");
    }
}
