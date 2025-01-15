public class Main {
    public static void main(String[] args) {
        Distances distanceCalculator = new Distances();
        SimulatedAnnealing simulatedAnnealing = new SimulatedAnnealing(distanceCalculator);
        simulatedAnnealing.findSolution();
    }
}