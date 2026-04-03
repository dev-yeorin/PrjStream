package ex01;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Person {
	private String name;
	private int 	age;
	
	public Person(String nae, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	 
	
	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}


public class StreamTest04 {

	public static void main(String[] args) {
		
		//int []
		// -> IntStream 	  : Arrays.stream(arr) int type의 stream
		// -> Stream<Integer> : .boxed() 		   int -> Integer
		// -> List<Integer>	  : toList()	 	   int -> 
		
		// 1) int[] 배열
		int [] arr = {1,2,3,4,5};
		
		// 2) int[] -> List<Integer>
		List<Integer> list = Arrays.stream(arr)
				.boxed()
				.toList();
		
		System.out.println("원본 List: " + list);
		
		//3) 전체 합계
		//mapToInt: stream 안에 있는 내용을 하나씩 꺼내서 변경 작업
		//Integer::intValue 		: Int < - Integer
		// Integer.valueOf(30)		: int->Integer
		int sum = list.stream()
				.mapToInt(Integer::intValue)
				.sum();
		System.out.println("합계: " + sum);
		
		// 4) filter: 짝수 추출
		List<Integer> evenList = list.stream()
				.filter(n -> n%2 == 0)
				.toList();
		System.out.println("짝수목록:" + evenList);
		
		// 5) map : 모든 데이터를 10배로 변환
		List<Integer> mappedList = list.stream()
				.map(n -> n * n)
				.toList(); // stream list -> array.list 변환
		System.out.println("배열 10배: " + mappedList);
		
		// 6) filter+map + sum
		Double result = list.stream()
				.filter(n -> n >= 3)
				.map( n -> n * n)				
				.mapToDouble(Integer::doubleValue) 
				//.mapToInt(Integer::intValue) //Integer -> int 변환
				.average()
				.orElse(0.0);
				//Optional<Double> : 결과가 null 될 수 없다
				// 만약 null 이면 .orElse(0.0) 추가해서 0.0으로 만들어야 함
				//.sum(); // 결과는 Int
		System.out.println("" + result);
		
		// 7) forEach
		//Stream<String> stream = Stream.of("apple", "banana", "cherry", "durian");
		/*
		String [] fruits = {"apple", "banana", "cherry", "durian"};
		List<String> fruitList = Arrays.asList(fruits);
		fruitList.stream()
				 .forEach(  fruit ->
				System.out.println(fruit.toUpperCase())
				);*/
		/*
		String [] fruits = {"apple",  "cherry", "banana", "durian"};
		List<String> fruitList = Arrays.asList(fruits);
		fruitList.stream()
				 .sorted() // 정렬
				 .forEach(  fruit ->
		System.out.println(fruit.toUpperCase())
				);*/
		
		String [] fruits = {"apple", "cherry", "apple", "banana", "durian"};
		List<String> fruitList = Arrays.asList(fruits);
		fruitList.stream()
				 .distinct() // 중복 제거
				 .sorted() // 정렬
				 .limit(3) // 작업 대상 갯수를 제한
				 .forEach(  fruit ->
		System.out.println(fruit.toUpperCase())
				);
		
		// 8)
		List<Person> people = Arrays.asList(
				new Person ("John", 25),
				new Person ("Jane", 30),
				new Person ("Bob", 25),
				new Person ("Alice", 230)
				);
	      Map<Integer, List<Person>> result2 
	      			= people.stream().collect
	    	      (Collectors.groupingBy(Person::getAge));
	    	      System.out.println(result2);
	    	         
				
	}

}
