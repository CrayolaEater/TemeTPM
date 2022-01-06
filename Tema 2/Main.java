import java.util.concurrent.BrokenBarrierException;

public class Main {
	static volatile BoundedQueue<Integer> bq = new BoundedQueue<Integer>(2);

	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {

		Thread t1 = new Thread() {
			public void run() {

				bq.enq(1);

			}
		};
		Thread t2 = new Thread() {
			public void run() {

				bq.enq(2);

			}
		};

		Thread t3 = new Thread() {
			public void run() {

				bq.enq(3);

			}
		};
		Thread t4 = new Thread() {
			public void run() {

				bq.deq();

			}
		};

		t1.start();
		t2.start();
		t3.start();
		t4.start();

		
		
		Thread.sleep(500);
		bq.print();
		
	}

}
