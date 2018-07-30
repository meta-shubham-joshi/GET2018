package Com;
import java.util.ArrayList;
import java.util.Scanner;

public class Zoo {

	ArrayList<Zone> obj = new ArrayList<Zone>();

	private int zoneCapacity;

	/*
	 * Functions to initialise the total number of zones in a zoo.
	 * 
	 * @params zonecapacity- Total zone capacity of the zoo.
	 */
	public void maxZoneCapacity(int zoneCapacity) {
		this.zoneCapacity = zoneCapacity;
	}

	/*
	 * Adding a zone to the zoo.
	 * 
	 * @params type- Type of zone.
	 * 
	 * @params cagecapacity - Capacity of the cage.
	 * 
	 * @params id- id of the zone.
	 * 
	 * @params parkVal - Whether the zone has park or not.
	 * 
	 * @params canteenval - Whether the zone has a canteen or not.
	 * 
	 * @return returns whether the zone is added to the zoo or not.
	 */
	public int addZoneToZoo(String type, int cagecapacity, int id,
			boolean haspark, boolean hascanteen) {

		try {
			if (obj.size() < zoneCapacity) {
				obj.add(new Zone(type, cagecapacity, id, haspark, hascanteen));
				System.out.println("Zone added successfully....!!!!!!!!");
				return 1;

			} else {
				System.out
						.println("Zone cannot be added.. Since no space for adding new zone....!!!!!!!!");
				return 0;
			}
		} catch (Exception e) {
			System.out.println("Something went wrong!!..");
			return 0;
		}
	}

	/*
	 * Adding a cage to a zone.
	 * 
	 * @params id- Id of the zone in which cage is to be added.
	 * 
	 * @params type- Type of animal Cage.
	 * 
	 * @params capacity- Capacity of the cage.
	 * 
	 * @return returns whether the cage is added to the zone or not.
	 */

	public int addCageToZone(int id, String type, int capacity) {
		try {
			for (Zone it : obj) {
				if (it.id == (id)) {

					if (it.spareCageCapacity() > 0) {
						it.addCage(type, capacity);
						System.out.println("Cage added successfully!!..");
						return 1;
					}
				}
			}
			System.out.println("Zone id provided is wrong!!..");
			return 0;

		} catch (Exception e) {
			System.out.println("Nothing");
			return 0;
		}
	}

	/*
	 * Adding an animal to a cage
	 * 
	 * @params animal - animal object.
	 * 
	 * @params id-Id of Zone.
	 * 
	 * @return returns whether the animal is added to cage or not.
	 */
	public int addAnimalToCage(Animal animal, int id) {

		try {

			for (Zone it : obj) {

				if (it.id == (id)) {

					for (Cage val : it.cage) {

						if (val.getType().equals(animal.type)
								&& val.getSpareCapacity() > 0) {

							val.addAnimal(animal);
							System.out.println("Animal added successfully!!!!!!..........");
							return 1;
						}
					}

					if (it.getCageCapacity() > 0) {

						System.out.println("Enter the size of cage you want:");

						Scanner sc = new Scanner(System.in);

						int cagecap = sc.nextInt();

						addCageToZone(it.id, animal.type, cagecap);

						for (Cage value : it.cage) {
							if (value.getType().equals(animal.type)) {

								value.addAnimal(animal);
								System.out.println("Animal added successfully!!!!!!..........");
								return 1;
							}
						}

					} else {
						System.out
								.println("New Cage cannot be created.... Since No Cage space available for addition of new animal in this zone..!!");
						return 0;
					}
				}
			}
			System.out
					.println("Zone id provided is wrong.... This zone id doesnot exist!!..");
			return 0;

		} catch (Exception e) {
			System.out.println("Error..!!");
			return 0;
		}
	}

	/*
	 * Function to remove an animal i.e. death of an animal.
	 * 
	 * @params id - Id of the zone.
	 * 
	 * @params type- Type of animal to be removed.
	 * 
	 * @params name - Name of the animal to be removed.
	 * 
	 * @return returns whether the animal is removed or not.
	 */
	public int removeAnimal(int id, String type, String name) {
		try {
			for (Zone it : obj) {

				if (it.id == id) {

					for (Cage val : it.cage) {

						if (val.getType().equals(type)) {

							for (Animal animal : val.animal) {
								if (animal.name.equals(name)) {
									val.animal.remove(animal);
									System.out
											.println("Animal is successfully removed!!!!....");
									return 1;
								}
							}
							System.out
									.println("Animal name provided is wrong.... Hence animal cannot be removed!!!!....");
							return 0;
						}
					}
					System.out
							.println("Animal type provided is wrong.... Hence animal cannot be removed!!!!....");
					return 0;

				}
			}
			System.out
					.println("Zone id provided is wrong.... Hence animal cannot be removed!!!!....");
			return 0;
		} catch (Exception e) {
			System.out.println("Nothing");
			return 0;
		}

	}

}
