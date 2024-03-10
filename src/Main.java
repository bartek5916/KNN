import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Flower> trainingListOfFLowers = new ArrayList<>();
    static List<Flower> testListOfFLowers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String root;

        System.out.println("Podaj sciezke pliku treningowego: ");
        root = scanner.nextLine();
        readFile(root, 0);

        System.out.println("Podaj sciezke pliku testowego: ");
        root = scanner.nextLine();
        readFile(root, 1);

        int k = -1;
        while (k <= 0 || k > trainingListOfFLowers.size()) {
            System.out.println("Podaj k: ");
            k = scanner.nextInt();
        }
        scanner.nextLine();
        Algorithm alg = new Algorithm((ArrayList<Flower>) trainingListOfFLowers);
        alg.listDistance((ArrayList<Flower>) testListOfFLowers, k);

        System.out.println("Czy chcesz wprowadzic wlasny wektor? Wpisz \"Tak\" lub \"Nie\"");
        String answer = scanner.nextLine();
        while(answer.equals("Tak")){
            ownVector();
            System.out.println("Czy chcesz wprowadzic kolejny wektor? ");
            answer = scanner.nextLine();
        }
    }

    public static void readFile(String fileName, int value) {
        String line;
        try {
            BufferedReader bf = new BufferedReader(new FileReader(fileName));

            while ((line = bf.readLine()) != null) {
                String[] arr = line.replace(",", ".").trim().split("\\s+");
                ArrayList<Double> attributes = new ArrayList<>();

                for (int i = 0; i < arr.length - 1; i++) {
                    attributes.add(Double.parseDouble(arr[i]));
                }

                if (value == 0) {
                    trainingListOfFLowers.add(new Flower(attributes, arr[arr.length - 1]));
                } else {
                    testListOfFLowers.add(new Flower(attributes, arr[arr.length - 1]));
                }
            }
        } catch (Exception e) {
            System.out.println("Nie znaleziono pliku");
        }
    }

    public static void ownVector() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wpisz podana ilosc cyfr: " + trainingListOfFLowers.getFirst().getAttributes().size() + " jako liczby z kropkami oddzielone znakami spacji: ");
        String[] arr = scanner.nextLine().trim().split(" ");

        ArrayList<Double> vector = new ArrayList<>();
        for (String s : arr) {
            vector.add(Double.parseDouble(s));
        }
        System.out.println("Wpisz k: ");
        int k = scanner.nextInt();

        Algorithm alg = new Algorithm((ArrayList<Flower>) trainingListOfFLowers);
        alg.vectorDistance(new Flower(vector), k);
    }
}
