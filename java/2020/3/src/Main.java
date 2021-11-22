import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.io.IOException;
public class Main{

	private static String inputFileName = "input.txt";
	private static String[] testcasesFileNames = {"testcase1.txt", "testcase2.txt"};

	private static String pathToInputFile = "/Users/mattiamac/Documents/Github/adventofCode/java/2020/3/";
	
	public static LinkedList<String> readInputFile(boolean test, String type) throws IOException{
		LinkedList<String> map = new LinkedList<String>();
		if(test){
			BufferedReader bReader;
			if(type.equals("small")){
				File f = new File(pathToInputFile+testcasesFileNames[0]);
				bReader = new BufferedReader(new FileReader(f));	
				String s = "";
				while((s = bReader.readLine()) != null)
					map.add(s);
			}
			else if(type.equals("large")){
				File f = new File(pathToInputFile+testcasesFileNames[1]);
				bReader = new BufferedReader(new FileReader(f));	
				String s = "";
				while((s = bReader.readLine()) != null)
					map.add(s);
			}
			else{
				//run all testcases
				for(String testcase : testcasesFileNames){
					File f = new File(pathToInputFile+testcase);
					bReader = new BufferedReader(new FileReader(f));	
					String s = "";
					while((s = bReader.readLine()) != null)
						map.add(s);
				}
			}
		}
		else{
			File inputFile = new File(pathToInputFile+inputFileName);
			BufferedReader bReader = new BufferedReader(new FileReader(inputFile));
			String s = "";
			while((s = bReader.readLine()) != null)
				map.add(s);
		}
		return map;
	}

	private static void printHelp(){
		System.out.println("-t per leggere da test file.");
		System.out.println("-i per leggere da file input.");
		System.out.println("-s per leggere da small test file");
		System.out.println("-L per leggere da large test file");

		System.out.println("Comandi di esempio:");
		System.out.println("java Main -i -> legge da input file");
		System.out.println("java Main -t -s -> legge da small test file");
		System.out.println("java Main -t -L -> legge da large test file");
	}

	public static void main(String[] args){
		LinkedList<String> map = new LinkedList<String>();	
		Solution s;
		if(args.length < 1){
			System.out.println("inserire flag!");
			printHelp();
			System.exit(0);
		}
		else{
			String testFlag = args[0];
			if(testFlag.equals("-t")){
				if(args.length < 2){
						System.out.println("Uso scorretto flag");
						printHelp();
						System.exit(0);
				}
				try{
					Tester t;
					System.out.println("Reading from test files.");
					String testType = args[1];
					if(testType.equals("-s")){
						map = readInputFile(true, "small");	
						System.out.println("Reading from small test file");						
					}
					else if(testType.equals("-L")){
						map = readInputFile(true, "large");
						System.out.println("Reading from large test file");
					}
					//TODO: implement running both testfiles 
					s = new Solution(map);
					LinkedList<Coords> res = s.exec();
					//t = new Tester(res, "testcase1.txt");
				}catch(IOException e){e.printStackTrace();}	
			}
			else if(testFlag.equals("-i")){
				try{
					System.out.println("Reading from input file.");
					map = readInputFile(false, "");	
					s = new Solution(map);
					s.exec();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
			
		}
		System.out.println("Terminating...");
	}

}