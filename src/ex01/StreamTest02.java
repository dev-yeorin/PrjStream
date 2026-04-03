package ex01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest02 {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("apple", "banana", "cherry");
		List<String> result = list.stream()
				.filter(s -> s.contains("a"))
				.collect(Collectors.toList());
		System.out.println(result);
	}

}
