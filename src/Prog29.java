import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets-ii/
 */
public class Prog29 extends BaseTestClass {

    public static void main(String[] args) {
        print(subsetsWithDup(new int[]{1,1,2,2}).toString());
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> totalWithoutDupli = new ArrayList<>();
        HashMap<Integer,Integer> indexMap = new HashMap<>();
        int i = 0;
        List<Integer> list = new ArrayList<>();
        for(i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        Collections.sort(list);
        for(i=0;i<nums.length;i++){
            nums[i] = list.get(i);
        }
        i=0;
        int lastElementVisited = -1;
        List<Integer> sizeAtEachIteration = new ArrayList<>();
        for (int c : nums) {
            if (i == 0) {
                List<Integer> sets = new ArrayList<>();
                sets.add(c);
                totalWithoutDupli.add(new ArrayList<>());
                totalWithoutDupli.add(sets);
                lastElementVisited = c;
            } else {
                int startInx = 0;
                if (c == lastElementVisited) {
                    int pos = indexMap.get(c);
                    if(pos-1 < 0){
                        pos = 1;
                        startInx = sizeAtEachIteration.get(pos - 1)-1;
                    }else{
                        startInx = sizeAtEachIteration.get(pos - 1);
                    }
                }


                int size = totalWithoutDupli.size();

                for (int k = startInx; k < size; k++) {
                    List<Integer> s = new ArrayList<>(totalWithoutDupli.get(k));
                    s.add(c);
                    totalWithoutDupli.add(s);
                }
            }
            sizeAtEachIteration.add(totalWithoutDupli.size());
            lastElementVisited = c;
            indexMap.put(c,i);
            i++;

        }

        return totalWithoutDupli;
    }
}
