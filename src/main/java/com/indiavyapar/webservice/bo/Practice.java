package com.indiavyapar.webservice.bo;

import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Practice {

	public static void main(String args[]) {

//		String arr [] = {"Rihan", "Aayan", "Shriyan", "Riyaan"};
//		
//		Arrays.stream(arr).filter( s -> s.toLowerCase().startsWith("r")).forEach(System.out::println);

//		Consumer<Integer> consumer = t -> System.out.println("The number is : " + t);
//		
//		consumer.accept(10);

//		List<Integer> list = Arrays.asList(1,2,3,4,5);

//		list.stream().forEach(consumer);

//		list.stream().forEach(t -> System.out.println("The number is : " + t));
//
//		Predicate<Integer> predicate = t -> t % 2 == 0;
//		list.stream().filter(predicate).forEach( t -> System.out.println("The number is even : " + t));
//
//		list.stream().filter(t -> t %2 == 0).forEach( t -> System.out.println("This is even number : " + t));
//		
//		
//		
//		
//		Map<String, Integer> map = new HashMap<>();
//		
//		map.put("A", 1);
//		map.put("B", 2);
//		
//		List<Entry<String, Integer>> mapList = new ArrayList<>(map.entrySet());
//		
//		Collections.sort(mapList, new Comparator<Entry<String, Integer>>() {
//
//			@Override
//			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
//				
//				return o2.getKey().compareTo(o1.getKey());
//			}
//			
//		});
//		
//		for(Entry<String, Integer> mapEntry : mapList) {
//			System.out.println(mapEntry.getKey());
//		}

//		
//		Map<Employee, Integer> employeeMap = new HashMap<>();
//		employeeMap.put(new Employee(1, "Kishan", 500000), 10);
//		employeeMap.put(new Employee(2, "Jacky", 600000), 20);
//		
//		employeeMap.entrySet().stream().sorted(Map.Entry.comparingByKey(
//				Comparator.comparing(Employee::getSalary))).forEach(System.out::println); 

//		long start = 0;
//		long end = 0;
//		
//		start = System.currentTimeMillis();
//		
//		IntStream.range(1, 1000000000).forEach( t -> Math.pow(t, 10));
//		
//		end = System.currentTimeMillis();
//		
//		System.out.println("System took this much time : " + (end-start));
//		
//		System.out.println("========================================");
//		
//	
//		
//		start = System.currentTimeMillis();
//
//		IntStream.range(1, 1000000000).parallel().forEach( t -> Math.pow(t, 10));
//
//		end = System.currentTimeMillis();
//
//		System.out.println("System took this much time : " + (end-start));

		// Sum using Java 8

		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 8, 7, 9);

		int sum = integers.stream().mapToInt(Integer::intValue).sum();

		System.out.println(sum);

		// Average

		double avg = integers.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0);

		System.out.println(avg);

		// To lowercases
		List<String> students = Arrays.asList("Virat", "Sachin", "Dhoni", "Yuvraj");

		students.stream().map(name -> name.toLowerCase()).collect(Collectors.toList()).forEach(System.out::println);

		// sum of odd and even
		int sumOfEven = integers.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();

		int sumOfOdd = integers.stream().filter(n -> n % 2 != 0).mapToInt(Integer::intValue).sum();

		System.out.println("Even - " + sumOfEven + " Odd - " + sumOfOdd);

		// Duplicates from array

		integers.stream().distinct().collect(Collectors.toList()).forEach(System.out::println);

		// Count strings starting with letters

		long startingWitLetter = students.stream().filter(s -> Character.isLetter(s.charAt(0))).count();

		System.out.println(startingWitLetter);

		// Sort from a-z

		students.stream().sorted().forEach(System.out::println);

		// Sort from z-a

		students.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

		// Max in list

		integers.stream().mapToInt(Integer::intValue).max().ifPresent(System.out::println);

		// Min in list

		integers.stream().mapToInt(Integer::intValue).min().ifPresent(System.out::println);
		
		//Second smallest
		
		System.out.println("-------------");
		
		integers.stream().distinct().sorted().skip(1).findFirst().ifPresent(System.out::println);
		
		//Second smallest
		
		integers.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().ifPresent(System.out::println);

	}

}
