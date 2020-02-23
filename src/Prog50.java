public class Prog50 extends BaseTestClass {

    public static void main(String... args){
        print(climbStairs(3));
    }

    public static int climbStairs(int n) {


        int[] arr = new int[n+1];
        for(int i=0;i<n+1;i++){
            arr[i] = -1;
        }

        return recurse(n,arr);
    }


    public static int recurse(int n,int[] arr){

        if(n==0) return 1;
        if(n==1) return 1;
        if(arr[n]!=-1) return arr[n];

        arr[n] =  recurse(n-1,arr) +recurse(n-2,arr);

        return arr[n];
    }
}
