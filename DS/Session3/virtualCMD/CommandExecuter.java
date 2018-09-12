package virtualCMD;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * class implementing the functionality of the commands.
 * 
 * @author User28
 *
 */
public class CommandExecuter {

	public Directory root;
	public Directory currentDir = null;
	public String pathOfRoot = "R:\\";
	public String path = "";
	public int length = 10;

	/**
	 * Initialising the root and currentDirectory.
	 */
	public CommandExecuter() {
		Directory rootDirect = new Directory("R: ", null, pathOfRoot);
		this.root = rootDirect;
		this.currentDir = this.root;
		printPath(root);
	}

	/**
	 * returns whether the directory is present or not.
	 * 
	 * @params dir - directory.
	 * @return returns whether the directory is present or not.
	 */
	public Directory isDirectoryPresent(String name) {
		for (Directory obj : currentDir.getListOfSubDirectories()) {
			if (obj.getName().equals(name))
				return obj;
		}
		return null;
	}

	/**
	 * To add a directory to the parent.
	 * 
	 * @params name- name of the directory to be created.
	 * @params parent- parent directory.
	 * @return return whether we can make a new directory or not.
	 */
	public int makeDirectory(String name) {
		if (name != null) {
			Directory dir = new Directory(name, currentDir, (currentDir.getPath() + name + "\\"));
			currentDir.addItem(dir);
			printPath(dir);
			return 1;
		}
		return 0;
	}

	/**
	 * To change the directory within the current directory..
	 * 
	 * @params dir- name of the directory.
	 * @return return whether we can change a directory or not.
	 */
	public int changeDirectory(String name) {
		Directory dir = isDirectoryPresent(name);
		if (dir != null) {
			this.currentDir = dir;
			printPath(currentDir);
			return 1;
		} else {
			System.out.println("Directory with given name does not exist!!..");
			return 0;
		}
	}

	/**
	 * Moving back to the parent directory....
	 * 
	 * @return return whether we can move back to a directory or not.
	 */
	public int back() {
		if (currentDir == null) {
			System.out.println("Current directory is null. So we cannot go back to the parent directory..");
			return 0;
		} else if (currentDir.equals(root)) {
			currentDir = null;
			System.out.println("Current directory is root. So we go back to the parent directory i.e null..");
			return 1;
		} else {
			currentDir = currentDir.getParent();
			System.out.println("Now, the current directory gets changed to" + currentDir.getName());
			return 1;
		}
	}

	/**
	 * Listing all the files in the current directory with the time of creation.
	 * 
	 * @return returns whether it has been created or not.
	 */
	public int ls() {
		if (currentDir != null) {
			System.out.println("Total number of subFolders are: " + currentDir.getListOfSubDirectories().size());
			for (Directory obj : currentDir.getListOfSubDirectories()) {

				System.out.println(obj.getName() + "  " + obj.getTimeStamp() + " ");

			}
			return 1;
		}
		System.out.println("Since no such current directory exist!!.. So no subfolders are there....");
		return 0;

	}

	/**
	 * Returns the list of pattern matches.
	 * 
	 * @param pattern
	 *            - pattern to be matched.
	 * @param m
	 *            - currentdirectory name to be matched.
	 * @param currentdir
	 *            - currentDirectory.
	 * @return returns the list of pattern matched.
	 */
	public ArrayList<String> isPresent(Pattern pattern, Matcher m, Directory currentdir) {

		ArrayList<String> list = new ArrayList<String>();

		if (m.find()) {
			list.add(currentdir.getName());
		}

		if (currentdir.getListOfSubDirectories().size() == 0) {
			return list;
		}

		for (Directory obj : currentdir.getListOfSubDirectories()) {

			Matcher matcher = pattern.matcher(obj.getName());

			ArrayList<String> res = isPresent(pattern, matcher, obj);

			if (res != null) {

				for (int i = 0; i < res.size(); i++) {
					list.add(res.get(i));
				}
			}
		}
		return list;

	}

	/**
	 * Finding the directories with the search string.
	 * 
	 * @param search
	 *            - string to be search.
	 * @return returns the list of strings.
	 */
	public ArrayList<String> find(String search) {

		ArrayList<String> result = new ArrayList<String>();

		if (!currentDir.equals(null)) {

			Pattern pattern = Pattern.compile(search);
			Matcher matcher = pattern.matcher(currentDir.getName());

			result = isPresent(pattern, matcher, currentDir);
		}
		return result;
	}

	/**
	 * Tree command for printing the whole directory structure.
	 */
	public ArrayList<String> Tree(Directory currentDir) {
		ArrayList<String> list = new ArrayList<String>();

		if (!currentDir.equals(null)) {
			list.add(currentDir.getName());
		}

		if (currentDir.getListOfSubDirectories().size() == 0) {
			return list;
		}

		for (Directory obj : currentDir.getListOfSubDirectories()) {

			ArrayList<String> res = Tree(obj);

			if (res != null) {

				for (int i = 0; i < res.size(); i++) {
					list.add(res.get(i));
				}
			}
		}

		System.out.print("\u2514");

		System.out.println(currentDir.getName());

		for (int i = 1; i < list.size(); i++) {

			for (int j = 0; j < length; j++)
				System.out.print(" ");
			System.out.println("\u251c" + list.get(i));
		}
		return list;

	}

	/**
	 * For printing the path of the directory.
	 * 
	 * @param dir-
	 *            directory.
	 */
	public void printPath(Directory dir) {
		try {
			if (dir.equals(root)) {
				System.out.println(pathOfRoot + ">");
			} else {
				System.out.println(dir.getPath() + ">");
			}

		} catch (NullPointerException e) {
			System.out.println("Since current directory is null!!..");
		}
	}

}
