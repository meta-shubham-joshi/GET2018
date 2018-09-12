package linkedList;

/*
 * classcontaining a Node attributes
 * created on August 4, 2018
 */
public class Node <valueType>{
	
	private valueType value;
	private Node <valueType> next;
	
	public Node (valueType value, Node<valueType> next) {
		this.value = value;
		this.next = next;
	}

	public valueType getValue() {
		return value;
	}

	public Node<valueType> getNext() {
		return next;
	}

	public void setValue(valueType value) {
		this.value = value;
	}

	public void setNext(Node <valueType> next) {
		this.next = next;
	}
	
	
	
}
