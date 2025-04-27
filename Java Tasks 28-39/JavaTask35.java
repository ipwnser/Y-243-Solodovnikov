import java.util.Arrays;
import java.util.Comparator;

public class JavaTask35 {
    public static void main(String[] args) {
        int[] weights = {56, 65, 74, 100, 99, 68, 86, 180, 90};
        Arrays.sort(weights, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return Integer.compare(sumOfDigits(b), sumOfDigits(a));
            }
        });


        System.out.println(Arrays.toString(weights).replaceAll("[\$$\$$\]", ""));
    }


    private static int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}