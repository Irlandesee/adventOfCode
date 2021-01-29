public class Solution{

	private int[] interiLetti;
	private int firstEntry;
	private int secondEntry;
	private int thirdEntry;

	private final int constant = 2020;

	public Solution(int[] interiLetti){
		this.interiLetti = interiLetti;
		findEntries();
		mulEntries();
	}

	public void findEntries(){
		int sum = 0;
		for(int i = 0; i < interiLetti.length; i++){
			for(int j = 0; j < interiLetti.length; j++){
				for(int k = 0; k < interiLetti.length; k++){
					sum = interiLetti[i]+interiLetti[j]+interiLetti[k];
					if(sum == constant){
						setFirstEntry(interiLetti[i]);
						setSecondEntry(interiLetti[j]);
						setThirdEntry(interiLetti[k]);
						break;
					}
				}
			}
		}
	}

	public void setFirstEntry(int x){
		firstEntry = x;
	}

	public void setSecondEntry(int y){
		secondEntry = y;
	}

	public void setThirdEntry(int z){
		thirdEntry = z;
	}

	public int mulEntries(){
		return firstEntry*secondEntry*thirdEntry;
	}

	public void printOutIntegerList(){
		for(int x : interiLetti)
			System.out.println(x);
	}

	public String toString(){
		return "\nFirst Entry: "+firstEntry+
				"\nSecond Entry: "+secondEntry+
				"\nThird Entry: "+thirdEntry+
				"\nEntries multiplied: "+mulEntries();
	}

}