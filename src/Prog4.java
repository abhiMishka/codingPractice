import java.util.*;

public class Prog4 {




    public static void main(String... args){


        int[][] grid = new int[][] {
                {3,0,8,4},
                {2,4,5,7},
                {9,2,6,3},
                {0,3,1,0}
        };

        int answer = maxIncreaseKeepingSkyline(grid);
        print(String.valueOf(answer));

    }

    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int total = 0;
        int rowMax = 0;
        ArrayList<Integer> maxLeftToRight = new ArrayList<>();
        HashMap<Integer,Integer> maxTopToBottom = new HashMap<>();
        for(int i=0; i<grid.length;i++ ){

            int[] x = grid[i];

            for(int j = 0;j<x.length;j++){

                if(maxTopToBottom.containsKey(j)) {
                    int val = maxTopToBottom.get(j);
                    if(val<x[j]){
                        maxTopToBottom.put(j, x[j]);
                    }
                }else{
                    maxTopToBottom.put(j, x[j]);
                }

                if(rowMax<x[j]){
                    rowMax = x[j];
                }
            }

            maxLeftToRight.add(rowMax);
//            print("max  : "+ rowMax);
            rowMax = 0;
        }

        for(int i=0; i<grid.length;i++ ) {

            int[] x = grid[i];

            for (int j = 0; j < x.length; j++) {
                total = total + (getMax(i,j,maxLeftToRight,maxTopToBottom) - x[j]);
            }
        }

        return total;
    }

    public static void print(String message){
        System.out.println(message);
    }

    public static int getMax(int i, int j, ArrayList<Integer> maxLeftToRight, HashMap<Integer, Integer> maxTopToBottom){
        int rowMax = maxLeftToRight.get(i);
        int colMax = maxTopToBottom.get(j);

        if(rowMax<colMax){
            return rowMax;
        }

        return colMax;
    }

}
