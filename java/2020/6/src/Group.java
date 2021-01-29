import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.LinkedList;

public class Group{

	private LinkedList<Integer> keys;
	private LinkedList<String> answers;

	private HashMap<Integer, String> m;

	private static int numberOfGroups = 0;

	public Group(LinkedList<Integer> keys, LinkedList<String> answers){
		this.keys = keys;
		this.answers = answers;

		m = new HashMap<Integer, String>();
		this.buildMap();

		numberOfGroups++;
	}

	private void buildMap(){
		for(int i = 0; i < keys.size(); i++){
			m.put(keys.get(i), answers.get(i));
		}
	}

	public void printGroup(){
		//System.out.println("---Group number: "+getNumberOfGroups());
		Iterator it = m.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry pair = (Map.Entry) it.next();
			System.out.println(pair.getKey() + " = " + pair.getValue());
			it.remove();
		}
	}

	public int getNumberOfGroups(){
		return numberOfGroups;
	}

	public HashMap<Integer, String> getMap(){
		return this.m;
	}

}