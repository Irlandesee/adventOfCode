import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.Iterator;

public class Main{

	private static String path = "/Users/mattiamac/Documents/Github/adventofcode/2020/24";
	private static String fileName = "";

	public static void main(String[] args) throws IOException{

		if(args.length < 1)
			System.out.println("Inserisci input file");
		else{
			fileName = args[0];
			String completePath = buildPath(fileName);

			File f = new File(completePath);
			BufferedReader bReader = new BufferedReader(new FileReader(f));
			String rigaLetta = "";
			
			
			while((rigaLetta = bReader.readLine()) != null){
				righeLette.add(rigaLetta);
			
			}



		}

	}

	private static String buildPath(String s){
		StringBuilder b = new StringBuilder();
		b.append(path);
		b.append("/");
		b.append(s);
		return b.toString();
	}

}