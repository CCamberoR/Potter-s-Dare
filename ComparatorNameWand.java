import java.util.Comparator;
/**
 * Write a description of class ComparatorNameWand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparatorNameWand implements Comparator<MagicWand>
{
   @Override
   public int compare(MagicWand w1, MagicWand w2){
       return w1.getNameWand().compareTo(w2.getNameWand());                    
   }   
}
