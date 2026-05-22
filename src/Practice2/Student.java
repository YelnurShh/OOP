package Practice2;

public class Student {

    private String name;
    private int id;
    private double grade; 

    public Student(String name, int id,  double grade) {
        this.name = name;
        this.id = id;
        setGrade(grade);
    }


    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getGrade() {
        return grade;
    }


    public void setGrade(double grade) {
        if (grade < 0 || grade > 100) {
            System.out.println("Invalid grade! Setting to 0.");
            this.grade = 0;
        } else {
            this.grade = grade;
        }
    }

    public String toString() {
        return name + " (ID: " + id + ") - " + grade;
    }
}