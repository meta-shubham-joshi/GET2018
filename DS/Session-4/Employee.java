package question1;

/**
 * 
 * @author User28
 *
 */
public class Employee {
	private int empId;
	private String name;
	private String address;

	/**
	 * Constructor to initialise values.
	 * 
	 * @param empId
	 *            - Employee Id
	 * @param name
	 *            - Employee name.
	 * @param address
	 *            - Employee address.
	 */
	public Employee(int empId, String name, String address) {
		this.empId = empId;
		this.name = name;
		this.address = address;
	}

	/**
	 * 
	 * @return employee Id.
	 */
	public int getEmpId() {
		return empId;
	}

	/**
	 * 
	 * @param empId
	 *            - Employee Id.
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	/**
	 * 
	 * @return name of employee.
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 *            - input name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return the address of employee.
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 
	 * @param address
	 *            - address of employee.
	 */
	public void setAddress(String address) {
		this.address = address;
	}

}
