import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaTask46 {
    public static int convertToArabic(String roman) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;
        int prevValue = 0;

        for (int i = roman.length() - 1; i >= 0; i--) {
            char c = roman.charAt(i);
            int value = romanMap.getOrDefault(c, -1);

            if (value == -1) {
                throw new IllegalArgumentException("Некорректный римский символ: " + c);
            }

            if (value < prevValue) {
                total -= value;
            } else {
                total += value;
                prevValue = value;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputRoman;
        int arabicNumber;

        while (true) {
            System.out.print("Введите римское число (от II до MMMCMXCIX): ");
            inputRoman = scanner.nextLine().toUpperCase();

            try {
                arabicNumber = convertToArabic(inputRoman);

                if (arabicNumber < 2 || arabicNumber > 9999) {
                    System.out.println("Число вне диапазона от II до MMMCMXCIX. Попробуйте снова.");
                } else {
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage() + " Попробуйте снова.");
            }
        }

        System.out.println("Арабское число: " + arabicNumber);
    }
}