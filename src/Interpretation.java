import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class Interpretation {
    Map<Character, Integer> arguments = null;
    int left, right, power = 0;

    public void setArguments(Map<Character, Integer> arguments) {
        this.arguments = arguments;
    }

    public void parse(String expression) {
        System.out.println("METHOD BEGAN");
        Character operator = null;
        for (Character token : expression.toCharArray()) {
            if (Character.isLetter(token)) {
                if (left == 0)
                    left = arguments.get(token);
                else {
                    right = arguments.get(token);
                    left = colculate(operator);
                }
            } else if (Character.isDigit(token)) {
                right = token;
                left = colculate(operator);
            } else
                operator = token;
        }
        System.out.println("RESULT " + left);
    }

    private int colculate(Character ch) {
        int result = 0;
        switch (ch) {
            case '*':
                result = left * right;
                break;
            case '+':
                result = left + right;
                break;
            case '-':
                result = left - right;
                break;
            case '/':
                result = left / right;
                break;
            case '^':
                result = left ^ right;
                break;
        }
        return result;
    }
}

