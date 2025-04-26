class JavaTask29 {
    public static void main(String[] args) {
        int n = 40000000; 
        
        if (n <= 0 || n >= 100000) {
            System.out.println("Число должно быть в диапазоне 0 < n < 100000");
            return;
        }
        
        squaresMethod(n);
    }
    
    public static void squaresMethod(int n) {
        if (n % 2 != 1) {
            System.out.println("Для четных чисел не существует последовательных квадратов с такой разницей");
            return;
        }
        
        int k = (n - 1) / 2;
        int square1 = k * k;
        int square2 = (k + 1) * (k + 1);
        
        System.out.printf("%d = %d - %d\n", n, square2, square1);
    }
}
