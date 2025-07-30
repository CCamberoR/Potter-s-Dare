import java.lang.Math;
/**
 * Write a description of class OffensiveHawthorn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OffensiveHawthorn extends Wand
{
    /**
     * Constructor for objects of class OffensiveHawthorn
     */
    public OffensiveHawthorn(String name){
        super(name);
    }
    
    /**
     * Returns the Ofensive Points of a character attacking with an OffensiveHawthorn.
     * @param the energy points of the character owning the Wand .
     * @param the offensive points of the character owning the wand.
     * @return the offensive points of a character attacking with an OffensiveHawthorn.
     * 
     */
    @Override
    public double offensive(double energy,double offensive){
        double attack;
        attack=0.6*energy+1.4*offensive;
        
        attack=(double)Math.round(attack*100d)/100d;
        
        return attack;
    }
    
    /**
     * Returns the defensice Points of a character defending with an OffensiveHawthorn.
     * @param the energy points of the character owning the Wand .
     * @param the defensive points of the character owning the wand.
     * @return the defensive points of a character defending with an OffensiveHawthorn.
     * 
     */
    @Override
    public double defensive(double energy,double defensive){
        double resistance;
        resistance=0.8*energy+0.2*defensive;
        
        resistance=(double)Math.round(resistance*100d)/100d;
        
        return resistance;
    }
    
    @Override
    public String getTypeWand(){
        return "OffensiveHawthornBehavior";
    }
}
