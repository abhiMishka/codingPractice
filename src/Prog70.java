import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Prog70 extends BaseTestClass {

    public static void main(String... args) {

        int[][] oranges1 = new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        int[][] oranges2 = new int[][]{
                {2, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        int[][] oranges3 = new int[][]{
                {}
        };

        int[][] oranges4 = new int[][]{
                {1, 1, 2, 0, 2, 0}
        };

        println(String.valueOf(orangesRotting(oranges1)));
        println(String.valueOf(orangesRotting(oranges2)));
        println(String.valueOf(orangesRotting(oranges3)));
        println(String.valueOf(orangesRotting(oranges4)));
    }


    /**
     * the value 0 representing an empty cell;
     * the value 1 representing a fresh orange;
     * the value 2 representing a rotten orange.
     *
     * @param grid
     * @return
     */
    public static int orangesRotting(int[][] grid) {
        if (grid.length == 0) return 0;
        int minutesPassed = 0;

        int FRESH = 1;
        int EMPTY = 0;
        int ROTTEN = 2;

        List<Node> rotten = new ArrayList<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == FRESH) {
                    fresh++;
                }
                if (grid[i][j] == ROTTEN) {
                    rotten.add(new Node(i, j));
                }
            }
        }

        List<Node> directions = new ArrayList<>();
        directions.add(new Node(-1, 0));
        directions.add(new Node(1, 0));
        directions.add(new Node(0, -1));
        directions.add(new Node(0, 1));

        while (fresh>0) {
            List<Node> newRotten = new ArrayList<>();
            List<Node> itemsToRemove = new ArrayList<>();
            for (Node node : rotten) {
                for (Node direction :
                        directions) {
                    Node newDirection = new Node(node.i + direction.i, node.j + direction.j);
                    if (isValid(grid, newDirection) && grid[newDirection.i][newDirection.j] == FRESH) {
                        newRotten.add(newDirection);
                        grid[newDirection.i][newDirection.j] = ROTTEN;
                        fresh--;
                    }
                }

                itemsToRemove.add(node);
            }
            rotten.removeAll(itemsToRemove);

            rotten.addAll(newRotten);

            if (rotten.isEmpty()) return -1;
            minutesPassed++;
        }

        return minutesPassed;
    }

    private static boolean isValid(int[][] grid, Node direction) {
        int i = direction.i;
        int j = direction.j;

        return (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length);

    }

//    private static boolean isValid()

    static class Node {
        int i, j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }

    }

    public static void dfs(int[][] grid, int i, int j) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) return;
        if (grid[i][j] == 0 || grid[i][j] == 2) return;

        grid[i][j] = 2;

        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);

    }
}
