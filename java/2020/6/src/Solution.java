import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class Solution{

	private Group g;
	private int numberOfUniqueAnswers;

	private HashMap<Integer, String> uniqueAnswers;

	public Solution(Group g){
		this.g = g;
		uniqueAnswers = new HashMap<Integer, String>();
		numberOfUniqueAnswers = 0;
		calculateUniqueAnswers();
	}

	public void calculateUniqueAnswers(){
		HashMap<Integer, String> map = g.getMap();
		Iterator it = map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry pair = (Map.Entry) it.next();
			if(!uniqueAnswers.containsValue(pair.getValue())){
				uniqueAnswers.put((Integer) pair.getKey(), (String) pair.getValue());
				this.setNumberOfUniqueAnswers();
			}
			it.remove();
		}
	}

	public int getNumberOfUniqueAnswers(){
		return this.numberOfUniqueAnswers;
	}

	public void setNumberOfUniqueAnswers(){
		this.numberOfUniqueAnswers++;
	}

	public HashMap<Integer, String> getUniqueAnswers(){
		return this.uniqueAnswers;
	}

	public void printUniqueAnswers(){
		Iterator it = uniqueAnswers.entrySet().iterator();
		System.out.println("--- unique answers present in this group: "+this.getNumberOfUniqueAnswers());
		while(it.hasNext()){
			Map.Entry pair = (Map.Entry) it.next();
			System.out.println(pair.getKey() + " = " + pair.getValue());
			it.remove();
		}
	}
}