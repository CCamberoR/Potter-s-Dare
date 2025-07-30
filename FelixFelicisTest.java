

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class FelixFelicisTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class FelixFelicisTest
{
    /**
     * Default constructor for test class FelixFelicisTest
     */
    public FelixFelicisTest()
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
    public void FelixFelicisTest()
    {
        Defensive defensiv1 = new Defensive("testSubject2");
        FelixFelicis felixFel1 = new FelixFelicis(defensiv1);
        assertEquals(26, felixFel1.getOffensivePoints(), 0.1);
    }
}

