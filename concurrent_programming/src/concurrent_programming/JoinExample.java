package concurrent_programming;

/**
 * Quick "join" test.
 * 
 * Output should always be:
 * 
 * <pre>
 * start
 * inside
 * end
 * </pre>
 * 
 */
public class JoinExample {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("start");
		Thread t1 = new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					System.out.println("inside");
				} catch (InterruptedException e) {
					// do nothing
				}
			}
		};
		t1.start();
		// force "main" thread to wait for "t1" to finish
		t1.join();
		System.out.println("end");
	}
}
