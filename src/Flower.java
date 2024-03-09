import java.util.ArrayList;

public class Flower {

    private ArrayList<Double> attributes;
    private String type;


    public Flower(ArrayList<Double> attributes, String type) {
        this.attributes = attributes;
        this.type = type;
    }

    public ArrayList<Double> getAttributes() {
        return attributes;
    }

    public String getType() {
        return type;
    }
}
