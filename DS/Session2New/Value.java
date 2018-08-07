package part2;

import java.util.ArrayList;

public class Value implements NestedList{
	
	private int value;
	
	public Value(int val){
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}
	
	public int sum(){
		return this.value;
	}

	@Override
	public int getSumOfAllIntegers() {
		
		return this.value;
	}

	@Override
	public int getLargestValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Integer> searchValue(int x) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
