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

	private static char[][] convertToBits(LinkedList<String> diagnosticReport){
		char[][] bits = new char[diagnosticReport.size()][diagnosticReport.get(0).length()];
		for(int i = 0; i < diagnosticReport.size(); i++)
			bits[i] = diagnosticReport.get(i).toCharArray();
		return bits;
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

	private static int[] countZeroesAndOnes(String criteria, char[][] bits){
		int count_zero = 0;
		int count_one = 0;
		int saveIndex = 0;
		int j = 0;
		int curRow = 0;
		int stopLimit = bits.length * bits[0].length;
		int[] res = new int[bits[0].length];

		for(int i = 0; i < stopLimit; i++){
			if(bits[curRow][j] == '0')
				count_zero++;
			else
				count_one++;
			if(curRow == bits.length -1){
				curRow = 0;
				if(criteria.equals("MSB")){
					if(count_zero > count_one){
						res[saveIndex] = 0;
						saveIndex++;
					}
					else{
						res[saveIndex] = 1;
						saveIndex++;
					}
					j++;
					count_zero = 0;
					count_one = 0;
					if(j == bits[curRow].length)
						j = 0;
				}
				else if(criteria.equals("LSB")){
					if(count_zero < count_one){
						res[saveIndex] = 0;
						saveIndex++;
					}
					else{
						res[saveIndex] = 1;
						saveIndex++;
					}
					j++;
					count_zero = 0;
					count_one = 0;
					if(j == bits[curRow].length)
						j = 0;
				}
			}
			else
				curRow++;
		}
		return res;
	}

	/**
	 * Part one methods
	 * **/


	private static long findGammaRate(char[][] bits){
		int[] bin = countZeroesAndOnes("MSB", bits);
		return convertToDecimal(bin);
	}

	private static long findEpsilonRate(char[][] bits){
		int[] bin = countZeroesAndOnes("LSB", bits);
		return convertToDecimal(bin);
	}

	/**
	 * Part two methods
	 * */

	private static char[][] mostCommonValues(int pos, String criteria, char[][] bits){
		int count_zero = 0;
		int count_one = 0;

		
		char[][] res;
		LinkedList<String> tmp = new LinkedList<String>();
		LinkedList<String> zeroes = new LinkedList<String>();
		LinkedList<String> ones = new LinkedList<String>();

		for(int i = 0; i < bits.length; i++){
			if(bits[i][pos] == '0'){
				count_zero++;
				zeroes.add(new String(bits[i]));
			}
			else{
				count_one++;
				ones.add(new String(bits[i]));
			}
			if(i == bits.length - 1){
				if(criteria.equals("MCV")){
					if(count_zero > count_one){
						for(int j = 0; j < zeroes.size(); j++)
							tmp.add(zeroes.get(j));
					}
					else{
						for(int j = 0; j < ones.size(); j++)
							tmp.add(ones.get(j));
					}
				}
				else if(criteria.equals("LCV")){
					if(count_zero < count_one){
						for(int j = 0; j < zeroes.size(); j++)
							tmp.add(zeroes.get(j));
					}
					else{
						for(int j = 0; j < ones.size(); j++)
							tmp.add(ones.get(j));
					}
				}
			}
		}
		res = new char[tmp.size()][tmp.get(0).length()];
		for(int i = 0; i < tmp.size(); i++)
			res[i] = tmp.get(i).toCharArray();
		
		return res;
	}

	/**
	 * Determine the most common value in the current position,
	 * keep only the numbers with that bit in that position. if 0 and 1
	 * are equally common, keep values with a 1 in the position being
	 * considered
	 * */
	private static long findOxigenRating(char[][] bits){
		int pos = 0;
		int numbersLeft = bits.length;

		while(numbersLeft > 1){
			bits = mostCommonValues(pos, "MCV", bits);
			numbersLeft = bits.length;
			pos++;
			if(pos == bits[0].length)
				pos = 0;
			//System.out.println("numbers left in bits: "+numbersLeft);
			//System.out.println("----------------------------");
		}

		char[] tmp = bits[0];
		int[] resBin = new int[tmp.length];
		for(int i = 0; i < tmp.length; i++)
			resBin[i] = Character.getNumericValue(tmp[i]);

		return convertToDecimal(resBin);
	}

	/**
	 * Determine the least common value in the current position,
	 * keep only the numbers with that bit in that position. if 0 or 1
	 * are equally common, keep values with a 0 in the position being 
	 * considered
	 * */
	private static long findScrubberRating(char[][] bits){
		int pos = 0;
		int numbersLeft = bits.length;

		while(numbersLeft > 1){
			bits = mostCommonValues(pos, "LCV", bits);
			numbersLeft = bits.length;
			pos++;
			if(pos == bits[0].length)
				pos = 0;
			//System.out.println("numbers left in bits: "+numbersLeft);
			//System.out.println("----------------------------");
		}

		char[] tmp = bits[0];
		int[] resBin = new int[tmp.length];
		for(int i = 0; i < tmp.length; i++)
			resBin[i] = Character.getNumericValue(tmp[i]);

		return convertToDecimal(resBin);
	}


	public static void main(String[] args){

		LinkedList<String> diagnosticReport = readInput("input.txt");

		char[][] bits = convertToBits(diagnosticReport);		

		long gammaRate = findGammaRate(bits);
		long epsilonRate = findEpsilonRate(bits);
		long powerConsumption = gammaRate * epsilonRate;
		System.out.println("--- part one ---");
		System.out.println("gamma rate: "+gammaRate);
		System.out.println("epsilon rate: "+epsilonRate);
		System.out.println("power consumption: "+powerConsumption);
		System.out.println("--- part two ---");
		long oxigenGeneratorRating = findOxigenRating(bits);
		long scrubberRating = findScrubberRating(bits);
		long lifeSupportRating = oxigenGeneratorRating * scrubberRating;
		System.out.println("oxigen generator rating: "+oxigenGeneratorRating);
		System.out.println("CO2 scrubber rating: "+scrubberRating);
		System.out.println("Life support rating: "+lifeSupportRating);
	}

}