import java.util.HashMap;
import java.util.Map;

public class JavaTask32 {
    public static void main(String[] args) {
        int i = 10; 
        long fibonacciNumber = fibonacci(i);
        System.out.println("F(" + i + ") = " + fibonacciNumber);
        Map<Character, Integer> digitCount = countDigits(fibonacciNumber);
        System.out.println("Наибольшее вхождение цифры: " + getMaxDigitCount(digitCount));
    }

    public static long fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long[][] matrix = {{1, 1}, {1, 0}};
        long[][] result = matrixPower(matrix, n - 1);
        return result[0][0];
    }

    private static long[][] matrixPower(long[][] matrix, int power) {
        long[][] result = {{1, 0}, {0, 1}}; 

        while (power > 0) {
            if (power % 2 == 1) {
                result = multiplyMatrices(result, matrix);
            }
            matrix = multiplyMatrices(matrix, matrix);
            power /= 2;
        }
        return result;
    }

    private static long[][] multiplyMatrices(long[][] a, long[][] b) {
        return new long[][]{
                {a[0][0] * b[0][0] + a[0][1] * b[1][0], a[0][0] * b[0][1] + a[0][1] * b[1][1]},
                {a[1][0] * b[0][0] + a[1][1] * b[1][0], a[1][0] * b[0][1] + a[1][1] * b[1][1]}
        };
    }

    public static Map<Character, Integer> countDigits(long number) {
        Map<Character, Integer> digitCount = new HashMap<>();
        
        String numberStr = String.valueOf(number);
        
        for (char digit : numberStr.toCharArray()) {
            digitCount.put(digit, digitCount.getOrDefault(digit, 0) + 1);
        }
        
        return digitCount;
    }

    public static String getMaxDigitCount(Map<Character, Integer> digitCount) {
        char maxDigit = ' ';
        int maxCount = -1;

        for (Map.Entry<Character, Integer> entry : digitCount.entrySet()) {
            char digit = entry.getKey();
            int count = entry.getValue();

            if (count > maxCount || (count == maxCount && digit < maxDigit)) {
                maxDigit = digit;
                maxCount = count;
            }
        }

        return "[" + maxCount + ", " + maxDigit + "]";
    }
}
