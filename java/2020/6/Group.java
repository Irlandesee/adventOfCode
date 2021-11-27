import java.util.LinkedList;
import java.util.List;

public class Group{

	private LinkedList<String> answers;
	private char[] alphabet;
	private char lastLetter;
	private int groupLength;

	public Group(){
		
	}

	public Group(LinkedList<String> answers){
		this.answers = answers;
		this.alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		//this.exec();
	}

	public LinkedList<String> getAnswers(){
		return this.answers;
	}

	public void setAnswers(LinkedList<String> answers){
		this.answers = answers;
	}

	private void exec(){
		//finding the last letter of the group
		for(String s : answers){
			char[] tmpAnswers = s.toCharArray();
			char lastLetter = ' ';
			for(int i = 0; i < tmpAnswers.length; i++){
				if(tmpAnswers[i] > lastLetter){
					lastLetter = tmpAnswers[i];
					groupLength = i;
				}
			}
		}
	}

	public void printGroup(){
		System.out.println("[Printing group information]");
		System.out.printf("answers size %d\n", this.answers.size());
		for(String s : this.answers){
			System.out.println(s);
		}
		//System.out.printf("last letter of the group: %c\n", this.lastLetter);
		//System.out.printf("group length: %d\n", this.groupLength);
	}

}