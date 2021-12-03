import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Main{

	private static final String pathToFile = "/Users/mattiamac/Documents/GitHub/adventOfCode/java/2021/3/";

	private static LinkedList<String> readInput(String filename){
		BufferedReader bReader = null;
		File f = null;
		LinkedList<String> res = new LinkedList<String>();

		String s = "";
		try{
			f = new File(pathToFile+filename);
			bReader = new BufferedReader(new FileReader(f));
			while((s = bReader.readLine()) != null){
				res.add(s);
			}
			bReader.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return res;
	}

	private static long convertToDecimal(int[] binaryNumbers){
		long sum = 0;
		int pow = binaryNumbers.length - 1;
		for(int i = 0; i < binaryNumbers.length; i++){
			sum += (binaryNumbers[i] * (Math.pow(2, pow)));
			pow--;
		}
		return sum;
	}


	private static long findGammaRate(LinkedList<String> diagnosticReport){
		
		int count_zero = 0;
		int count_one = 0;

		char[][] bits = new char[diagnosticReport.size()][diagnosticReport.get(0).length()];
		int[] counters = new int[diagnosticReport.get(0).length()];
		
		for(int i = 0; i < diagnosticReport.size(); i++){
			char[] tmp = diagnosticReport.get(i).toCharArray();
			bits[i] = tmp;
		}
		int saveIndex = 0;
		int j = 0;
		int curRow = 0;
		int stop = bits.length * bits[0].length;
		for(int i = 0; i < stop; i++){
			if(bits[curRow][j] == '0')
				count_zero++;
			else
				count_one++;
			if(curRow == bits.length - 1){
				curRow = 0;
				if(count_zero > count_one){
					counters[saveIndex] = 0;
					saveIndex++;
				}
				else{
					counters[saveIndex] = 1;
					saveIndex++;
				}
				j++;
				count_zero = 0;
				count_one = 0;
				
				if(j == bits[curRow].length)
					j = 0;
			}
			else
				curRow++;				
		}
		
		return convertToDecimal(counters);
	}

	private static long findEpsilonRate(LinkedList<String> diagnosticReport){
		int count_zero = 0;
		int count_one = 0;

		char[][] bits = new char[diagnosticReport.size()][diagnosticReport.get(0).length()];
		int[] counters = new int[diagnosticReport.get(0).length()];
		
		for(int i = 0; i < diagnosticReport.size(); i++){
			char[] tmp = diagnosticReport.get(i).toCharArray();
			bits[i] = tmp;
		}
		int saveIndex = 0;
		int j = 0;
		int curRow = 0;
		int stop = bits.length * bits[0].length;

		for(int i = 0; i < stop; i++){
			if(bits[curRow][j] == '0')
				count_zero++;
			else
				count_one++;
			if(curRow == bits.length - 1){
				curRow = 0;
				if(count_zero < count_one){
					counters[saveIndex] = 0;
					saveIndex++;
				}
				else{
					counters[saveIndex] = 1;
					saveIndex++;
				}
				j++;
				count_zero = 0;
				count_one = 0;
				
				if(j == bits[curRow].length)
					j = 0;
			}
			else
				curRow++;				
		}	

		return convertToDecimal(counters);
	}


	public static void main(String[] args){

		LinkedList<String> diagnosticReport = readInput("testcase.txt");
		long gammaRate = findGammaRate(diagnosticReport);
		long epsilonRate = findEpsilonRate(diagnosticReport);
		long powerConsumption = gammaRate * epsilonRate;
		System.out.println("--- part one ---");
		System.out.println("gamma rate: "+gammaRate);
		System.out.println("epsilon rate: "+epsilonRate);
		System.out.println("power consumption: "+powerConsumption);
		System.out.println("--- part two ---");
		
	}

}