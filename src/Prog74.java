import java.util.Objects;
import java.util.Stack;

public class Prog74 extends BaseTestClass {
    public static void main(String... args) {
        char[][] island1 = new char[][]{
                {'1', '1', '1', '1', '1'},
                {'0', '0', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        println("ans : " + numIslands(island1));

    }

    static int[][] directions = new int[][]{
            {0, -1},
            {0, 1},
            {1, 0},
            {-1, 0}
    };

    static int R;
    static int C;

    static boolean isValid(int i, int j) {
        return i >= 0 && i < R && j >= 0 && j < C;
    }

    public static int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int count = 0;
        R = grid.length;
        C = grid[0].length;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid, int i, int j) {
        if (grid[i][j] == '1') grid[i][j] = '0';
        for (int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (isValid(newI, newJ) && grid[newI][newJ] != '0') {
                dfs(grid, newI, newJ);
            }
        }

    }

}

/**
 *  static class Node {
 *         int i;
 *         int j;
 *
 *         public Node(int i, int j) {
 *             this.i = i;
 *             this.j = j;
 *         }
 *
 *         @Override
 *         public String toString() {
 *             return "Node{" +
 *                     "i=" + i +
 *                     ", j=" + j +
 *                     '}';
 *         }
 *
 *         @Override
 *         public boolean equals(Object o) {
 *             if (this == o) return true;
 *             if (o == null || getClass() != o.getClass()) return false;
 *             Node node = (Node) o;
 *             return i == node.i &&
 *                     j == node.j;
 *         }
 *
 *         @Override
 *         public int hashCode() {
 *             return Objects.hash(i, j);
 *         }
 *     }
 *
 *
 *     //    public static void exploreNode(char[][] grid, Node node2) {
 * //        Stack<Node> explore = new Stack<>();
 * //        explore.add(node2);
 * //        while (!explore.isEmpty()) {
 * //            Node node = explore.pop();
 * //            grid[node.i][node.j] = '0';
 * ////            println(node.toString());
 * //            for (int i = 0; i < directions.length; i++) {
 * //                int[] dir = directions[i];
 * //                int newI = node.i + dir[0];
 * //                int newJ = node.j + dir[1];
 * //                if (isValid(grid, newI, newJ) && grid[newI][newJ] == '1') {
 * //                    grid[newI][newJ] = '0';
 * ////                    println("adding");
 * //                    explore.add(new Node(newI, newJ));
 * //                }
 * //            }
 * //        }
 * //
 * ////        print2D(grid);
 * ////        printSeparation();
 * //    }
 */
