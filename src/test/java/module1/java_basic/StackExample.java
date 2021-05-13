package module1.java_basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StackExample {
    private static Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('[', ']');
        put('{', '}');
        put('(', ')');
    }};

    public static void main(String[] args){
        Boolean result = balanced("[()]{}{[(()]()})");
        String resultMsg = result ? "Balanced" : "Unbalanced";
        System.out.println(resultMsg);
    }

    private static Boolean balanced(String input) {
        Stack<Character> stack = new Stack<Character>();

        for (Character tmp: input.toCharArray()) {
            if ("([{".indexOf(tmp) != -1) {
                stack.push(tmp);
            } else {
                Character start = stack.empty() ? null : stack.pop();
                if (start == null || !map.get(start).equals(tmp)) {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
