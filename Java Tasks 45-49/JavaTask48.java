import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class JavaTask48 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите значение x: ");
        int x = scanner.nextInt();

        int y = 2 * x + 1;
        int z = 3 * x + 1;

        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        HashSet<Long> seen = new HashSet<>();

        long start = 1;
        minHeap.add(start);
        seen.add(start);

        int count = 0;
        int maxElements = 20; 

        System.out.println("Последовательность u:");
        while (count < maxElements && !minHeap.isEmpty()) {
            long current = minHeap.poll();
            System.out.print(current + " ");
            count++;

            long nextY = current + y;
            long nextZ = current + z;

            if (!seen.contains(nextY)) {
                minHeap.add(nextY);
                seen.add(nextY);
            }
            if (!seen.contains(nextZ)) {
                minHeap.add(nextZ);
                seen.add(nextZ);
            }
        }
    }
}