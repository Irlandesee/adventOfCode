import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;

public class Main{

	private static File f;
	private static BufferedReader bReader;

	private static String absolutePath = "";
	private static String fileName = "";
	private static String regex = ",";

	private static int rows = 0;

	public static void main(String[] args){
		String stringaLetta = "";
		LinkedList<Integer> interiLetti = new LinkedList<Integer>();

		if(args.length <= 0){
			System.out.println("Inserisci il file");
			System.exit(0);
		}else{
			try{
				fileName = args[0];
				f = new File(fileName);
				absolutePath = f.getAbsolutePath();
				bReader = new BufferedReader(new FileReader(f));
				stringaLetta = bReader.readLine();
				interiLetti = splitString(stringaLetta);
				bReader.close();
			}catch(IOException e){
				System.out.println("Error while reading: " 
					+absolutePath+fileName);
				e.printStackTrace();
			}
			int[] intcode = new int[4];
			int index = 0;

			IntcodeProgram p;

			int opcode = interiLetti.get(0);
			int positionFirstInput = interiLetti.get(1);
			int positionSecondInput = interiLetti.get(2);
			int positionOutput = interiLetti.get(3);

			intcode[0] = opcode;
			intcode[1] = positionFirstInput;
			intcode[2] = positionSecondInput;
			intcode[3] = positionOutput;

			p = new IntcodeProgram(intcode);
			System.out.println(p.toString());


		}
	}

	private static LinkedList<Integer> splitString(String s){
		String[] splitString = s.split(regex);
		LinkedList<Integer> temp = new LinkedList<Integer>();

		for(int i = 0; i < splitString.length; i++){
			int x = Integer.parseInt(splitString[i]);
			temp.add(x);
		}
		return temp;
	}


	private  static class IntcodeProgram{

		private int[] intcode;

		private int opcode;
		private int positionFirstInput;
		private int positionSecondInput;
		private int positionOutput;

		public IntcodeProgram(int[] intcode){
			this.intcode = intcode;
			this.readIntcodeProgram();
		}

		public void readIntcodeProgram(){
			int[] intcode = this.getIntcode();

			this.setOpcode(intcode[0]);
			this.setPositionFirstInput(intcode[1]);
			this.setPositionSecondInput(intcode[2]);
			this.setPositionOutput(intcode[3]);
		}

		public int[] getIntcode(){
			return this.intcode;
		}

		public int getOpcode(){
			return this.opcode;
		}

		public void setOpcode(int opcode){
			this.opcode = opcode;
		}

		public int getPositionFirstInput(){
			return this.positionFirstInput;
		}

		public void setPositionFirstInput(int positionFirstInput){
			this.positionFirstInput = positionFirstInput;
		}

		public int getPositionSecondInput(){
			return this.positionSecondInput;
		}

		public void setPositionSecondInput(int positionSecondInput){
			this.positionSecondInput = positionSecondInput;
		}

		public int getPositionOutput(){
			return this.positionOutput;
		}

		public void setPositionOutput(int positionOutput){
			this.positionOutput = positionOutput;
		}

		public String toString(){
			return "opcode: "+this.getOpcode()+"\nPosition of first input: "
				+this.getPositionFirstInput() + "\nPosition of second input: "+this.getPositionSecondInput()
				+"\nPosition of output: " +this.getPositionOutput();
		}
	}

}
