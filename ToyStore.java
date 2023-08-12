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

}