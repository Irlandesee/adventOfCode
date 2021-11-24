Scanner reader = new Scanner(new File("res/day04_input"));
ArrayList<String> passports = new ArrayList<String>();

String passport = "";
while (reader.hasNextLine()) {
    String line = reader.nextLine();
    if (line.equals("")) {
        passports.add(passport);
        passport = "";
    } else {
        passport += " " + line;
    }
}
passports.add(passport); // adds in last passport found

int legal = 0; // contains 7 fields (excluding cid)
int valid = 0; // contains 7 fields AND each field meets requirements

for (String pp : passports) {
    if (isLegal(pp)) {
        legal++;
    }
    if (isLegal(pp) && isValid(pp)) {
       valid++;
    }
}

System.out.println("part 1: " + legal); // part 1
System.out.println("part 2: " + valid); // part 2

}

private static boolean isValid(String pp) {

    String[] split = pp.split(" ");
    for (String s : split) {
        if (s.startsWith("byr:") && !s.replace("byr:", "").matches("19[2-9] 
            [0-9]|200[0-2]")) {
            return false;
        } else if (s.startsWith("iyr") && !s.replace("iyr:", 
            "").matches("201[0-9]|2020")) {
            return false;
        } else if (s.startsWith("eyr:") && !s.replace("eyr:", 
            "").matches("202[0-9]|2030")) {
            return false;
        } else if (s.startsWith("hgt:")
                && !s.replace("hgt:", "").matches("1[5-8][0-9]cm|19[0- 
            3]cm|59in|6[0-9]in|7[0-6]in")) {
            return false;
        } else if (s.startsWith("hcl:") && !s.replace("hcl:", "").matches("# 
            [0-9a-f]{6}")) {
             return false;
        } else if (s.startsWith("ecl:") && !s.replace("ecl:", 
            "").matches("amb|blu|brn|gry|grn|hzl|oth")) {
            return false;
        } else if (s.startsWith("pid:") && !s.replace("pid:", "").matches(" 
            [0-9]{9}")) {
            return false;
        }
}

return true; 

}

private static boolean isLegal(String pp) {

    return pp.contains("byr:") && pp.contains("iyr:") && pp.contains("eyr:") 
    && pp.contains("hgt:") && pp.contains("hcl:") && pp.contains("ecl:") 
    && pp.contains("pid:");

}