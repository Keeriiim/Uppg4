import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Word {
    private Glossary lista;
    private Random slump = new Random();
    private Scanner scan = new Scanner(System.in);
    private String guess;
    private boolean numberOfTries = true;
    private int counter = 10;
    String empty = "";
    ArrayList<String> hiddenSlumpOrd = new ArrayList<>();
    
    public void setGlossary(Glossary lista) {
        this.lista = lista;
    }
    
    String guessALetter(){
        this.guess = scan.nextLine();
        return guess;
    }

    void printHiddenSlumpord(String slumpOrd){
        for (int i = 0; i < slumpOrd.length(); i++) {
            this.hiddenSlumpOrd.add("_");
        } 

        for (int j = 0; j < hiddenSlumpOrd.size(); j++) {
            System.out.print(hiddenSlumpOrd.get(j) + " ");
        } 
    }

    void printUpdatedHiddenSlumpord(String guess, String slumpOrd){
        char inputChar = guess.charAt(0);

        for (int i = 0; i < slumpOrd.length(); i++) {
            if(inputChar == slumpOrd.charAt(i)){
                hiddenSlumpOrd.set(i, guess);
                System.out.println("Success! " + i + " is set to " + guess);
            }
            System.out.println("Failed, did not find " + guess + " at index " + i+ " but we found " + slumpOrd.charAt(i));  
        }
        
    }
  
}


/*
 * Ord-klassen:
Egenskaper: Ett ord
Hanterar ordet vi gissar på
Metoder:
getOrd(): returnerar ordet
matchaBokstav(): kollar om en given bokstav matchar någon i ordet
ersättBokstav(): ersätter en bokstav i ordet med en annan
 */