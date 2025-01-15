public class Main {
    public static void main(String[] args) {
        Distances distanceCalculator = new Distances();
        IterativeSolution solutionFinder = new IterativeSolution(distanceCalculator);
        solutionFinder.findSolution();
    }
}
