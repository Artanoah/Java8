package Tree;

import java.util.function.*;

/**
 * @author Steffen Giersch
 */
public class Node {
	
	private String value;
	
	private Node leftChild;
	private Node rightChild;

	/**
	 * Creates a new Object of type Node. The leftChild and rightChild are null.
	 * @param value Value of the node.
	 */
	public Node(String value) {
		this.value = value;
	}
	
	/**
	 * Creates a new Object of type Node. The rightChild is null. This Constructor should be used for unary functions.
	 * @param value Value of the Node
	 * @param leftChild Left child of the Node. This has to be of type Node, too.
	 */
	public Node(String value, Node leftChild) {
		this.value = value;
		this.leftChild = leftChild;
	}
	
	/**
	 * Creates a new Object of type Node.
	 * @param value Value of the Node.
	 * @param rightChild Right child of the Node. This has to be of type Node, too.
	 * @param leftChild Left child of the Node. This has to be of type Node, too.
	 */
	public Node(String value, Node rightChild, Node leftChild) {
		this.value = value;
		this.rightChild = rightChild;
		this.leftChild = leftChild;
	}
	
	/**
	 * Creates a new object of type Node. The new object is a deep copy of the argument other.
	 * @param other Node to duplicate.
	 */
	public Node(Node other) {
		this.value = new String(other.getValue());
		
		if(other.getLeftChild() != null) {
			this.leftChild = new Node(other.getLeftChild());
		}
		if(other.getRightChild() != null) {
			this.rightChild = new Node(other.getRightChild());
		}
	}
	
	/**
	 * Applies the given function f on every value in this node any every of its children
	 * @param f Function to apply on every value
	 */
	public void applyOnValues(Function<String, String> f) {
		value = f.apply(value);
		if(leftChild != null) {
			leftChild.applyOnValues(f);
		}
		if(rightChild != null) {
			rightChild.applyOnValues(f);
		}
	}
	
	/**
	 * Applies the given function f on this node. The Node this may be altered in the process
	 * @param f Function to apply on this
	 */
	public void applyOnNode(Function<Node, Node> f) {
		f.apply(this);
	}
	
	/**
	 * Determines if this Node is a node in the tree (has children).
	 * @return Returns "true" if this Node is node in the tree (has children)
	 */
	public boolean isNode() {
		return leftChild != null || rightChild != null;
	}
	
	/**
	 * Determines if this Node is a leaf (has no children).
	 * @return Returns "true" if this Node is leaf (has no children)
	 */
	public boolean isLeaf() {
		return leftChild == null && rightChild == null;
	}
	
	
	//##### Getter und Setter #####
	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	//#### toString Methoden #####
	@Override
	public String toString() {
		return value + (isLeaf() ? "" : " [" + 
				(leftChild == null ? "[]" : leftChild) + ", " +
				(rightChild == null ? "[]" : rightChild) + 
				"]");
	}
}
