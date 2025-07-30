
/**
 * Write a description of class Defensive here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Defensive extends Character
{
    /**
     * Constructor for objects of class Defensive
     */
      public Defensive(String name){ 
        super(name);
        setDefensivePoints(getDefensivePoints()+5);
    }
}
