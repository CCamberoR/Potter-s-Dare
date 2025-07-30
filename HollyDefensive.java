import java.lang.Math;
/**
 * Write a description of class HollyDefensive here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HollyDefensive extends Wand
{
    
    /**
     * 
     * Constructor for objects of class HollyDefensive
     */
    public HollyDefensive(String name){
        super(name);
        
    }
    
    /**
     * 
     * Returns the Ofensive Points of a character attacking with a HollyDefensive.
     * @param the energy points of the character owning the Wand .
     * @param the offensive points of the character owning the wand.
     * @return the offensive points of a character attacking with a HollyDefensive.
     * 
     */
    @Override
    public double offensive(double energy,double offensive){
        double attack;
        attack=0.7*energy+0.3*offensive;
        
        attack=(double)Math.round(attack*100d)/100d;
        
        return attack;
    }
    
    /**
     * Returns the defensive Points of a character defending with a HollyDefensive.
     * @param the energy points of the character owning the Wand .
     * @param the defensive points of the character owning the wand.
     * @return the defensive points of a character defending with an HollyDefensive.
     * 
     */
    @Override
    public double defensive(double energy,double defensive){
        double resistance;
        resistance=0.9*energy+1.1*defensive;
        
        resistance=(double)Math.round(resistance*100d)/100d;
        
        return resistance;
    }
    
     @Override
    public String getTypeWand(){
        return "HollyDefensiveBehavior";
    }
}
