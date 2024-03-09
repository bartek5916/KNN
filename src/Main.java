import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Flower> listOfFLowers = new ArrayList<>();

    public static void main(String[] args) {

        readFile("data/iris_training.txt");

        for(Flower f : listOfFLowers){
            System.out.println(f);
        }

    }

    public static void readFile(String fileName){
        String line;
        try {
            BufferedReader bf = new BufferedReader(new FileReader(fileName));

            while((line = bf.readLine()) != null){
                String[] arr = line.replace(",", ".").trim().split("\\s+");
                ArrayList<Double> attributes = new ArrayList<>();

                for(int i = 0; i < arr.length - 1; i++){
                    attributes.add(Double.parseDouble(arr[i]));
                }

                listOfFLowers.add(new Flower(attributes, arr[arr.length - 1]));
            }
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }
}
