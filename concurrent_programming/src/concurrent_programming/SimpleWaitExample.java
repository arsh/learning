package concurrent_programming;

import java.util.concurrent.atomic.AtomicBoolean;

public class SimpleWaitExample {

	public static void main(String[] args) {
		final AtomicBoolean LOCK = new AtomicBoolean(false);
		Thread t1 = new Thread() {
			@Override
			public void run() {
				try {
					// need to have object monitor (lock)
					synchronized (LOCK) {
						// while (!LOCK.get()) {
						LOCK.wait();
						// }
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("done");
			}
		};

		t1.start();

		Thread t2 = new Thread() {
			@Override
			public void run() {
				System.out.println("trying to notify");
				synchronized (LOCK) {
					LOCK.set(true);
					LOCK.notifyAll();
					System.out.println("notified");
				}
			}
		};

		t2.start();
	}
}
