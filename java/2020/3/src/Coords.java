public class Coords{
	private int x;
	private int y;

	public Coords(int x, int y){
		this.x = x;			
		this.y = y;
	}

	public int getX(){			
		return this.x;
	}

	public int getY(){
		return this.y;		
	}

	public boolean equals(Coords other){
		if(this.getX() == other.getX() && this.getY() == other.getX())
			return true;
		return false;
	}

	public String toString(){
		return "x: "+this.getX()+" y: "+this.getY();
	}

}