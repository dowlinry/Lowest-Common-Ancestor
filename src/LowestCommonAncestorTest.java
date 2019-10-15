import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class LowestCommonAncestorTest {
	// Tests for Binary Search Trees
	@Test
	void testEmptyTree() {
		LowestCommonAncestor testTree = new LowestCommonAncestor();
		assertEquals("This answer should be -1", -1, testTree.findLCA(3, 4));
	}

	@Test
	void testAllRightTree() {
		LowestCommonAncestor testTree = new LowestCommonAncestor();
		testTree.root = new Node(0);
		testTree.root.right = new Node(1);
		testTree.root.right.right = new Node(2);
		testTree.root.right.right.right = new Node(3);
		assertEquals("This answer should be 2", 2, testTree.findLCA(2, 3));
	}

	@Test
	void testAllLeftTree() {
		LowestCommonAncestor testTree = new LowestCommonAncestor();
		testTree.root = new Node(0);
		testTree.root.left = new Node(1);
		testTree.root.left.left = new Node(2);
		testTree.root.left.left.left = new Node(3);
		assertEquals("This answer should be 1", 1, testTree.findLCA(1, 3));
	}

	@Test
	void testTree1() {
		LowestCommonAncestor testTree = new LowestCommonAncestor();
		testTree.root = new Node(0);
		testTree.root.left = new Node(1);
		testTree.root.right = new Node(2);
		testTree.root.left.left = new Node(3);
		testTree.root.left.right = new Node(4);
		testTree.root.right.left = new Node(5);
		testTree.root.right.right = new Node(6);
		assertEquals("This answer should be 0", 0, testTree.findLCA(1, 5));

	}

	@Test
	void testTree2() {
		LowestCommonAncestor testTree = new LowestCommonAncestor();
		testTree.root = new Node(0);
		testTree.root.left = new Node(1);
		testTree.root.left.left = new Node(2);
		testTree.root.left.left.left = new Node(3);
		testTree.root.left.left.left.right = new Node(4);
		testTree.root.left.left.right = new Node(5);
		testTree.root.right = new Node(6);
		testTree.root.right.right = new Node(7);
		testTree.root.right.right.left = new Node(8);
		testTree.root.right.right.left.left = new Node(9);
		testTree.root.right.right.left.right = new Node(10);
		assertEquals("This answer should be 0", 0, testTree.findLCA(10, 2));
	}

	@Test
	void testTree3() {
		LowestCommonAncestor testTree = new LowestCommonAncestor();
		testTree.root = new Node(0);
		testTree.root.left = new Node(1);
		testTree.root.left.right = new Node(2);
		testTree.root.left.right.right = new Node(3);
		testTree.root.left.right.right.left = new Node(4);
		testTree.root.right = new Node(5);
		testTree.root.right.left = new Node(6);
		testTree.root.right.right = new Node(7);
		testTree.root.right.right.right = new Node(8);
		testTree.root.right.right.right.left = new Node(9);
		testTree.root.right.right.right.left.right = new Node(10);
		testTree.root.right.right.right.left.right.right = new Node(11);
		assertEquals("This answer should be 5", 5, testTree.findLCA(6, 10));
	}

	// Tests for Directed Acyclic Graphs from here down
	//
	@Test
	void emptyGraph() {
		DAGraph testGraph = new DAGraph(0);
		assertTrue("List should be empty", testGraph.lowestCommonAncestor(2, 1).isEmpty());
	}

	@Test
	void testOutOfRangeInputs() {
		DAGraph testGraph = new DAGraph(4);
		testGraph.addEdge(0, 1);
		testGraph.addEdge(0, 2);
		testGraph.addEdge(2, 3);

		assertTrue("Testing nodes that are out of range", testGraph.lowestCommonAncestor(69, 420).isEmpty());
	}

	@Test
	void testNegativeInputs() {
		DAGraph testGraph = new DAGraph(4);
		testGraph.addEdge(0, 1);
		testGraph.addEdge(0, 2);
		testGraph.addEdge(2, 3);

		assertTrue("Testing nodes that are negative", testGraph.lowestCommonAncestor(-69, -420).isEmpty());
	}

	@Test
	void testSingleReturnLCA() {
		DAGraph testGraph = new DAGraph(4);
		testGraph.addEdge(0, 1);
		testGraph.addEdge(0, 2);
		testGraph.addEdge(2, 3);

		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(0);

		assertTrue("Testing for singular return of LCA", testGraph.lowestCommonAncestor(3, 1).contains(result.get(0)));

	}

	@Test
	void testMultipleReturnLCA() {
		DAGraph testGraph = new DAGraph(7);

		testGraph.addEdge(0, 3);
		testGraph.addEdge(1, 3);
		testGraph.addEdge(1, 4);
		testGraph.addEdge(2, 5);
		testGraph.addEdge(2, 6);
		testGraph.addEdge(3, 5);
		testGraph.addEdge(3, 6);
		testGraph.addEdge(4, 6);

		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(3);
		result.add(2);

		assertTrue("Testing that there are multiple outputs",
				testGraph.lowestCommonAncestor(5, 6).size() == result.size());

		for (int i = 0; i < result.size(); i++) {
			assertTrue("Testing outputs are correct", testGraph.lowestCommonAncestor(5, 6).contains(result.get(i)));
		}

	}

	@Test
	void testNoResultLCA() {
		DAGraph testGraph = new DAGraph(7);

		testGraph.addEdge(1, 2);
		testGraph.addEdge(2, 3);
		testGraph.addEdge(3, 4);
		testGraph.addEdge(4, 5);
		testGraph.addEdge(1, 6);
		testGraph.addEdge(6, 7);
		testGraph.addEdge(7, 4);

		ArrayList<Integer> result = new ArrayList<Integer>();

		assertTrue("Testing that there are multiple outputs",
				testGraph.lowestCommonAncestor(3, 7).size() == result.size());
		
	}
}
