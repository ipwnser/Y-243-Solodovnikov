import java.util.Scanner;

public class JavaTask34 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество палочек: ");
        long n = scanner.nextLong();
        
        long tanyaSticks = calculateTanyaSticks(n);
        System.out.println("Количество палочек у Тани: " + tanyaSticks);
    }

    public static long calculateTanyaSticks(long n) {
        long tanyaSticks = 0;

        while (n > 0) {
            if (n % 2 == 0) { 
                n /= 2;
            } else { 
                n -= 1;
            }

            if (n > 0) {
                tanyaSticks++; 
                n -= 1; 
            }
        }

        return tanyaSticks;
    }
}
