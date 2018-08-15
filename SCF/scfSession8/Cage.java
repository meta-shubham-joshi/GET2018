package scfSession8;

import java.util.ArrayList;

public class Cage {

	private String type;
	private int capacity;

	ArrayList<Animal> animal = new ArrayList<Animal>();

	/*
	 * Constructor to initialise the cage parameters.
	 * 
	 * @params type-type of animal cage.
	 * 
	 * @params cagecapacity- total cage capacity.
	 */
	public Cage(String type, int capacity) {
		this.type = type;
		this.capacity = capacity;
	}

	public String getType() {
		return this.type;
	}

	public int getCapacity() {
		return this.capacity;
	}

	public int getSpareCapacity() {
		return this.capacity;
	}

	/*
	 * Adding animal.
	 * 
	 * @param object-object of animal class.
	 */
	public void addAnimal(Animal object) {
		try {

			if (getSpareCapacity() > 0) {
				this.animal.add(object);
				this.capacity--;
			} else {
				System.out.println("Animal cannot be added in this cage!!..");
				return;
			}
		} catch (Exception e) {
			System.out.println("Something happened");
		}

	}

}
