import java.util.*;

public class Prog88 extends BaseTestClass {

    public static void main(String... args){
        println(String.valueOf(findTreasureIsland(new char[][]{
                {'O','O','O','O'},
                {'D','O','O','O'},
                {'O','D','D','D'},
                {'O','D','X','O'},
        })));
    }

    public static int findTreasureIsland(char[][] board){
        Deque<Node> nodeList = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        nodeList.push(new Node(0,0,0));
        visited[0][0] = true;
        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        while (!nodeList.isEmpty()){

            Node nd = nodeList.poll();
            println("nodePolled : " +nd.toString());

            for (int[] dir : directions) {
                int newI = nd.i + dir[0];
                int newJ = nd.j + dir[1];

                if (isValid(board, newI, newJ,visited)) {
                    if (board[newI][newJ] == 'X') {
                        return nd.count+1;
                    } else {
                        visited[newI][newJ] = true;
                        nodeList.add(new Node(newI, newJ,nd.count+1));
                    }
                }
            }
        }
        return 0;
    }



    public static boolean isValid(char[][] board, int i, int j, boolean[][] visited){
        return ((i>=0 && i< board.length) && (j<board[i].length && j>=0) && board[i][j] != 'D' && !visited[i][j]);
    }

    static class Node{
        int i,j,count;

        public Node(int i, int j,int count) {
            this.i = i;
            this.j = j;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "i=" + i +
                    ", j=" + j +
                    ", count=" + count +
                    '}';
        }
    }
}
