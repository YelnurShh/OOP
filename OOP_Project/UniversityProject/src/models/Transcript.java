package models;

import java.io.Serializable;
import java.util.*;

public class Transcript implements Serializable {
    private static final long serialVersionUID = 1L;

    private Student student;
    private Map<Course, Mark> records = new LinkedHashMap<>();

    public Transcript(Student s) {
        this.student = s;
    }

    public void put(Course c, Mark m) {
        records.put(c, m);
    }

    public Map<Course, Mark> getRecords() { return records; }

    public double computeGpa() {
        if (records.isEmpty()) return 0;
        double total = 0;
        int totalCredits = 0;
        for (Map.Entry<Course, Mark> e : records.entrySet()) {
            int credits = e.getKey().getCredits();
            double gpaPoint = letterToGpa(e.getValue().getLetter());
            total += gpaPoint * credits;
            totalCredits += credits;
        }
        return totalCredits == 0 ? 0 : total / totalCredits;
    }

    private double letterToGpa(String letter) {
        switch (letter) {
            case "A":  return 4.0;
            case "A-": return 3.67;
            case "B+": return 3.33;
            case "B":  return 3.0;
            case "B-": return 2.67;
            case "C+": return 2.33;
            case "C":  return 2.0;
            case "C-": return 1.67;
            case "D+": return 1.33;
            case "D":  return 1.0;
            default:   return 0.0;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("===== Transcript of ").append(student.getName()).append(" =====\n");
        for (Map.Entry<Course, Mark> e : records.entrySet()) {
            sb.append(e.getKey()).append(" -> ").append(e.getValue()).append("\n");
        }
        sb.append("GPA: ").append(String.format("%.2f", computeGpa()));
        return sb.toString();
    }
}
