import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

class Glossary {
    Meny meny = new Meny();
    private int val;
    private String ord;
    private String slumpOrd;
    private int slumpIndex;
    Random slump = new Random();
    Scanner scan = new Scanner(System.in);
    ArrayList<String> ordlista = new ArrayList<>();

    
    int printGlossaryOptions(){
        System.out.println("\n---- ORDLISTA ----");
        System.out.println("\n1.Lägg till ord\n2.Ta bort ord\n3.Visa ordlistan\n4.Tillbaka");
        System.out.print("Ditt val: ");
        val = scan.nextInt();
        return val;
    }

    void läggTillOrd(){
        System.out.print("Skriv in ett ord till ordlistan : ");
        ord = scan.next();
        ordlista.add(ord);
        scan.nextLine();
        System.out.println("--"+ord + "-- har lagts till i ordlistan");
    }

    void taBortOrd(){
        if(ordlista.isEmpty()){
            System.out.println("---- Ordlistan är tom ----");
        }
        else {
            System.out.println("\nVilket ord vill du ta bort? Ordlista: " + ordlista);
            ord = scan.next();
            
            if(ordlista.contains(ord)){
                int removeWord = ordlista.indexOf(ord);;
                System.out.println("Ordet --"+ordlista.get(removeWord)+ "-- är borttaget från ordlistan.");
                ordlista.remove(removeWord);
            }
            else {
                System.out.println("\nOrdet finns inte i ordlistan, försök igen");
                
            }
        }
    }

    void printGlossary(){
        if(ordlista.isEmpty()){
            System.out.println("---- Ordlistan är tom ----");
        }
        else {
            System.out.println("\n**** Ordlista ****\n");
            for (int i = 0; i < ordlista.size(); i++) {
                System.out.println("ord "+(i+1)+": "+ordlista.get(i));
            }
            System.out.println("\n******************");
        }
    }

    String slumpOrd(){
        slumpIndex = slump.nextInt(ordlista.size());
        slumpOrd = ordlista.get(slumpIndex);
        return slumpOrd;

    }
  
}
/*
 * Ordlista-klassen:
Egenskaper: En lista med ord
Metoder:
slumpOrd(): väljer ett slumpmässigt ord från listan
läggTillOrd(): lägger till ett ord till listan
taBortOrd(): tar bort ett ord från listan
 */