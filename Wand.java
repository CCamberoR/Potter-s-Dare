/**
 * Abstract class Wand - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
public abstract class Wand implements MagicWand
{
    private String nameWand;
    private String type;
    
    /**
     * Constructor for objects of class Wand
     */
    public Wand(String name){
        nameWand=name;
        type="";
    }
    
    /**
     * Returns the totalOfensivePoints of a character attacking.
     */
    @Override
    public abstract double offensive(double energy,double offensive);
    
    /**
     * Returns the resistancePoints of a character defending.
     */
    @Override
    public abstract double defensive(double energy,double defensive);
    
    /**
     * Sets the name of the wand by one specified by parameters.
     */
    @Override
    public void setNameWand(String nameW){
        this.nameWand=nameW;
    }
    
    
    @Override
    public String getNameWand(){
        return this.nameWand;
    }
    
    @Override
    public String getTypeWand(){
        return this.type;
    }
}
