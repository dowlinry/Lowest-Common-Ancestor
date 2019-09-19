import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LowestCommonAncestorTest {

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

}
