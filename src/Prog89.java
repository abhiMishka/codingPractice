import java.util.*;

public class Prog89 extends BaseTestClass {

    public static void main(String... args) {
        print2D((updateMatrix(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1},
                {1, 1, 1}
        })));
        printSeparation();
//
//        print2D((updateMatrix(new int[][]{
//                {0, 0, 0},
//                {0, 1, 0},
//                {0, 0, 0}
//        })));

//        print2D((updateMatrix(new int[][]{
//                {0, 0, 1, 0, 1, 1, 1, 0, 1, 1},
//                {1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
//                {1, 1, 1, 1, 1, 0, 0, 0, 1, 1},
//                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
//                {0, 0, 1, 1, 1, 0, 1, 1, 1, 1},
//                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
//                {1, 1, 1, 1, 0, 1, 0, 1, 0, 1},
//                {0, 1, 0, 0, 0, 1, 0, 0, 1, 1},
//                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
//                {1, 0, 1, 1, 1, 0, 1, 1, 1, 0}
//        })));
//        print2D((updateMatrix(new int[][]{
//                {1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
//                {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
//                {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
//                {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
//                {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
//                {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
//                {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
//                {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
//                {1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
//                {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}}
//        )));
    }

    public static int[][] updateMatrix(int[][] matrix) {

        if (matrix.length == 0) return matrix;

        int[][] ansMatrix = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    ansMatrix[i][j] = 0;
                } else {
                    boolean[][] doneBfs = new boolean[matrix.length][matrix[0].length];
                    ansMatrix[i][j] = dfs(matrix, i, j, doneBfs);
                    print2D(ansMatrix);
                    printSeparation();
//                    int top = Integer.MAX_VALUE, bottom = Integer.MAX_VALUE, right = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
//                    if (i - 1 >= 0) {
//                        if (doneBfs[i - 1][j]) {
//                            top = matrix[i - 1][j];
//                        } else {
//                            top = bfs(matrix, i - 1, j);
//                            doneBfs[i - 1][j] = true;
//                        }
//                    }
//                    if (i + 1 < matrix.length) {
//                        if (doneBfs[i + 1][j]) {
//                            bottom = matrix[i + 1][j];
//                        } else {
//                            bottom = bfs(matrix, i + 1, j);
//                            doneBfs[i + 1][j] = true;
//                        }
//                    }
//                    if (j + 1 < matrix[0].length) {
//                        if (doneBfs[i][j + 1]) {
//                            right = matrix[i][j + 1];
//                        } else {
//                            right = bfs(matrix, i, j + 1);
//                            doneBfs[i][j + 1] = true;
//                        }
//                    }
//                    if (j - 1 >= 0) {
//                        if (doneBfs[i][j - 1]) {
//                            left = matrix[i][j - 1];
//                        } else {
//                            left = bfs(matrix, i, j - 1);
//                            doneBfs[i][j - 1] = true;
//                        }
//                    }
//                    println("for " + i + " , " + j + " top: " + top + " left: " + left + " right: " + right + " bottom: " + bottom);
//                    ansMatrix[i][j] = Math.min(Math.min(Math.min(top, bottom), right), left) + 1;
//                    matrix[i][j] = ansMatrix[i][j];
//                    doneBfs[i][j] = true;
                }
            }


        }

        return ansMatrix;
    }

    static int[][] directions = new int[][]{
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    private static int bfs(int[][] matrix, int i, int j) {
        if (matrix[i][j] == 0) return 0;
        Deque<Node> nodeDeque = new LinkedList<>();
        nodeDeque.push(new Node(i, j, matrix[i][j]));
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        while (!nodeDeque.isEmpty()) {

            Node node = nodeDeque.poll();
            int c = matrix[i][j];
            visited[node.i][node.j] = true;
            for (int[] dir :
                    directions) {
                int newI = node.i + dir[0];
                int newJ = node.j + dir[1];

                if (isValid(matrix, newI, newJ, visited)) {
                    if (matrix[newI][newJ] == 0) {
                        return c + 1;
                    } else {
                        visited[i][j] = true;
                        nodeDeque.add(new Node(newI, newJ, c + 1));
                    }

                }
            }


        }

        return 0;
    }


    private static int recBfs(int[][] matrix, int i, int j, boolean[][] visited) {
        if (!isValid(matrix, i, j, visited)) return 0;

        if (matrix[i][j] > 1) return matrix[i][j] + 1;

        List<Integer> responseList = new ArrayList<>();

        for (int[] dir :
                directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (isValid(matrix, newI, newJ, visited)) {
                visited[i][j] = true;
                responseList.add(recBfs(matrix, newI, newJ, visited));
                visited[newI][newJ] = true;
            }
        }
        println("responseList : " + responseList.toString());
        int min = Integer.MAX_VALUE;
        for (int a :
                responseList) {
            if (a < min) min = a;
        }
        matrix[i][j] = min + 1;
        return matrix[i][j];

    }

    static boolean isValid(int[][] mat, int i, int j, boolean[][] visited) {
        return (i >= 0 && i < mat.length && j >= 0 && j < mat[0].length && !visited[i][j]);
    }

    static class Node {
        int i, j, count;

        public Node(int i, int j, int count) {
            this.i = i;
            this.j = j;
            this.count = count;
        }
    }

    public static int dfs(int[][] mat, int i, int j, boolean[][] visited) {
        if(visited[i][j]) return mat[i][j]+1;
        if (mat[i][j] == 0 ) return 1;
        if (mat[i][j] > 1 ) return mat[i][j];

        List<Integer> responseList = new ArrayList<>();

        visited[i][j] = true;

        for (int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (isValid(newI, newJ,mat)) {
                responseList.add(dfs(mat, newI, newJ, visited));
            }
        }

        mat[i][j] = Collections.min(responseList);
        return mat[i][j];

    }

    private static boolean isValid(int i, int j,int[][] mat) {
        return (i >= 0 && i < mat.length && j >= 0 && j < mat[0].length);
    }
}
