
/**
 *
 * @author incul
 */
public class Oala {

    public int cantitate;

    public Oala(int cantitateInceput) {
        this.cantitate = cantitateInceput;
    }

    public synchronized void mananca(int salbaticId) throws InterruptedException {
        while (cantitate == 0) { // nu putem manca daca oala e goala
            wait();//asteptam ca bucatarul sa umple oala
        }
        this.cantitate--;
        System.out.printf("Salbaticul %d a mancat din oala!\n", salbaticId);
        notifyAll(); // notificam faptul ca am reusit sa mancam
    }

    public synchronized void umpleCantitate(int n) throws InterruptedException {
        while (cantitate > 0) {//umplem doar oala goala
            wait(); // asteptam ordin de la salbatic sa umplem oala
        }
        this.cantitate = n;
        System.out.println("Bucatarul a umplut oala!");
        notifyAll(); // la fel si in cazul bucatarului
    }
}
