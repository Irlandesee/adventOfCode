/**
*For a mass of 12, divide by 3 and round down to get 4, then subtract 2 to get 2.
*For a mass of 14, dividing by 3 and rounding down still yields 4, so the fuel required is also 2.
*For a mass of 1969, the fuel required is 654.
*For a mass of 100756, the fuel required is 33583.
**/

public class Solution{
	
	private int[] fuelRequirements;

	public Solution(int[] interiLetti){
		fuelRequirements = interiLetti;
	}

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

	public int calculateSumFuelRequirements(){
		int[] fuelRequirementsPerModule = roundDownFuelRequirements(fuelRequirements);
		int sum = 0;
		for(int i = 0; i < fuelRequirementsPerModule.length; i++){
			sum += fuelRequirementsPerModule[i];
			System.out.println("Fuel at index: "+i+"->"+sum);
			
		}

		return sum;
	}

}