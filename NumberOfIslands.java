import java.util.HashSet;
import java.util.Set;

/**
 * Created by pradyumna on 7/21/18.
 */
public class NumberOfIslands {

    public boolean isValidPosition(int i, int j, int rows, int columns) {
        if (i >= rows || i < 0 || j < 0 || j >= columns) {
            return false;
        }
        return true;
    }

    public void bfs(char[][] grid, int i, int j, Set<String> visited) {
        String key = i+":"+j;
        if (visited.contains(key)) {
            return;
        }
        visited.add(key);
        int[] next_i = {0, 0, 1, -1};
        int[] next_j = {1, -1, 0, 0};
        for (int i1=0; i1<next_i.length; i1++) {
            int current_i = i+next_i[i1];
            int current_j = j+next_j[i1];
            if (isValidPosition(current_i, current_j, grid.length, grid[0].length) && grid[current_i][current_j] == '1') {
                bfs(grid, current_i, current_j, visited);
            }
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length, columns = grid[0].length;
        Set<String> visitedSet = new HashSet<>();
        int numIslands = 0;
        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                char currentValue = grid[i][j];
                String key = i+":"+j;
                if (currentValue == '1' && !visitedSet.contains(key)) {
                    numIslands++;
                    bfs(grid, i, j, visitedSet);
                }
            }
        }
        return numIslands;
    }
}
