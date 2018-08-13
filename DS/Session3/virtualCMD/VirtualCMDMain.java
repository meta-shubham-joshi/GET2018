package virtualCMD;

import java.util.ArrayList;
import java.util.Scanner;

public class VirtualCMDMain {

	public static void main(String args[]) {

		String command;
		String[] inputSeparator;

		CommandExecuter ce = new CommandExecuter();

		Directory dir = new Directory("Shubham", null, ce.root.getPath());

		while (true) {

			Scanner sc = new Scanner(System.in);

			command = sc.nextLine();

			inputSeparator = command.split(" ");

			if (inputSeparator.length > 2) {
				System.out.println("Wrong input!!..");
			}

			switch (inputSeparator[0]) {

			case "mkdir":
				try {
					ce.makeDirectory(inputSeparator[1]);
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out
							.println("Invalid input!!.. Since null directory cannot be created!!..");
				}
				break;

			case "cd":
				ce.changeDirectory(inputSeparator[1]);
				break;

			case "bk":
				ce.back();
				break;

			case "ls":
				ce.ls();
				break;

			case "find":
				ArrayList<String> res = ce.find(inputSeparator[1]);

				for (int i = 0; i < res.size(); i++) {
					System.out.println(res.get(i) + "  ");
				}

				break;

			case "tree" : ce.Tree(ce.root); 
							break;
			 
			default:
				System.out.println("Wrong Input given!!..");
			}
		}
}
}

