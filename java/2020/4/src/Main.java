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
	private static final String testcaseStageTwo = "testcaseStagetwo.txt";
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

	/**
	 * PART 2 METHODS
	 * **/

	/**
	 * four digits; at least 1920 and at most 2002.
	 * */
	private static boolean checkBirthYear(int birthYear){
		if(birthYear >= 1920 && birthYear <= 2002){
			System.out.println("birthYear valid");
			return true;
		}
		System.out.println("birthYear invalid");
		return false;
	}

	/**
	 * four digits; at least 2010 and at most 2020.
	 * */
	private static boolean checkIssueYear(int issueYear){
		if(issueYear >= 2010 && issueYear <= 2020){
			System.out.println("issueYear valid");
			return true;
		}
		System.out.println("issueYear invalid");
		return false;
	}

	/**
	 * four digits; at least 2020 and at most 2030.
	 * */
	private static boolean checkExpirationYear(int expirationYear){
		if(expirationYear >= 2020 && expirationYear <= 2030){
			System.out.println("expirationYear valid");
			return true;
		}
		System.out.println("expirationYear valid");
		return false;
	}

	/**
	 * a number followed by either cm or in:
	 * 	If cm, the number must be at least 150 and at most 193.
		If in, the number must be at least 59 and at most 76.
	 * */
	private static boolean checkHeight(String measuramentUnit, int height){
		System.out.printf("-Checking height: %s, %d\n", measuramentUnit, height);
		if(measuramentUnit.equals("cm")){
			if(height >= 150 && height <= 193){
				System.out.println("height valid");
				return true;
			}
		}
		else if(measuramentUnit.equals("in")){
			if(height >= 59 && height <= 76){
				System.out.println("height valid");
				return true;
			}
		}
		System.out.println("height invalid");
		return false;
	}

	/**
	 * a # followed by exactly six characters 0-9 or a-f.
	 * */
	private static boolean checkHairColor(String hairColor){
		LinkedList<Character> validChars = new LinkedList<Character>();
		validChars.add('a');
		validChars.add('b');
		validChars.add('c');
		validChars.add('d');
		validChars.add('e');
		validChars.add('f');
		char leadingChar = hairColor.charAt(0);
		if(leadingChar != '#'){
			System.out.println("haircolor invalid");
			return false;
		}
		else{
			for(int i = 1; i < hairColor.length(); i++){
				char c = hairColor.charAt(i);
				if(!(Character.isDigit(c)))
					if(!validChars.contains(c)){
						System.out.println("haircolor invalid");
						return false;
					}
			}
		}
		System.out.println("haircolor valid");
		return true;
	}

	/**
	 * exactly one of: amb blu brn gry grn hzl oth.
	 * */
	private static boolean checkEyeColor(String eyeColor){
		LinkedList<String> validStrings = new LinkedList<String>();
		validStrings.add("amb");
		validStrings.add("blu");
		validStrings.add("brn");
		validStrings.add("gry");
		validStrings.add("grn");
		validStrings.add("hzl");
		validStrings.add("oth");

		if(validStrings.contains(eyeColor)){
			System.out.println("eye valid");
			return true;
		}
		System.out.println("eye invalid");
		return false;
	}

	/**
	 * a nine-digit number, including leading zeroes.
	 * */
	private static boolean checkPassportID(String passportID){
		if(passportID.length() != 9){
			System.out.println("pid invalid");
			return false;
		}
		System.out.println("pid valid");
		return true;
	}

	private static boolean checkPartTwoRequirements(Passport p){
		HashMap<String, String> pMap = p.getMap();
		int birthYear = Integer.parseInt(pMap.get("byr"));
		int issueYear = Integer.parseInt(pMap.get("iyr"));
		int expirationYear = Integer.parseInt(pMap.get("eyr"));
		String height = pMap.get("hgt");
		String heightNumber = "";
		String measuramentUnit = "";
		if(height.length() < 4){
			System.out.println("height invalid: less than 4	");
			return false;
		}
		else{
			char[] tmp = height.toCharArray();
			char[] digits = new char[3];
			char[] letters = new char[2];
			int j = 0;
			for(int i = 0; i < tmp.length; i++){
				if(Character.isDigit(tmp[i]))
					digits[i] = tmp[i];
				else if(Character.isLetter(tmp[i])){
					letters[j] = tmp[i];
					j++;
					if(j == letters.length)
						j = 0;
				}
			}
			StringBuilder strBuilder = new StringBuilder();
			heightNumber = strBuilder.append(digits).toString();
			strBuilder.setLength(0);
			measuramentUnit = strBuilder.append(letters).toString();
			strBuilder.setLength(0); 
		}
		String hairColor = pMap.get("hcl");
		String eyeColor = pMap.get("ecl");
		String passportID = pMap.get("pid");

		boolean byr = checkBirthYear(birthYear);
		boolean iyr = checkIssueYear(issueYear);
		boolean eyr = checkExpirationYear(expirationYear);
		boolean hgt = checkHeight(measuramentUnit, Integer.parseInt(heightNumber.trim()));
		boolean hcl = checkHairColor(hairColor);
		boolean ecl = checkEyeColor(eyeColor);
		boolean pid = checkPassportID(passportID);

		if(byr && iyr && eyr && hgt && hcl && ecl && pid){
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
		System.out.println("-------------------");
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
		System.out.println("-------------------");

		System.out.println("[STAGE 3 SORTING]");
		LinkedList<Passport> partTwoValidPassports = new LinkedList<Passport>();

		for(Passport p : validPassports){
			printPassport(p);
			boolean valPartTwo = checkPartTwoRequirements(p);
			if(valPartTwo){
				System.out.println("[VALID PASSPORT]");
				partTwoValidPassports.add(p);
				p.setValid(true);
			}
			else{
				invalidPassports.add(p);
				p.setValid(false);
			}
			System.out.println("Validity: "+p.getValid());
			System.out.println("-------------------");
		}

		System.out.printf("[PASSPORT SIZE] : %d\n", passports.size());
		System.out.printf("[VALID PASSPORTS] : %d\n", partTwoValidPassports.size());
		System.out.printf("[INVALID PASSPORTS] : %d\n", invalidPassports.size());

	}



}