package lab3.problem5;

public class Sort {
	static <E> void swap(E[] a, int i, int j) {
		E t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	static <E extends Comparable<E>> void selectionSort(E[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++)
				if (a[j].compareTo(a[min]) < 0)
					min = j;
			swap(a, i, min);
		}
	}

	static <E extends Comparable<E>> void insertionSort(E[] a) {
		for (int i = 1; i < a.length; i++) {
			E k = a[i];
			int j = i - 1;
			while (j >= 0 && a[j].compareTo(k) > 0) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = k;
		}
	}
}
