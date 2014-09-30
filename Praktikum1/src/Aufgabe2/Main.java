package Aufgabe2;

import Tree.Node;

public class Main {

	public static void main(String[] args) {
		Node root = new Node("/");
		root.setLeftChild(new Node("x"));
		root.setRightChild(new Node("x"));
		System.out.println(root);
		MathUtilities.differentiate(root);
		System.out.println(root);
	}

}
