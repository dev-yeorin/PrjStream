package ex01;

import java.util.Arrays;
import java.util.List;

public class StreamTest03 {

	public static void main(String[] args) {
		
		//Integer [] 				arr = {1,2,3,4,5};
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		System.out.println(numbers);
		int sum = numbers.stream()
				.reduce(0, Integer::sum);
		// Integer 클래스의 정적 메서드 sum(int a, int b) L Integer.sum(int a, int b)
		// (a, b) -> a + b
		System.out.println(sum);
		
		List<Integer> list = Arrays.asList(7,2,8,4,5);
		int sum2 = list.stream().reduce(0,(a,b) -> a+b);
				System.out.println(sum2);
				
		
	}

}
