import java.util.*;

/**
 * Created by pradyumna on 2/20/19.
 *
 * https://leetcode.com/problems/remove-invalid-parentheses/
 */

public class RemoveInvalidParenthesis {


    private boolean verifyValidParenthesis(String s) {
        int count = 0;
        for (Character ch : s.toCharArray()) {
            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }

    public List<String> removeInvalidParentheses(String s) {

        List<String> validList = new ArrayList<>();

        if (s == null) {
            return validList;
        }

        if (verifyValidParenthesis(s)) {
            validList.add(s);
            return validList;
        }

        boolean foundValid = false;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(s);

        while (!queue.isEmpty()) {

            String childString = queue.poll();

            if (verifyValidParenthesis(childString)) {
                validList.add(childString);
                foundValid = true;
            }

            if (foundValid) {
                continue;
            }

            for (int i = 0; i < childString.length(); i++) {
                if (childString.charAt(i) != '(' && childString.charAt(i) != ')') {
                    continue;
                }
                String tmp = childString.substring(0, i) + childString.substring(i+1);
                if (!visited.contains(tmp)) {
                    queue.add(tmp);
                    visited.add(tmp);
                }
            }
        }

        return validList;
    }

    public static void main(String[] args) {
        RemoveInvalidParenthesis removeInvalidParenthesis = new RemoveInvalidParenthesis();
        removeInvalidParenthesis.removeInvalidParentheses("((")
                .stream()
                .forEach(System.out::println);
    }

}
