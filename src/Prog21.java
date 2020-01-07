import java.util.Arrays;

public class Prog21 extends BaseTestClass {

    public static void main(String[] args) {

        int N = 30;
        print(fib(N)+"\n");
//        print(fib2(N));


    }


    public static int fib(int N) {
        int[] mem = new int[N + 1];
        for (int i = 0; i < mem.length; i++) {
            mem[i] = -1;
        }
        return cal(N,mem);
    }

    public static int cal(int N, int[] mem){
        mem[0] = 0;
        if (N == 0) {
            return 0;
        }

        if (N == 1) {
            return 1;
        }
        mem[1] = 1;



        for(int i=2;i<=N;i++){
            mem[i] = mem[i-1] + mem[i-2];
        }

        return mem[N];

    }

    public static int fib2(int N) {
        if(N == 0){
            return 0;
        }
        if(N == 1){
            return 1;
        }

        return fib(N-1) + fib(N-2);
    }
}
