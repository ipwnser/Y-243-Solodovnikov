public class JavaTask2 {
    public static void main(String[] args){
        JavaTask2.greetingsMethod("testArGUment");
    }
    public static void greetingsMethod(String name){
        var newName = name.toLowerCase();
        newName = newName.substring(0,1).toUpperCase() + newName.substring(1);
        System.out.println("Привет, " + newName + "!");
    }
}
