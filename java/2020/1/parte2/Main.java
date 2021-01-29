import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.io.File;

public class Main{

	public static void main(String[] args){
		int[] inputNumbers = new int[200];
		if(args.length <= 0)
			System.out.println("Inserisci nome input file!");
		else{
			String inputFile = args[0];
			String pathToDir = "/Users/mattiamac/Documents/Github/adventOfCode/2020/1";
			StringBuilder b = new StringBuilder();
			b.append(pathToDir);
			b.append("/");
			b.append(inputFile);
			String pathComplete = b.toString();
			File f = new File(pathComplete);
		
			try{
				int i = 0;
				BufferedReader bReader = new BufferedReader(new FileReader(f));
				String stringaLetta = "";
				while((stringaLetta = bReader.readLine()) != null){
					
					inputNumbers[i] = Integer.parseInt(stringaLetta);
					i += 1;
				}
				Solution s = new Solution(inputNumbers);
				System.out.println(s.toString());
				
				bReader.close();
			}catch(IOException e){
				System.out.println("error while reading: "+inputFile);
				e.printStackTrace();
			}

		}	
	}
	
}