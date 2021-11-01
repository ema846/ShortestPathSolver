package nz.ac.auckland.softeng281.a4;

import java.util.ArrayList;

public class NodesStackAndQueue {

	private ArrayList<Node> list;

	public NodesStackAndQueue() {
		list = new ArrayList<Node>();
	}

	// returns the size of the queue/stack
	public int size() {
		return list.size();
	}

	// returns the list of nodes
	public ArrayList<Node> getList() {
		return list;
	}

	// return true if the queue/stack is empty, vice versa
	public boolean isEmpty() {
		return list.isEmpty();
	}

	// deletes a known node from the queue/stack
	public void delete(Node node) {
		list.remove(node);
	}

	/**
	 * Push operation refers to inserting an element on the Top of the stack.
	 *
	 * @param node
	 */
	public void push(Node node) {
		// add the node on top the queue/stack
		list.add(node);
	}

	/**
	 * pop an element from the top of the stack (removes and returns the tope
	 * element)
	 *
	 * @return
	 */
	public Node pop() {
		// fetch the top node and assign it to the output node
		String value = list.get(list.size() - 1).getValue();
		Node top = new Node(value);
		// delete the top node
		list.remove(list.size() - 1);
		return top;
	}

	/**
	 * get the element from the top of the stack without removing it
	 *
	 * @return
	 */
	public Node peek() {
		// return the top node
		return list.get(list.size() - 1);
	}

	/**
	 * append an element at the end of the stack
	 *
	 * @param node
	 */
	public void append(Node node) {
		// add the node at the end
		list.add(0, node);
	}

	public void print() {
		for (Node node : list) {
			System.out.println(node);
		}
	}
}
