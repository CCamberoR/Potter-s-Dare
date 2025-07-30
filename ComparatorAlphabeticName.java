import java.util.Comparator;
/**
 * Write a description of class ComparatorNameWand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparatorAlphabeticName implements Comparator<Character>
{
   @Override
   public int compare(Character c1, Character c2){
       return c1.getName().compareTo(c2.getName());                    
   }   
}

