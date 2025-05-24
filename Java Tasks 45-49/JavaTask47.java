import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class JavaTask47 {
    public static int[][] generateArray(int N) {
        Random rand = new Random();
        int[][] array = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                array[i][j] = rand.nextInt(100); 
            }
        }
        return array;
    }

    public static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int num : row) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }

    public static List<Integer> snail(int[][] array) {
        List<Integer> result = new ArrayList<>();
        int n = array.length;
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                result.add(array[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                result.add(array[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(array[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(array[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива N: ");
        int N = scanner.nextInt();

        if (N < 1) {
            System.out.println("Размер массива должен быть положительным числом.");
            return;
        }

        int[][] array = generateArray(N);
        
        System.out.println("Исходный массив:");
        printArray(array);

        List<Integer> spiralOrder = snail(array);
        
        System.out.println("Массив в формате змейки:");
        System.out.println(spiralOrder);
    }
}