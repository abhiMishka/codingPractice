/**
 * https://leetcode.com/problems/satisfiability-of-equality-equations/submissions/
 */
public class Prog43 extends BaseTestClass {
    public static void main(String... args){
        print(String.valueOf(equationsPossible(new String[]{"a==b","b==c","c!=a"})));
    }

    public static boolean equationsPossible(String[] equations) {
        boolean isPossible = true;

        int alphabetArray[] = new int[26];

        for(int i=0;i<alphabetArray.length;i++){
            alphabetArray[i] = i;
        }

        for (String equation :
                equations) {
            if (isSignEquals(equation)){
                union(alphabetArray,equation.charAt(0)%26,equation.charAt(3)%26);
            }
        }

        for (String equation :
                equations) {
            if (!isSignEquals(equation)){
                if(isConntected(alphabetArray,equation.charAt(0)%26,equation.charAt(3)%26)){
                    isPossible = false;
                }
            }
        }


        return isPossible;
    }

    public static void union(int[] arr,int i,int j){
        if(i!=j) {
            int rooti = getRoot(arr,i);
            int rootj = getRoot(arr,j);

            arr[rootj] = rooti;
        }
    }

    public static int getRoot(int[] arr,int i){
        while(arr[i]!=i){
            i = arr[i];
        }
        return i;
    }

    public static boolean isConntected(int[] arr,int i,int j){

        return getRoot(arr,i) == getRoot(arr,j);
    }



    public static boolean isSignEquals(String eqn){
        return eqn.charAt(1) != '!';
    }
}
