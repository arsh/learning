package learning;

import java.util.LinkedList;
import java.util.Queue;

// TODO: this needs to be revised
public class EventsQueueExample {
	private static Queue<String> queue = new LinkedList<>();

	private static long randomLong(int max) {
		return (long) (Math.random() * max);
	}

	public static void main(String[] args) {
		final Thread readerThread = new Thread() {
			@Override
			public void run() {
				synchronized (queue) {
					while (queue.isEmpty()) {
						try {
							queue.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					// process messages
					System.out.println(queue.poll());
				}
			}
		};

		readerThread.start();

		final Thread writerThread = new Thread() {
			@Override
			public void run() {
				long maxMessagesToAdd = randomLong(10);
				long totalMessagesAdded = 0;
				while (true && totalMessagesAdded < maxMessagesToAdd) {
					// System.out.printf("sleeping for %d ms\n", randomSleepTime);
					// sleepQuietly(randomLong(1000));

					// System.out.println("adding something to the queue");
					// add event to the queue
					queue.add("" + Math.random());
					totalMessagesAdded++;
					synchronized (queue) {
						queue.notifyAll();
					}
				}

				// synchronized (queue) {
				// queue.notifyAll();
				// }
			}
		};

		writerThread.start();
	}
}
