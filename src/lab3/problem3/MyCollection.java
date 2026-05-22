package lab3.problem3;

public interface MyCollection<E> {
	boolean add(E e);

	boolean remove(E e);

	boolean contains(E e);

	int size();

	boolean isEmpty();

	void clear();

	Object[] toArray();
}
