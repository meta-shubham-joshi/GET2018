package linkedList;

/*
 * class containing linked list implementation
 * created on August 4, 2018
 */
public class LinkedList <valueType> {
	
	private Node<valueType> head = null;  
	private int listSize=0;
	/*
	 * method to add elements to the list
	 * @param element to be added in the list
	 * @return 1 if added successfully otherwise return 0
	 */
	public int addElementToList (valueType element) {
		Node<valueType> newNode = new Node<valueType>(element, null);
		try {
			if(head==null) {
				head = newNode;
				listSize++;
			} else {
				Node <valueType> temporaryNode = head;
				while(temporaryNode.getNext()!=null) {
					temporaryNode = temporaryNode.getNext(); 
				}
				temporaryNode.setNext(newNode);
				listSize++;
			}
		} catch (Exception e) {
			System.out.println("Exception occurred !");
			return 0;
		}
		
		return 1;
	}
	
	/*
	 * method to get an element at particular index
	 * 
	 */
	public valueType getElement(int index) {
		int count = 0;
		index = index-1;
		Node <valueType> temporaryNode=null;
		try {
			if(head==null) {
				System.out.println("List is empty !");
				return null;
			} else {
				if(index==0) {
					return head.getValue();
				} else {
					temporaryNode = head;
					while(count != (index-1) && temporaryNode!=null) {
						temporaryNode = temporaryNode.getNext(); 
						count++;
					}
					return temporaryNode.getValue();
				}
			}
		} catch (Exception e) {
			System.out.println("Exception occurred !");
			return null;
		}
	}
	
	/*
	 * method returning head value
	 */
	public Node<valueType> getHead() {
		return head;
	}

	/*
	 * method for deleting elements from specified position
	 * @param index as integer 
	 * @return 1 if deleted successfully otherwise return 0
	 */
	public int deleteElementFromList(int index) {
		int count = 0;
		index = index-1;
		Node <valueType> temporaryNode=null;
		try {
			if(head==null) {
				System.out.println("List is empty !");
				return 0;
			} else {
				if(index==0) {
					temporaryNode=head;
					head=(null);
					head=(temporaryNode.getNext());
					listSize--;
				} else {
					temporaryNode = head;
					while(count != (index-1) && temporaryNode!=null) {
						temporaryNode = temporaryNode.getNext(); 
						count++;
					}
					Node<valueType> temporaryNode1 = temporaryNode.getNext().getNext();
					temporaryNode.setNext(temporaryNode1);
					listSize--;
				}
			}
		} catch (Exception e) {
			System.out.println("Exception occurred !");
			return 0;
		}
		
		return 1;
	}
	
	/*
	 * method to give size of list
	 * @return list size
	 */
	public int getListSize() {
		return listSize;
	}
	
	/*
	 * method to display list elements
	 */
	public void displayList() {
		Node <valueType> temporaryNode = head;
		System.out.println("List elements are:\n");
		while(temporaryNode.getNext()!= null) {
			System.out.print(temporaryNode.getValue()+" ");
			temporaryNode = temporaryNode.getNext();  
		}
		System.out.print(temporaryNode.getValue());
		System.out.println();
	}
}
