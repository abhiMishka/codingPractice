public class Prog53 extends BaseTestClass {

    public static void main(String... args) {
//        println(String.valueOf(exist(new char[][]{
//                        {'A', 'B', 'C', '1'},
//                        {'0', 'H', 'I', '1'},
//                        {'0', '1', 'S', '1'},
//                        {'0', '1', '1', '1'}
//                }, "ABHI"))
//        );

        println(String.valueOf(isPalindrome("Abhiihba")));

    }

    public static boolean exist(char[][] board, String word) {

        boolean answer = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    answer = findRecursively(board, i, j, word, 0);
                    if (answer) return answer;
                }
            }
        }
        return answer;
    }

    private static boolean findRecursively(char[][] board, int i, int j, String word, int wordPos) {

        if (i < 0 || i >= word.length() || j < 0 || j > board[i].length) return false;

        if (board[i][j] == word.charAt(wordPos)) {
            return true;
        }


        return findRecursively(board, i + 1, j, word, wordPos + 1) ||
                findRecursively(board, i - 1, j, word, wordPos + 1) ||
                findRecursively(board, i, j + 1, word, wordPos + 1) ||
                findRecursively(board, i, j - 1, word, wordPos + 1);


    }

    public static boolean isPalindrome(String word) {
       int wordLength = word.length();
       int mid1 = wordLength/2;
       int mid2 = mid1;


       if(wordLength%2==0){
           mid2 = wordLength/2;
           mid1 = mid2-1;
       }

//        println(mid1+"");
//        println(mid2+"");

       boolean isPalindrome = true;

       while (mid1<wordLength && mid1>=0 && mid2<wordLength){
           if(Character.toLowerCase(word.charAt(mid1))!=Character.toLowerCase(word.charAt(mid2))){
               isPalindrome = false;
           }
           mid1--;
           mid2++;
       }

       return isPalindrome;

    }

//    public static String validateRegex(String regex){
//
//    }
}
