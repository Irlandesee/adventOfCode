import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main{


	public static void main(String[] args){
		File f;
		BufferedReader bReader; 
		String fileName = "";
		String absolutePath = "";
		String stringaLetta = "";
		int[] interiLetti = new int[100];
		int rows = 0;
		if(args.length <= 0){
			System.out.println("Inserisci file");
			System.exit(0);
		}
		else{
			try{
				fileName = args[0];
				f = new File(fileName);
				absolutePath = f.getAbsolutePath();
				bReader = new BufferedReader(new FileReader(f));

				while((stringaLetta = bReader.readLine()) != null){
					System.out.println("row: "+ rows + " " +stringaLetta);
					int interoLetto = Integer.parseInt(stringaLetta);
					interiLetti[rows] = interoLetto;
					rows += 1;
				}
				
				bReader.close();
			}catch(IOException e){
				System.out.println("Error while reading: "
					+absolutePath+fileName);
				e.printStackTrace();
			}
		}

		Solution s = new Solution(interiLetti);
		int sum = s.calculate_Module_SumFuelRequirements();
		System.out.println("Sum: "+sum);
		System.out.println();
		
		int totalFuelRequiredModuleFuel = s.calculateTotalFuelRequired();
		System.out.println("Total fuel required by module and fuel: "+totalFuelRequiredModuleFuel);
	}
}