import java.util.Scanner;

public class JavaTask6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] memory = new int[3];
        int count = 0; 
        while (true) {
            System.out.print("Введите число (или 'exit' для выхода): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            int number;
            try {
                number = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите корректное число.");
                continue;
            }

            if (count < memory.length) {
                memory[count] = number;
                count++;
            } else {
                int minIndex = 0;
                for (int i = 1; i < memory.length; i++) {
                    if (memory[i] < memory[minIndex]) {
                        minIndex = i;
                    }
                }
                memory[minIndex] = number;
            }

            System.out.print("Текущие числа в памяти: ");
            for (int i = 0; i < count; i++) {
                System.out.print(memory[i] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}