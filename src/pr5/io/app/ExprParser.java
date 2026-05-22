package pr5.io.app;

import java.io.*;
import java.util.*;

public class ExprParser {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new FileReader("expressions.txt"));
            PrintWriter res = new PrintWriter(new FileWriter("results.txt"));
            PrintWriter log = new PrintWriter(new FileWriter("log.txt"))
        ) {
            String ln;
            while ((ln = br.readLine()) != null) {
                ln = ln.trim();
                if (ln.isEmpty()) continue;
                try {
                    res.println(ln + " = " + eval(ln));
                } catch (Exception e) {
                    log.println("ERROR [" + ln + "]: " + e.getMessage());
                }
            }
        }
        System.out.println("Done -> results.txt, log.txt");
    }

    private static double eval(String expr) {
        StringTokenizer st = new StringTokenizer(expr, "+-*/", true);
        double a = parseNum(expr, st.nextToken().trim());
        if (!st.hasMoreTokens()) throw new NoSuchElementException("missing operator");
        String op = st.nextToken().trim();
        if (!st.hasMoreTokens()) throw new NoSuchElementException("missing second operand in: " + expr);
        double b = parseNum(expr, st.nextToken().trim());
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new UnsupportedOperationException("unknown operator: " + op);
        };
    }

    private static double parseNum(String expr, String s) {
        if (s.isEmpty()) throw new NoSuchElementException("missing operand in: " + expr);
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("invalid number '" + s + "' in: " + expr);
        }
    }
}
