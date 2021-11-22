package passport;

import java.util.Map;
import java.util.HashMap;

public class Passport{

	private HashMap<String, String> passport;
	private boolean valid;

	private final String[] keys = 
		{"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid", "cid"};

	public Passport(HashMap<String, String> readPassport){
		this.passport = readPassport;
	}

	public boolean getValid(){
		return this.valid;
	}

	public void setValid(boolean valid){
		this.valid = valid;
	}

	public HashMap<String, String> getMap(){
		return this.passport;
	}

	public void setMap(HashMap<String, String> map){
		this.passport = map;
	}

}