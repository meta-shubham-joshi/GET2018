package part2;

import java.util.ArrayList;

public class NestedListMain {
	
	NestedList nestedlist = new List();
	
	ArrayList<NestedList> list1 = new ArrayList<>();

	list1.add(new Value(1));
	list2.add(new Value(2));
	
	ArrayList<NestedList> list2 = new ArrayList<>();
	list2.add(new Value(3));
	list2.add(new Value(4));
	
	list1.add(new List(list2));
	
	ArrayList<NestedList> list3 = new ArrayList<>();
	list3.add(new List(list1));
	list3.add(new Value(5));
	
	nestedlist.add(new Value(6));
	nestedList.add(new Value(7));
	nestedList.add(new List(list2));
	nestedList.add(new List(list1));
	nestedList.add(new List(list3));
	
	
	
	int sum = nestedlist.getSumOfAllIntegers();
	int largestValue = nestedlist.getLargestValue();
	ArrayList<Integer> search = nestedlist.searchValue(6);
	

}
