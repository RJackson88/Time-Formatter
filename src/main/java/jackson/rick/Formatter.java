/**
 * Created by rickjackson on 2/15/17.
 */
package jackson.rick;

public class Formatter {
    private String[] digits;
    private String[] teens;
    private String[] tens;
    
    Formatter() {
        this.digits = new String[10];
        this.teens = new String[9];
        this.tens = new String[5];
    }
    
    public void constructDigits() {
        digits[0] = "Oh";
        digits[1] = "One";
        digits[2] = "Two";
        digits[3] = "Three";
        digits[4] = "Four";
        digits[5] = "Five";
        digits[6] = "Six";
        digits[7] = "Seven";
        digits[8] = "Eight";
        digits[9] = "Nine";
    }
    
    public void constructTeens() {
        teens[0] = "Eleven";
        teens[1] = "Twelve";
        teens[2] = "Thirteen";
        teens[3] = "Fourteen";
        teens[4] = "Fifteen";
        teens[5] = "Sixteen";
        teens[6] = "Seventeen";
        teens[7] = "Eighteen";
        teens[8] = "Nineteen";
    }
    
    public void constructTens() {
        tens[0] = "Ten";
        tens[1] = "Twenty";
        tens[2] = "Thirty";
        tens[3] = "Fourty";
        tens[4] = "Fifty";
    }
}
