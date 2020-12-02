public class Solution{
	
	private int[] minOccorenze;
	private int[] maxOccorenze;

	private String[] l;
	private String[] passwords;
	private String[] validPasswords;

	private int count;

	public Solution(int[] minOccorenze, int[] maxOccorenze, String[] l, String[] passwords){
		this.minOccorenze = minOccorenze;
		this.maxOccorenze = maxOccorenze;
		this.l = l;
		this.passwords = passwords;

		validPasswords = new String[passwords.length];
		count = 0;

		checkPasswords();
	}
	
	private void checkPasswords(){

		for(int i = 0; i <passwords.length; i++){
			int minOccorenza = minOccorenze[i];
			int maxOccorenza = maxOccorenze[i];
			String letteraDaCheckare = l[i];
			String pwd = passwords[i];

			printCurrentPassword(minOccorenza, maxOccorenza, letteraDaCheckare, pwd);
			/**
			if(checkMinMax(minOccorenza, maxOccorenza, letteraDaCheckare, pwd)){
				System.out.println("---Password valida, la salvo");
				this.setCount();
				validPasswords[i] = pwd;
			}**/

			if(checkLetterAtPos(minOccorenza, maxOccorenza, letteraDaCheckare, pwd)){
				System.out.println("---password valida, la salvo");
				this.setCount();
				validPasswords[i] = pwd;
			}
		}
		System.out.println("Job finished!");
	}

	public void printCurrentPassword(int min, int max, String l, String pwd){
		System.out.println("Min: "+min);
		System.out.println("Max: "+max);
		System.out.println("l: "+l);
		System.out.println("pwd: "+pwd);
	}


	public boolean checkMinMax(int min, int max, String letter, String password){
		char[] chars = password.toCharArray();
		char[] letterChar = letter.toCharArray();
		int count = 0;

		for(int i = 0; i < chars.length; i++){
			char c = chars[i];
			if(c == letterChar[0])
				count += 1;
		}

		if(count >= min && count <= max)
			return true;
		return false;
	}

	public boolean checkLetterAtPos(int pos_min, int pos_max, String letter, String password){
		char[] chars = password.toCharArray();
		char[] letterChar = letter.toCharArray();
		pos_min = pos_min -1;
		pos_max = pos_max -1;

		char firstIndex = chars[pos_min];
		char secondIndex = chars[pos_max];

		if(firstIndex == letterChar[0] && secondIndex != letterChar[0])
			return true;
		else if(firstIndex != letterChar[0] && secondIndex == letterChar[0])
			return true;
		else if(firstIndex != letterChar[0] && secondIndex != letterChar[0])
			return false;
		return false;
	}


	public int getCount(){
		return this.count;
	}

	public void setCount(){
		this.count++;
		//System.out.println(count);
	}

	public String toString(){
		return "";
	}
}