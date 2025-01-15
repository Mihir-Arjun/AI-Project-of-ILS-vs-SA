import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SimulatedAnnealing {
    Distances distanceCalculator;
    double temperature = 1000;
    double coolingRate = 0.003;
    int noImprovementLimit = 1000; // Limit for stopping criterion
    int noImprovementCount = 0; // Counter for stopping criterion

    // List to store the objective value at each iteration
    List<Integer> objectiveValues = new ArrayList<>();

    SimulatedAnnealing(Distances distanceCalculator) {
        this.distanceCalculator = distanceCalculator;
    }

    void findSolution() {
        long totalRuntime = 0;
        int iterations = 1000;
        List<Integer> solution = new ArrayList<>();
        for (int i = 0; i < Distances.numCampuses; i++) {
            solution.add(i);
        }
        solution.add(0); // Add Hatfield to the end of the solution

        int bestDistance = distanceCalculator.calculateTotalDistance(solution);

        Random random = new Random(1234);
        for (int i = 0; i < iterations; i++) {
            long startTime = System.currentTimeMillis();
            List<Integer> newSolution = new ArrayList<>(solution);
            int index1 = random.nextInt(Distances.numCampuses - 1) + 1; // Exclude Hatfield from the swap
            int index2 = random.nextInt(Distances.numCampuses - 1) + 1; // Exclude Hatfield from the swap
            Collections.swap(newSolution, index1, index2);

            int currentDistance = distanceCalculator.calculateTotalDistance(solution);
            int newDistance = distanceCalculator.calculateTotalDistance(newSolution);

            if (acceptanceProbability(currentDistance, newDistance, temperature) > Math.random()) {
                solution = newSolution;
                noImprovementCount = 0; // Reset counter if there is improvement
            } else {
                noImprovementCount++; // Increment counter if there is no improvement
            }

            // Record the objective value at this iteration
            objectiveValues.add(bestDistance);

            // Break the loop if there is no improvement after a set number of consecutive
            // iterations
            if (noImprovementCount >= noImprovementLimit) {
                break;
            }

            temperature *= 1 - coolingRate;
            long endTime = System.currentTimeMillis();
            long runtime = endTime - startTime;
            totalRuntime += runtime;
        }

        System.out.println("Number of Iterations: " + iterations);
        System.out.println("Best route: " + solution);
        // System.out.println("Objective values at each iteration: " + objectiveValues);
        int objectiveValue = distanceCalculator.calculateTotalDistance(solution);
        System.out.println("Objective function value: " + objectiveValue);
        double averageRuntime = (double) totalRuntime / iterations;
        System.out.println("Average runtime over " + iterations + " iterations: " + averageRuntime + " milliseconds");
        double sum = 0;
        for (Integer value : objectiveValues) {
            sum += value;
        }
        //double average = sum / objectiveValues.size();
        //System.out.println("Average objective function value: " + average);
    }

    double acceptanceProbability(int currentDistance, int newDistance, double temperature) {
        if (newDistance < currentDistance) {
            return 1.0;
        }
        return Math.exp((currentDistance - newDistance) / temperature);
    }

    int calculateTotalDistance(List<Integer> solution) {
        int totalDistance = 0;
        for (int i = 0; i < solution.size() - 1; i++) { // Subtract 1 to avoid out of bounds error
            int start = solution.get(i);
            int end = solution.get(i + 1);
            totalDistance += Distances.distanceMatrix[start][end];
        }
        return totalDistance;
    }
}
