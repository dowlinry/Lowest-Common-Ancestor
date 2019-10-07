import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LowestCommonAncestorTest {
	//Tests for Binary Search Trees
	@Test
	void testEmptyTree() {
		LowestCommonAncestor testTree = new LowestCommonAncestor();
		assertEquals("This answer should be -1",-1,testTree.findLCA(3,4));
	}
	
	@Test
	void testAllRightTree() {
		LowestCommonAncestor testTree = new LowestCommonAncestor();
		testTree.root = new Node(0);
		testTree.root.right = new Node(1);
		testTree.root.right.right = new Node(2);
		testTree.root.right.right.right = new Node(3);
		assertEquals("This answer should be 2", 2 ,testTree.findLCA(2, 3));
	}

	@Test
	void testAllLeftTree() {
		LowestCommonAncestor testTree = new LowestCommonAncestor();
		testTree.root = new Node(0);
		testTree.root.left = new Node(1);
		testTree.root.left.left = new Node(2);
		testTree.root.left.left.left = new Node(3);
		assertEquals("This answer should be 1", 1 ,testTree.findLCA(1, 3));
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
        assertEquals("This answer should be 0",0,testTree.findLCA(1, 5));
  
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
		assertEquals("This answer should be 0", 0 , testTree.findLCA(10, 2));
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
		assertEquals("This answer should be 5",5,testTree.findLCA(6, 10));
	}
	
	//Tests for Directed Acyclic Graphs from here down
	//
	@Test
	void emptyGraph(){
		DAGraph testGraph = new DAGraph(0);
		assertTrue("List should be empty",testGraph.lowestCommonAncestor(2, 1).isEmpty());
	}

}
