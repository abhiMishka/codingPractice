import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Prog96 extends BaseTestClass {
    public static void main(String... args){

        println("ans : " +combinationSum(new int[]{6,3,2,7},7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

//        Arrays.sort(candidates);
        dfs(candidates,target,new Stack<>(),ans,0);


        return ans;

    }


    public static void dfs(int[] candidates, int target, Stack<Integer> items, List<List<Integer>> ans,int idx) {

       if(target==0){
           ans.add(items);
           return;
       }

       if(target<0) return;
        for (int i= 0;i<candidates.length;i++) {
            Stack<Integer> s = new Stack<>();
            items.add(candidates[i]);
            dfs(candidates,target-candidates[i], (Stack<Integer>) items.clone(),ans,i);
            items.pop();
        }

    }
}
