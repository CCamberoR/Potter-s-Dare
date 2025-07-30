/**
 * Write a description of class MagicWands here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public interface MagicWand
{
   /**
     * Returns the totalOfensivePoints of a character attacking.
     */
   public double offensive(double energy,double offensive);
   
   /**
     * Returns the resistancePoints of a character defending.
     */
   public double defensive(double energy,double defensive);
   
   /**
     * Sets the name of the wand by one specified by parameters.
     */
   public void setNameWand(String nameW);
   
   /**
     * Gets the name of the wand.
     */
   public String getNameWand();
   
   /**
     * Gets the type of the wand.
     */
   public String getTypeWand();
}
