import java.lang.Math;
/**
 * Write a description of class FelixFelicis here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FelixFelicis extends Potion
{
    /**
     * Constructor for objects of class FelixFelicis
     */
    public FelixFelicis(Character character){
        super(character);
    }
    
    /**
     * Returns the offensive points of the character's wand multiplied by 1,3.
     * @return the offensive points of the character's wand multiplied by 1,3.
     */
    @Override
    public double getOffensivePoints(){
        double attack=1.3*characterWithPotion.getOffensivePoints();
        
        
        attack=(double)Math.round(attack*100d)/100d;
        
        return attack;
    }
}
