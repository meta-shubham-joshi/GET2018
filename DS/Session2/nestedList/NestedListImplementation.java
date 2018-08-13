package nestedList;
import java.util.List;

import linkedList.LinkedList;
import linkedList.Node;

/*
 * class containing implementaion of nested list operations
 * created on August 04, 2018
 */
public class NestedListImplementation implements NestedList {
	private LinkedList <LinkedList<Integer>> nestedList = new LinkedList <LinkedList<Integer>>();

	/*
	 * method to calculate sum of all the integers int he nested lists
	 * @return sum of the integers
	 */
	@Override
	public int getSumOfAllIntegers() {
		int totalOfInteger = 0;
		Node<LinkedList<Integer>> outerListHead = nestedList.getHead();
		try{
			while(outerListHead!=null) {
				Node <Integer> innerListHead = outerListHead.getValue().getHead();
				while(innerListHead !=null) {
					totalOfInteger += innerListHead.getValue();
					innerListHead = innerListHead.getNext();
				}
				outerListHead = outerListHead.getNext();
			}
		} catch (Exception e) {
			System.out.println("Some error ocurred !");
			return 0;
		}
		
		
		return totalOfInteger;
	}

	/*
	 * method to find largest value from the list
	 * @return the largest value from the list
	 */
	@Override
	public int getLargestValueFromNestedList() {
		int maxValue=Integer.MIN_VALUE;
		Node<LinkedList<Integer>> outerListHead = nestedList.getHead();
		try{
			while(outerListHead!=null) {
				Node <Integer> innerListHead = outerListHead.getValue().getHead();
				while(innerListHead !=null) {
					if(maxValue<innerListHead.getValue()) {
						maxValue=innerListHead.getValue();
					}
					innerListHead = innerListHead.getNext();
				}
				outerListHead = outerListHead.getNext();
			}
		} catch (Exception e) {
			System.out.println("Some error ocurred !");
			return 0;
		}
		return maxValue;
	}

	/*
	 * method finds the value int he list
	 * @return index of the value found
	 */
	@Override
	public String searchValue(int value) {
		int indexCount=0, listcount=0,innerListSize=0;
		boolean flag = false;
		Node<LinkedList<Integer>> outerListHead = nestedList.getHead();
		try{
			while(outerListHead!=null) {
				Node <Integer> innerListHead = outerListHead.getValue().getHead();
				indexCount=0;
				while(innerListHead !=null) {
					innerListSize = outerListHead.getValue().getListSize();
					if(value == innerListHead.getValue()) {
						break;
					}
					indexCount++;
					innerListHead = innerListHead.getNext();
				}
				listcount++;
				outerListHead = outerListHead.getNext();
			}
			if(listcount == nestedList.getListSize() && indexCount == listcount) {
				flag=true;
			}
		} catch (Exception e) {
			System.out.println("Some error ocurred !");
			return "Element Not found !";
		}
		if(!flag)
			return "Element found in List "+listcount+" at index "+indexCount;
		else 
			return "Element not found !";
	}
	
	/*
	 * method to add list in the nested list
	 */
	public void addElements (LinkedList<Integer> list) {
		nestedList.addElementToList(list);
	}
	
}
