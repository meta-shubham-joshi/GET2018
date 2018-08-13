package question;

public class Node {

	private int key;
	private String value;
	public Node left;
	public Node right;

	/**
	 * Constructor to Initialize node values.
	 * 
	 * @param key
	 *            - Key of the node.
	 * @param value
	 *            - Value of the node.
	 */
	public Node(int key, String value) {
		this.key = key;
		this.value = value;
		this.left = null;
		this.right = null;
	}

	/**
	 * Getting the Key value.
	 * 
	 * @return the key
	 */
	public int getKey() {
		return this.key;
	}

	/**
	 * Getting the String value.
	 * 
	 * @return the value.
	 */
	public String getValue() {
		return this.value;
	}

	/**
	 * Setting the key value.
	 * 
	 * @param key
	 *            - key value.
	 */
	public void setKey(int key) {
		this.key = key;
	}

	/**
	 * Seeting the string value.
	 * 
	 * @param value
	 *            - String value.
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
