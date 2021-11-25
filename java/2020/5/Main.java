import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.LinkedList;
import java.util.Comparator;

public class Main{

	private static final String inputFile = "input.txt";
	private static final String pathToFile = "/Users/mattiamac/Documents/Github/adventOfCode/java/2020/5/";

	private static LinkedList<String> readFile(){
		LinkedList<String> ris = new LinkedList<String>();
		try{
			String s = "";
			File f = new File(pathToFile+inputFile);
			BufferedReader bReader = new BufferedReader(new FileReader(f));
			while((s = bReader.readLine()) != null){
				ris.add(s);
			}
			bReader.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return ris;
	}

	private static String getCodeRow(String code){
		String ris = code.substring(0, code.length()-3);
		return ris;
	}

	private static String getCodeCol(String code){
		String ris = code.substring(code.length()-3, code.length());
		return ris;
	}

	private static int decodeRow(String encodedRow){
		int maxRange = 128;
		int lowerLimit = 0;
		int upperLimit = maxRange - 1;

		char upperHalf = 'B';
		char lowerHalf = 'F';

		int row = -1;
		char[] rowChars = encodedRow.toCharArray();

		for(int i = 0; i < rowChars.length; i++){
			char c = rowChars[i];
			//System.out.printf("i: %d, c: %c, range = [%d, %d]\n", i, c, lowerLimit, upperLimit);
			if(lowerLimit > upperLimit){
				System.out.println("---------------------");
				System.out.printf("Error at: %d\n", i);
				System.out.printf("%c, range = [%d, %d]\n", c, lowerLimit, upperLimit);
				System.out.println("---------------------");
				break;
			}
			if(c == upperHalf){
				int tmp = upperLimit - lowerLimit;
				tmp = tmp / 2;
				lowerLimit = upperLimit - tmp;
				//System.out.printf("Tmp: %d, lowerLimit: %d\n", tmp, lowerLimit);
				if(i == rowChars.length - 1){//lastIteration
					row = upperLimit;
					return row;
				}
			}
			else if(c == lowerHalf){
				int tmp = upperLimit - lowerLimit;
				tmp = (tmp / 2);
				upperLimit = lowerLimit  + tmp;
				//System.out.printf("Tmp: %d, upperLimit: %d\n", tmp, upperLimit);
				if(i == rowChars.length - 1){
					row = lowerLimit;
					return row;
				}
			}
			//System.out.println("---------------------");
		}
		return row;
	}

	
	private static int decodeCol(String encodedCol){
		int maxRange = 8;
		int lowerLimit = 0;
		int upperLimit = maxRange - 1;

		char upperHalf = 'R';
		char lowerHalf = 'L';

		int col = -1;
		char[] cols = encodedCol.toCharArray();
		for(int i = 0; i < cols.length; i++){
			char c = cols[i];
			//System.out.printf("i: %d, c: %c, range = [%d, %d]\n", i, c, lowerLimit, upperLimit);
			if(lowerLimit > upperLimit){
				System.out.println("---------------------");
				System.out.printf("Error at: %d\n", i);
				System.out.printf("%c, range = [%d, %d]\n", c, lowerLimit, upperLimit);
				System.out.println("---------------------");
				break;
			}
			if(c == upperHalf){
				int tmp = upperLimit - lowerLimit;
				tmp = tmp / 2;
				lowerLimit = upperLimit - tmp;
				//System.out.printf("Tmp: %d, lowerLimit: %d\n", tmp, lowerLimit);
				if(i == cols.length - 1){//lastIteration
					col = upperLimit;
					return col;
				}
			}
			else if(c == lowerHalf){
				int tmp = upperLimit - lowerLimit;
				tmp = (tmp / 2);
				upperLimit = lowerLimit  + tmp;
				//System.out.printf("Tmp: %d, upperLimit: %d\n", tmp, upperLimit);
				if(i == cols.length - 1){
					col = lowerLimit;
					return col;
				}
			}
			//System.out.println("---------------------");
		}

		return col;
	}
	

	public static void main(String[] args){

		LinkedList<String> input = readFile();

		/**
		if(args.length < 1)
			System.exit(0);
		

		String s = args[0];
		String tmpRow = getCodeRow(s);
		String tmpCol = getCodeCol(s);
		int row = decodeRow(tmpRow);
		int col = decodeCol(tmpCol);
		int seatID = (row * 8) + col;
		System.out.printf("Row: %d, Col: %d, seatID: %d\n", row, col, seatID);
		**/
		int highestID = 0;
		LinkedList<Integer> seatIDs = new LinkedList<Integer>();

		for(String s : input){
			String tmpRow = getCodeRow(s);
			String tmpCol = getCodeCol(s);
			int row = decodeRow(tmpRow);
			int col = decodeCol(tmpCol);
			int seatID = (row * 8) + col;
			if(seatID > highestID){
				highestID = seatID;
				//System.out.printf("New highest seat id found\n", highestID);
			}
			seatIDs.add(seatID);
		}
		System.out.printf("highestID: %d\n", highestID);
		System.out.println("---------------------");
		Comparator<Integer> order = Integer::compare;
		seatIDs.sort(order);

		for(Integer i : seatIDs)
			System.out.println(i);

		for(int i = 0; i < seatIDs.size(); i++){
			int tmp = seatIDs.get(i);
			if(tmp + 1  != (seatIDs.get(i+1))){
				System.out.printf("seat found: %d\n", tmp + 1);
				break;
			}
		}
		
		
	}

}