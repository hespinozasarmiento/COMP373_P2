package Facility;

public class InspectionImpl implements Inspection{

    private String id;
    private String time;
    private String type;

    public InspectionImpl() {
        id = null;
        time = null;
        type = null;
    }

    public InspectionImpl(String id, String time, String type) {
        this.id = id;
        this.time = time;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSummary() {
        return type;
    }

    public void setSummary(String type) {
        this.type = type;
    }

    public String toString() {
        return type + " " + this.time;
    }

}
