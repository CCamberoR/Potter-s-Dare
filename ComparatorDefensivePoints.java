import java.util.Comparator;
/**
 * Write a description of class ComparatorGryffindor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparatorDefensivePoints implements Comparator<Character>
{
    // instance variables - replace the example below with your ownimport java.util.Comparator;
    //menor a mayor y despues alfabetico.
   @Override
   public int compare(Character c1, Character c2){
       if(c1.getDefensivePoints()>c2.getDefensivePoints())
           return 1;
       else    
           if(c1.getDefensivePoints()<c2.getDefensivePoints())
               return -1;
           else
               return c1.getName().compareTo(c2.getName());      
   }    
    
    
}
