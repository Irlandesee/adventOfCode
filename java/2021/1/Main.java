import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class Main{

	private static final String testcase = "testcase.txt";
	private static final String input = "input.txt";
	private static final String pathToFile = "/Users/mattiamac/Documents/Github/adventOfCode/java/2021/1/";

	private static LinkedList<Integer> readInput(String filename){
		String s = "";
		LinkedList<Integer> numbers = new LinkedList<Integer>();
		
		try{
			File f = new File(pathToFile + filename);
			BufferedReader bReader = new BufferedReader(new FileReader(f));	
			while((s = bReader.readLine()) != null){
				if(!s.equals(""))
					numbers.add(Integer.parseInt(s));
			}
			bReader.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return numbers;
	}

	public static void main(String[] args){

		LinkedList<Integer> numbers = readInput(input);

		/**
		 * --- part one ---
		 * */
		int countPartOne = 0;
		for(int i = 0; i < numbers.size(); i++){
			int currentNumber = numbers.get(i);
			if(i > 0){
				int previousNumber = numbers.get(i-1);
				if(currentNumber > previousNumber){
					//System.out.printf("%d > %d\n", currentNumber, previousNumber);
					countPartOne++;
				}
			}
		}

		System.out.println("Counts part one: "+countPartOne);

		/**
		 * --- part two ---
		 * */

		int countPartTwo = 0;
		


		System.out.println("Counts part two: "+countPartTwo);
		
	}

}


