package question1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class EmployeeCollectionTest {

	@Test
	public void testSortingById() throws EmployeeAlreadyExist {
		EmployeeCollection employeeCollection = new EmployeeCollection();

		employeeCollection.addEmployee(2, "shubham", "bhilwara");
		employeeCollection.addEmployee(3, "rahul", "jaipur");
		employeeCollection.addEmployee(1, "madhav", "surat");

		List<Employee> expectedResult = new ArrayList<Employee>();

		expectedResult.add(new Employee(1, "madhav", "surat"));
		expectedResult.add(new Employee(2, "shubham", "bhilwara"));
		expectedResult.add(new Employee(3, "rahul", "jaipur"));

		employeeCollection.sortingById();

		for (int i = 0; i < expectedResult.size(); i++) {
			assertEquals(expectedResult.get(i).getEmpId(), employeeCollection
					.getListOfEmployee().get(i).getEmpId());
			assertEquals(expectedResult.get(i).getName(), employeeCollection
					.getListOfEmployee().get(i).getName());
			assertEquals(expectedResult.get(i).getAddress(), employeeCollection
					.getListOfEmployee().get(i).getAddress());
		}
	}

	@Test(expected = EmployeeAlreadyExist.class)
	public void testEmployeeAlreadyExist() throws EmployeeAlreadyExist {
		EmployeeCollection employeeCollection = new EmployeeCollection();

		employeeCollection.addEmployee(1, "madhav", "surat");
		employeeCollection.addEmployee(3, "rahul", "jaipur");
		employeeCollection.addEmployee(1, "madhav", "surat");
		employeeCollection.addEmployee(3, "rahul", "jaipur");

		List<Employee> expectedResult = new ArrayList<Employee>();

		expectedResult.add(new Employee(1, "madhav", "surat"));
		expectedResult.add(new Employee(3, "rahul", "jaipur"));

		employeeCollection.sortingById();

		for (int i = 0; i < expectedResult.size(); i++) {
			assertEquals(expectedResult.get(i).getEmpId(), employeeCollection
					.getListOfEmployee().get(i).getEmpId());
			assertEquals(expectedResult.get(i).getName(), employeeCollection
					.getListOfEmployee().get(i).getName());
			assertEquals(expectedResult.get(i).getAddress(), employeeCollection
					.getListOfEmployee().get(i).getAddress());
		}
	}

	@Test
	public void testSortingByName() throws EmployeeAlreadyExist {
		EmployeeCollection employeeCollection = new EmployeeCollection();

		employeeCollection.addEmployee(1, "Abhishek", "surat");
		employeeCollection.addEmployee(2, "Baa", "jaipur");
		employeeCollection.addEmployee(3, "Deepak", "jaipur");

		List<Employee> expectedResult = new ArrayList<Employee>();

		expectedResult.add(new Employee(1, "Abhishek", "surat"));
		expectedResult.add(new Employee(2, "Baa", "jaipur"));
		expectedResult.add(new Employee(3, "Deepak", "jaipur"));

		employeeCollection.sortingByName();

		for (int i = 0; i < expectedResult.size(); i++) {
			assertEquals(expectedResult.get(i).getEmpId(), employeeCollection
					.getListOfEmployee().get(i).getEmpId());
			assertEquals(expectedResult.get(i).getName(), employeeCollection
					.getListOfEmployee().get(i).getName());
			assertEquals(expectedResult.get(i).getAddress(), employeeCollection
					.getListOfEmployee().get(i).getAddress());
		}
	}
}
