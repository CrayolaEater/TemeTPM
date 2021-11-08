
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author incul
 */
public class Bucatar extends Thread {

    private int n;
    private Oala oala;

    public Bucatar(Oala oala, int n) {
        this.oala = oala;
        this.n = n;
    }

    @Override
    public void run() {
        try {
            this.oala.umpleCantitate(n);
        } catch (InterruptedException ex) {
            Logger.getLogger(Bucatar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
