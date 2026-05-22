package pr5.io.app;

import java.io.*;
import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        Map<String, Integer> freq = new TreeMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String ln;
            while ((ln = br.readLine()) != null) {
                for (String w : ln.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", "").split("\\s+")) {
                    if (!w.isEmpty()) freq.merge(w, 1, Integer::sum);
                }
            }
        } catch (IOException e) {
            System.out.println("Read error: " + e.getMessage());
            return;
        }

        List<Map.Entry<String, Integer>> lst = new ArrayList<>(freq.entrySet());
        lst.sort((a, b) -> b.getValue() - a.getValue());

        try (PrintWriter pw = new PrintWriter(new FileWriter("report.txt"))) {
            for (Map.Entry<String, Integer> e : lst) pw.println(e.getKey() + ": " + e.getValue());
        } catch (IOException e) {
            System.out.println("Write error: " + e.getMessage());
        }

        System.out.println("Done -> report.txt");
    }
}
