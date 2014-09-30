package Aufgabe2;

import java.util.function.Function;

import Tree.Node;

public class MathUtilities {
	
	/**
	 * Integrates the function f from start to end with the accuracy of granularity.
	 * @param f Function to integrate
	 * @param start Start of integration
	 * @param end End of integration
	 * @param granularity Number of steps taken to integrate. This may affect the outcome heavily!
	 * @return
	 */
	public static double intigrate(Function<Double, Double> f, double start, double end, double granularity) {
		double akku = 0;
		double size = end - start;
		double stepSize = size / granularity;
		
		if(size == 0d) {
			return 0d;
		}
		
		for(double a = start; a < end; a += stepSize ) {
			akku += stepSize * ((f.apply(a) + f.apply(a + stepSize)) / 2);
		}
		
		return akku;
	}
	
	public static Node differentiate(Node root) {
		if(root.getValue().equals("+") || root.getValue().equals("-")) {	//Summenregel aufrufen
			root.applyOnNode(node -> {
				node.setLeftChild(differentiate(node.getLeftChild()));
				node.setRightChild(differentiate(node.getRightChild()));
				return node;
			});
		} else if (root.getValue().equals("*")) {							//Produktregel aufrufen
			root.applyOnNode(node -> {
				Node left1 = new Node(node.getLeftChild());
				Node left2 = new Node(node.getLeftChild());
				Node right1 = new Node(node.getRightChild());
				Node right2 = new Node(node.getRightChild());
				node.setLeftChild(
						new Node("*", 
								left1, 
								differentiate(right1)));
				node.setRightChild(
						new Node("*", 
								differentiate(left2), 
								right2));
				return node;
			});
		} else if (root.getValue().equals("/")) {							//Divisionsregel aufrufen
			root.applyOnNode(node -> {
				Node left1 = new Node(node.getLeftChild());
				Node left2 = new Node(node.getLeftChild());
				Node right1 = new Node(node.getRightChild());
				Node right2 = new Node(node.getRightChild());
				Node right3 = new Node(node.getRightChild());
				Node right4 = new Node(node.getRightChild());
				
				node.setLeftChild(new Node("-", 
						new Node("*", 
								differentiate(left1), 
								right1), 
						new Node("*", 
								left2, 
								differentiate(right2))));
				node.setRightChild(new Node("*", right3, right4));
				return node;
			});
		} else if(root.isLeaf()) {											//Blattregel aufrufen
			root.applyOnNode(node -> {
				if(node.getValue().matches("[0-9]+")) {
					node.setValue("0");
				} else {
					node.setValue("1");
				}
				return node;
			});
		} else {															//Funktionsregel aufrufen
			
		}
		
		return root;
	}
	//Kettenregel, Produktregel, Summenregel
}
