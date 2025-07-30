import java.lang.Math;
/**
 * Write a description of class InvigorationPotion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Invigoration extends Potion
{
    /**
     * Constructor for objects of class InvigorationPotion
     */
    public Invigoration(Character character){
        super(character);
    }
    
    /**
     * Returns the defensivePoints of the character's wand multiplied by 1,4.
     * @return the defensive points of the characer's wand multiplied by 1,4.
     */
    public double getDefensivePoints(){
      
        double defense =  characterWithPotion.getDefensivePoints()*1.4;
        
        defense=(double)Math.round(defense*100d)/100d;
        
        return defense;
    }
}
