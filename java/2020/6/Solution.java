import java.util.Iterator;
import java.util.LinkedList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;

public class Solution{

	private static String pathToFile = "/Users/mattiamac/Documents/Github/adventOfCode/java/2020/6/";

	private static LinkedList<String> readInput(String inputFile){
		System.out.println("Reading input");
		LinkedList<String> res = new LinkedList<String>();
		try{
			File f = new File(pathToFile+inputFile);
			BufferedReader bReader = new BufferedReader(new FileReader(f));
			String s = "";
			while((s = bReader.readLine()) != null){
				res.add(s);
			} 
			bReader.close();
		}catch(IOException e){e.printStackTrace();}
		return res;
	}

	private static LinkedList<Group> divideInputIntoGroups(LinkedList<String> input){
		System.out.println("Dividing into groups");
		Iterator it =  input.iterator();
		LinkedList<Group> groups = new LinkedList<Group>();
		LinkedList<String> l = new LinkedList<String>();

		while(it.hasNext()){
			String s = it.next().toString();
			if(s.equals("")){
				LinkedList<String> answers = new LinkedList<String>();
				for(String x : l)
					answers.add(x);
				groups.add(new Group(answers));
				l.clear();
			}
			else
				l.add(s);
		}

		return groups;
	}

	public static void main(String[] args){
		String inputFile = "testcase.txt";
		LinkedList<String> input = readInput(inputFile);
		LinkedList<Group> groups = divideInputIntoGroups(input);
		
		
		
		
	}
}