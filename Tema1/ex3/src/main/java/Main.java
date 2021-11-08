
/**
 *
 * @author incul
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {

        int cantitateMancare = 5;
        int nrSalbatici = 8;
        Salbatic salbatici[] = new Salbatic[nrSalbatici]; // vectorul de salbatici (thread urile fiecarui salbatic)
        Oala oalaBucatarului = new Oala(cantitateMancare);

        //initializam salbaticii
        for (int i = 0; i < nrSalbatici; i++) {
            salbatici[i] = new Salbatic(oalaBucatarului, i);
            salbatici[i].start();
        }

        //creem bucatarul
        Bucatar b = new Bucatar(oalaBucatarului, cantitateMancare);
        b.start();

        b.join();
        for (int i = 0; i < nrSalbatici; i++) {
            salbatici[i].join();
        }
    }

}
