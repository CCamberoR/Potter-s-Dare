import java.util.*;
import java.util.Collections;
import java.io.*;
import java.lang.Math;

/**
 * Write a description of class Hogwarts here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hogwarts
{   
    private static Hogwarts instance;
    private ArrayList<MagicWand> replacements;
    private HashMap<String,House> houseMap;
    private LinkedHashSet<Character> Dungeon;
    private ArrayList<Character> Fighters; 
    
    /**
     * Constructor for objects of class Hogwarts
     */
    private Hogwarts(){ 
        replacements = new ArrayList();
        houseMap= new HashMap();
        Dungeon = new LinkedHashSet();
        Fighters = new ArrayList();
    }
    
    /**
     * This method allows to create a single instance of the class Hogwarts. 
     */
    public synchronized static
    Hogwarts getInstance(){
        if(instance==null){
            instance=new Hogwarts();
        }
        return instance;
    }
    
    /**
     * 
     * returns the list of wand replacements.
     * @return the list of wand replacements "replacements".
     * 
     */
    public ArrayList getReplacementList(){
      return  this.replacements;
    }
    
    /**
     * adds a new wand to the replacements list.
     * @param MagicWand to be added to the Array Of wand replacements.
     * 
     */
    public void addReplacements( MagicWand W){
        replacements.add(W);
    }    
    
    /** 
     * the method returns and removes the MagicWand in the position 0 in the ArrayList of wand replacements.
     * @return the MagicWand in the position 0 in the ArrayList of wand replacements. 
     */
    public MagicWand getAndRemoveReplacement(){
        MagicWand w;
        if(!this.replacements.isEmpty()){
            w=this.replacements.remove(0);
            return w;
        }
        else
            return null;    
    }
    
    /**
     * 
     * return the number of wands in the replacement list.
     * @return the size of the Array of wand replacements.
     * 
     */
    public int getNumberOfWands(){
        return this.replacements.size();
    }
    
    /**
     * 
     * Adds the specified house to the map of houses.
     * @param the String to be setted as the key of the hashMap of houses. 
     * @param the House to be added to the HashMap of houses.
     * 
     */
    public void addHouse(String name,House h){
        this.houseMap.put(name,h);
    }
    
    /**
     * Iterates over the map of houses looking for the specified character, removes it from its house 
     * and then is added to the dungeon set.
     * 
     * @param character to be removed from its house and added to the dungeon Linkedhashset.
     * 
     */
    public void sendToTheDungeon(Character c){
        for(HashMap.Entry<String,House> entry : houseMap.entrySet()){
          if(entry.getValue().getCharacter(0)==c){
              entry.getValue().removeCharacterFromHouse(c);
              this.Dungeon.add(c);
          } 
      }   
    }
    
    /**
     * 
     * Adds the specified character to the fighters array.
     * @param character to be added to the Array of fighters.
     * 
     */
    public void addFighter(Character c){
            this.Fighters.add(c);        
    }
    
     /**
     * Iterates over the HashMap of houses
     * taking the first wizards from each house and adding then to the
     * array of Fighters and then sort it by lower to higher energy.
     */
    public void prepareFighters(){
        for(HashMap.Entry<String,House> entry : houseMap.entrySet()){
               if( entry.getValue().getCharacter(0)!=null)
               addFighter(entry.getValue().getCharacter(0));             
        }            
            Collections.sort(this.Fighters,new ComparatorEnergyPoints());
    }

    /**
     *  The method iterates inside the Fighters and makes each wizard
     *  fight with the other wizards on by one if their energy points
     *  are higher than 0.
     *  @param printWriter to write in a text file
     */
    public void Duel(PrintWriter pw){
        for(Character c1 : Fighters){
                for(Character c2 : Fighters){
                    if(c1.getEnergyPoints()>0 ){
                        if(c1.getName()!=c2.getName() && c2.getEnergyPoints()>0){
                            display(c1,c2);
                            print(c1,c2,pw);
                            c1.Fight(c2,pw);
                        }
                    }
                    else{
                       
                       if(c1.getName()!=c2.getName()){
                            display(c1,c2);
                            print(c1,c2,pw);
                            pw.println();
                            System.out.println(); 
                       }
                    } 
                }    
            
        }    
    }
    
    /**
     * Displays the name of the two characters that are going to fight. It is shown in the format specified for the project.
     * @param character who is attacking
     * @param character who is defending
     */
    public void display(Character c1,Character c2){
        System.out.println("<"+c1.getName() + "> is dueling against <" + c2.getName()+">");
    }
    
    /**
     * Displays the name of the two characters that are going to fight. It is shown in the format specified for the project.
     * @param character who is attacking
     * @param character who is defending
     * @param printWriter to write in a text file
     */
    public void print(Character c1,Character c2,PrintWriter pw){
        pw.println("<"+c1.getName() + "> is dueling against <" + c2.getName()+">");
    }
    
    /**
     * The method iterates over the Array of Fighters and checks if the character
     * should be sent to the dungeon if the energy points are below 0, or otherwise sent to its house
     */
    public void returnCharacters(){
        Iterator<Character> it = Fighters.iterator();
        Character Ch;
        while(it.hasNext()){
            Ch=it.next();
            it.remove();
            if(Ch!=null)
                if(Ch.getEnergyPoints()>0)
                    returnToHouse(Ch);  
                else
                    sendToTheDungeon(Ch);
        }
    }
    
    /**
     *  Removes the first character of the array of wizards in the house and inserts it again so the caracter is now in the last positión
     *  
     *  @param character to be removed from its house and added to that house again 
     *  for the character to be in the last position of the array of wizards in that house.
     *  
     */
    public void returnToHouse(Character Ch){
      for(HashMap.Entry<String,House> entry : houseMap.entrySet()){
          if(entry.getValue().getCharacter(0)==Ch){
              entry.getValue().removeCharacterFromHouse(Ch);
              entry.getValue().addCharacter(Ch);
          } 
      }   
    }
    
     /**
     * Returns true if there's only one house with characters left in the map of houses, false otherwise. 
     * @return true if there's only one house with characters left in the HashMap of houses
     * 
     */
    public boolean checkWinnerHouse(){
        boolean flag = false;
        int i=0;
        for(House h1: houseMap.values()){
            if(!h1.houseEmpty()){
                i++;
            }    
        }
        if(i==1) flag=true;   
            
        return flag;
    }
    
    /**
     * Displays the name, energyPoints, offensivePoints, defensivePoints of the characters in the ArrayList of fighters
     * and the name and the type of the wand that they have. It is shown in the format specified for the project.
     */
    public void displayC(){
        for(Character c : Fighters){
            System.out.println("character:<"+c.getName()+"> "+
            "<e: "+c.getEnergyPoints()+"> <o: "+c.getOffensivePoints()+
            "> <d: "+c.getDefensivePoints()+"> <wand: " + c.getCharacterWand().getNameWand() + " ("+ c.getCharacterWand().getTypeWand() + ")"+ ">");
        }
    }
    
    /**
     * Prints the name, energyPoints, offensivePoints, defensivePoints of the characters in the ArrayList of fighters
     * and the name and the type of the wand that they have. It is shown in the format specified for the project.
     * @param printWriter to write in a text file
     */
    public void printC(PrintWriter pw){
        for(Character c : Fighters){
            pw.println("character:<"+c.getName()+"> "+
            "<e: "+c.getEnergyPoints()+"> <o: "+c.getOffensivePoints()+
            "> <d: "+c.getDefensivePoints()+"> <wand: " + c.getCharacterWand().getNameWand() + " ("+ c.getCharacterWand().getTypeWand() + ")"+ ">" );
        }
    }
    
    /**
     * Displays the turn and the method displayC. It is shown in the format specified for the project.
     * @param turn in which the characters are going to fight
     */
    public void displayD(int turns){
        System.out.print("\n");
        System.out.println("turn: <"+turns+">");
        System.out.println("characters who are going to duel:");
        System.out.println("--------------------------------");
        displayC();
        System.out.println("\n");
        System.out.println("duels:");
        System.out.println("-----");
    }
    
    /**
     * Prints the turn and the method printC. It is shown in the format specified for the project.
     * @param turn in which the characters are going to fight
     * @param printWriter to write in a text file
     */
    public void printD(int turns,PrintWriter pw){
        pw.print("\n");
        pw.println("turn: <"+turns+">");
        pw.println("characters who are going to duel:");
        pw.println("--------------------------------");
        printC(pw);
        pw.println("\n");
        pw.println("duels:");
        pw.println("-----");
    }
    
    /**
     * Displays the name, energyPoints, offensivePoints, defensivePoints of the character specified by parameter
     * and the name and the type of the wand that they have and the place where the character goes. This is shown
     * after the duel. It is shown in the format specified for the project.
     * @param character who has fight
     */
    public void displayCR(Character c){
            if(c.getEnergyPoints()>0){
                System.out.println("character:<"+c.getName()+"> "+
                "<e: "+c.getEnergyPoints()+"> <o: "+c.getOffensivePoints()+
                "> <d: "+c.getDefensivePoints()+"> <wand: "+ c.getCharacterWand().getNameWand() + " ("+ c.getCharacterWand().getTypeWand() + ")"+ ">"
                + " returns to the house");
            }
            else{
                System.out.println("character:<"+c.getName()+"> "+
                "<e: "+c.getEnergyPoints()+"> <o: "+c.getOffensivePoints()+
                "> <d: "+c.getDefensivePoints()+"> <wand: "+  c.getCharacterWand().getNameWand() + " ("+ c.getCharacterWand().getTypeWand() + ")"+ ">"
                 + " goes to the dungeon");
            }
    }
    
    /**
     * Prints the name, energyPoints, offensivePoints, defensivePoints of the character specified by parameter
     * and the name and the type of the wand that they have and the place where the character goes. This is shown
     * after the duel. It is shown in the format specified for the project.
     * @param character who has fight
     * @param printWriter to print in a text file
     */
    public void printCR(PrintWriter pw,Character c){
            if(c.getEnergyPoints()>0){
                pw.println("character:<"+c.getName()+"> "+
                "<e: "+c.getEnergyPoints()+"> <o: "+c.getOffensivePoints()+
                "> <d: "+c.getDefensivePoints()+"> <wand: "+ c.getCharacterWand().getNameWand() + " ("+ c.getCharacterWand().getTypeWand() + ")"+ ">"
               + " returns to the house");
            }
            else{
                pw.println("character:<"+c.getName()+"> "+
                "<e: "+c.getEnergyPoints()+"> <o: "+c.getOffensivePoints()+
                "> <d: "+c.getDefensivePoints()+"> <wand: "+ c.getCharacterWand().getNameWand() + " ("+ c.getCharacterWand().getTypeWand() + ")"+ ">"
                +" goes to the dungeon");
            }
    }
    
    /**
     * Displays duel results:
     * ------------
     * It is shown in the format specified for the project.
     */
    public void displayR(){
        System.out.println("duel results:");
        System.out.println("------------");
    }
    
    /**
     * Prints duel results:
     * ------------
     * It is shown in the format specified for the project.
     * @param printWriter to print in a text file
     */
    public void printR(PrintWriter pw){
        pw.println("duel results:");
        pw.println("------------");
    }
    
    /** Displays houses:
     * ------
     * The name of the house and then displays the method displayCHouse.
     * It is shown in the format specified for the project.
     */
    public void displayHouseAndCharacters(){
        System.out.println("houses:");
        System.out.println("------");
        for(House h1: houseMap.values()){
            System.out.println("house:<"+h1.getName()+">");
            h1.displayCHouse();
            System.out.println();
        }
    }
    
    /** Prints houses:
     * ------
     * The name of the house and then prints the method printCHouse.
     * It is shown in the format specified for the project.
     * @param printWriter to print in a text file
     */
    public void printHouseAndCharacters(PrintWriter pw){
        pw.println("houses:");
        pw.println("------");
        for(House h1: houseMap.values()){
            pw.println("house:<"+h1.getName()+">");
            h1.printCHouse(pw);
            pw.println();
        }
    }
    
    /**
     * Displays the name, energyPoints, offensivePoints, defensivePoints and the name and the type of the wand of all the characters
     * in the dungeon. It is shown in the format specified for the project.
     */
    public void displayDungeon(){
        for(Character c : Dungeon){
            System.out.println("character:<"+c.getName()+"> "+
            "<e: "+c.getEnergyPoints()+"> <o: "+c.getOffensivePoints()+
            "> <d: "+c.getDefensivePoints()+"> <wand: " + c.getCharacterWand().getNameWand()+ " ("+ c.getCharacterWand().getTypeWand() + ")"+ ">");
        }
    }
    
    /**
     * Prints the name, energyPoints, offensivePoints, defensivePoints and the name and the type of the wand of all the characters
     * in the dungeon. It is shown in the format specified for the project.
     * @param printWriter to write in a text file
     */
    public void printDungeon(PrintWriter pw){
        for(Character c : Dungeon){
            pw.println("character:<"+c.getName()+"> "+
            "<e: "+c.getEnergyPoints()+"> <o: "+c.getOffensivePoints()+
            "> <d: "+c.getDefensivePoints()+"> <wand: " + c.getCharacterWand().getNameWand() + " ("+ c.getCharacterWand().getTypeWand() + ")"+ ">");
        }
    }
    
    /**
     * Displays the name and the type of all the wands stored in the replacements ArrayList. It is shown in the format
     * specified for the project.
     */
    public void displayReplacements(){
        System.out.println("new wands:");
        for(MagicWand w : replacements){
            System.out.println("wand: <" + w.getNameWand() +" ("+ w.getTypeWand() + ")"+ ">" );
        }
    }
    
    /**
     * Prints the name and the type of all the wands stored in the replacements ArrayList. It is shown in the format
     * specified for the project.
     * @param printWriter to write in a text file
     */
    public void printReplacements(PrintWriter pw){
        pw.println("new wands:");
        for(MagicWand w : replacements){
            pw.println("wand: <" + w.getNameWand() +" ("+ w.getTypeWand() + ")"+ ">");
        }
    }
    
    /**
     * Displays the methods displayHouseAndCharacters, displayReplacements and displayDungeon in the format specified for the project.
     */
    public void displayEndAndDungeon(){
        System.out.println();
        System.out.println("end of simulation:");
        System.out.println("----------------------");
        displayHouseAndCharacters();
        System.out.println();
        displayReplacements();
        System.out.println("----------");
        System.out.println("dungeon characters:");
        System.out.println("-------------------");
        System.out.println();
        displayDungeon();
    }
    
    /**
     * Prints the methods printHouseAndCharacters, printReplacements and printDungeon in the format specified for the project.
     * @param printWriter to write in a text file
     */
     public void printEndAndDungeon(PrintWriter pw){
        pw.println();
        pw.println("end of simulation:");
        pw.println("----------------------");
        printHouseAndCharacters(pw);
        pw.println();
        printReplacements(pw);
        pw.println("----------");
        pw.println("dungeon characters:");
        pw.println("-------------------");
        pw.println();
        printDungeon(pw);
    }
    
    /**
     * Displays the name of the house that has win the duel and the method displayCHouse. It is shown in the format specified
     * for the project.
     * @param the house that has win the duel
     */
    public void displayWinner(House CurrentWinnerHouse){
        System.out.println();
        System.out.println("the winner house is:");
        System.out.println("-------------------");
        for(House h1: houseMap.values()){
            if(h1.getName()==CurrentWinnerHouse.getName()){
                System.out.println("house:<"+h1.getName()+">");
                h1.displayCHouse();
            }
        }
    }
    
    /**
     * Prints the name of the house that has win the duel and the method printCHouse. It is shown in the format specified
     * for the project.
     * @param the house that has win the duel
     * @param printWriter to write in a text file
     */
    public void printWinner(House CurrentWinnerHouse,PrintWriter pw ){
        pw.println();
        pw.println("the winner house is:");
        pw.println("-------------------");
        for(House h1: houseMap.values()){
            if(h1.getName()==CurrentWinnerHouse.getName()){
                pw.println("house:<"+h1.getName()+">");
                h1.printCHouse(pw);
            }
        }
    }
    
    
    /**
     * the method simulates a real battle between wizards,firstly
     * preparing the character from each house in the HashMap,secondly,
     * making the fight, thirdly giving them a replacement wand(if they were not defeated)
     * and lastly sending then to their house or to the dungeon.
     * 
     * then when the turn 10 finished the method will check the winner house 
     * following the criteria stated on the documentation.
     */
    public void game(){
        House CurrentWinnerHouse=null;
        int turns=0;
        int prueba=0;
        int minWizards=0;
        double minEnergy=0;
        
        
        File myFile = new File("salida.txt");
        
        try{
        if(!myFile.exists()){
            myFile.createNewFile();
        }    
            PrintWriter pw = new PrintWriter(myFile);
            
            displayHouseAndCharacters();
            printHouseAndCharacters(pw);
            
            displayReplacements();
            printReplacements(pw);
            
       while(turns<10 && !checkWinnerHouse()){  
           
           this.prepareFighters();
           displayD(turns);
           printD(turns,pw);
           this.Duel(pw);
           displayR();
           printR(pw);
           for(Character c : Fighters){
               displayCR(c);
               printCR(pw,c);
               if(c.getEnergyPoints()!=0  && this.getNumberOfWands()!=0){
                    c.assignWand(this.getAndRemoveReplacement());
                    System.out.println("new wand assigned: <"+c.getCharacterWand().getNameWand() + " (class "+c.getCharacterWand().getTypeWand()+")>");
                    pw.println("new wand assigned: <"+c.getCharacterWand().getNameWand() + " (class "+c.getCharacterWand().getTypeWand()+")>");
               }
           }
           this.returnCharacters();
           turns++;
          
       }
      
       
       displayEndAndDungeon();
       printEndAndDungeon(pw);
       
       if(checkWinnerHouse()){
            for(House h1: houseMap.values()){
                if(h1.numberOfWizards()!=0){
                    CurrentWinnerHouse=h1; 
                    
                }
            }
        }
        else{
            minWizards=0;
                for(House h1: houseMap.values()){
                    if(h1.numberOfWizards()>minWizards){
                        minWizards=h1.numberOfWizards();
                        CurrentWinnerHouse=h1;
                    }  
                    else{ 
                        if(h1.numberOfWizards()==minWizards && h1.numberOfWizards()!=0){
                            if(h1.HouseEnergyPoints()>CurrentWinnerHouse.HouseEnergyPoints()){
                                CurrentWinnerHouse=h1;
                            } 
                            else{
                                if(h1.HouseEnergyPoints()==CurrentWinnerHouse.HouseEnergyPoints()){
                                    if(h1.HouseOffensiveDefensivePoints()<CurrentWinnerHouse.HouseOffensiveDefensivePoints())
                                        CurrentWinnerHouse=h1;  
                                }
                            }    
                        }
                    }
                }    
        }    
        displayWinner(CurrentWinnerHouse);
        printWinner(CurrentWinnerHouse,pw);
        pw.close();
       }
       catch(IOException e){
         e.printStackTrace();   
       }
       
    }   
    
}
