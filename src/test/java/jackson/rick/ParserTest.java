/**
 * Created by rickjackson on 2/15/17.
 */
package jackson.rick;

import org.junit.Before;
import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

public class ParserTest {
    private Parser parser;
    
    @Before
    public void setup() {
        this.parser = new Parser("2400");
    }
    
    @Test
    public void getPatternTest() {
        Pattern expected = null;
        Pattern actual = parser.getClockPattern();
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void validInputTest() {
        boolean expected = true;
        boolean actual = parser.validInput(new StringBuilder("12:00 p.m."));
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void isCivilianTest() {
        boolean expected = true;
        boolean actual = parser.isCivilian(new StringBuilder("12:00 pm"));
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void getPeriodTest() {
        parser.setPeriod(new StringBuilder("12:00 pm"));
        String expected = "After";
        String actual = parser.getPeriod();
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void getClockTest() {
        parser.setClock(new StringBuilder("1200"));
        String expected = "Military";
        String actual = parser.getClock();
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void toDigitsTest() {
        String expected = "1200";
        String actual = parser.toDigits(new StringBuilder("12:00 p.m."));
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void getTimeTest() {
        parser.setTime(new StringBuilder("1200"));
        String expected = "12";
        String actual = parser.getTime(0);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
}
