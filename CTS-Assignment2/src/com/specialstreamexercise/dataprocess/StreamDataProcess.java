package com.specialstreamexercise.dataprocess;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDataProcess {

	public List<Integer> getMultiplesOfFive() {
		Stream<Integer> infinite = Stream.iterate(5, i -> i + 5);
		 
		
		List<Integer> multipliesOfFive = infinite
		  .limit(20)
		  .collect(Collectors.toList());
		return multipliesOfFive;
	}
	
	
	public long[] getSquaresOfThree()
	{
		long[] squareOfThree = IntStream.range(20, 50) 
                .filter(i -> i % 3 == 0).mapToLong(i->i*i).toArray(); 
                
		return squareOfThree;
		
	}

}
