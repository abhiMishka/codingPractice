import java.util.Arrays;

/**
 * https://leetcode.com/problems/coin-change/
 */
public class Prog49 extends BaseTestClass {

    public static void main(String... args) {
        println(String.valueOf(coinChange(new int[]{2}, 3)));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] arr = new int[amount+1];
        for(int i=0;i<amount+1;i++){
            arr[i]= amount+1;
        }

//        println(Arrays.toString(arr));

        for (int i = 0; i < amount+1; i++) {
            int min = amount+1;
            int amountRequired = i;
            int stepsTaken = 0;
//            int remaining = amountRequired;
            for (int coinPicked : coins) {
                int remaining = amountRequired - coinPicked;
                if(remaining<=amountRequired && remaining>=0){
                    if(arr[remaining]!=0) {
                        int localSteps = 1 + arr[remaining];
                        if (localSteps < min) {
                            min = localSteps;
                        }
                    }else{
                        if(remaining==0){
                            min = 1;
                        }
                    }

                }else{
//                    remaining = amountRequired;
                }
            }
            if (min==amount+1) min = 0;
            arr[i] = min;
        }

        println(Arrays.toString(arr));


        return arr[amount]==0?-1:arr[amount];
    }
}
