package samples;

import java.util.Arrays;
import java.util.List;

public class TestStreams {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("one", "two");
		list.stream().filter((s) -> "one".equals(s)).map((s) -> s.toUpperCase()).forEach((s) -> System.out.println("hola " + s));
		
	}
}
