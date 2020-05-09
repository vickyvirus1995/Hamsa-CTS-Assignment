import java.util.List;

import com.specialstreamexercise.dataprocess.StreamDataProcess;

public class SpecialStreamExercise {
	
	public static void main(String[] args) {
		
		StreamDataProcess dataProcess = new StreamDataProcess();
		
		List<Integer> multipliesOfFive = dataProcess.getMultiplesOfFive();
		
		System.out.println("Mutiplies of Five are");
		System.out.println(multipliesOfFive);
		
		long[] squareOfThree = dataProcess.getSquaresOfThree();
		
		System.out.println("\nSquare of odd multiplies of three are");
		for(long squareThree : squareOfThree)
		{
			System.out.println(squareThree);
		}
	}

}
