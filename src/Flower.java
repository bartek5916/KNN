import java.util.ArrayList;

public class Flower {

    private ArrayList<Double> attributes;
    private String type;
    private double distance;


    public Flower(ArrayList<Double> attributes, String type) {
        this.attributes = attributes;
        this.type = type;
        this.distance = 0;
    }

    public ArrayList<Double> getAttributes() {
        return attributes;
    }

    public String getType() {
        return type;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "attributes=" + attributes +
                ", type='" + type + '\'' +
                '}';
    }
}
