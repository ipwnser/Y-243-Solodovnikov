public class JavaTask1{
    
    public static void main(String[] args){
        JavaTask1.isEndOf("abc", "bc");
    }
    public static void isEndOf(String firstStr, String secondStr){
        var boolvalue = firstStr.substring(firstStr.length() - secondStr.length()).equals(secondStr);
        System.out.println(boolvalue);
    }
}