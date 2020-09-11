package intlist;

import java.util.ArrayList;

// Checkstyle will report an error with this line:
import java.util.List;

public class SanityCheck {
    public static void main(String[] args) {
        // The following line of code should compile only if you correctly installed Java 11 or higher.
        System.out.println("Java 11 or above is correctly installed: " + " ".isBlank());

        // The following four lines should run, but checkstyle should complain about style errors in each lines.
        // TODO: checkstyle will flag all todos as errors
        ArrayList<String> a = new ArrayList<>();
        a.add("test"); // Deliberately long line: ............................................................................................... end
        System.out.println( !a.isEmpty());

        // The following line should produce an error when not commented.
        // List l = new ArrayList();

        System.out.println("Sanity check complete: everything seems to have been configured correctly!");
    }
}
