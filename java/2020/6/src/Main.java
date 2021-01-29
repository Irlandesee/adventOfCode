import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.HashMap;

public class Main{

	private static String fileName;
	private static String pathToDir = "/Users/mattiamac/Documents/Github/adventofCode/2020/6";
	private static String unixSeparator = "/";
	private static String groupSeparator = " ";

	public static void main(String[] args){
		if(args.length < 1)
			System.out.println("Input file name:");
		else{
			fileName = args[0];
			File f = new File(buildPath(fileName, pathToDir));
			LinkedList<String> righeLette = new LinkedList<String>();
			LinkedList<Group> g = new LinkedList<Group>();
			LinkedList<Integer> keys = new LinkedList<Integer>();
			LinkedList<String> answers = new LinkedList<String>();

			try{
				BufferedReader reader = new BufferedReader(new FileReader(f));
				String rigaLetta = "";

				while((rigaLetta = reader.readLine()) != null){
					righeLette.add(rigaLetta);
				}
				righeLette.add(" "); //fix per leggere l'ultimo gruppo ......
				reader.close();
			}catch(IOException e){
				System.out.println("Error while reading file: "+fileName);
				e.printStackTrace();
			}
			int i = 0;
			for(String s : righeLette){
				if(!s.isBlank()){
					keys.add(i);
					answers.add(s);
					i++;
				}
				else if(s.isBlank()){
					Group temp = new Group(keys, answers);
					keys.clear();
					answers.clear();
					g.add(temp);
					i = 0;
				}
			}
			int uniqueAnswers = 0;
			for(Group temp : g){
				Solution s = new Solution(temp);
				s.printUniqueAnswers();
				uniqueAnswers += s.getNumberOfUniqueAnswers();
			}
			System.out.println("--- number of unique answers: "+uniqueAnswers);
		}
	}

	private static String buildPath(String fileName, String pathToDir){
		StringBuilder b = new StringBuilder();
		b.append(pathToDir);
		b.append(unixSeparator);
		b.append(fileName);

		return b.toString();
	}
}