import java.util.HashSet;
import java.util.Set;

public class JavaTask36 {
    public static void main(String[] args) {
        String encryptedText = "Khoor Zruog"; 
        int shift = 3; 

        String decryptedText = decryptCaesarCipher(encryptedText, shift);
        System.out.println("Расшифрованный текст: " + decryptedText);

        Set<String> dictionary = createDictionary();

        checkWordsInDictionary(decryptedText, dictionary);
    }

    private static String decryptCaesarCipher(String text, int shift) {
        StringBuilder decrypted = new StringBuilder();
        
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                character = (char) ((character - base - shift + 26) % 26 + base);
            }
            decrypted.append(character);
        }
        
        return decrypted.toString();
    }

    private static Set<String> createDictionary() {
        Set<String> dictionary = new HashSet<>();

        dictionary.add("hello");
        dictionary.add("world");
        
        return dictionary;
    }

    private static void checkWordsInDictionary(String text, Set<String> dictionary) {
        String[] words = text.toLowerCase().split("\\W+"); 
        
        for (String word : words) {
            if (dictionary.contains(word)) {
                System.out.println("Слово найдено в словаре: " + word);
            }
        }
    }
}