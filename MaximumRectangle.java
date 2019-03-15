/**
 * Created by pradyumna on 2/14/19.
 */
public class MaximumRectangle {

    class DPState{
        int maxRectWidth;
        int maxRectHeight;
        int maxLeft;
        int maxTop;

        DPState() {
            maxRectWidth = 0;
            maxRectHeight = 0;
            maxLeft = 0;
            maxTop = 0;
        }
    }

    public int maximalRectangle(char[][] matrix) {

        int rows = matrix.length, cols = matrix[0].length;

        DPState[][] dpStates = new DPState[rows][cols];
        int maxRect = 0;

        for (int i=0; i<rows; i++) {

            for (int j=0; j<cols; j++) {
                dpStates[i][j] = new DPState();

                if (matrix[i][j] == '1') {
                    dpStates[i][j].maxLeft = 1;
                    dpStates[i][j].maxTop = 1;
                    dpStates[i][j].maxRectHeight = 1;
                    dpStates[i][j].maxRectWidth = 1;

                    int leftRectArea = 1;
                    int topRectArea = 1;

                    if (j > 0) {
                        DPState leftDPState = dpStates[i][j - 1];
                        dpStates[i][j].maxLeft = leftDPState.maxLeft + 1;
                    }
                    if (i > 0) {
                        DPState topDPState = dpStates[i-1][j];
                        dpStates[i][j].maxTop = topDPState.maxTop + 1;
                    }

                    if (j > 0) {
                        DPState leftDPState = dpStates[i][j - 1];
                        leftRectArea = (leftDPState.maxLeft + 1)*Math.min(dpStates[i][j - 1].maxRectHeight, dpStates[i][j].maxTop);
                    }

                    if (i > 0) {
                        DPState topDPState = dpStates[i-1][j];
                        topRectArea = (topDPState.maxTop + 1)*Math.min(dpStates[i - 1][j].maxRectWidth, dpStates[i][j].maxLeft);
                    }

                    if (dpStates[i][j].maxLeft > Math.max(leftRectArea, Math.max(topRectArea, dpStates[i][j].maxTop))) {
                        dpStates[i][j].maxRectWidth = dpStates[i][j].maxLeft;
                        dpStates[i][j].maxRectHeight = 1;
                    } else if (dpStates[i][j].maxTop > Math.max(leftRectArea, Math.max(topRectArea, dpStates[i][j].maxLeft))) {
                        dpStates[i][j].maxRectHeight = dpStates[i][j].maxTop;
                        dpStates[i][j].maxRectWidth = 1;
                    } else if (leftRectArea > Math.max(dpStates[i][j].maxTop, Math.max(topRectArea, dpStates[i][j].maxLeft))) {

                    }
                    int maxAdj = Math.max(dpStates[i][j].maxRectHeight*dpStates[i][j].maxLeft, dpStates[i][j].maxRectWidth*dpStates[i][j].maxTop);
                    int maxLine = Math.max(dpStates[i][j].maxLeft, dpStates[i][j].maxTop);

                    maxRect = Math.max(maxAdj, Math.max(maxRect, maxLine));
                }
            }
        }
        return maxRect;
    }


    public static void main(String[] args) {

    }


}
