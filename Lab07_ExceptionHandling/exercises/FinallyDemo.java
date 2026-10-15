// Challenge: return inside try, printing inside finally.
// Predict the output of each call BEFORE you run the program.
public class FinallyDemo {

    // Case 1: return in try, print in finally
    static int case1() {
        try {
            System.out.println("case1: in try");
            return 1;
        } finally {
            System.out.println("case1: in finally");
        }
    }

    // Case 2: finally changes the variable AFTER the return value was chosen
    static int case2() {
        int x = 10;
        try {
            return x;
        } finally {
            x = 99;
            System.out.println("case2: x changed to " + x + " in finally");
        }
    }

    // Case 3 (bad practice): a return inside finally replaces the try's return
    @SuppressWarnings("finally")
    static int case3() {
        try {
            return 1;
        } finally {
            return 3;
        }
    }

    public static void main(String[] args) {
        System.out.println("case1 returned " + case1());
        System.out.println("case2 returned " + case2());
        System.out.println("case3 returned " + case3());
    }
}
