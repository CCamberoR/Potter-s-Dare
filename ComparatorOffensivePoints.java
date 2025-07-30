import java.util.Comparator;
/**
 * Write a description of class ComparatorHufflepuff here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparatorOffensivePoints implements Comparator<Character>
{
   @Override
   public int compare(Character c1, Character c2){
       if(c1.getOffensivePoints()>c2.getOffensivePoints())
           return 1;
       else    
           if(c1.getOffensivePoints()<c2.getOffensivePoints())
               return -1;
           else
               return c1.getName().compareTo(c2.getName());
   }    
}
