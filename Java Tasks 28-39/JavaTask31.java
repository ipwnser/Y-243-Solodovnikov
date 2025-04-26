import java.util.ArrayList;
import java.util.List;

public class JavaTask31 {
    public static void main(String[] args) {

        int[] distances = {50, 55, 57, 58, 60};
        int maxDistance = 175; 
        int citiesToVisit = 3; 

        int result = chooseBestSum(maxDistance, citiesToVisit, distances);
        System.out.println("Максимально возможное расстояние: " + result);
    }

    public static int chooseBestSum(int maxDistance, int citiesToVisit, int[] distances) {
        List<int[]> combinations = new ArrayList<>();
        generateCombinations(distances, new int[citiesToVisit], 0, 0, combinations);

        int bestSum = -1;

        for (int[] combination : combinations) {
            int sum = sumArray(combination);
            if (sum <= maxDistance && sum > bestSum) {
                bestSum = sum;
            }
        }

        return bestSum;
    }

    private static void generateCombinations(int[] distances, int[] currentCombination,
                                             int startIndex, int depth,
                                             List<int[]> combinations) {
        if (depth == currentCombination.length) {
            combinations.add(currentCombination.clone());
            return;
        }

        for (int i = startIndex; i < distances.length; i++) {
            currentCombination[depth] = distances[i];
            generateCombinations(distances, currentCombination, i + 1, depth + 1, combinations);
        }
    }

    private static int sumArray(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }
}
