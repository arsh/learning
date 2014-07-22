package learning;

public class DeadLock {

	public static void main(String[] args) {
		String a = "a";
		String b = "b";

		new Thread(() -> {
			synchronized (a) {
				Utils.printf("got lock for 'a'");
				//Utils.safeSleep(2000);
				Utils.printf("waiting lock for 'b'");
				synchronized (b) {
					Utils.printf("a=%s; b=%s", a, b);
				}
			}
		}, "t1").start();

		new Thread(() -> {
			synchronized (b) {
				Utils.printf("got lock for 'b'");
				//Utils.safeSleep(2000);
				Utils.printf("waiting lock for 'a'");
				synchronized (a) {
					Utils.printf("a=%s; b=%s", a, b);
				}
			}
		}, "t2").start();
	}
}
