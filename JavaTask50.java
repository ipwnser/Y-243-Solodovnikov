import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Calculator {
    private static final String HISTORY_FILE = "history.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> history = loadHistory();

        System.out.println("Добро пожаловать в калькулятор!");
        System.out.println("Введите выражение или 'exit' для выхода.");

        while (true) {
            System.out.print("Введите выражение: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                double result = evaluateExpression(input);
                System.out.println("Результат: " + result);
                String record = input + " = " + result;
                saveToHistory(record);
                history.add(record);
            } catch (Exception e) {
                System.out.println("Ошибка при вычислении выражения: " + e.getMessage());
            }
        }

        System.out.println("\nИстория вычислений:");
        for (String record : history) {
            System.out.println(record);
        }

        scanner.close();
    }

    private static List<String> loadHistory() {
        List<String> history = new ArrayList<>();
        File file = new File(HISTORY_FILE);
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    history.add(line);
                }
            } catch (IOException e) {
                System.out.println("Ошибка при чтении истории: " + e.getMessage());
            }
        }
        return history;
    }

    private static void saveToHistory(String record) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(HISTORY_FILE, true))) {
            bw.write(record);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении истории: " + e.getMessage());
        }
    }

    private static double evaluateExpression(String expr) throws Exception {
        expr = expr.replaceAll("\\s+", "");
        expr = processAbsoluteValues(expr);
        return evaluate(expr);
    }

    private static String processAbsoluteValues(String expr) throws Exception {
        Pattern pattern = Pattern.compile("\\|([^|]+)\\|");
        Matcher matcher = pattern.matcher(expr);

        while (matcher.find()) {
            String innerExpr = matcher.group(1);
            double value = evaluate(innerExpr);
            double absValue = Math.abs(value);
            expr = expr.replaceFirst(Pattern.quote("|" + innerExpr + "|"), Double.toString(absValue));
            matcher = pattern.matcher(expr);
        }
        return expr;
    }

    private static double evaluate(String expr) throws Exception {
        expr = evaluateOperator(expr, "\\^", true);
        expr = evaluateOperator(expr, "[*/%//]", false);
        return parseAndCompute(expr);
    }

    private static String evaluateOperator(String expr, String operatorRegex, boolean rightAssociative) throws Exception {
        Pattern pattern;
        
        if (operatorRegex.equals("\\^")) { 
            pattern = Pattern.compile("(-?\\d+(?:\\.\\d+)?)(\\^)(-?\\d+(?:\\.\\d+)?)");
        } else if (operatorRegex.equals("[*/%//]")) { 
            pattern = Pattern.compile("(-?\\d+(?:\\.\\d+)?)([*/%//])(-?\\d+(?:\\.\\d+)?)");
        } else { 
            throw new Exception("Неизвестный оператор");
        }

        Matcher matcher;

        while ((matcher = pattern.matcher(expr)).find()) {
            double leftOperand = Double.parseDouble(matcher.group(1));
            String op = matcher.group(2);
            double rightOperand = Double.parseDouble(matcher.group(3));
            double result;

            switch (op) {
                case "^":
                    result = Math.pow(leftOperand, rightOperand);
                    break;
                case "*":
                    result = leftOperand * rightOperand;
                    break;
                case "/":
                    if (rightOperand == 0) throw new Exception("Деление на ноль");
                    result = leftOperand / rightOperand;
                    break;
                case "%":
                    if (rightOperand == 0) throw new Exception("Деление по модулю на ноль");
                    result = leftOperand % rightOperand;
                    break;
                case "//":
                    if (rightOperand == 0) throw new Exception("Деление без остатка на ноль");
                    result = Math.floor(leftOperand / rightOperand);
                    break;
                default:
                    throw new Exception("Неизвестный оператор");
            }

            String replacement = Double.toString(result);
            int startIndex = matcher.start();
            int endIndex = matcher.end();
            expr = expr.substring(0, startIndex) + replacement + expr.substring(endIndex);
        }
        
        return expr;
    }

    private static double parseAndCompute(String expr) throws Exception {
        List<Double> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();

        Pattern patternNumberOperator =
                Pattern.compile("(-?\\d+(?:\\.\\d+)?|[+-])");

        Matcher matcher =
                Pattern.compile("[+-]?\\d+(?:\\.\\d+)?|[+-]").matcher(expr);

        int index = 0;

        while (index < expr.length()) {
            char ch = expr.charAt(index);

            if (ch == '+' || ch == '-') && index != 0 && Character.isDigit(expr.charAt(index - 1)) == false && expr.charAt(index -1 ) != ')') {
                operators.add(ch);
                index++;
            } else if (Character.isDigit(ch) || ch == '.') || ch == '+' || ch == '-') {

                int startIdx= index;

                while (index < expr.length() && 
                       (Character.isDigit(expr.charAt(index)) || expr.charAt(index)=='.')) {

                    index++;
                }
                String numberStr=expr.substring(startIdx,index);

                numbers.add(Double.parseDouble(numberStr));
                
             } else if(ch=='+' || ch=='-'){

                 operators.add(ch);
                 index++;
             }else{
                 index++;
             }
         }

         double result= numbers.get(0);

         for(int i=0; i<operators.size();i++){
             char op= operators.get(i);

             double nextNumber= numbers.get(i+1);

             switch(op){
                 case '+':
                     result+= nextNumber;
                     break;
                 case '-':
                     result-= nextNumber;
                     break;
                 default:
                     throw new Exception("Некорректный оператор");
             }
         }
         return result;
     }
}
