package anubis.util.api;


/**
	 * An Enumerator is an object that knows how to treverse
	 * a collection in order to enumerate its elements/
	 */
public interface Enumerator {

	/**
	 * Tests whether there are more elements to enumerate/
	 * @return <code>true</code> iff there are more elements to enumerate/
	 */
	boolean hasNext();
	/**
	 * Advances to the next element in the collection being enumerated.
	 * @throws IllegalStateException When called while hasNext() is false.
	 * @return The next element in the collection being enuareted.
	 */
	Object next();
}
