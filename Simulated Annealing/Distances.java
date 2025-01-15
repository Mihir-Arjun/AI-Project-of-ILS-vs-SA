import java.util.List;

public class Distances {
     static int[][] distanceMatrix = {
        {0, 15, 20, 22, 30},
        {15, 0, 10, 12, 25},
        {20, 10, 0, 8, 22},
        {22, 12, 8, 0, 18},
        {30, 25, 22, 18, 0}
    };

    static int numCampuses = distanceMatrix.length;

    int calculateTotalDistance(List<Integer> solution) {
        int totalDistance = 0;
        for (int i = 0; i < solution.size(); i++) {
            int start = solution.get(i);
            int end = solution.get((i + 1) % solution.size());
            totalDistance += distanceMatrix[start][end];
        }
        return totalDistance;
    }
}
