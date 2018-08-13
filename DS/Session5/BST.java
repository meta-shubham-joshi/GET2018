package question;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.text.html.parser.Parser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class BST implements DictionaryInterface {

	public Node root;

	ArrayList<Node> sortedListValues = new ArrayList<Node>();
	ArrayList<Node> sortedListRangeValues = new ArrayList<Node>();

	/**
	 * Constructor to Initialize root of BST.
	 * 
	 * @param filepath
	 *            - path of JSon file.
	 */
	public BST(String filepath) {
		this.root = null;
		this.readJSon(filepath);
	}

	/**
	 * Read JSon file.
	 * 
	 * @param filepath
	 *            - Path of JSon file.
	 */
	public void readJSon(String filepath) {

		try {
			JSONParser parser = new JSONParser();
			Object object = parser.parse(new FileReader(filepath));
			JSONArray listOfObjects = (JSONArray) object;
			Iterator<JSONObject> itr = listOfObjects.iterator();

			while (itr.hasNext()) {
				JSONObject obj = itr.next();
				Node node = new Node(Integer.parseInt((String) obj.get("key")),
						(String) obj.get("value"));

				System.out.println(node.getKey() + "  :  " + node.getValue());
				this.add(node, root);
			}

		} catch (Exception e) {
			System.out.println(e);

		}

	}

	/**
	 * To add a node to the file.
	 * 
	 * @param node
	 *            - Node to be added
	 * @param root
	 *            - traversing node.
	 */
	public Node add(Node node, Node root) {

		if (this.root == null) {
			this.root = node;
			return this.root;
		}

		if (root == null) {
			return node;
		}
		if (node.getKey() < root.getKey()) {
			root.left = add(node, root.left);
		} else if (node.getKey() > root.getKey()) {
			root.right = add(node, root.right);
		}
		return root;
	}

	/**
	 * Finding minimum value in the node.
	 * 
	 * @param node
	 *            - Node address.
	 * @return return the node having minimum value.
	 */
	public Node findMin(Node node) {

		Node prev = null;
		while (node.left != null) {
			prev = node;
			node = node.left;
		}
		if (prev != null) {
			prev.left = null;
		}
		return node;
	}

	/**
	 * To delete a node.
	 * 
	 * @param key
	 *            - key of the node.
	 * @param root
	 *            - root of the node.
	 * @return the deleted node.
	 */
	@Override
	public Node delete(int key, Node root) {

		// base case
		if (root == null)
			return root;

		if (key < root.getKey())
			root.left = delete(key, root.left);

		else if (key > root.getKey())
			root.right = delete(key, root.right);
		else {
			// leaf node
			if (root.left == null && root.right == null) {
				return null;
			}

			// Node having 1 child
			if (root.left == null && root.right != null) {
				return root.right;
			}
			if (root.left != null && root.right == null) {
				return root.left;
			}

			// Node having two child
			if (root.left != null && root.right != null) {
				Node node = findMin(root.right);
				root.setKey(node.getKey());
				return root;
			}
		}
		return root;
	}

	/**
	 * Getting the value for a specified key.
	 * 
	 * @param key
	 *            - key value.
	 * @param root
	 *            - root node.
	 * @return the value for the key.
	 */
	@Override
	public String getValue(int Key, Node root) {

		while (root != null) {
			if (Key < root.getKey())
				root = root.left;
			else if (Key > root.getKey()) {
				root = root.right;
			} else {
				return root.getValue();
			}
		}
		return null;

	}

	/**
	 * Adding values to the list in sorted order.
	 * 
	 * @param root
	 *            - Root node.
	 */
	@Override
	public void sortedList(Node root) {

		if (root != null) {
			sortedList(root.left);
			sortedListValues.add(root);
			sortedList(root.right);
		}
	}

	/**
	 * Adding values to the node in the specified range k1 and k2.
	 * 
	 * @param root
	 *            - root node.
	 * @param k1
	 *            - lower limit.
	 * @param k2
	 *            - upper limit.
	 */
	@Override
	public void sortedListRange(Node root, int k1, int k2) {

		if (root != null) {
			sortedListRange(root.left, k1, k2);
			if (root.getKey() >= k1 && root.getKey() <= k2)
				sortedListRangeValues.add(root);
			sortedListRange(root.right, k1, k2);
		}
	}

}
