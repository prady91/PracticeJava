import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by pradyumna on 6/5/18.
 */
public class ValidParenthesis {

    public boolean isValidParenthesis(String s) {

        if (s == null || s.isEmpty()) {
            return true;
        }

        Set<Character> parSet = "[]{}()".chars().mapToObj(c -> (char)c).collect(Collectors.toSet());
        Map<Character, Character> parenthesisMap = new HashMap<>();
        parenthesisMap.put('[', ']');
        parenthesisMap.put('(', ')');
        parenthesisMap.put('{', '}');

        Stack<Character> parStack = new Stack<>();
        for (Character ch : s.toCharArray()) {
            if (!parSet.contains(ch)) {
                continue;
            }
            if (parenthesisMap.containsKey(ch)) {
                parStack.push(ch);
            } else if (!parStack.isEmpty() && parenthesisMap.get(parStack.peek()).equals(ch)) {
                parStack.pop();
            } else {
                return false;
            }
        }
        return parStack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParenthesis validParenthesis = new ValidParenthesis();
        String str = "[a,b](c)";
        System.out.println(validParenthesis.isValidParenthesis(str));
    }

}
