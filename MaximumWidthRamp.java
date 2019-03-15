import java.util.Stack;

/**
 * Created by pradyumna on 12/23/18.
 */
public class MaximumWidthRamp {


    public int maxWidthRamp(int[] A) {
        Stack<Integer> minIndexStack = new Stack<Integer>();

        int l = A.length;
        for (int i = 0; i < l; i++) {
            if (minIndexStack.isEmpty() || A[minIndexStack.peek()] > A[i]) {
                minIndexStack.push(i);
            }
        }

        int res = 0;
        for (int i = l-1; i >= 0; i--) {
            while (!minIndexStack.isEmpty() && A[minIndexStack.peek()] <= A[i]) {
                res = Math.max(res, i-minIndexStack.pop());
            }
        }
        return res;
    }


}
