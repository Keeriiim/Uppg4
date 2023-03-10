import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private Word ord;
    Scanner scan = new Scanner(System.in);
    private String name = "";
    private int val;
    public ArrayList<String> lista = new ArrayList<>();
    public ArrayList<Integer> poäng = new ArrayList<>();


    public void addPlayer(){
        System.out.print("Skriv in ett namn: ");
        this.name = scan.next(); // When setName() reads input using scan.next(), it reads only the next token and not the entire line.
        scan.nextLine(); // After setName() returns, the newline character from the user's input is left in the input buffer -> next scan.nextline(); reads whats stored in the buffer!
        lista.add(name);
        poäng.add(0);
        System.out.println("----"+name +"----" + " tillagt i spelarlistan");
    }

    public void checkForPlayer(){
        if(lista.isEmpty()){
            System.out.println("--- Det finns inga spelare i listan ----");
        }
        else{
            printPlayers();
            System.out.print("Skriv in det namn du vill ta bort: ");
            this.name = scan.nextLine();
            if(lista.contains(name)){
                lista.remove(lista.indexOf(name));
                System.out.println("Spelare " + name + " borttagen!");
            }
            else{
                System.out.println(name + " finns inte i listan");
            }
        }
    }

    void printPlayers(){
        if(lista.isEmpty()){
            System.out.println("---- Spelarelistan är tom ----");
        }
        else {
            System.out.println("\n**** SPELARLISTA ****");
            for (int i = 0; i < lista.size(); i++) {
                System.out.println("Spelare "+(i+1)+" "+lista.get(i));            
            }
            System.out.println("********************");
        }
    }

    void printPoäng(){
        if(poäng.isEmpty()){
            System.out.println("Det finns ingen poänglista");
        }
        else {
            System.out.println("\nSpelare:      Poäng: ");
            for (int i = 0; i < lista.size(); i++) {
                System.out.print(lista.get(i) +" ");
                for (int j = 0; j < (19-lista.get(i).length()); j++) {
                    System.out.print(" ");
                }
                System.out.println(poäng.get(i));
                
            }
        }
    }

    int pointOptions(){
        System.out.println("\n---- POÄNGSTATUS ----");
        System.out.println("\n1.Visa poänglistan\n2.Återställ alla poäng\n3.Tillbaka");
        System.out.print("Ditt val: ");
        val = scan.nextInt();
        return val;
    }

    void ökaPoäng(int p){
        poäng.set(p+1);    
    }

    void resetPoäng(){
        if(!lista.isEmpty()){
            for (int i = 0; i < lista.size(); i++) {
                poäng.set(i, 0);
                System.out.println("\nAlla poäng har återställts till 0");
            }
        }
        else{
            System.out.println("Finns inga poäng att återställa");

        }
    }
}


/*
 Spelare-klassen:
Egenskaper: Namn, antal poäng
Metoder:
getNamn(): returnerar spelarens namn
setNamn(): sätter spelarens namn
getPoäng(): returnerar spelarens poäng
ökaPoäng(): ökar spelarens poäng med 1
resetPoäng(): återställer spelarens poäng till 0
 */
