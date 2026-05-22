package Practice4.bonus.main;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
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
