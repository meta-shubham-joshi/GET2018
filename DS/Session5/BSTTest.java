package question;

import static org.junit.Assert.*;

import org.junit.Test;

public class BSTTest {

	@Test
	public void testAddNodePass() {

		String filePath = "C:\\Users\\User28\\workspace\\DS-Session5\\src\\question\\pairs.json";

		BST bst = new BST(filePath);

		Node obj3 = new Node(3, "ram");
		Node obj4 = new Node(4, "komal");

		// Adding nodes to the BST.
		Node obj1 = bst.add(obj3, bst.root);
		Node obj2 = bst.add(obj4, bst.root);

		assertEquals(obj3.getValue(), bst.getValue(3, bst.root));
		assertEquals(obj4.getValue(), bst.getValue(4, bst.root));

	}

	@Test
	public void testAddNodeFail() {

		String filePath = "C:\\Users\\User28\\workspace\\DS-Session5\\src\\question\\pairs.json";

		BST bst = new BST(filePath);

		Node obj3 = new Node(3, "ram");
		Node obj4 = new Node(4, "komal");

		// Adding nodes to the BST.
		Node obj1 = bst.add(obj3, bst.root);
		Node obj2 = bst.add(obj4, bst.root);

		assertNotEquals(obj4.getValue(), bst.getValue(3, bst.root));
		assertNotEquals(obj3.getValue(), bst.getValue(4, bst.root));

	}
}
