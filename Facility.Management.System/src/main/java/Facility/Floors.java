package Facility;
import java.util.ArrayList;

public interface Floors {
	public int getPersonCapacity();

	public void setPersonCapacity(int capacity);

	public String getID();

	public void setID(String id);

	public int getRooms();

	public int getNumRooms();

	public void setNumRooms(int numRooms);

	public double getLength();

	public void setLength(double length);

	public double getWidth();

	public void setWidth(double width);

	public double getHeight();

	public void setHeight(double height);

	public ArrayList<Facility> getNumFacility();

	public void setNumFacility(int numFacility);
}
