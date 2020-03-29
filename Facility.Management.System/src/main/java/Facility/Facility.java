package Facility;

import java.util.ArrayList;
import Client_Detail.Address;

public class Facility implements Facility_Interface{
	
	private String name = null;
	private String facilityType = null; 
	private String dimensions = "500*500";
	private Address address;
	private int capacity;
	private String detail = null;
	private static ArrayList<Floors> numFloors;
	private ArrayList<Unit> Units;
	public ArrayList<Inspection> inspections = new ArrayList<Inspection>();
	private double usage;
	public Facility(){
		
		//Default parameters 
		this.dimensions = "500*500";
		this.address = null;
		this.capacity = 10;
		this.facilityType = "Basic Facility";
		numFloors = new ArrayList<Floors>(10);
  	    Units = new ArrayList<Unit>(10);
	}
	//overload
	public Facility(String Name, String FacilityType, String Dimensions, int Capacity, Address address){
		this.setName(Name);
		this.facilityType = FacilityType;
		this.dimensions = Dimensions;
		this.address = address;
		this.capacity = Capacity;
		inspections = new ArrayList<Inspection>();
	}
	public void listUnits() {
		for (Unit u : Units){
			System.out.println(u.getId());
		}
	}

	public String getFacilityInfo() {
		return this.getName() + " " + this.facilityType + " " + this.address;
	}
	

	public int getAvailableCapacity() {
		return capacity;
	}

	public boolean addNewUnit(Unit unit) {
		if (!this.Units.contains(unit.getId())){
			this.Units.add(unit);
			return true;
			}
		else return false;
	}

	public void addFacilityDetail(String s) {
		this.detail = s;
	}

	public boolean removeUnit(Unit unit) {
		if (!this.Units.contains(unit)){
			this.Units.remove(unit);
			return true;
			}
		else return false;
	}
	
	public void setUsage(double use){

		usage += use;
	}
	public double getUsage(){

		return usage;
	}
	public ArrayList<Inspection> getInspections(){

		return inspections;
	}
	public void addInspection(Inspection inspection) {

		inspections.add(inspection);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {

		this.name = name;
	}
	public String getFacilityType() {

		return facilityType;
	}
	public void setFacilityType(String facilityType) {

		this.facilityType = facilityType;
	}

	public String getDimensions() {

		return dimensions;
	}
	public void setDimensions(String dimensions) {

		this.dimensions = dimensions;
	}
	public Address getAddress() {

		return address;
	}
	public void setAddress(Address address) {

		this.address = address;
	}
	public void setCapacity(int capacity) {

		this.capacity = capacity;
	}
}
