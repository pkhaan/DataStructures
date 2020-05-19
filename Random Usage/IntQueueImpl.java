import java.io.PrintStream;
import java.util.NoSuchElementException;

public class IntQueueImpl<T> implements IntQueue<T> {

	private int queueSize; // number of elements in queue
	private Node head; // first element of queue
	private Node tail; // last element of queue

	private class Node {
		T item;
		Node next;

		Node(T item) {
			this.item = item;
			next = null;
		}
	}

	public boolean isEmpty() {

		return head == null;
	}

	public void put(T item) {

		Node t = tail;
		tail = new Node(item);
		if (isEmpty())
			head = tail;
		else
			t.next = tail;
		queueSize++;

	}

	public T get() throws NoSuchElementException {

		if (isEmpty()) throw new NoSuchElementException();
		T v = head.item;
		Node t = head.next;
		head = t;
		queueSize--;
		return v;
		

	}

	public T peek() throws NoSuchElementException {
		if (isEmpty()) throw new NoSuchElementException();
		return head.item;
	}

	public void printQueue(PrintStream stream) {
		if (isEmpty())
			stream.println("The queue is empty");
		else {
			Node x = head;
			System.out.print("{");
			while (x != null) {
				stream.print(x.item + " ");
				x = x.next;
			}
			System.out.println("}");
		}
	}

	public int size() {
		return queueSize;
	}
}