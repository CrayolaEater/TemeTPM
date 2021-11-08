import java.util.concurrent.locks.ReentrantLock;

public class LockBasedQueue {
	volatile int head = 0, tail = 0;
	static final int QSIZE = 5;
	volatile int items[] = new int[QSIZE];
	ReentrantLock lock = new ReentrantLock();

	public void enq(int x) {
		while (tail - head == QSIZE) {
		}
		;
		lock.lock();
		try {
			items[tail % QSIZE] = x;
			tail++;
			System.out.println("Bagat " + x);
		} finally {
			lock.unlock();
		}
	}

	public int deq() {
		while (tail == head) {
		}
		;
		lock.lock();
		try {
			int item = items[head % QSIZE];
			head++;
			System.out.println("Scos " + item);
			System.out.println("Dimensiune coada : " + (tail - head));
			return item;
		} finally {
			lock.unlock();
		}
	}
}