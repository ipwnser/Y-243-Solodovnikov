public class JavaTask7 {
    public static void main(String[] args) {
        String input = "abc abc ab abc ab acs acs"; 
        String[] words = input.split(" "); 
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (!isWordInResult(result.toString(), words[i])) {
                result.append(words[i]).append(" "); 
            }
        }

        System.out.println(result.toString().trim());
    }

    public static boolean isWordInResult(String result, String word) {
        String[] resultWords = result.split(" ");
        for (String resultWord : resultWords) {
            if (resultWord.equals(word)) {
                return true; 
            }
        }
        return false; 
    }
}