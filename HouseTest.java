

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class HouseTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class HouseTest
{
    private House house1;

    /**
     * Default constructor for test class HouseTest
     */
    public HouseTest()
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
        house1 = new House("GRYFFINDOR");
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
        assertEquals("GRYFFINDOR", house1.getName());
    }


    @Test
    public void getNumberOfWizardsTest()
    {
        Offensive offensiv1 = new Offensive("jonny");
        house1.addCharacter(offensiv1);
        assertEquals(1, house1.numberOfWizards());
    }

    @Test
    public void getCharacterTest()
    {
        Offensive offensiv1 = new Offensive("jonny");
        house1.addCharacter(offensiv1);
        Offensive offensiv2 = (Offensive)house1.getCharacter(0);
        assertEquals(true, offensiv1.equals(offensiv2));
    }

    @Test
    public void getHouseEnergyPointsTest()
    {
        Offensive offensiv1 = new Offensive("1");
        Offensive offensiv2 = new Offensive("2");
        Offensive offensiv3 = new Offensive("3");
        house1.addCharacter(offensiv1);
        house1.addCharacter(offensiv2);
        house1.addCharacter(offensiv3);
        assertEquals(60, house1.HouseEnergyPoints(), 0.1);
    }

    @Test
    public void getHouseOffensivePointsTest()
    {
        Offensive offensiv1 = new Offensive("1");
        Offensive offensiv2 = new Offensive("2");
        Offensive offensiv3 = new Offensive("3");
        HollyDefensive hollyDef1 = new HollyDefensive("1");
        HollyDefensive hollyDef2 = new HollyDefensive("2");
        HollyDefensive hollyDef3 = new HollyDefensive("3");
        offensiv1.assignWand(hollyDef1);
        offensiv2.assignWand(hollyDef2);
        offensiv3.assignWand(hollyDef3);
        house1.addCharacter(offensiv1);
        house1.addCharacter(offensiv2);
        house1.addCharacter(offensiv3);
        assertEquals(135, house1.HouseOffensiveDefensivePoints(), 0.1);
    }

    @Test
    public void isHouseEmptyTest()
    {
        assertEquals(true, house1.houseEmpty());
    }
}







