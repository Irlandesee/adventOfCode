import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;

public class Main{

	private static String[] splitString(String s){
		String regex = ":";
		return s.split(regex);
	}

	private static String[] splitLeftString(String leftString){
		String regex = " ";
		return leftString.split(regex);
	}

	private static String[] splitOccorenze(String occorenze){
		String regex = "-";
		return occorenze.split(regex);
	}


	public static void main(String[] args){
		if(args.length < 1)
			System.out.println("Inserisci input file!!");
		else{

			LinkedList<String> stringheLette = new LinkedList<String>();

			int[] minOccorenze;
			int[] maxOccorenze;
			String[] lettereDaCheckare;
			String[] passwords;

			String pathToInputFile = "/Users/mattiamac/Documents/Github/adventOfCode/2020/2/parte1";
			StringBuilder b = new StringBuilder();
			String inputFile = args[0];

			b.append(pathToInputFile);
			b.append("/");
			b.append(inputFile);
			
			String completePath = b.toString();

			File f = new File(completePath);
			try{
				BufferedReader bReader = new BufferedReader(new FileReader(f));
				String stringaLetta = "";
				while((stringaLetta = bReader.readLine()) != null){
					stringheLette.add(stringaLetta);
				}
			}catch(IOException e){
				System.out.println("Error while reading file: "+inputFile);
				e.printStackTrace();
			}

			minOccorenze = new int[stringheLette.size()];
			maxOccorenze = new int[stringheLette.size()];
			lettereDaCheckare = new String[stringheLette.size()];
			passwords = new String[stringheLette.size()];

			for(int i = 0; i < stringheLette.size(); i++){
				//---splitting string
				String[] split = splitString(stringheLette.get(i));
				String leftString = split[0];
				String rightString = split[1];

				//---splitting leftString
				String[] leftStringSplitted = splitLeftString(leftString);
				String occorenze = leftStringSplitted[0];
				String letteraDaCheckare = leftStringSplitted[1];
				lettereDaCheckare[i] = letteraDaCheckare;

				String[] occorenzeSplitted = splitOccorenze(occorenze);
				int minOccorenza = Integer.parseInt(occorenzeSplitted[0]);
				int maxOccorenza = Integer.parseInt(occorenzeSplitted[1]);

				minOccorenze[i] = minOccorenza;
				maxOccorenze[i] = maxOccorenza;

				//---trimming right string
				rightString = rightString.trim();
				passwords[i] = rightString;

			}

			Solution s = new Solution(minOccorenze, maxOccorenze, lettereDaCheckare, passwords);
		
			//testing methods
			//13-16 k: kkkkkgmkbvkkrskhd
			
			int numeroPasswordValide = s.getCount();
			System.out.println(numeroPasswordValide);
		}

		


	}

}