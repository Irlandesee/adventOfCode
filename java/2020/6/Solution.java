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
		LinkedList<Group> res = new LinkedList<Group>();
		LinkedList<String> answers = new LinkedList<String>();
		Group g = new Group();
		for(String s : input){
			if(!s.equals("")){
				System.out.printf("adding {%s} to asnwers\n", s);
				answers.add(s);
			}
			else{
				System.out.println("Creating new group");
				LinkedList<String> tmp = answers;
				g.setAnswers(tmp);
				res.add(g);
				System.out.println("---newly added group");
				Group t = res.get(res.size()-1);
				t.printGroup();
				System.out.printf("res size: %d\n", res.size());
				answers.clear();
			}
		}

		return res;
	}

	public static void main(String[] args){
		String inputFile = "testcase.txt";
		LinkedList<String> input = readInput(inputFile);

		LinkedList<Group> groups = divideInputIntoGroups(input);
		
		
		
	}
}