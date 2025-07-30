import java.io.*;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class OffensiveTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class OffensiveTest
{
    private Offensive offensiv1;

    /**
     * Default constructor for test class OffensiveTest
     */
    public OffensiveTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        offensiv1 = new Offensive("HANNAH");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void getNameTest()
    {
        assertEquals("HANNAH", offensiv1.getName());
    }

    @Test
    public void getOffensivePointsTest()
    {
        assertEquals(25, offensiv1.getOffensivePoints(), 0.1);
    }

    @Test
    public void getDefensivePointsTest()
    {
        assertEquals(20, offensiv1.getDefensivePoints(), 0.1);
    }

    @Test
    public void getTotalOffensiveTest()
    {
        HollyDefensive hollyDef1 = new HollyDefensive("HannahW");
        offensiv1.assignWand(hollyDef1);
        assertEquals(21.5, offensiv1.getTotalOffensivePoints(), 0.1);
    }

    @Test
    public void getResistancePointsTest()
    {
        HollyDefensive hollyDef1 = new HollyDefensive("HannahW");
        offensiv1.assignWand(hollyDef1);
        assertEquals(40, offensiv1.getResistancePoints(), 0.1);
    }

    @Test
    public void fightTest()
    {
        File myFile2 = new File("salidaTest.txt");
        try{
        if(!myFile2.exists()){
            myFile2.createNewFile();
        } 
                PrintWriter pwtest = new PrintWriter(myFile2);
                OffensiveHawthorn offensiv2 = new OffensiveHawthorn("HannahOffensiveWand");
                offensiv1.assignWand(offensiv2);
                Defensive defensiv1 = new Defensive("JOHN");
                OffensiveHawthorn offensiv3 = new OffensiveHawthorn("JohnW");
                defensiv1.assignWand(offensiv3);
                offensiv1.Fight(defensiv1,pwtest);
                assertEquals(0, defensiv1.getEnergyPoints(), 0.1);
                pwtest.close();
               
        }
       catch(IOException e){
         e.printStackTrace();   
       }
       myFile2.delete();
    }
}






