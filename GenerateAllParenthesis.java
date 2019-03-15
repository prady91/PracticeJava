import java.util.ArrayList;
import java.util.List;

/**
 * Created by pradyumna on 2/17/19.
 *
 * https://www.interviewbit.com/problems/generate-all-parentheses-ii/
 *
 */


public class GenerateAllParenthesis {


    private void generateParenthesisUtil(int openAvailableCount, int closeAvailableCount, StringBuilder builder, List<String> parenthesisList) {

        if (openAvailableCount > closeAvailableCount) {
            return;
        }

        if (openAvailableCount == closeAvailableCount && openAvailableCount == 0) {
            parenthesisList.add(builder.toString());
            return;
        }

        if (openAvailableCount > 0) {
            builder.append('(');
            generateParenthesisUtil(openAvailableCount-1, closeAvailableCount, builder, parenthesisList);
            builder.deleteCharAt(builder.length()-1);
        }

        if (closeAvailableCount > 0) {
            builder.append(')');
            generateParenthesisUtil(openAvailableCount, closeAvailableCount-1, builder, parenthesisList);
            builder.deleteCharAt(builder.length()-1);
        }

        return;
    }

    public ArrayList<String> generateParenthesis(int A) {
        ArrayList<String> possibleParenthesis = new ArrayList<>();
        generateParenthesisUtil(A, A, new StringBuilder(), possibleParenthesis);
        return possibleParenthesis;
    }


    public static void main(String[] args) {
        GenerateAllParenthesis generateAllParenthesis = new GenerateAllParenthesis();
        generateAllParenthesis.generateParenthesis(0)
                .stream()
                .forEach(System.out::println);
    }
}

