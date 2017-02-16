/**
 * Created by rickjackson on 2/15/17.
 */
package jackson.rick;

import java.util.ArrayList;
import java.util.List;

public class Formatter {
    private StringBuilder output;
    private List<String> digits;
    private List<String> teens;
    private List<String> tens;
    private String clock;
    private String period;
    private List<String> time;
    
    Formatter() {
        this.output = new StringBuilder();
        this.digits = new ArrayList<>(10);
        this.teens = new ArrayList<>(10);
        this.tens = new ArrayList<>(4);
        this.clock = "Civilian";
        this.period = "Before";
        this.time = new ArrayList<>(2);
        constructDigits();
        constructTeens();
        constructTens();
        constructTime();
    }
    
    public void constructDigits() {
        digits.add("Oh");
        digits.add("One");
        digits.add("Two");
        digits.add("Three");
        digits.add("Four");
        digits.add("Five");
        digits.add("Six");
        digits.add("Seven");
        digits.add("Eight");
        digits.add("Nine");
    }
    
    public void constructTeens() {
        teens.add("Ten");
        teens.add("Eleven");
        teens.add("Twelve");
        teens.add("Thirteen");
        teens.add("Fourteen");
        teens.add("Fifteen");
        teens.add("Sixteen");
        teens.add("Seventeen");
        teens.add("Eighteen");
        teens.add("Nineteen");
    }
    
    public void constructTens() {
        tens.add("Twenty");
        tens.add("Thirty");
        tens.add("Forty");
        tens.add("Fifty");
    }
    
    public void constructTime() {
        time.add("00");
        time.add("00");
    }
    
    public String getDigit(int i) throws ArrayIndexOutOfBoundsException {
        return digits.get(i);
    }
    
    public String getTeen(int i)  throws ArrayIndexOutOfBoundsException {
        return teens.get(i-10);
    }
    
    public String getTen(int i) throws ArrayIndexOutOfBoundsException {
        return tens.get(i-2);
    }
    
    public String getClock() {
        return clock;
    }
    
    public String setClock(String str) {
        return clock = str;
    }
    
    public String getPeriod() {
        return period;
    }
    
    public String setPeriod(String str) {
        return period = str;
    }
    
    public String getTime(int index) throws ArrayIndexOutOfBoundsException {
        return time.get(index);
    }
    
    public String getTime(String str) throws ArrayIndexOutOfBoundsException {
        int index = time.indexOf(str);
        return time.get(index);
    }
    
    public List<String> setTime(List<String> L) {
        return time = L;
    }
    
    public String setTime(int index, String str) {
        return time.set(index, str);
    }
    
    public int getHours() {
        return Integer.valueOf(time.get(0));
    }
    
    public int getMinutes() {
        return Integer.valueOf(time.get(1));
    }
    
    public StringBuilder getCivilianFormalHours() {
        StringBuilder sb = new StringBuilder();
        
        return getHours() < 10 ? sb.append(getDigit(getHours()))
                          : sb.append(getTeen(getHours()));
    }
    
    public StringBuilder getCivilianFormalMinutes() {
        StringBuilder sb = new StringBuilder();
        
        if (getHours() == 12 && getMinutes() == 0) {
            if (period.equalsIgnoreCase("Before")) {
                sb.append("midnight");
            } else {
                sb.append("noon");
            }
        } else if (getMinutes() == 0) {
            sb.append("o'clock");
        } else if (getMinutes() < 10) {
            sb.append(getDigit(getMinutes()).toLowerCase());
        } else if (getMinutes() < 20) {
            sb.append(getTeen(getMinutes()).toLowerCase());
        } else {
            sb.append(getTen(getMinutes() / 10).toLowerCase());
            sb.append("-");
            sb.append(getDigit(getMinutes() % 10).toLowerCase());
        }
        return sb;
    }
    
    public StringBuilder getCivilianInformalHours() {
        StringBuilder sb = new StringBuilder();
        
        if (getMinutes() == 0) {
            if (getHours() == 12) {
                if (getPeriod().equalsIgnoreCase("Before")) {
                    sb.append("Midnight");
                } else {
                    sb.append("Noon");
                }
            } else {
                sb.append(getCivilianFormalHours());
            }
        } else if (getMinutes() > 30) {
            sb.append(" before ");
            if (getHours() == 11) {
                if (getPeriod().equalsIgnoreCase("Before")) {
                    sb.append("noon");
                } else {
                    sb.append("midnight");
                }
            } else if (getHours() + 1 > 12) {
                sb.append("one");
            } else {
                sb.append(getCivilianFormalHours().toString().toLowerCase());
            }
        } else {
            sb.append(" after ");
            sb.append(getCivilianFormalHours().toString().toLowerCase());
        }
        return sb;
    }
    
    public StringBuilder getCivilianInformalMinutes() {
        StringBuilder sb = new StringBuilder();
        int minutes = 0;
        
        if (getMinutes() > 30) {
            minutes = 60 - getMinutes();
        } else {
            minutes = getMinutes();
        }
        
        if (minutes == 1) {
            sb.append("One-minute");
        } else if (minutes > 1 && minutes < 10) {
            sb.append(getDigit(minutes));
            sb.append(" minutes");
        } else if (minutes >= 10 && minutes < 20) {
            sb.append(getTeen(minutes));
            sb.append(" minutes");
        } else if (minutes >= 20 && minutes < 30) {
            sb.append(getTen(minutes / 10));
            if (minutes / 10 != 0) {
                sb.append("-");
                sb.append(getDigit(minutes % 10).toLowerCase());
                sb.append(" minutes");
            }
        }
        return sb;
    }
    
    public StringBuilder getAbbreviation() {
        StringBuilder sb = new StringBuilder();
        
        if (getPeriod().equalsIgnoreCase("Before")) {
            sb.append(" a.m.");
        } else {
            sb.append(" p.m.");
        }
        
        return sb;
    }
    
    public StringBuilder getPeriodType() {
        StringBuilder sb = new StringBuilder();
        
        if (getPeriod().equalsIgnoreCase("Before")) {
            sb.append(" in the morning");
        } else {
            sb.append(" in the afternoon");
        }
        return sb;
    }
    
    public StringBuilder toCivilianFormal() {
        StringBuilder sb = new StringBuilder();
        sb.append(getCivilianFormalHours());
        sb.append(" ");
        sb.append(getCivilianFormalMinutes());
        sb.append(getAbbreviation());
        return sb;
    }
}
