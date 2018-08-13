package part2;

import java.util.ArrayList;

public class List implements NestedList{
	
	ArrayList<NestedList> list;
	
	public List(){
	
	}
	
	public List(ArrayList<NestedList> lst){
		this.list = lst;
	}
	
	public int getValue(int index){
		return this.list.get(index);
	}
	
	public int sum(){
		int sum=0;
		for(int i=0;i<this.list.size();i++){
			sum += this.list.get(i);
		}
	}

	@Override
	public int getSumOfAllIntegers() {
		int sum=0;
		
		for(int i=0;i<this.list.size();i++){
			sum += this.list.get(i).sum();
		}
		return sum;
	}

	@Override
	public int getLargestValue() {
		int max= Integer.MIN_VALUE;
		
		for(int i=0;i<this.list.size();i++){
			if(max <= list.get(i).getValue()){
				max = list.get(i).getValue();
			}
		}
		return 0;
	}

	@Override
	public ArrayList<Integer> searchValue(int x) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
