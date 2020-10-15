import java.io.PrintStream;
import java.util.NoSuchElementException;

public class IntStackImpl<T> implements IntStack<T> {

	private Node head;
	private int stackSize;

	private class Node {
		T item;
		Node next;

		Node(T item, Node next) {
			this.item = item;
			this.next = next;
		}
	}

	@Override
	public boolean isEmpty() {
		return (head == null);
	}

	@Override
	public void push(T item) {
		head = new Node(item, head);
		stackSize++;
	}

	@Override
	public T pop() throws NoSuchElementException {
		T v = head.item;
		Node t = head.next;
		head = t;
		stackSize--;
		return v;
	}

	@Override
	public T peek() throws NoSuchElementException {
		if (isEmpty())
			throw new NoSuchElementException();
		return head.item;
	}

	@Override
	public void printStack(PrintStream stream) {
		if (isEmpty())
			stream.println("The stack is empty");
		else {
			Node x = head;
			while (x != null) {
				stream.println(x.item);
				x = x.next;
			}
		}
	}

	@Override
	public int size() {
		return stackSize;
	}

}
