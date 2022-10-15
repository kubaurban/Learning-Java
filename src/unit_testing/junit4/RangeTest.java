package unit_testing.junit4;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
                                        //klasa testująca wraz z metodami muszą być w JUnit 4 publiczne
public class RangeTest {                //tutaj odpal klasę testową

    private static Range range;

    /*
    Inne ważne adnotacje:
    @BeforeClass - metoda statyczna z tą adnotacją wykonuje się raz przed pierwszym testem danej klasy
    @AfterClass - metoda statyczna z tą adnotacją wykonuje się raz po ostatnim teście danej klasy
    @After - analog. do @Before
     */

    @Before                                     // ta metoda zostanie uruchomiona przed każdym testem jednostkowym !
    public void setUp() {
        range = new Range(10, 20);
    }

    /*
    Nazewnictwo testów wg zasady give_when_then
     */

    @Test
    public void numberInRange_isInRange_true() {
        Assert.assertTrue(range.isInRange(15));
        /* jeśli w argumencie metody assertTrue podana zostanie wartość logiczna false,
         IntelliJ zwróci błąd dedykowany testowi jednostkowemu
         Zwróć uwagę na inne warianty metody Assert.assert_ , zwłaszcza assertEquals */
    }

    @Test
    public void numberNotInRange_isInRange_false() {
        Assert.assertFalse(range.isInRange(25));
    }

    @Test
    public void lowerBoundLowerThanUpperBound_Range_nothing() {
        //new Range(20, 30);
    }

    @Test(expected = IllegalArgumentException.class) // zamiast asercji
    public void lowerBoundHigherThanUpperBound_Range_IllegalArgumentException() {
        new Range(20, 10);
    }
    /*
    @Test                                            // z asercją
    public void Range_lowerBoundHigherThenUpperBound_IllegalArgumentException() {
        try{
            new Range(20, 10);
            fail("Exception wasn't thrown!");       // kończy wykonanie testu niepowodzeniem
        catch(IllegalArgumentException e){
            Assert.assertEquals("Lower bound is higher than upper bound!",e.getMessage()); //po co to?
        }
    }
     */
}
