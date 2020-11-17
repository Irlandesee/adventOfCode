import java.util.LinkedList;

public class Solution{
	
	private int[] fuelRequirements;
	private int Module_Mass = 0;
	private int Module_fuelRequired = 0;
	private int Fuel_fuelRequired = 0;
	private int Total_fuelRequired = 0;


	public Solution(int[] interiLetti){
		fuelRequirements = interiLetti;
	}

	//1
	private int[] roundDownFuelRequirements(int[] fuelRequirements){
		int[] ris = new int[fuelRequirements.length];
		for(int i = 0; i < ris.length; i++){
			int x = fuelRequirements[i];
			double xRoundedDown = Math.floor(x/3);
			int fuelForModule = (int) xRoundedDown-2;
			ris[i] = fuelForModule;
		}
		return ris;
	}

	public int calculate_Module_SumFuelRequirements(){
		int[] fuelRequirementsPerModule = roundDownFuelRequirements(fuelRequirements);
		int sum = 0;
		for(int i = 0; i < fuelRequirementsPerModule.length; i++){
			sum += fuelRequirementsPerModule[i];
			System.out.println("Fuel at index: "+i+"->"+sum);
			
		}
		return sum;
	}

	//2
	private int calculate_fuelRequired(int fuelRequired){
		double ris = Math.floor(fuelRequired/3);
		return (int) ris-2;
	}

	public int calculate_Module_fuelRequired(int moduleMass){
		return  this.calculate_fuelRequired(moduleMass);
	}

	public int calculate_Fuel_SumFuel(){
		int[] fuelRequirements_Module = roundDownFuelRequirements(fuelRequirements);
		LinkedList<Integer> fuelRequired_Fuel = new LinkedList<Integer>();
		int sum = 0;
		int tmp = 0;
		for(int i = 0; i < fuelRequirements_Module.length; i++){
			tmp = fuelRequirements_Module[i];
			System.out.println("Calculating fuel requirements for: "+tmp);
			while(tmp >= 0){
				System.out.println("	-calculating fuel requirements for: "+tmp);
				fuelRequired_Fuel.add(tmp);
				tmp = calculate_fuelRequired(tmp);
			}

		}

		for(int i = 0; i < fuelRequirements.length; i++){
			tmp = fuelRequirements_Module[i];
			sum = sum + tmp;
			for(Integer x : fuelRequired_Fuel)
				sum += x;
		}
		return sum;
	}

}