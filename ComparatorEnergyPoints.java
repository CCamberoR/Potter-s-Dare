import java.util.Comparator;
/**
 * Write a description of class ComparatorFighters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparatorEnergyPoints implements Comparator<Character>
{
    @Override
   public int compare(Character c1, Character c2){       
        if(c1.getEnergyPoints()>c2.getEnergyPoints())
           return 1;
           else    
            if(c1.getEnergyPoints()<c2.getEnergyPoints())
               return -1;
              else
               return c1.getName().compareTo(c2.getName());
        
   }   
    
    
}
