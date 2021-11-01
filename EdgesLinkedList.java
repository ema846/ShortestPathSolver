package nz.ac.auckland.softeng281.a4;

/**
 * The Linked List Class has only one head pointer to the start edge (head)
 * Edges are indexed starting from 0. The list goes from 0 to size-1. Note that
 * the List does not have a maximum size.
 *
 * @author Partha Roop
 */
public class EdgesLinkedList {
	// the head of the linked list
	private Edge headEdge;
	private Edge tailEdge;
	private int length;

	public EdgesLinkedList() {
		headEdge = null;
		tailEdge = null;
		length = 0;
	}

	// return the head edge
	public Edge getHeadEdge() {
		return headEdge;
	}
	
	// return the head edge
	public Edge getTailEdge() {
		return tailEdge;
	}

	/**
	 * This method adds an edge as the start edge of the list
	 *
	 * @param edge to prepend
	 */
	public void prepend(Edge edge) {
		// if the linked list is empty, assign input edge to head edge and tail edge
		if (headEdge == null) {
			headEdge = edge;
			tailEdge = edge;
		} else {
			// if its not empty, set the next edge of input to current head edge and assign
			// head edge with input edge
			edge.setNext(headEdge);
			headEdge = edge;
		}
		// increment length
		length++;
	}

	/**
	 * This method adds an edge as the end edge of the list
	 *
	 * @param edge to append
	 */
	public void append(Edge edge) {
		// if the linked list is empty, assign input edge to head edge and tail edge
		if (headEdge == null) {
			headEdge = edge;
			tailEdge = edge;
		} else {
			// if its not empty, set the input edge to the next edge of current tail edge
			// and assign the input edge to tail edge
			tailEdge.setNext(edge);
			tailEdge = edge;
		}
		// increment length
		length++;
	}

	/**
	 * This method gets the edge at a given position
	 *
	 * @param pos: an integer, which is the position
	 * @return the Edge at the position pos
	 */
	public Edge get(int pos) throws InvalidPositionException {
		if (pos < 0 || pos > size() - 1) {
			throw new InvalidPositionException("Position " + pos + " outside the list boundary");
		}
		// iterate the linked list "pos" number of times to get the edge at "pos"
		// position
		Edge output = headEdge;
		for (int i = 0; i < pos; i++) {
			output = output.getNext();
		}
		return output;
	}

	/**
	 * This method adds an edge at a given position in the List
	 *
	 * @param pos:  an integer, which is the position
	 * @param edge: the edge to add
	 * @throws InvalidPositionException
	 */
	public void insert(int pos, Edge edge) throws InvalidPositionException {
		if (pos < 0 || pos > size() - 1) {
			throw new InvalidPositionException("Position " + pos + " outside the list boundary");
		}
		// if pos equals zero, its equivalent to prepend method
		if (pos == 0) {
			prepend(edge);
		} else {
			// otherwise, iterate to the edge before position "pos"
			Edge frontEdge = headEdge;

			for (int i = 0; i < pos - 1; i++) {
				frontEdge = frontEdge.getNext();
			}
			// set the input edge's next edge to current edge's next edge
			edge.setNext(frontEdge.getNext());
			// and set the current edge's next edge to inputn edge
			frontEdge.setNext(edge);
			// increment length
			length++;
		}
	}

	/**
	 * This method removes an edge at a given position
	 *
	 * @param pos: an integer, which is the position
	 */
	public void remove(int pos) throws InvalidPositionException {
		if (pos < 0 || pos > size() - 1) {
			throw new InvalidPositionException("Position " + pos + " outside the list boundary");
		}
		// if pos equals zero, set head edge to head edge's next edge
		if (pos == 0) {
			headEdge = headEdge.getNext();
			// if pos equals length-1, set head edge to head edge's next edge
		} else if(pos == size()-1) {
			Edge connect = headEdge;

			for (int i = 0; i < size() - 2; i++) {
				connect = connect.getNext();
			}
			tailEdge = connect;
		}
			else {
			// otherwise, iterate to the edge before position "pos"
			Edge connect = headEdge;

			for (int i = 0; i < pos - 1; i++) {
				connect = connect.getNext();
			}
			// set current edge's next edge to second edge after current edge
			connect.setNext(connect.getNext().getNext());
		}
		// decrement length
		length--;
	}

	/**
	 * This method returns the size of the Linked list
	 *
	 * @return the size of the list
	 */

	public int size() {
		return length;
	}

	/**
	 * This method is used for printing the data in the list from head till the last
	 * node
	 */
	public void print() {
		Edge edge = headEdge;
		while (edge != null) {
			System.out.println(edge);
			edge = edge.getNext();
		}
	}
}
