import java.util.Scanner;

public class JavaTask45 {
    public static String convertToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {
            "M", "CM", "D", "CD", "C", "XC",
            "L", "XL", "X", "IX", "V", "IV", "I"
        };

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                roman.append(symbols[i]);
            }
        }
        return roman.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        do {
            System.out.print("Введите количество лет (от 2 до 9999): ");
            n = scanner.nextInt();
            if (n <= 1 || n >= 10000) {
                System.out.println("Некорректный ввод.");
            }
        } while (n <= 1 || n >= 10000);

        String romanYear = convertToRoman(n);
        System.out.println(romanYear);
    }
}