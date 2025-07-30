

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DefensiveTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DefensiveTest
{
    private Defensive defensiv1;

    /**
     * Default constructor for test class DefensiveTest
     */
    public DefensiveTest()
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
        defensiv1 = new Defensive("JOHN");
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
        assertEquals("JOHN", defensiv1.getName());
    }

    @Test
    public void getOffensivePointsTest()
    {
        assertEquals(20, defensiv1.getOffensivePoints(), 0.1);
    }

    @Test
    public void getDefensivePointsTest()
    {
        assertEquals(25, defensiv1.getDefensivePoints(), 0.1);
    }

    @Test
    public void getEnergyPointsTest()
    {
        assertEquals(20, defensiv1.getEnergyPoints(), 0.1);
    }

    @Test
    public void getTotalOffensivePointsTest()
    {
        OffensiveHawthorn offensiv1 = new OffensiveHawthorn("JohnW");
        defensiv1.assignWand(offensiv1);
        assertEquals(40, defensiv1.getTotalOffensivePoints(), 0.1);
    }

    @Test
    public void getResistancePointsTest()
    {
        OffensiveHawthorn offensiv1 = new OffensiveHawthorn("johnW");
        defensiv1.assignWand(offensiv1);
        assertEquals(21, defensiv1.getResistancePoints(), 0.1);
    }
}






