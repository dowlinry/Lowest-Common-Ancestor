import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LowestCommonAncestorTest {

	@Test
	void testEmptyTree() {
		LowestCommonAncestor testTree = new LowestCommonAncestor();
		assertEquals("This answer should be -1",-1,testTree.findLCA(3,4));
	}

}
