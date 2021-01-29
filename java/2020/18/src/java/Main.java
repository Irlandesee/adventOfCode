import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;

public class Main{

	public static void main(String[] args) throws IOException{
		String fileName = "";
		String fileDirectory = "/Users/mattiamac/Documents/Github/adventOfCode/2020/18/";
		LinkedList<String> righeLette = new LinkedList<String>();
		LinkedList<String> rules = new LinkedList<String>();
		LinkedList<String> receivedMessages = new LinkedList<String>();


		if(args.length >= 1){
			fileName = args[0];

			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append(fileDirectory);
			sBuilder.append(fileName);

			File f = new File(sBuilder.toString());
			BufferedReader bReader = new BufferedReader(new FileReader(f));
			String rigaLetta = "";
			while((rigaLetta = bReader.readLine()) != null){
				righeLette.add(rigaLetta);
			}

			System.out.println("Size: " +righeLette.size());
			int index = 132;
			for(int i = 0; i < righeLette.size(); i++){
				if(i < index){
					String rule = righeLette.get(i);
					if(!(rule.isBlank()))
						rules.add(rule);
				}
				else
					receivedMessages.add(righeLette.get(i));

			}

			System.out.println("----- rules");
			for(String s : rules)
				System.out.println(s);
			System.out.println("----- receivedMessages");
			for(String s : receivedMessages)
				System.out.println(s);


		}else{	
			System.out.println("Inserire File Name");
		}

	}

}