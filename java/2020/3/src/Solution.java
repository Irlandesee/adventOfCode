import java.util.List;
import java.util.LinkedList;

public class Solution{

	private List<String> map;
	private char[][] slope;

	private int finalRowIndex;
	private LinkedList<Coords> res;

	public Solution(LinkedList<String> map){
		this.map = map;
		this.slope = new char[map.size()][map.get(0).length()];
		finalRowIndex = map.size() - 1;
	}

	public LinkedList<Coords> exec(){
		System.out.printf("number of rows: %d\n", map.size());
		System.out.printf("row length: %d\n", map.get(0).length());
		readSlopeFromMap();
		
		res = new LinkedList<Coords>();

		long firstSlope = traverse(1, 1);
		long secondSlope = traverse(3, 1);
		long thirdSlope = traverse(5, 1);
		long fourthSlope = traverse(7 ,1);
		long fifthSlope = traverse(1, 2);
		

		long totalTreeCount = firstSlope * secondSlope * thirdSlope * fourthSlope * fifthSlope;
		System.out.printf("Total Treecount: %d\n", totalTreeCount);
		return res;
	}

	private int traverse(int right, int down){

		int curCol = 0;
		int  treeCount = 0;
		for(int i = down; i < map.size(); i+= down){
			curCol += right;
			if(curCol > map.get(i).length()-1)
				curCol = curCol - map.get(i).length();
			if(map.get(i).charAt(curCol) == '#')
				treeCount++;
		}
		System.out.printf("Treecount: %d\n", treeCount);
		return treeCount;
	}

	private void readSlopeFromMap(){
		for(int i = 0; i < map.size(); i++){
			String row = map.get(i);
			slope[i] = row.toCharArray();
		}
	}

	private int countTreesInRow(char[] row){
		int treeCount = 0;
		for(int i = 0; i < row.length; i++){
			char c = row[i];
			if(c == '#')
				treeCount++;
		}
		return treeCount;
	}

	public void printSlope(){
		System.out.println("Solution printing slope");
		for(int i = 0; i < slope.length; i++){
			for(int j = 0; j < slope[i].length; j++){
				if(j == slope[i].length -1)
					System.out.printf("%c\n", slope[i][j]);
				System.out.printf("%c", slope[i][j]);
			}
		}
	}

}