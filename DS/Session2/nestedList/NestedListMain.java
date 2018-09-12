package nestedList;

import java.util.Scanner;

import linkedList.LinkedList;

/*
 * class containing main method
 */
public class NestedListMain {
	public static void main(String args[]) {
		Scanner scanner = new Scanner (System.in);
		LinkedList<Integer> linkList=null;
		NestedListImplementation nestedList = new NestedListImplementation();
		System.out.println("Enter no. of List:");
		int numberOfLists = scanner.nextInt();
		for(int i=0 ; i<numberOfLists ; i++) {
			linkList = new LinkedList<Integer>();
			System.out.println("Enter no. of element for List "+(i+1)+" :");
			int numberOfElements = scanner.nextInt();
			System.out.println("Enter element:");
			for(int j=0 ; j<numberOfElements ; j++) {
				int element = scanner.nextInt();
				linkList.addElementToList(element);
			} 
			linkList.displayList();
			//nestedList.addElements(linkList);
		}
		int choice = 0;
		while(choice != 4) {
			System.out.println("Enter your choice:\1. Get Sum Of All Integers\n2. Get Largest Value From The List\n3. Search For An Element\n4. Exit");
			choice = scanner.nextInt();
			 switch (choice) {
				 case 1:
					 System.out.println("total = "+nestedList.getSumOfAllIntegers());
					 break;
				
				 case 2:
					 System.out.println("Largest value: "+nestedList.getLargestValueFromNestedList());
					 break;
					
				 case 3:
					 System.out.println("Enter the element to be searched :");
					 int element = scanner.nextInt();
					 System.out.println(nestedList.searchValue(element));
					 
				 case 4:
					 System.exit(0);
					 
				default:
					System.out.println("Invalid Choice !");
					break;
			 }
		}
	
	}
}
