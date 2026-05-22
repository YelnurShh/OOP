package pr4.interfaces.main;

import pr4.interfaces.model.*;
import pr4.interfaces.services.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Problem 2
        Restaurant r = new Restaurant();
        r.servePizza(new Cat());
        r.servePizza(new Student("Aibek", 3.5));

        // Problem 3
        App app = new App();
        app.getStatistics(new LogicGame());
        app.getStatistics(new MemoryGame());

        iPhone ip = new iPhone();
        ip.sell();
        ip.plug();

        // Problem 4
        List<Student> list = new ArrayList<>();
        list.add(new Student("Zara", 3.2));
        list.add(new Student("Aibek", 3.8));
        list.add(new Student("Mira", 2.9));

        Collections.sort(list);
        System.out.println("By GPA: " + list);

        Collections.sort(list, new NameComparator());
        System.out.println("By name: " + list);

        // Bonus
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        int[] cnt = new int[11];
        for (int x : arr) cnt[x]++;
        int[] sorted = new int[arr.length];
        int i = 0;
        for (int v = 0; v <= 10; v++)
            for (int j = 0; j < cnt[v]; j++)
                sorted[i++] = v;
        System.out.println("Sorted: " + Arrays.toString(sorted));
    }
}
