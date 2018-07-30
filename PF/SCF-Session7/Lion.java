package Com;


public class Lion extends Mammal{
	
	public Lion(String type,String name,int age,float weight,String typeOfSound,String furColor){
		this.type = type;
		this.name = name;
		this.age = age;
		this.weight =weight;
		this.typeOfSound = typeOfSound;
		this.furColor = furColor;
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
	
	public String getFurColor() {
		return this.furColor;
	}
	
	public String getAnimalSound(){
		return this.typeOfSound;
	}

}