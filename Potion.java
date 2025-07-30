
/**
 * Write a description of class Potion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Potion extends Character
{
    protected Character characterWithPotion;
    /**
     * Constructor for objects of class Potion
     */
    public Potion(Character charac){
        super(charac.getName());        
        characterWithPotion=charac;
        setEnergyPoints(charac.getEnergyPoints());
        setOffensivePoints(charac.getOffensivePoints());
        setDefensivePoints(charac.getDefensivePoints());
        assignWand(charac.getCharacterWand());
    }
    
    
}
