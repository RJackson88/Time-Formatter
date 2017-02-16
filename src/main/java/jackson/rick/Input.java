/**
 * Created by rickjackson on 2/15/17.
 */
package jackson.rick;

import java.util.Scanner;

public class Input {
    private Scanner scan;
    
    public Input() {
        this.scan = new Scanner(System.in);
    }
    
    public String getTime() {
        return scan.nextLine();
    }
}
