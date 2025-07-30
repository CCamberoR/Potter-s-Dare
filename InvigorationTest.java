

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class InvigorationTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class InvigorationTest
{
    /**
     * Default constructor for test class InvigorationTest
     */
    public InvigorationTest()
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
    public void EnvigorationTest()
    {
        Offensive offensiv1 = new Offensive("testSubject");
        Invigoration invigora1 = new Invigoration(offensiv1);
        assertEquals(28, invigora1.getDefensivePoints(), 0.1);
    }
}

