public class Prog42 extends BaseTestClass {

    public static void main(String... args) {
        solve(new char[][]{
                        {'O', 'X', 'X', 'X', 'X', 'X', 'O', 'O'},
                        {'O', 'O', 'O', 'X', 'X', 'X', 'X', 'O'},
                        {'X', 'X', 'X', 'X', 'O', 'O', 'O', 'O'},
                        {'X', 'O', 'X', 'O', 'O', 'X', 'X', 'X'},
                        {'O', 'X', 'O', 'X', 'X', 'X', 'O', 'O'},
                        {'O', 'X', 'X', 'O', 'O', 'X', 'X', 'O'},
                        {'O', 'X', 'O', 'X', 'X', 'X', 'O', 'O'},
                        {'O', 'X', 'X', 'X', 'X', 'O', 'X', 'X'}
                }
        );

//        {'X', 'O', 'X', 'X'},
//        {'X', 'O', 'O', 'X'},
//        {'X', 'X', 'O', 'X'},
//        {'X', 'O', 'X', 'X'}

//        {'X', 'O', 'X', 'X','O'},
//        {'O', 'O', 'X', 'X','O'},
//        {'X', 'X', 'O', 'X','O'},
//        {'X', 'O', 'X', 'X','O'},
//        {'X', 'X', 'X', 'X','O'}
    }

    public static void solve(char[][] board) {

        if (board.length == 0) return;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || i == board.length - 1 || j == 0 || j == board[i].length - 1) {
                        board[i][j] = '1';
                    } else if (board[i - 1][j] == '1') {
                        board[i][j] = '1';
                    } else if (board[i + 1][j] == '1') {
                        board[i][j] = '1';
                    } else if (board[i][j - 1] == '1') {
                        board[i][j] = '1';
                    } else if (board[i][j + 1] == '1') {
                        board[i][j] = '1';
                    }
                }
            }
        }

        print2DArray(board);

        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || i == board.length - 1 || j == 0 || j == board[i].length - 1) {
                        board[i][j] = '1';
                    } else if (board[i - 1][j] == '1') {
                        board[i][j] = '1';
                    } else if (board[i + 1][j] == '1') {
                        board[i][j] = '1';
                    } else if (board[i][j - 1] == '1') {
                        board[i][j] = '1';
                    } else if (board[i][j + 1] == '1') {
                        board[i][j] = '1';
                    }
                }
            }
        }

       print2DArray(board);

        for (int j = 0; j < board[0].length; j++) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || i == board.length - 1 || j == 0 || j == board[i].length - 1) {
                        board[i][j] = '1';
                    } else if (board[i - 1][j] == '1') {
                        board[i][j] = '1';
                    } else if (board[i + 1][j] == '1') {
                        board[i][j] = '1';
                    } else if (board[i][j - 1] == '1') {
                        board[i][j] = '1';
                    } else if (board[i][j + 1] == '1') {
                        board[i][j] = '1';
                    }
                }
            }
        }


        print2DArray(board);

        for (int j = board[0].length - 1; j >= 0; j--) {
            for (int i = board.length - 1; i >= 0; i--) {
                if (board[i][j] == 'O') {
                    if (i == 0 || i == board.length - 1 || j == 0 || j == board[i].length - 1) {
                        board[i][j] = '1';
                    } else if (board[i - 1][j] == '1') {
                        board[i][j] = '1';
                    } else if (board[i + 1][j] == '1') {
                        board[i][j] = '1';
                    } else if (board[i][j - 1] == '1') {
                        board[i][j] = '1';
                    } else if (board[i][j + 1] == '1') {
                        board[i][j] = '1';
                    }
                }
            }
        }

        print2DArray(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }

        print2DArray(board);

    }

    private static void print2DArray(char[][] board) {
        print("\n");

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                print(board[i][j] + " ");
            }
            print("\n");
        }
    }
}
