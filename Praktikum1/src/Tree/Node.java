package Tree;

import java.util.function.*;

public class Node {
	
	private String value;
	
	private Node leftChild;
	private Node rightChild;
	
	private boolean alreadyDifferenciated = false;

	public Node(String value) {
		this.value = value;
	}
	
	public Node(String value, Node rightChild, Node leftChild) {
		this.value = value;
		this.rightChild = rightChild;
		this.leftChild = leftChild;
	}
	
	public Node(Node other) {
		this.value = new String(other.getValue());
		
		if(other.getLeftChild() != null) {
			this.leftChild = new Node(other.getLeftChild());
		}
		if(other.getRightChild() != null) {
			this.rightChild = new Node(other.getRightChild());
		}
	}
	
	public void applyOnValues(Function<String, String> f) {
		value = f.apply(value);
		if(leftChild != null) {
			leftChild.applyOnValues(f);
		}
		if(rightChild != null) {
			rightChild.applyOnValues(f);
		}
	}
	
	public void applyOnNode(Function<Node, Node> f) {
		f.apply(this);
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
	
	public boolean isNode() {
		return leftChild != null || rightChild != null;
	}
	
	public boolean isLeaf() {
		return leftChild == null && rightChild == null;
	}
	
	public boolean isAlreadyDifferenciated() {
		return alreadyDifferenciated;
	}

	public void setAlreadyDifferenciated(boolean alreadyDifferenciated) {
		this.alreadyDifferenciated = alreadyDifferenciated;
	}
	
	@Override
	public String toString() {
		return value + " [" + leftChild + ", " + rightChild + "]";
	}
}
