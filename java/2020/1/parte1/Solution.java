import java.util.LinkedList;

public class Solution{

		private LinkedList<Integer> interiLetti;
		private final int constant = 2020;
		private int firstEntry;
		private int secondEntry;

		public Solution(LinkedList<Integer> interiLetti){
			this.interiLetti = interiLetti;
			printInputNumbers();
			findEntries();
		}

		public void printInputNumbers(){
			for(int i : interiLetti)
				System.out.println(i);
		}

		public void findEntries(){
			for(int x : interiLetti){
				for(int y : interiLetti){
					int sum = x + y;
					System.out.println(x+"+"+y+"="+sum);
					if(sum == constant){
						System.out.println("first entry found: "+x);
						this.setFirstEntry(x);
						System.out.println("second entry found: "+y);
						this.setSecondEntry(y);
						break;
					}
				}
			}
		}

		public int multiplyEntries(){
			return this.getFirstEntry() * this.getSecondEntry();
		}

		public int getFirstEntry(){
			return this.firstEntry;
		}

		public void setFirstEntry(int firstEntry){
			this.firstEntry = firstEntry;
		}

		public int getSecondEntry(){
			return this.secondEntry;
		}

		public void setSecondEntry(int secondEntry){
			this.secondEntry = secondEntry;
		}

		public String toString(){
			return "\nFirst entry: "+this.getFirstEntry()
					+"\nSecond entry: "+this.getSecondEntry()
					+"\nMul: "+this.multiplyEntries();
		}

	}