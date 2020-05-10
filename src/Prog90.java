import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prog90 extends BaseTestClass {
    public static void main(String... args){

    }

    public int minPathSum(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                dfs(grid,i,j,new boolean[grid.length][grid[0].length],0);
            }
        }
        int ans = dfs(grid,0,0,new boolean[grid.length][grid[0].length],0);
        return ans;
    }

    public static int dfs(int[][] mat, int i, int j, boolean[][] visited,int sum) {
        if(visited[i][j]) return 0;

        if(i== (mat.length-1) && j == (mat[0].length-1)) return 0;


        List<Integer> responseList = new ArrayList<>();

        visited[i][j] = true;

        for (int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (isValid(newI, newJ,mat)) {
                println("" +newI +" , " +newJ);
                responseList.add(mat[i][j] + dfs(mat, newI, newJ, visited,sum));
            }
        }


        return Collections.min(responseList);

    }
    private static boolean isValid(int i, int j,int[][] mat) {
        return (i >= 0 && i < mat.length && j >= 0 && j < mat[0].length);
    }
    static int[][] directions = new int[][]{
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public static void println(String message) {
        System.out.println(message);
    }
}
