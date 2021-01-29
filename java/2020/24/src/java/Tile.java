import java.util.HashMap;
import java.util.Iterator;

public class Tile{

	private final String[] keys = {"east", "southeast", "southwest", "west", "northwest", "northeast"};
	private final String[] directions = {"e", "se", "sw", "w", "nw", "ne"}; 
	private final String[] colors = {"white", "black"};

	private String tileColor;

	private HashMap<String, Integer> map;

	public Tile(HashMap<String, Integer> map){
		this.map = map;


	}

	public HashMap<String, Integer> getMap(){
		return this.map;
	}

	public void setMap(HashMap<String, Integer> map){
		this.map = map;
	}

	public String getTileColor(){
		return this.tileColor;
	}

	public void setTileColor(String tileColor){
		this.tileColor = tileColor;
	}

	public String toString(){
		return "";
	}

}