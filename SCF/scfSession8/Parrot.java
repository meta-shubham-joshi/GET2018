package scfSession8;

public class Parrot extends Bird {

	public Parrot(String type, String name, int age, float weight,
			String typeOfSound, int wings) {
		this.type = type;
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.typeOfSound = typeOfSound;
		this.wings = wings;
	}

	public String getType() {
		return this.type;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	public float getWeight() {
		return this.weight;
	}

	public int getWings() {
		return this.wings;
	}

	public String getAnimalSound() {
		return this.typeOfSound;
	}

}
