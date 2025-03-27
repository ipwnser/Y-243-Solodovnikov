public class JavaTask5 {
    public static void main(String[] args) {
        JavaTask5.stepsMethod(1,2,5);
    }
    public static void stepsMethod(int start, int step, int stepsCount){
        var i = start;
        while (i <= stepsCount*step){
            System.out.println(i);
            i += step;
        }
    }
}