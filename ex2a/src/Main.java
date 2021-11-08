
public class Main {

	public static void main(String[] args) {
		LockBasedQueue L = new LockBasedQueue();
		new Thread(() -> {
			L.deq();
		}).start();

		new Thread(() -> {
			L.enq(2);
		}).start();
		
		new Thread(() -> {
			L.deq();
		}).start();
	}
}
