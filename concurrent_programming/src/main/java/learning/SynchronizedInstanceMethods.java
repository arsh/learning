package learning;

public class SynchronizedInstanceMethods {

	public static synchronized void method() {
		System.out.println("SynchronizedInstanceMethods.method() from " + Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		// this is using java 8 lambdas
		new Thread(() -> {
			try {
				Thread.sleep(2500);
			} catch (Exception e) {
			}
			SynchronizedInstanceMethods.method();
		}, "t1").start();

		new Thread(() -> {
			SynchronizedInstanceMethods.method();
		}, "t2").start();
	}
}
