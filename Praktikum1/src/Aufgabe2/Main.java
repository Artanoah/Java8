package Aufgabe2;

import Tree.Node;

public class Main {

	public static void main(String[] args) {
		Node root = new Node("/");
		root.setLeftChild(new Node("+", new Node("cos", new Node("x1")), new Node("z1")));
		root.setRightChild(new Node("*", new Node("y2"), new Node("-cos", new Node("x2"))));
		System.out.println(root);
		MathUtilities.differentiate(root);
		System.out.println(root);
	}
}
