public class JavaTask28 {
    public static String caesarCipher(String text, int shift, String direction) {
        if (direction.equalsIgnoreCase("left")) {
            shift = -shift;
        } else {
            direction = "right";
        }

        StringBuilder result = new StringBuilder();

        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                int alphabetSize = 26; 

                int offset = ch - base;

                int shifted = (offset + shift) % alphabetSize;
                if (shifted < 0) shifted += alphabetSize;

                char encryptedChar = (char) (base + shifted);
                result.append(encryptedChar);
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {

        String encrypted = caesarCipher("Test text", 3, "left");
        System.out.println("Encrypted string: " + encrypted);
    }
}