package question;

public class Main {

	public static void main(String args[]) {

		String filePath = "C:\\Users\\User28\\workspace\\DS-Session5\\src\\question\\pairs.json";

		BST bst = new BST(filePath);

		Node obj3 = new Node(3, "ram");
		Node obj4 = new Node(4, "komal");

		// Adding nodes to the BST.
		bst.add(obj3, bst.root);
		bst.add(obj4, bst.root);

		System.out
				.println("Sorted List***************************** After Deletion");

		Node objdel1 = bst.delete(45, bst.root);

		bst.sortedList(bst.root);

		System.out
				.println("Sorted list of the Dictionary according to Key is:");
		for (int i = 0; i < bst.sortedListValues.size(); i++) {
			System.out.println(bst.sortedListValues.get(i).getKey() + "  :  "
					+ bst.sortedListValues.get(i).getValue());
		}

		System.out
				.println("Searching value***************************** For a Key");
		String objsearch = bst.getValue(2, bst.root);
		if (objsearch == null)
			System.out
					.println("Given key is not found.. Wrong input key!!.. So null value returned!!..");
		else
			System.out.println(objsearch);

		System.out.println("Sorted*****************************List");
		bst.sortedList(bst.root);

		System.out
				.println("Sorted list of the Dictionary according to Key is:");
		for (int i = 0; i < bst.sortedListValues.size(); i++) {
			System.out.println(bst.sortedListValues.get(i).getKey() + "  :  "
					+ bst.sortedListValues.get(i).getValue());
		}

		System.out.println("Sorted*****************************List");
		bst.sortedListRange(bst.root, 1, 4);

		System.out
				.println("Sorted list of the Dictionary according to Keys in the specified range is:");
		for (int i = 0; i < bst.sortedListRangeValues.size(); i++) {
			System.out.println(bst.sortedListRangeValues.get(i).getKey()
					+ "  :  " + bst.sortedListRangeValues.get(i).getValue());
		}
	}

}
