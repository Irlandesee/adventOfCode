import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class Main{

	private static LinkedList<String> righeLette;
	private static HashMap<String, String> m;


	private static final int numMinimoChiaviNecessarie = 7;
	private static final String pathToFile = "/Users/mattiamac/Documents/Github/adventofCode/2020/4";
	public static void main(String[] args){

		String rigaLetta = "";

		if(args.length < 1)
			System.out.println("Inserisci nome file!");
		else{
			String fileName = args[0];
			File f = new File(buildPath(fileName, pathToFile));
			try{
				BufferedReader r = new BufferedReader(new FileReader(f));
				while((rigaLetta = r.readLine()) != null){
					if(!(rigaLetta.isBlank())){
						righeLette.add(rigaLetta);
					}else{
						LinkedList<Passport> p =buildPassport(righeLette);
						for(Passport x : p)
							x.printPassport();
					}
				}
				r.close();
			}catch(IOException e){
				System.out.print("Error while reading: "+fileName);
				e.printStackTrace();
			}
			



		}
		
	}

	private static String buildPath(String fileName, String pathToFile){
		StringBuilder b = new StringBuilder();
		b.append(pathToFile);
		b.append("/");
		b.append(fileName);

		return b.toString();
	}

	private static LinkedList<Passport> buildPassport(LinkedList<String> l){
		HashMap<String, String> map = new HashMap<String, String>();
		Passport p;
		LinkedList<Passport> ris = new LinkedList<Passport>();
		Iterator<String> it = l.iterator();
		int count = 0;
		int numberOfEntries = 0;

		while(it.hasNext()){
			String riga = it.next();
			String[] splittedRiga = splitRiga(riga);
			numberOfEntries += splittedRiga.length;
			for(String entry : splittedRiga){
				String[] entrySplitted = splitEntry(entry);
				if(count < numMinimoChiaviNecessarie){
					map.put(entrySplitted[0], entrySplitted[1]);
					count++;
				}
			}
			if(){
				p = new Passport(map);
				ris.add(p);
				count = 0;
			}
		}
		return ris;
	}

	private static String[] splitRiga(String riga){
		return riga.split(" ");
	}

	private static String[] splitEntry(String entry){
		return entry.split(":");
	}

}