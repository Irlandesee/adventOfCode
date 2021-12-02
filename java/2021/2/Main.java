import java.util.LinkedList;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main{

	private static LinkedList<Direction> readInput(String filename){
		LinkedList<Direction> res = new LinkedList<Direction>();
		try{
			File f = new File(filename);
			BufferedReader bReader = new BufferedReader(new FileReader(f));
			String s = "";
			while((s = bReader.readLine()) != null){
				String[] tmp = s.split(" ");
				Direction d = new Direction(tmp[0], Integer.parseInt(tmp[1]));
				res.add(d);
			} 
			bReader.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return res;
	}

	private static long movePartOne(long tmp, Direction d){
		if(d.getDirection().equals("up"))
			return (tmp -= d.getLength());
		else
			return (tmp += d.getLength());
	}

	private static long calHorizonalPos(long pos_x, long pos_y){
		return (pos_x * pos_y);
	} 

	/** Part two **/

	private static long increaseDepth(long depth, long aim, long increase){
		return (depth + (aim * increase));
	}

	public static void main(String[] args){

		LinkedList<Direction> directions = readInput("input.txt");
		long pos_x = 0;
		long pos_y = 0;
		long aim = 0;

		long depth = 0;

		for(Direction d : directions){
			if(d.getDirection().equals("forward"))
				pos_x = movePartOne(pos_x, d);
			else{
				pos_y = movePartOne(pos_y, d);
			}
		}
		long horizontalPosPartOne = calHorizonalPos(pos_x, pos_y);
		System.out.println("Part one horizontalPos: "+horizontalPosPartOne);
		System.out.println("--------------");

		pos_x = 0;
		pos_y = 0;

		for(Direction d : directions){
			if(d.getDirection().equals("forward")){
				if(aim == 0){
					pos_x = movePartOne(pos_x, d);
				}
				else{
					pos_x = movePartOne(pos_x, d);
					depth = increaseDepth(depth, aim, d.getLength());
				}
			}
			else{
				aim = movePartOne(aim, d);
			}
		}
		System.out.printf("pos_x: %d\npos_y: %d\ndepth: %d\naim: %d\n", pos_x, pos_y, depth, aim);
		long res = pos_x * depth;
		System.out.println("Part two: "+res);

	}

}