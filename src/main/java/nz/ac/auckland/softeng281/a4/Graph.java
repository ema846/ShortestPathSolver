package nz.ac.auckland.softeng281.a4;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**
 * You cannot add new fields.
 */
public class Graph {

	/**
	 * Each node maps to a list of all the outgoing edges from that node
	 */
	private HashMap<Node, EdgesLinkedList> adjacencyMap;
	/**
	 * root of the graph, to know where to start the DFS or BFS
	 */
	private Node root;

	/**
	 * !!!!!! You cannot change this method !!!!!!!
	 */
	public Graph(List<String> edges, List<String> weights) {
		if (edges.isEmpty() || weights.isEmpty()) {
			throw new IllegalArgumentException("edges and weights are empty");
		}
		adjacencyMap = new HashMap<>();
		int i = 0;
		for (String edge : edges) {
			String[] split = edge.split(",");
			Node source = new Node(split[0]);
			Node target = new Node(split[1]);
			Edge edgeObject = new Edge(source, target, Integer.parseInt(weights.get(i)));
			if (!adjacencyMap.containsKey(source)) {
				adjacencyMap.put(source, new EdgesLinkedList());
			}
			adjacencyMap.get(source).append(edgeObject);
			if (i == 0) {
				root = source;
			}
			i++;
		}
	}

	/**
	 * find a particular node, note that a node might not have outgoing edges but
	 * only ingoing edges so you need to check also the target nodes of the edges
	 *
	 * @param node
	 * @return true if adjacencyMap contains the node, false otherwise.
	 */
	public boolean isNodeInGraph(Node node) {
		// loop through the values of the hashmap, which contains all edges
		for (EdgesLinkedList expectedValue : adjacencyMap.values()) {
			// for each value(linked list), assign an edge to the head edge
			Edge expectedEdge = expectedValue.getHeadEdge();
			// while the linked list is not empty, loop through each edge
			// and compare its source and target nodes to the input node
			while (expectedEdge != null) {
				if (expectedEdge.getTarget().equals(node) || expectedEdge.getSource().equals(node)) {
					// if it does contain input node, return true
					return true;
				}
				expectedEdge = expectedEdge.getNext();
			}
		}
		// return false if no such node was found
		return false;
	}

	/**
	 * This method finds an edge with a specific weight, if there are more than one
	 * you need to return the first you encounter. You must use Breath First Search
	 * (BFS) strategy starting from the root.
	 * <p>
	 * You can create a data structure to keep track of the visited nodes Set<Node>
	 * visited = new HashSet<>(); If you don't keep track of the visited nodes the
	 * method will run forever!
	 * <p>
	 * <p>
	 * In addition to the data structure visited you can only create new
	 * datastructures of type EdgesLinkedList and NodesStackAndQue
	 *
	 * @param weight
	 * @return the Edge with the specific weight, null if no edge with the specif
	 *         weight exists in teh graph
	 */
	public Edge searchEdgeByWeight(int weight) {
		// create a queue and a visited list
		NodesStackAndQueue visited = new NodesStackAndQueue();
		NodesStackAndQueue queue = new NodesStackAndQueue();

		// insert the root into queue and visited list
		queue.push(root);
		visited.push(root);

		// initialize a node and assign it with the root node
		Node currentNode = root;

		// while the queue is not empty
		while (!queue.isEmpty()) {
			// assign the current node to the first node in the queue
			// and remove the first node in the queue
			currentNode = queue.pop();
			
			// initialize a edge linked list to contain the value of the current node
			EdgesLinkedList list = adjacencyMap.get(currentNode);

			// initialize an edge to contain the head edge of the linked list
			Edge currentEdge = list.getHeadEdge();

			// while current edge is not null
			while (currentEdge != null) {

				// if the target node of the current edge is not in the list
				// then add it to the back of queue and visited list
				if (!visited.getList().contains(currentEdge.getTarget())) {
					visited.append(currentEdge.getTarget());
					queue.append(currentEdge.getTarget());
				}

				// if the current edge contains the input weight
				// then return its edge
				if (currentEdge.getWeight() == weight) {
					return currentEdge;
				}
				currentEdge = currentEdge.getNext();
			}
		}
		// if no such edge was found, return null
		return null;
	}

	/**
	 * Returns the weight of the Edeg with Node source and Node target if the given
	 * Edge is inside the graph. If there is no edge with the specified source and
	 * target, the method returns -1 You must use Depth First Search (DFS) strategy
	 * starting from the root.
	 * <p>
	 * RULES You can create a data structure to keep track of the visited nodes
	 * Set<Node> visited = new HashSet<>(); If you don't keep track of the visited
	 * nodes the method will run forever!
	 * <p>
	 * In addition to the data structure visited you can only create new data
	 * structures of type
	 * <p>
	 * NodesStackAndQueue and EdgesLinkedList
	 *
	 * @param source
	 * @param target
	 * @return the weight of the first encountered edge with source and target, -1
	 *         if no edge with the given source and target exists
	 */
	public int searchWeightByEdge(Node source, Node target) {
		// create a stack and a visited list
		NodesStackAndQueue visited = new NodesStackAndQueue();
		NodesStackAndQueue stack = new NodesStackAndQueue();

		// insert the root into stack and visited list
		stack.push(root);
		visited.push(root);

		// initialize a node and assign it with the root node
		Node currentNode = root;

		// while stack is not empty
		while (!stack.isEmpty()) {
			// assign the current node to the first node in the stack
			// and remove the first node in the stack
			currentNode = stack.pop();

			// add the current node into visited list
			if (!visited.getList().contains(currentNode)) {
				visited.push(currentNode);
			}

			// initialize a edge linked list to contain the value of the current node
			EdgesLinkedList list = adjacencyMap.get(currentNode);

			// initialize an edge to contain the head edge of the linked list
			Edge currentEdge = list.getHeadEdge();

			// while current edge is not null
			while (currentEdge != null) {
				// if the visited list does not contain target node of the current edge
				// then add the target node in the front of the stack
				if (!visited.getList().contains(currentEdge.getTarget())) {
					stack.push(currentEdge.getTarget());
				}

				// if the current edge contains input source and target nodes
				// then return its weight
				if (currentEdge.getSource().equals(source) && currentEdge.getTarget().equals(target)) {
					return currentEdge.getWeight();
				}
				currentEdge = currentEdge.getNext();
			}
		}
		// if no such edge was found, return -1
		return -1;
	}

	/**
	 * Given a source Node and a target Node it returns the shortest path between
	 * source and target
	 * <p>
	 * A Path is represented as an ordered sequence of nodes, together with the
	 * total weight of the path. (see Path.java class)
	 *
	 * @param source
	 * @param target
	 * @return the shortest path between source and target
	 */
	public Path computeShortestPath(Node source, Node target) {
		//if the target node is the source node, then the distance is 0,
		//regardless of whether a self-loop exists or not
		if(source.equals(target)) {
			List sameNodes = new ArrayList<Node>();
			sameNodes.add(source);
			sameNodes.add(target);
			Path outputSame = new Path(0, sameNodes);
			return outputSame;
		}
		// create a queue and two hash maps which takes in node as key
		// and integer/node as value respectively
		NodesStackAndQueue queue = new NodesStackAndQueue();
		HashMap<Node, Integer> distance = new HashMap<Node, Integer>();
		HashMap<Node, Node> prev = new HashMap<Node, Node>();

		// insert all nodes in the graph into distance hash map as key and set
		// corresponding value to infinite; into queue; into prev as key and
		// set corresponding value to null
		for (EdgesLinkedList list : adjacencyMap.values()) {
			Edge setupEdge = list.getHeadEdge();

			if (!distance.containsKey(setupEdge.getSource())) {
				distance.put(setupEdge.getSource(), Integer.MAX_VALUE);
				queue.append(setupEdge.getSource());
				prev.put(setupEdge.getSource(), null);
			}
			if (!distance.containsKey(setupEdge.getTarget())) {
				distance.put(setupEdge.getTarget(), Integer.MAX_VALUE);
				queue.append(setupEdge.getTarget());
				prev.put(setupEdge.getTarget(), null);
			}
		}

		// initialize a node to input source node
		Node currentNode = source;

		// set current node's value in distance to 0
		distance.replace(currentNode, 0);

		// while queue is not empty
		while (!queue.isEmpty()) {

			// remove the current node from queue
			queue.delete(currentNode);

			// if current node has an outgoing edge
			// then initialize an edge to its head edge
			if (adjacencyMap.containsKey(currentNode)) {
				Edge currentEdge = adjacencyMap.get(currentNode).getHeadEdge();

				// while the current edge is not null
				while (currentEdge != null) {
					// ignoring self-loops, if the new distance (sum of distance between current
					// node to its target node
					// and distance between the current node from the root) is smaller than the
					// distance between the root
					// to the target node, then set the distance of the target node to the new
					// distance and set the previous
					// node fo the target node to current node
					if (!currentEdge.getSource().equals(currentEdge.getTarget())
							&& (currentEdge.getWeight() + distance.get(currentEdge.getSource())) < distance
									.get(currentEdge.getTarget())) {
						distance.replace(currentEdge.getTarget(),
								currentEdge.getWeight() + distance.get(currentEdge.getSource()));
						prev.replace(currentEdge.getTarget(), currentNode);
						currentEdge = currentEdge.getNext();
					} else {
						currentEdge = currentEdge.getNext();
					}
				}

				// set the current node to the node in the queue with the shortest distance from
				// root
				int minIndex = 0;
				if (queue.size() != 0) {
					for (int i = 1; i < queue.size(); i++) {
						if (distance.get(queue.getList().get(i)) < distance.get(queue.getList().get(minIndex))) {
							minIndex = i;
						}
					}
					currentNode = queue.getList().get(minIndex);
				}
			}
		}

		// construct the path and return it
		List nodes = new ArrayList<Node>();
		int totalCost = distance.get(target);
		while (target != null) {
			nodes.add(0, target);
			target = prev.get(target);
		}
		Path output = new Path(totalCost, nodes);
		return output;
	}

}
