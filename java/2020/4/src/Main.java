import passport.*;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Iterator;

public class Main{

	private static final String testcase = "testcase.txt";
	private static final String inputFile = "input.txt";
	private static final String pathToFile = "/Users/mattiamac/Documents/Github/adventOfCode/java/2020/4/";

	private static final String[] keys = 
		{"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid", "cid"};

	private static LinkedList<String> readInputFile(String inputFile){
		LinkedList<String> input = new LinkedList<String>();
		try{
			File f = new File(pathToFile+inputFile);
			BufferedReader bReader = new BufferedReader(new FileReader(f));
			String s = "";
			while((s = bReader.readLine()) != null){
				input.add(s);
			}
		}catch(IOException e){
			e.printStackTrace();
		}

		return input;
	}

	private static LinkedList<String> buildPassportList(LinkedList<String> input){
		LinkedList<String> passportList = new LinkedList<String>();

		for(int i = 0; i < input.size(); i++){
			String s = input.get(i);
			if(!s.equals("")){
				String[] tmp = s.split(" ");
				for(String t : tmp)
					passportList.add(t);
			}
			else
				passportList.add("");
		}
		
		return passportList;
	}

	private static LinkedList<Passport> buildPassport(LinkedList<String> passportList){
		Iterator it = passportList.iterator();
		LinkedList<Passport> passports = new LinkedList<Passport>();
		
		LinkedList<String> l = new LinkedList<String>();
		while(it.hasNext()){
			String s = it.next().toString();
			if(s.equals("")){
				HashMap<String, String> hMap = new HashMap<String, String>();
				for(String x : l){
					String[] t = x.split(":");
					hMap.put(t[0], t[1]);
				}
				passports.add(new Passport(hMap));
				l.clear();
			}
			else{
				l.add(s);
			}
		}
		
		return passports;
	}

	private static void printPassports(LinkedList<Passport> passports){
		System.out.println("Printing out passport");
		for(Passport p : passports){
			HashMap<String, String> map = p.getMap();
			for(var entry : map.entrySet()){
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
			System.out.println();
		}
		System.out.println("Done");
	}

	private static void printPassport(Passport p){
		HashMap<String, String> pMap = p.getMap();
		for(var entry : pMap.entrySet()){
			System.out.println(entry.getKey() +" : "+ entry.getValue());
		}
	}
	
	private static LinkedList<Passport> checkListValidity(LinkedList<Passport> passports){
		LinkedList<Passport> validPassports = new LinkedList<Passport>();
		for(int i = 0; i < passports.size(); i++){
			Passport p = passports.get(i);
			HashMap<String, String> pMap =p.getMap();

			if(!pMap.containsKey("cid")){
				System.out.printf("Adding passport %d to valid list\n", i);
				validPassports.add(p);
			}

		}
		return validPassports;
	}

	private static boolean checkPassportValidity(Passport p){
		HashMap<String, String> pMap = p.getMap();
		if(!pMap.containsKey("cid")){
			/**
			printPassport(p);
			System.out.println("--------------------------");
			**/
			return true;
		}
		return false;
	}
	
	public static void main(String[] args){

		LinkedList<String> input = readInputFile(inputFile);
		LinkedList<String> passportList = buildPassportList(input);
				
		LinkedList<Passport> passports = buildPassport(passportList);
		LinkedList<Passport> passportsToCheck = new LinkedList<Passport>();
		LinkedList<Passport> validPassports = new LinkedList<Passport>();
		LinkedList<Passport> invalidPassports = new LinkedList<Passport>();
		System.out.println("[STAGE 1 SORTING]");
		
		for(int i = 0; i < passports.size(); i++){
			Passport p = passports.get(i);
			HashMap<String, String> pMap = p.getMap();
			int passportSize = pMap.size();
			//System.out.printf("Passport [%d], size: %d\n", i, passportSize);
			//printPassport(p);
			if(passportSize == 8){
				//System.out.println("Adding passport to valid list");
				p.setValid(true);
				validPassports.add(p);
			}else if(passportSize < 7){
				//System.out.println("Adding passport to invalid list");
				p.setValid(false);
				invalidPassports.add(p);
			}
			else{ //passport length == 7
				//System.out.println("Adding passport to check list");
				passportsToCheck.add(p);
			}
			//System.out.println("-------------------");
		}

		/**
		System.out.println("Valid passports after 1 stage sorting: "+ validPassports.size());
		printPassports(validPassports);
		System.out.println("-------------------");
		System.out.println("Passport to check after 1 stage sorting: "+passportsToCheck.size());
		printPassports(passportsToCheck);
		System.out.println("-------------------");
		System.out.println("Invalid passports after 1 stage sorting: "+invalidPassports.size());
		printPassports(invalidPassports);
		System.out.println("-------------------");
		**/
		System.out.println("[STAGE 2 SORTING]");
		for(Passport p : passportsToCheck){
			boolean validity = checkPassportValidity(p);
			if(validity){
				validPassports.add(p);
				p.setValid(true);
			}
			else{
				invalidPassports.add(p);
				p.setValid(false);
			}
		}
		System.out.printf("[PASSPORT SIZE] : %d\n", passports.size());
		System.out.printf("[VALID PASSPORTS] : %d\n", validPassports.size());
		System.out.printf("[INVALID PASSPORTS] : %d\n", invalidPassports.size());
		//printPassports(validPassports);

	}



}