public class JavaTask39 {
    public static void main(String[] args) {
        String inputText = "Привет, мир! Как дела? Это тестовое предложение.";
        String transformedText = transformText(inputText);
        System.out.println(transformedText);
    }

    private static String transformText(String text) {
        StringBuilder result = new StringBuilder();
        String[] words = text.split("(?<=\\W)|(?=\\W)"); 
        
        for (String word : words) {
            if (word.matches("\\w+")) {
                char firstChar = word.charAt(0);
                String transformedWord = word.substring(1) + firstChar + "ауч";
                result.append(transformedWord);
            } else {
                result.append(word);
            }
        }
        
        return result.toString();
    }
}