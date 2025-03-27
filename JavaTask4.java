public class JavaTask4 {
    public static void main(String[] args) {
        JavaTask4.squareMethod(2, 6);
    }
    public static void squareMethod(int firstNum, int secondNum){
        var funcStep = Math.min(firstNum, secondNum);
        var funcEnd = Math.max(firstNum, secondNum);
        var i = funcStep;
        while (i <= funcEnd){
            System.out.println(i*i);
            i += funcStep;
        }
    }
}