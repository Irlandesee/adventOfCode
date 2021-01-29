import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class Passport {
   
    private boolean validity;
    private HashMap<String, String> map;

    private static int passportNumber = 0; //number of passport created

    public Passport(HashMap <String, String> map){
        this.map = map;
        passportNumber++;
    }

    public boolean getValidity(){
        return this.validity;
    }

    public void setValidity(boolean validity){
        this.validity = validity;
    }

    public HashMap<String, String> getMap(){
        return this.map;
    }

    public void printPassport(){
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println("Key "+pair.getKey()+" = "+" Value"
            +pair.getValue());
            it.remove();
        }
    }

    public int getPassportNumber(){
        return passportNumber;
    }

}
