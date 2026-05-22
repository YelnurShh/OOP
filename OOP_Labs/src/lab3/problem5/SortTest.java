package lab3.problem5;

import lab3.problem4.Employee;
import java.util.Arrays;
import java.util.Date;

public class SortTest {
    public static void main(String[] args) {
        Chocolate[] ch = { new Chocolate("Twix", 50), new Chocolate("Mars", 30), new Chocolate("Snickers", 60) };
        Sort.selectionSort(ch);
        System.out.println("Chocolates: " + Arrays.toString(ch));

        Time[] t = { new Time(12, 30, 0), new Time(8, 0, 0), new Time(10, 15, 30) };
        Sort.insertionSort(t);
        System.out.println("Times: " + Arrays.toString(t));

        Employee[] e = {
            new Employee("Charlie", 50000, new Date(), "I1"),
				new Employee("Alice", 70000, new Date(), "I2"),
            new Employee("Bob", 60000, new Date(), "I3")
        };
        Sort.selectionSort(e);
        System.out.println("Employees: " + Arrays.toString(e));
    }
}
