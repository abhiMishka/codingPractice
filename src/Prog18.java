import java.util.*;

public class Prog18 extends BaseTestClass {

    public static int[] getArray1() {
        return new int[]{0};
    }

    public static void main(String[] args) {

//        List<Integer> ans = findDisappearedNumbers(getArray1());
//        Integer ans = firstMissingPositive(getArray1());
        Integer ans = firstUniqChar2("loveleetcode");

        print("ans  : " + ans);

    }

    public static int firstUniqChar(String s) {
        int firstIndex = -1;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),-1);
            }else{
                map.put((s.charAt(i)),i);
            }
        }
        if(map.keySet().isEmpty()) return firstIndex;

        int index = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(index==0 && entry.getValue()!=-1){
                firstIndex = entry.getValue();
                index++;
            }else if(entry.getValue()==-1){
                continue;
            }else{
                if(entry.getValue()<firstIndex){
                    firstIndex = entry.getValue();
                }
            }

        }
        return firstIndex;
    }

    public static int firstUniqChar2(String s) {
        int firstIndex = 0;
        int alphabets[] = new int[26];
        for(int i=0;i<s.length();i++) {
            if(i==0){
                alphabets[s.charAt(i)%26] = -4;
                continue;
            }
            if(alphabets[s.charAt(i)%26]!=0){
                alphabets[s.charAt(i)%26] = -2;
            }else{
                alphabets[s.charAt(i)%26]=i;
            }
        }

        for(int i =0;i<alphabets.length;i++){
            if(alphabets[i]==0 || alphabets[i]==-2) continue;
            if(alphabets[i]==-4) return 0;
            if(firstIndex==0){
                firstIndex=alphabets[i];
            }else if(alphabets[i]<firstIndex){
                    firstIndex=alphabets[i];

            }
        }
            return firstIndex;
    }

    public static int maxSubArray(int[] nums) {


        if (nums.length == 1) {
            return nums[0];
        }

        int maxTillHere = nums[0];
        int currentMax = nums[0];

        for (int i = 1; i < nums.length; i++) {


        }

        return maxTillHere;

    }

    public static int removeElement(int[] nums, int val) {

        int length = nums.length;
        int i = 0;
        int j = 1;
        int total = 0;

        for (int a :
                nums) {
            if (a == val) total++;
        }

        while (j <= length - 1) {
            if (nums[j] == val) {
                j++;
                continue;
            } else if (nums[i] == val) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            } else {
                if (j == i + 1) j++;
                i++;
            }

            if (i >= length) break;

            if (nums[i] == val) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }


        }

        print("newArray : " + Arrays.toString(nums) + " , total : " + (total + 1) + "\n");

        if (total == nums.length) {
            return 0;
        } else {
            return i + 1;
        }

    }

    public static List<Integer> findDuplicates(int[] nums) {

        List<Integer> listOfRepeating = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int current = Math.abs(nums[i]);
            int elementAtPos = nums[current - 1];

            if (elementAtPos < 0) {
                listOfRepeating.add(current);
            } else {
                nums[current - 1] = -1 * elementAtPos;
            }

        }

        return listOfRepeating;

    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> listOfMissing = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int current = Math.abs(nums[i]);
            int elementAtPos = nums[current - 1];

            if (elementAtPos > 0) {
                nums[current - 1] = -1 * elementAtPos;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                listOfMissing.add(i + 1);
            }
        }

        return listOfMissing;

    }

    public static int firstMissingPositive(int[] nums) {

//        print("original : " +Arrays.toString(nums) +"\n");

        int i = 0;
        while (i < nums.length) {
            if (nums[i] > nums.length - 1 || nums[i] <= 0) {
                i++;
                continue;
            }
            if (nums[i] == i + 1) {
                i++;
            } else {
                if (nums[nums[i] - 1] != nums[i]) {
                    swap(nums, nums[i] - 1, i);
                } else {
                    i++;
                }
//                    print("after swap : " +Arrays.toString(nums) +"\n");

            }

        }

//        print("modified : " +Arrays.toString(nums) +"\n");

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }


        return i + 1;

    }

    public static int firstMissingPositive2(int[] A) {
        int i = 0;
        while (i < A.length) {
            if (A[i] == i + 1 || A[i] <= 0 || A[i] > A.length) i++;
            else if (A[A[i] - 1] != A[i]) swap(A, i, A[i] - 1);
            else i++;
        }
        i = 0;
        while (i < A.length && A[i] == i + 1) i++;
        return i + 1;
    }

    public static void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static int missingNumber(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) < nums.length) {
                nums[Math.abs(nums[i])] = -1 * Math.abs(nums[Math.abs(nums[i])]);
                if(nums[Math.abs(nums[i])]==0 ){
                    nums[Math.abs(nums[i])] = -1*nums.length ;
                    nums[0]  = -1*nums.length;
                }
            }
        }

//        print("output : " +Arrays.toString(nums) +"\n");

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) return i;
        }

        return nums.length;
    }

    public static int missingNumber1(int[] nums) {

        int total = 0;
        int n = nums.length;

        for (int a :
                nums) {
            total = total + a;
        }

        return ((n*(n+1))/2)-total;
    }

}