import java.util.Scanner;

public class Meny{
    private int val;
    private int val1;
    private Scanner scan = new Scanner(System.in);



    public int visaHuvudmeny(){
        System.out.println("\n---- HUVUDMENY ----");
        System.out.println("\n1.Spelmany\n2.Avsluta");
        System.out.print("Ditt val: ");
        val = scan.nextInt();
        return val;
        }   

    public int visaSpelmeny(){
        System.out.println("\n---- SPELMENY ----");
        System.out.println("\n1.Starta spel\n2.Spelare (Lägg till/ta bort)\n3.Ordlista (Lägg till/ta bort)\n4.Poängstatus\n5.Tillbaka");
        System.out.print("Ditt val: ");
        val1 = scan.nextInt();
        return val1;
        
    }   

    public int printPlayerOptions(){
        System.out.println("\n---- SPELARMENY ----");
        System.out.println("\n1.Lägg till spelare\n2.Ta bort spelare\n3.Visa alla spelare\n4.Tillbaka");
        System.out.print("Ditt val: ");
        val1 = scan.nextInt();
        return val1;      
    }

    int printGlossaryOptions(){
        System.out.println("\n---- ORDLISTA ----");
        System.out.println("\n1.Lägg till ord\n2.Ta bort ord\n3.Visa ordlistan\n4.Tillbaka");
        System.out.print("Ditt val: ");
        val = scan.nextInt();
        return val;
    }
}

/* 
 * 
 * Meny-klassen:
Metoder:
visaHuvudmeny(): visar huvudmenyn och låter spelaren välja en funktion
visaSpelmeny(): visar spelmenyn och låter spelaren välja en funktion
För att använda klasserna tillsammans kan du göra följande:

Tips
Skapa en instans av Spelare-klassen
Skapa en instans av Ordlista-klassen och lägg till ord till listan
Skapa en instans av Spelet-klassen och använd slumpOrd() från Ordlista-klassen för att välja ett ord att gissa på
Anropa startaSpel() från Spelet-klassen för att börja spelet och visa menyerna med hjälp av Meny-klassen
Låt spelaren gissa på bokstäver och använd gissa() från Spelet-klassen för att kolla om bokstaven finns i ordet
Uppdatera antal gissningar kvar och lägg till gissade bokstäver i en lista
Fortsätt att låta spelaren gissa på bokstäver tills spelet antingen avslutas eller spelaren vinner
Visa resultatet och återgå till huvudmenyn med hjälp av Meny-klassen
 */