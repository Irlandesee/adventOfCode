public class Direction{

	private String direction;
	private int length;

	public Direction(String direction, int length){
		this.direction = direction;
		this.length = length;;
	}

	public String getDirection(){
		return this.direction;
	}

	public int getLength(){
		return this.length;
	}

	public String toString(){
		return "Direction: " + this.direction + "\nLength: " + this.length;
	}

}