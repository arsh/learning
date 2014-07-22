package learning;

public class Utils {

	/**
	 * Go to sleep safely (no exceptions)
	 * 
	 * @param millis
	 */
	public static void safeSleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Printf with thread name included prefixed
	 * 
	 * @param formatString
	 * @param args
	 */
	public static void printf(String formatString, Object... args) {
		System.out.printf("%s --> %s\n", Thread.currentThread().getName(), String.format(formatString, args));
	}
}
