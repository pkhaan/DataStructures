/**
 * @author peter_000
 */
package anubis.util.api;

/**
 * Elemental Structural group of objects that
 * contains three fundamental operations: search , removal and insertion
 *  
 */
public interface Collection {
	/**
	 * Adds an object in this Collection
	 * @param object the object to add
	 * @return true iff the object was added
	 */
     boolean add(Object object);
     /**
      * Removes an object from the Collection
      * @param object The Object to remove
      * @return true iff the object was added
      * 
      */
     boolean remove(Object object);
     /**
      * Searches for an object in the Collection.
      * @param object The object to search for
      * @return true iff there is an object o 
      * that element.equals(o)
      *
      */
     boolean contains(Object object);
     
     /**
      * the size of the collection
      */
     int size();
     /**
      * if collection is empty
      */
     boolean isEmpty();
     /**
      * removes all objects from stored in the collection
      */
     void clear();
     /**
      * Check if provided collection is a Genuine Superset
      * @param c Another Collection
      * return true if this instance contains every element in c
      */
     boolean containsAll(Collection c);
     /**Union
      * @param c
      **/
     void addAll(Collection c);
     /**Difference
      * @param c Another Collection
      */
     void removeAll(Collection c);
     /**Intersection
      * @param c Another Collection
      *
      */
     void retainAll(Collection c);
     /**Creates an enumerator of the collection
      * @return An Enumerator of the Collection
      * 
      */
     Enumerator enumerator();
	@Override
	int hashCode();
	@Override
	boolean equals(Object obj);
	Object clone() throws CloneNotSupportedException;
	@Override
	String toString();
	void finalize() throws Throwable;
}

