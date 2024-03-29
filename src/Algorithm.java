import java.util.*;

public class Algorithm {
    ArrayList<Flower> trainingList;

    public Algorithm(ArrayList<Flower> trainingList) {
        this.trainingList = trainingList;
    }

    public void vectorDistance(Flower flower, int k){
        calculateDistance(flower);
        trainingList.sort(new Comparator<Flower>() {
            @Override
            public int compare(Flower o1, Flower o2) {
                return Double.compare(o1.getDistance(), o2.getDistance());
            }
        });

        System.out.println("Wynik klasyfikacji to: " + getClassification(k));
    }


    public void listDistance(ArrayList<Flower> testList, int k){
        int counter = 0;
        for(int i = 0; i < testList.size(); i++){
            calculateDistance(testList.get(i));
            trainingList.sort(new Comparator<Flower>() {
                @Override
                public int compare(Flower o1, Flower o2) {
                    return Double.compare(o1.getDistance(), o2.getDistance());
                }
            });
            if(getClassification(k).equals(testList.get(i).getType())){
                counter++;
            }
        }

        System.out.println("Prawidlowo zakwalifikowane przyklady: " + counter);
        System.out.println("Dokladnosc: " + (double) counter/testList.size() * 100 + "%");
    }

    private String getClassification(int k) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < k; i++){
            map.put(trainingList.get(i).getType(), map.getOrDefault(trainingList.get(i).getType(), 0) + 1);
        }

        String classification = "";
        int max = 0;

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();

        while(iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();

            if(entry.getValue() > max){
                classification = entry.getKey();
                max = entry.getValue();
            }
        }
        return classification;
    }

    public void calculateDistance(Flower flower){
        for(int i = 0; i < trainingList.size(); i++){
            double distance = 0;
            for(int j = 0; j < flower.getAttributes().size(); j++){
                distance = distance + Math.pow(trainingList.get(i).getAttributes().get(j) - flower.getAttributes().get(j), 2);
            }
            distance = Math.sqrt(distance);
            trainingList.get(i).setDistance(distance);
        }
    }
}
