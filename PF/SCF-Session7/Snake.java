package Com;


public class Snake extends Reptile{
	
	public Snake(String type,String name,int age,float weight,String typeOfSound,int coldBlooded){
		this.type = type;
		this.name = name;
		this.age = age;
		this.weight =weight;
		this.typeOfSound = typeOfSound;
		this.coldBlooded = coldBlooded;
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
	
	public int getColdBlooded() {
		return this.coldBlooded;
	}
	
	public String getAnimalSound(){
		return this.typeOfSound;
	}
}
