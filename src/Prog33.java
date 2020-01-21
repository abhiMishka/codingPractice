import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/find-k-th-smallest-pair-distance/
 */
public class Prog33 extends BaseTestClass {
    public static void main(String... args) {

        int ans = smallestDistancePair(new int[]{1,3,2,2,5,7},1);
        print("final answer : " +ans);

    }

    public static int smallestDistancePair(int[] nums, int k) {
        int smalledDist = 0;
        ArrayList<Integer> numList = new ArrayList<Integer>();
        ArrayList<Integer> diffList = new ArrayList<Integer>();
        for(int a : nums) numList.add(a);
        Collections.sort(numList);
        int diff;
        for(int i =0;i<numList.size()-1;i++){
            diff = numList.get(i+1)-numList.get(i);
            diffList.add(diff);
            if(diff<smalledDist) smalledDist = diff;
        }
        Collections.sort(diffList);
        smalledDist = diffList.get(k-1);
//        print(diffList.toString()+"\n");

        return smalledDist;

    }

}
