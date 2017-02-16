/**
 * Created by rickjackson on 2/15/17.
 */
package jackson.rick;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private StringBuilder input;
    private StringBuilder result;
    private String clock;
    private String period;
    private String[] time;
    
    public Parser(String input) {
        this.input = new StringBuilder(input);
        this.result = new StringBuilder();
        this.clock = "";
        this.period = "";
        this.time = new String[2];
    }
    
    public Pattern getClockPattern() {
        return Pattern.compile(""
                + "(((^[0-1]?[0-9])([\\s:]?)([0-5][0-9]$))|"
                + "(^[2]([0-3][\\s:]?[0-5][0-9]$|[4][\\s:]?[0]{2}$)))|"
                + "((^[0]?[1-9][\\s:]?[0-5][0-9][\\s]?([Aa]|[Pp])[.]?[Mm]["
                + ".]?$)|"
                + "(^[1][0-2][\\s:]?[0-5][0-9][\\s]?([Aa]|[Pp])[.]?[Mm][.]?$)"
                + ")");
    }
    
    public boolean validInput(StringBuilder sb) {
        Pattern p = Pattern.compile(""
                + "(((^[0-1]?[0-9])([\\s:]?)([0-5][0-9]$))|"
                + "(^[2]([0-3][\\s:]?[0-5][0-9]$|[4][\\s:]?[0]{2}$)))|"
                + "((^[0]?[1-9][\\s:]?[0-5][0-9][\\s]?([Aa]|[Pp])[.]?[Mm]["
                + ".]?$)|"
                + "(^[1][0-2][\\s:]?[0-5][0-9][\\s]?([Aa]|[Pp])[.]?[Mm][.]?$)"
                + ")");
        Matcher m = p.matcher(sb);
        return m.find();
    }
    
    public boolean isCivilian(StringBuilder sb) {
        Pattern p = Pattern.compile("([Aa]|[Pp])[Mm]$");
        Matcher m = p.matcher(sb);
        return m.find();
    }
    
    public String getPeriod() {
        return period;
    }
    
    public void setPeriod(StringBuilder sb) {
        if (isCivilian(sb)) {
            Pattern p = Pattern.compile("([Aa][.]?[Mm][.]?$)");
            Matcher m = p.matcher(sb);
            
            if (m.find()) {
                period = "Before";
            } else {
                period = "After";
            }
        }
    }
    
    public String getClock() {
        return clock;
    }
    
    public void setClock(StringBuilder sb) {
        if (isCivilian(sb)) {
            clock = "Civilian";
        } else {
            clock = "Military";
        }
    }
    
    public String toDigits(StringBuilder sb) {
        StringBuilder s = new StringBuilder();
        
        for (int i = 0; i < sb.length(); i++) {
            if (Character.isDigit(sb.charAt(i))) {
                s.append(sb.charAt(i));
            }
        }
        return s.toString();
    }
    
    public void setTime(StringBuilder sb) {
        time[0] = sb.substring(0, sb.length()-2);
        time[1] = sb.substring(sb.length()-2);
    }
    
    public String[] getTime() {
        return time;
    }
    
    public void parse() {
        setClock(input);
        result.append(toDigits(input));
        setTime(result);
    }
}
