import java.util.*;
import java.io.*;
/**
 * Write a description of class House here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class House
{
  private ArrayList<Character> Wizards;
  private String name;
  /**
  * Constructor for objects of class House
  */
  public House(String houseName){
      Wizards=new ArrayList<Character>();
      name=houseName;
  }
  
  /**
   * Returns the name of the house.
   * @return the name of the house. 
   * 
   */
  public String getName(){
        return name;
  }
  
  /**
   * Adds a Character to the array of wizards.
   * @param Character to be add to the Array of Wizards 
   * in the House.
   * 
   */
  public void addCharacter(Character character){
      Wizards.add(character);
  }
   
  /**
   * Returns the character at the given index of the array of wizards.
   * @param index of the character we want to get.
   * @return the wizard of the Array of Wizards
   * in the position "index".
   * 
   */ 
  public Character getCharacter(int index){
      if(indexValid(index)){
          Character wizard=Wizards.get(index);
          return wizard;
      }
      else
           return null;
  }
  /**
   * Returns the arraylist of wizards inside the house.
   * @return the ArrayList of wizards inside the house.
   */
  public ArrayList getWizardsList(){
      return  this.Wizards;
  }
   
   /**
    * Determine whether the given index is valid for the collection.
    * 
    * @param index The index to be checked.
    * @return true if the index is valid, false otherwise.
    */
  private boolean indexValid(int index){
      boolean valid;
        
      if(index<0 || index>=Wizards.size()) {
           valid=false;
      }
      else {
           valid=true;
      }
      return valid;
  }
  
  
  /** 
   * Removes the specified character from the array of wizards.
   * @param Character to be removed.
   * 
   */
  public void removeCharacterFromHouse(Character Ch){
      this.Wizards.remove(Ch);
  }
  
  /**
   * Returns true if the array of wizards is empty,false otherwise.
   * @return true if the Array of Wizards is empty.
   * 
   */
  public boolean houseEmpty(){
      return this.Wizards.isEmpty();
  }    
  
  /**
   * Retuns the number of character in the array of wizards.
   * @return the size of the Array of wizards.
   */
  public int numberOfWizards(){
      return this.Wizards.size();
  }
  
  /**
   * Returns the total sum of the energy points of all the characters in the array of wizards.
   * @return the  total sum of the energy points of all the wizards
   * in the house.
   * 
   */  
  public double HouseEnergyPoints(){
      double sum=0;
      for(int i=0;i<numberOfWizards();i++){
          sum=sum+this.Wizards.get(i).getEnergyPoints();    
      }
      return sum;
  }
  
  /**
   * Returns the total sum of the Defensive points of all the characters in the array of wizards.
   * @return the total sum of the Defensive and Offensive points 
   * of all wizards in the house.
   * 
   */
  public double HouseOffensiveDefensivePoints(){
     double sum=0;
     for(int i=0;i<numberOfWizards();i++){
         sum=sum+this.Wizards.get(i).getOffensivePoints()+this.Wizards.get(i).getDefensivePoints();    
     }
     return sum;
  }
  
  /**
   * Displays the name, energyPoints, offensivePoints, defensivePoints of a character and the name and the type
   * of the wand that the character is using. It is shown in the format specified for the project.
   */
  public void displayCHouse(){
      for(Character c : Wizards){
          System.out.println("character:<"+c.getName()+"> "+
          "<e: "+c.getEnergyPoints()+"> <o: "+c.getOffensivePoints()+
          "> <d: "+c.getDefensivePoints()+"> <wand: " + c.getCharacterWand().getNameWand()+ " ("+ c.getCharacterWand().getTypeWand() + ")"+ ">");
      }
  }
  
  /**
   * Prints the name, energyPoints, offensivePoints, defensivePoints of a character and the name and the type
   * of the wand that the character is using. It is shown in the format specified for the project.
   */
  public void printCHouse(PrintWriter pw){
      for(Character c : Wizards){
          pw.println("character:<"+c.getName()+"> "+
          "<e: "+c.getEnergyPoints()+"> <o: "+c.getOffensivePoints()+
          "> <d: "+c.getDefensivePoints()+"> <wand: " + c.getCharacterWand().getNameWand()+ " ("+ c.getCharacterWand().getTypeWand() + ")"+ ">");
      }
  }
  
}