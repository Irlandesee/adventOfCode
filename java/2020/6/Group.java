import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

public class Group{

	private LinkedList<String> answers;
	private char[] uniqueAnswers;
 	private char[] alphabet;
	private char lastLetter;
	private int groupLength;
	private int numbeOfUniqueAnswers;
	private int numberOfCommonAnswers;

	public Group(){
		
	}

	public Group(LinkedList<String> answers){
		this.answers = answers;
		this.alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		this.uniqueAnswers = new char[alphabet.length]; //at most 
		this.exec();
		this.uniqueAnswersPartOne();
		this.commonAnswersPartTwo();
	}

	public LinkedList<String> getAnswers(){
		return this.answers;
	}

	public void setAnswers(LinkedList<String> answers){
		this.answers = answers;
	}

	public int getNumberOfUniqueAnswers(){
		return this.numbeOfUniqueAnswers;
	}

	public int getNumberOfCommonAnswers(){
		return this.numberOfCommonAnswers;
	}

	private void exec(){
		//finding the last letter of the group
		char lastLetter = ' ';
		for(String s : answers){
			char currentLastLetter = s.charAt(s.length() - 1);
			if(currentLastLetter > lastLetter)
				this.lastLetter = currentLastLetter;
		}
	}

	private void uniqueAnswersPartOne(){
		char c = ' ';
		int count = 0;
		
		
		String bigAnswer = "";
		for(String s : answers)
			bigAnswer += s;
		char[] tmp = bigAnswer.toCharArray();
		char[] unique = new char[tmp.length];
		
		Arrays.sort(tmp);
		
		for(int i = 0; i < tmp.length; i++){
			if(tmp[i] > c){
				uniqueAnswers[count] = c;
				c = tmp[i];
				count++;
			}
		}
		
		this.numbeOfUniqueAnswers = count;
		
	}

	private void commonAnswersPartTwo(){
		
		int count = 0;

		char[][] matrix = new char[answers.size()][alphabet.length];
		for(int i = 0; i < answers.size(); i++)
			matrix[i] = answers.get(i).toCharArray();
		

		System.out.println(count);
		System.out.println("------------");
		this.numberOfCommonAnswers = count;

	}

	public void printGroup(){
		System.out.println("[Printing group information]");
		System.out.printf("answers size %d\n", this.answers.size());
		for(int i = 0; i < answers.size(); i++)
			System.out.printf("%d, %s\n", i, answers.get(i));
		System.out.printf("last letter of the group: %c\n", this.lastLetter);
		//System.out.printf("group length: %d\n", this.groupLength);
	}

}