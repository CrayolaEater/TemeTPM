
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author incul
 */
public class Salbatic extends Thread {

    private Oala oala;
    private int salbaticId;

    public Salbatic(Oala oala, int id) {
        this.oala = oala;
        this.salbaticId = id;
    }

    @Override
    public void run() {
        try {
            this.oala.mananca(this.salbaticId);
        } catch (InterruptedException ex) {
            Logger.getLogger(Salbatic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
