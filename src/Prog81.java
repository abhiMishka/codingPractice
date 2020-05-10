public class Prog81 {

    public static void main(String... args) {

        for (int i = 0; i < 10; i++) {
            int ans = findNthPrime(i);
            System.out.println(i +" = "+ans);
        }
    }

    public static int findNthPrime(int n){
        if(n==0) return 0;
        if(n==1) return 2;
        if(n==2) return 3;

        int count = 2;
        boolean isDivisible;

       while(true){

           for(int i = 4;i<Integer.MAX_VALUE;i++){
               isDivisible = false;
                for(int j = 2;j<=Math.sqrt(i);j++){
                    if(i%j==0){
                        isDivisible = true;
                        break;
                    }
                }
                if(!isDivisible) count++;
                if(count == n){
                    return i;
                }
           }

       }

    }
}
