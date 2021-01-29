import java.util.LinkedList;

public class Solution{
	
	private int[] fuelRequirements;
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
			//System.out.println("Fuel at index: "+i+"->"+sum);
			
		}
		return sum;
	}

	public int calculateTotalFuelRequired(){
		LinkedList<Module> mList = new LinkedList<Module>();
		int totalFuelRequired = 0;

		//fuel requirements is the mass of every module
		for(Integer i : fuelRequirements){
			Module m = new Module(i);
			mList.add(m);
		}

		for(Module temp : mList){
			totalFuelRequired = totalFuelRequired += temp.calculateTotalFuelRequired();
		}

		return totalFuelRequired;
	}


	//2
	private class Fuel{

		private Module m;
		private int fuelMass; // the mass of the fuel
		private int fuel_fuelMassRequired; //mass of fuel required to carry fuelMass 
	
		public Fuel(int fuelMass){
			this.fuelMass = fuelMass;
		}

		public int get_fuelMass(){
			return this.fuelMass;
		}

		public void set_fuelMass(int fuelMass){
			this.fuelMass = fuelMass;
		}

		public int get_fuelMassRequired(){
			return this.fuel_fuelMassRequired;
		}

		public void set_fuelMassRequired(int fuel_fuelMassRequired){
			this.fuel_fuelMassRequired = fuel_fuelMassRequired;
		}

		public Module getModule(){
			return this.m;
		}

		private void setModule(Module m){
			this.m = m;
		}
		/**
		public String toString(){
			return "FuelMass: "+this.fuelMass+" Fuel required for this mass: "
				+this.fuel_fuelMassRequired +" Module: "+m.getModuleMass();
		}**/
	}

	private class Module{

		private int moduleMass;
		private int carburanteRichiesto_modulo;
		private int totalFuelRequired_Module_Fuel = 0;

		private LinkedList<Fuel> listaCarburanti;

		public Module(int moduleMass){
			this.moduleMass = moduleMass;

			listaCarburanti = new LinkedList<Fuel>();
		}

		public int calculateFuelRequired(){
			carburanteRichiesto_modulo = (int) Math.floor(moduleMass/3)-2;
			return carburanteRichiesto_modulo;
		}
		
		public int calculateTotalFuelRequired(){
			Fuel temp = new Fuel(calculateFuelRequired());
			listaCarburanti.add(temp);
			Fuel tmp;
			for(Fuel f : listaCarburanti){
				if(f.get_fuelMass() >= 0){
					tmp = new Fuel(calculateFuelRequired());
					f.set_fuelMassRequired(calculateFuelRequired());					
					listaCarburanti.add(tmp);
				}
			}

			for(Fuel f : listaCarburanti){
				totalFuelRequired_Module_Fuel = totalFuelRequired_Module_Fuel
					+ f.get_fuelMass();
			}
			return totalFuelRequired_Module_Fuel;
		}

		public int getModuleMass(){
			return this.moduleMass;
		}

		private void setModuleMass(int moduleMass){
			this.moduleMass = moduleMass;
		}

		public int get_carburateRichiesto_modulo(){
			return this.carburanteRichiesto_modulo;
		}

		private void set_carburanteRichiesto_modulo(int carburanteRichiesto_modulo){
			this.carburanteRichiesto_modulo = carburanteRichiesto_modulo;
		}

		public String toString(){
			return "Module mass: "+moduleMass+", Fuel required for Module: "+carburanteRichiesto_modulo;
		}
	}

}