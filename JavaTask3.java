public class JavaTask3 {
    public static void main(String[] args) {
        String result = vowelsRemoval("gdhdfikmkmapei");
        System.out.println("Строка без гласных: " + result);
    }
    public static String vowelsRemoval(String str) {
        String vowels = "aeiouAEIOU";
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (vowels.indexOf(c) == -1) {
                result.append(c); 
            }
        }
        return result.toString();
    }
}