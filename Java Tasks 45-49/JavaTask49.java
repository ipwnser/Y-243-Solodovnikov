import java.util.HashMap;
import java.util.Map;

public class JavaTask49 {
    private static Map<Long, Long> memo = new HashMap<>();
    public static long fusc(long n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        long result;
        if (n == 0) {
            result = 0; 
        } else if (n == 1) {
            result = 1; 
        } else if (n % 2 == 0) {
            result = fusc(n / 2);
        } else {
            long nDiv2 = n / 2;
            result = fusc(nDiv2) + fusc(nDiv2 + 1);
        }
        memo.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        for (long i = 0; i <= 20; i++) {
            System.out.println("fusc(" + i + ") = " + fusc(i));
        }
    }
}