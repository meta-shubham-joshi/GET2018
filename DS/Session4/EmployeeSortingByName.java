package question1;

import java.util.Comparator;

public class EmployeeSortingByName {

	/**
	 * Comparator for sorting Employees by employee name.
	 */
	public static Comparator<Employee> sortByName = new Comparator<Employee>() {

		public int compare(Employee e1, Employee e2) {
			return e1.getName().compareToIgnoreCase(e2.getName());
		}
	};

}
