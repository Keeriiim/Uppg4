import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Hangman
 {

    static ArrayList<String> printHiddenLetters = new ArrayList<>();
    static ArrayList<String> printUpdatedHiddenLetters = new ArrayList<>();

    public static void main(String[] args) {
        Glossary lista = new Glossary();
        Word ordAlgoritm = new Word();
        ordAlgoritm.setGlossary(lista);
        Player spelare = new Player();
        Meny meny = new Meny();

        boolean yttreLoop = true;
        boolean inreLoop = true;
        boolean gissningsLoop = true;
        Scanner scan = new Scanner(System.in);
        int counter = 0;
    
       
        
        while(yttreLoop){ // loop som håller huvudmenyn aktiv
            int huvudMenyval = meny.visaHuvudmeny();  // Förenklar kod
            
            switch(huvudMenyval){ 
                case 1:
                   while(inreLoop){ // loop som håller spelmenyn aktiv
                    int spelMenyval = meny.visaSpelmeny();
                    // ************* TRY CATCH FÖR ATT FÅNGA ERROR OM MAN INTE SKRIVER EN INT TILL MENYERNA ?
                    switch(spelMenyval){
                        case 1:
                        if(spelare.lista.isEmpty()){
                            System.out.println("Var vänlig och lägg till en spelare");
                            break;
                        }
                        else if(lista.ordlista.isEmpty()){
                            System.out.println("Var vänlig och lägg till ord i ordlistan");
                            break;
                        }


                        else{
                            printStartaSpel();   // Printar välkommen till spelet
                            String slumpOrd = lista.slumpOrd(); // Väljer ett ord random ur ordlistan
                            String storedGuesses ="";
                            int failedGuessCounter = 0;

                            System.out.println("Printar random ordet ur listan: " + slumpOrd);


                            System.out.println("\n**********************");
                            ordAlgoritm.printHiddenSlumpord(slumpOrd);
                            System.out.println("\n\n**********************");
                            
                                for (int i = 0; i < spelare.lista.size(); i++) {
                                    
                                    while (true) {
                                        System.out.print(spelare.lista.get(i) + " 's tur att gissa: ");
                                        String guess = ordAlgoritm.guessALetter();
                                        
                                        if (storedGuesses.contains(guess)) {
                                            System.out.println("You have already guessed this, try another.");
                                            continue;
                                        }
                                        
                                        storedGuesses += guess;
                                        
                                        if (slumpOrd.contains(guess)) {
                                            System.out.println("Correct guess!");
                                            ordAlgoritm.printUpdatedHiddenSlumpord(guess,slumpOrd); // ersätter " _ " med en korrekt gissad bokstav 
                                            lista.spelare.ökaPoäng(spelare.lista.get(i)); // öka poäng för spelaren
                                            lista.spelare.printPoäng(); // Bara för att se poäng


                                        } else {
                                            System.out.println("Wrong guess.");
                                            failedGuessCounter++;

                                            // counter = 3
                                        }
                                        
                                     /*    if (secretWord.equals(guessedLetters)) {
                                            System.out.println("Congratulations, you guessed the word!");
                                            // printa allas poäng och återvänd till menyn // fråga vill du spela igen
                                            break;
                                        } */
                                    }

                                    }
                                    
                        }
                                
                                /*  System.out.println("Vill du spela igen?");
                                    System.out.println("1.Ja\n2.Nej");
                                    int val = scan.nextInt();
                                    while(val != 1 || val != 2){
                                        System.out.println("Vill du spela igen?");
                                        System.out.println("1.Ja\n2.Nej");
                                        val = scan.nextInt();
                                        if(val == 1){
                                            ordAlgoritm.hiddenSlumpOrd.clear();
                                            meny.visaSpelmeny();
                                          //  break;
                                        }
                                        else if (val == 2){
                                           // meny.visaHuvudmeny();
                                            break;
                                        }
                                    } */
        
    
                        case 2: // Visar menyvalen för spelare
                        boolean spelarLoop = true; 
                        while(spelarLoop){ // Håller menyn för spelare aktiv tills man väljer tillbaka
                            int playerOption = meny.printPlayerOptions();
                            if(playerOption == 1){ // Lägger till spelare
                                spelare.addPlayer();
                            }
                            else if(playerOption == 2){ // Tar bort spelare ifall det finns
                                spelare.checkForPlayer();
                                
                            }
                            else if(playerOption == 3){ // Printar alla spelare ifall de finns
                                spelare.printPlayers();
                            }
                            else if(playerOption == 4){ // Tillbaka till spelmenyn
                                spelarLoop = false;
                            }
                        }
                        break;

                        case 3: // Visar menyvalen för Ordlista
                        boolean listaLoop = true;
                        while(listaLoop){ // Håller menyn för ordlistan aktiv tills man väljer tillbaka
                            int glossaryOption = lista.printGlossaryOptions();
                            if(glossaryOption == 1){ // Lägger till ord
                                lista.läggTillOrd();
                            }
                            else if(glossaryOption == 2){ // Tar bort ett ord ifall det finns
                                lista.taBortOrd(); 
                            }
                            else if(glossaryOption == 3){ // Printar ordlistan ifall den finns
                                lista.printGlossary();
                            }
                            else if(glossaryOption == 4){ // Tillbaka till spelmenyn
                                listaLoop = false;
                            }
                       } 
                        break;

                        
                        case 4: // Visar menyn för poängstatus
                        boolean poängLoop = true;
                        while(poängLoop){ // Håller menyn för poänglistan aktiv tills man väljer tillbaka
                            int pointOption = spelare.pointOptions();
                            
                            if(pointOption == 1){ // printa poängen
                                spelare.printPoäng();
                            }
                            else if (pointOption == 2){ // Reset allas poäng
                                spelare.resetPoäng();
                            }
                            else if(pointOption == 3){ // Tillbaka till huvudmeny
                                poängLoop = false;
                           }
                        }  
                        break;
                        
                        case 5: // Tar en tillbaka till huvudmenyn
                        meny.visaHuvudmeny(); 
                        break;
                    }
                } 
            case 2: // Avslutar programmet
            yttreLoop = false;
            System.out.println("Programmet är avslutat!");
            break;

            default: // Printar error ifall man inte väljer 1 eller 2
            System.out.println("---------- Error : Choose 1 or 2 ----------");
            break;

    } 
    
}
scan.close();
    
}


public static void printStartaSpel(){
    System.out.println("\nVälkommna till Hangman\nVarje spelare kommer i turordning att få gissa på en bokstav, gissar man rätt får man ett poäng.\nGissar man fel kommer gubben närma sig ett steg mot att hängas!\n");
}

public static void drawHangman(int counter){
        if(counter == 0){
            System.out.println("   O ");
        }
        else if(counter == 1){
            System.out.println("   O ");
            System.out.println(" --I-- ");
        }
        else if(counter == 2){
            System.out.println("   O ");
            System.out.println(" --I-- ");
            System.out.println("   / "+"\" ");
            System.out.println("You LOSE !");
        }
    }
 }


/* 
Du ska skapa ett "Hänga gubbe spel", här nedan följer lite tips på hur du kan lägga upp det. Men du kan självklart göra det helt och hållet på ditt sätt.
Spelet-klassen:
Egenskaper:
En instans av Ordlista-klassen
En instans av Ord-klassen
En instans av Spelare-klassen
Antal gissningar kvar
En lista med gissade bokstäver



Spelet-klassen:
Egenskaper:
En instans av Ordlista-klassen
En instans av Ord-klassen
En instans av Spelare-klassen
Antal gissningar kvar
En lista med gissade bokstäver
Metoder:
public void startaSpel(): initierar ett nytt spel
public void gissa(): låter spelaren gissa en bokstav
avslutaSpel(): avslutar spelet
vinnare(): kollar om spelaren vunnit spelet



                                    }  */