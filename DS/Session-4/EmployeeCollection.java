package question1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeCollection {

	List<Employee> listOfEmployee = new ArrayList<Employee>();
	Set<Integer> employeeIdSet = new HashSet<Integer>();

	/**
	 * To add a employee to the list of employees.
	 * 
	 * @param empId
	 *            - Employee Id.
	 * @param name
	 *            - Employee Name.
	 * @param address
	 *            - Employee Address.
	 * @throws EmployeeAlreadyExist.
	 */
	public void addEmployee(int empId, String name, String address)
			throws EmployeeAlreadyExist {

		if (employeeIdSet.contains(empId)) {
			throw new EmployeeAlreadyExist("This Employee already exist!!..");
		}

		employeeIdSet.add(empId);
		listOfEmployee.add(new Employee(empId, name, address));
	}

	/**
	 * @return the list of employees.
	 */
	public List<Employee> getListOfEmployee() {
		return listOfEmployee;
	}

	/**
	 * Sorting by name.
	 */
	public void sortingByName() {
		Collections.sort(listOfEmployee, EmployeeSortingByName.sortByName);

	}

	/**
	 * Sorting by Id.
	 */
	public void sortingById() {
		Collections.sort(listOfEmployee, EmployeeSortingById.sortById);
	}

}
