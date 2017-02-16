/**
 * Created by rickjackson on 2/15/17.
 */
package jackson.rick;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FormatterTest {
    private Formatter format;
    
    @Before
    public void setup() {
        this.format = new Formatter();
    }
    
    @Test
    public void getDigitTest() {
        String expected = "Oh";
        String actual = format.getDigit(0);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void getTeenTest() {
        String expected = "Ten";
        String actual = format.getTeen(10);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void getTenTest() {
        String expected = "Twenty";
        String actual = format.getTen(20);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void getClockTest() {
        String expected = "Civilian";
        String actual = format.getClock();
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void setClockTest() {
        String expected = "Military";
        String actual = format.setClock("Military");
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void getPeriodTest() {
        String expected = "Before";
        String actual = format.getPeriod();
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void setPeriodTestString() {
        String expected = "After";
        String actual = format.setPeriod("After");
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void getTimeTestInteger() {
        String expected = "00";
        String actual = format.getTime(0);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void getTimeTestString() {
        String expected = "00";
        String actual = format.getTime("00");
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void setTimeTestList() {
        List<String> list = new ArrayList<>(2);
        list.add("8");
        list.add("30");
        String expected = "8";
        String actual = format.setTime(list).get(0);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void setTimeTest() {
        String expected = "00";
        String actual = format.setTime(0, "01");
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void getHoursTest() {
        int expected = 0;
        int actual = format.getHours();
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void getMinutesTest() {
        int expected = 0;
        int actual = format.getMinutes();
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void getCivilianFormalHoursTest() {
        format.setTime(0, "12");
        String expected = "Twelve";
        String actual = format.getCivilianFormalHours().toString();
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void getCivilianFormalMinutesTest() {
        format.setTime(0, "12");
        format.setTime(1, "00");
        format.setPeriod("Before");
        String expected = " midnight";
        String actual = format.getCivilianFormalMinutes().toString();
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void getCivilianInformalHoursTest() {
        format.setTime(0, "11");
        format.setTime(1, "33");
        format.setPeriod("Before");
        String expected = " before noon";
        String actual = format.getCivilianInformalHours().toString();
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void getInformalCivilianMinutesTest() {
        format.setTime(0, "12");
        format.setTime(1, "33");
        format.setPeriod("Before");
        String expected = "Twenty-seven minutes";
        String actual = format.getCivilianInformalMinutes().toString();
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void getAbbreviationTest() {
        format.setPeriod("After");
        String expected = "a.m.";
        String actual = format.getAbbreviation().toString();
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void getPeriodTypeTest() {
        format.setPeriod("After");
        String expected = " in the afternoon";
        String actual = format.getPeriodType().toString();
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void toCivilianFormalTest() {
        format.setTime(0, "12");
        format.setTime(1, "00");
        String expected = " a.m.";
        String actual = format.toCivilianFormal().toString();
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
}
