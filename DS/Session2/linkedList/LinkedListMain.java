package linkedList;

import java.util.Scanner;

public class LinkedListMain {
	public static void main(String args[]) {
		Scanner scanner = new Scanner (System.in);
		LinkedList<Integer> linkList=new LinkedList<Integer>();
		System.out.println("Enter no. of element:");
		int n = scanner.nextInt();
		System.out.println("Enter element:");
		for(int i=0 ; i<n ; i++) {
			int element = scanner.nextInt();
			linkList.addElementToList(element);
		}
		
		linkList.displayList();
		System.out.println("list size: "+linkList.getListSize());

		linkList.deleteElementFromList(4);
		linkList.displayList();
		System.out.println("list size: "+linkList.getListSize());
	}
}
