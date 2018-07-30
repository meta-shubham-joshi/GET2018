package Com;

import java.util.ArrayList;

public class Zone {
	
	private String type;
	public int id;
	private int cagecapacity;
	private boolean parkval;
	private boolean canteenval;
	
	ArrayList<Cage> cage = new ArrayList<Cage>();
	
	public Zone(){
		System.out.println("Zone is to be added now..!!");
	}
	
	/*
	 * Constructor to initialise the zone parameters.
	 * 
	 * @params type-type of animal zone.
	 * 
	 * @params cagecapacity- total cage capacity.
	 * 
	 * @params id- id of the zone.
	 * 
	 * @params haspark - whether the zone has park or not.
	 * 
	 * @params hascanteen - whether the zone has canteen or not.
	 */
	public Zone(String type,int cagecapacity,int id,boolean haspark,boolean hascanteen){
		this.type = type;
		this.cagecapacity = cagecapacity;
		this.id = id;
		this.parkval = haspark;
		this.canteenval = hascanteen;
	}
	
	public String getType(){
		return this.type;
	}
	
	public int getId(){
		return this.id;
	}
	
	public int getCageCapacity(){
		return this.cagecapacity;
	}
	
	public boolean hasPark(){
		return this.parkval;
	}
	
	public boolean hasCanteen(){
		return this.canteenval;
	}
	
	public int spareCageCapacity(){
		return cagecapacity;
	}
	
	/**
	 * Adding cage to the zone.
	 * @param type- type of animal cage.
	 * @param capacity- capacity of cage.
	 */
	public void addCage(String type,int capacity){
		
		this.cage.add(new Cage(type, capacity));
		cagecapacity--;
	}
	
	
	
	
	
	
}

