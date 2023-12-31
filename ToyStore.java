import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

public class ToyStore {
    private static PriorityQueue<Toy> toyQueue;

    public ToyStore() {
        toyQueue = new PriorityQueue<>();
    }

    public void addToy (Toy toy) {
        toyQueue.add(toy);
    }

    public String getRandomToy() {
        int totalWeight = 0;
        for (Toy toy : toyQueue) {
            totalWeight += toy.getWeight();
        }
        int randomWeight = (int) (Math.random() * totalWeight + 1);
        int currentWeight = 0;
        for (Toy toy : toyQueue) {
            currentWeight += toy.getWeight();
            if (randomWeight <= currentWeight) {
                return toy.getId() + " " + toy.getName();
            }
        }
        return "";
    }

    public void runGame(int numRounds) {
        try{
            FileWriter writer = new FileWriter("result.txt");
            for (int i = 0; i < numRounds; i++) {
                String result = getRandomToy();
                writer.write(result + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Toy toy1 = new Toy("1", "Конструктор", 2);
        Toy toy2 = new Toy("2", "Робот", 2);
        Toy toy3 = new Toy("3", "Кукла", 6);

        ToyStore toyStore = new ToyStore();

        toyStore.addToy(toy1);
        toyStore.addToy(toy2);
        toyStore.addToy(toy3);

        toyStore.runGame(10);
    }
}