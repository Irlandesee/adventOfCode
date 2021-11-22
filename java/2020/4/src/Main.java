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

	public static void main(String[] args){

		LinkedList<String> input = readInputFile(testcase);
		LinkedList<String> passportList = buildPassportList(input);
				
		LinkedList<Passport> passports = buildPassport(passportList);
		
		for(Passport p : passports){
			HashMap<String, String> map = p.getMap();
			for(var entry : map.entrySet()){
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
			System.out.println();
		}
		
	}



}