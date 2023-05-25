public class App {
    public static void main(String[] args) throws Exception {
        Semaforo s = new Semaforo(1);

        Box b = new Box();

        Autovettura ferrari = new Autovettura("Leclerc", 16, "Ferrari", s, b);
        Autovettura mercedes = new Autovettura("Hamilton", 34, "mercedes", s, b);
        Autovettura redbull = new Autovettura("Verstappen", 12, "redbull", s, b);
        
        ferrari.start();
        mercedes.start();
        redbull.start();

        ferrari.join();
        mercedes.join();
        redbull.join();
        
        System.out.println("FINE GARA");
    }
}
