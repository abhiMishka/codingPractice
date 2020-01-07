public class Prog11 extends BaseTestClass {

    public static int[] getArray1() {
        return new int[]{1,8,6,2,5,4,8,3,7};
    }
    private static int[] getArray2() { return new int[]{3,4}; }

    public static void main(String... args) {

        int ans = maxArea(getArray1());

        print(String.valueOf(ans));

    }

    public static int maxArea(int[] height) {
        int maxWater  = 0;
        int currentMax = 0;
        int i=0;int j=1;

        if(height.length==1) return 0;

        while (i<height.length && j<height.length){
            if(height[j]>=height[i]){
                if(maxWater<(j-i)){
                    maxWater = j-i;
                }
                i = j;
                currentMax = j++;
            }else{
                j++;
            }

            print("i : " +i+ " , j " +j +" , max ; " +maxWater+"\n");
        }

        return maxWater*maxWater;

    }


}
