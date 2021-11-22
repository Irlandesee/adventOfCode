import java.util.LinkedList;

public class Tester{

	private LinkedList<Coords> coordsFirstTestcase;
	private LinkedList<Coords> coordsSecondTestcase;

	private String testCase;
	private LinkedList<Coords> coordsToCheck;

	public Tester(LinkedList<Coords> coords, String testCase){
		this.testCase = testCase;
		this.coordsToCheck = coords;
		this.exec();
	}

	private void initFirstTestCase(){
		coordsFirstTestcase = new LinkedList<Coords>();
		coordsFirstTestcase.add(new Coords(0,0));
		coordsFirstTestcase.add(new Coords(1,3));
		coordsFirstTestcase.add(new Coords(2,6));
		coordsFirstTestcase.add(new Coords(3,9));
		coordsFirstTestcase.add(new Coords(5,1));
		coordsFirstTestcase.add(new Coords(6,4));
		coordsFirstTestcase.add(new Coords(7,7));
		coordsFirstTestcase.add(new Coords(8,10));
		coordsFirstTestcase.add(new Coords(10,2));
	}

	private void initSecondTestcase(){
		System.out.printf("nothing here yet");
	}

	private void exec(){
		System.out.println("[TESTER]");
		if(this.testCase.equals("testcase1.txt")){
			this.initFirstTestCase();
			if(coordsToCheck.size() != coordsFirstTestcase.size()){
				System.out.println("Coordinates list length do not match!");
				System.out.printf("firstTestCase list length %d\n", coordsFirstTestcase.size());
				System.out.printf("coordsToCheck list length %d\n", coordsToCheck.size());
			}
			else{
				boolean testFlag = true;
				Coords c = new Coords(-1, -1);
				Coords d = new Coords(-1, -1);
				for(int i = 0; i < coordsFirstTestcase.size(); i++){
					c = coordsFirstTestcase.get(i);
					if(!c.equals(coordsToCheck.get(i))){
						testFlag = false;
						d = coordsToCheck.get(i);
						break;
					}
				}
				if(!testFlag){
					System.out.println("Testcase1 not passed. Failure point:");
					System.out.printf("Testcase1: %s\n", c.toString());
					System.out.printf("Testcase2: %s\n", d.toString());
				}
				else
					System.out.printf("Testcase1 passed");
			}
		}
		else if(this.testCase.equals("testcase2.txt")){
			System.out.printf("nothing here yet");
		}
		else{
			System.out.println("Testcase does not exists! Exiting...");
			System.exit(0);
		}
		System.out.println("[TESTER DONE]");
	}

}