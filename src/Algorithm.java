import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Algorithm {
    ArrayList<Flower> trainingList;

    public Algorithm(ArrayList<Flower> trainingList) {
        this.trainingList = trainingList;
    }

    public void vectorDistance(Flower flower, int k){
        Collections.sort(trainingList, new Comparator<Flower>() {
            @Override
            public int compare(Flower o1, Flower o2) {
                return Double.compare(o1.getDistance(), o2.getDistance());
            }
        });
    }
    public void listDistance(ArrayList<Flower> testList, int k){
        for(int i = 0; i < testList.size(); i++){
            Collections.sort(trainingList, new Comparator<Flower>() {
                @Override
                public int compare(Flower o1, Flower o2) {
                    return Double.compare(o1.getDistance(), o2.getDistance());
                }
            });
        }
    }
    public void calculateDistance(Flower flower){
        double distance = 0;

        for(int i = 0; i < trainingList.size(); i++){
            for(int j = 0; j < flower.getAttributes().size(); j++){
                distance = distance + Math.pow(trainingList.get(i).getAttributes().get(j) - flower.getAttributes().get(j), 2);
            }
            distance = Math.sqrt(distance);
            trainingList.get(i).setDistance(distance);
        }
    }

}
