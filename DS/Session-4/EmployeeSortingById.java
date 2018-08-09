package question1;

import java.util.Comparator;

public class EmployeeSortingById {

	/**
	 * Comparator for comparing values by employee Id.
	 */
	public static Comparator<Employee> sortById = new Comparator<Employee>() {
		public int compare(Employee emp1, Employee emp2) {

			return ((emp1.getEmpId() < emp2.getEmpId()) ? -1
					: (emp1.getEmpId() == emp2.getEmpId()) ? 0 : 1);
		}

	};

}
