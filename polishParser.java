/**
 * Class polishParser takes a normal polish notation (NPN) value
 * converts it to a postfix polish notation (RPN)
 * e.g[+,2,-,3,4]>>>>>[4,3,-,2,+]
 * and evaluates the value
 * runs as NPN if only three elements...
 *
 * @author Faozy Adamson
 * @date 8th December 2020
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Integer;
import java.util.Stack;

public class polishParser {
    private Scanner s;
    private String[] operators;
    private ArrayList<String> a;
    private ArrayList<String> b;
    public static void main(String[] args) {
        polishParser parser = new polishParser();
        Stack<Integer> pars = new Stack<>(); // stack to use to evaluate notation if there are more than three elements
        String oper ="-+x";
        String inp = parser.s.nextLine(); // store user input as string
        String[] f= inp.split("\\s+"); // eliminate empty spaces and store values in array
        // Base case if one or two inputs are put in by the user returns a number //#endregion
        //if its the first or only input or returns an invalid input message.//#endregion
            try {
                if(f.length < 3) {
               System.out.println(Integer.parseInt(f[0]));
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input");
            }
        // populate two arrays one to be used if elements more than three otherwise use the other
        for(int i=(f.length-1); i>=0 ; i--) {
            parser.a.add(f[i]);}
        for(int i=0; i< f.length; i++) {
            parser.b.add(f[i]);
    }

    int i =0;// initialise i
    int basic=3;// to test if elements are more than three
        //runs when elements are more than three
        //prints last value in stack of type int
        if ((parser.a.size() - i) >= basic) {
            for( i=0; i< parser.a.size(); i++) {
                // check if value in array is an operator
                if (!oper.contains(parser.a.get(i))) {
                    pars.push(Integer.parseInt(parser.a.get(i)));
                }
                // compute algorithm to evaluate user input
                if (parser.a.get(i).equals(parser.operators[0])) {
                    int a = pars.pop();
                    int b = pars.pop();
                    pars.push(parser.add(a, b));
                }
                if (parser.a.get(i).equals(parser.operators[1])) {
                    int a = pars.pop();
                    int b = pars.pop();
                    pars.push(parser.subtr(a, b));
                }
                if (parser.a.get(i).equals(parser.operators[2])) {
                    int a = pars.pop();
                    int b = pars.pop();
                    pars.push(parser.mult(a, b));
                }
            }

            System.out.println(pars.pop());
            }
        
            
        }
    



    /**
     *Initialise fields/ construct fields
     *
     *
     */
    public polishParser() {
        a = new ArrayList<>();
        b = new ArrayList<>();
        s = new Scanner(System.in);
        // operators of fixed array
        operators = new String[3];
        operators[0] = "+";
        operators[1] = "-";
        operators[2] = "x";
    }

    /**
     * Method add computes sum of two integers
     * format(l + r) from infix notation
     * @param x left operand.... from infix notation
     * @param y right operand....------
     * @return sum of left and right operand of type int
     */

    private int add(int x, int y) {
        return x + y;
    }
    /**
     * Method mult computes sum of two integers
     * format(l * r) from infix notation
     * @param x left operand.... from infix notation
     * @param y right operand....------
     * @return multiplication of left and right operand of type int
     */
    private int mult(int x, int y) {
        return x * y;
    }

    /**
     * Method subtr computes sum of two integer.
     * format(x - y) from infix notation
     * @param x left operand.... from infix notation
     * @param y right operand....------
     * @return subtraction of left and right operand of type int
     */

    private int subtr(int x, int y) {
        return x - y;
    }
}
