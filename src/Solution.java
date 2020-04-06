import java.util.*;

class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String ab = in.nextLine();
            String[] input = ab.split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            String n = in.nextLine();
            String[] houses = n.split(" ");
            ArrayList<Integer> houseList = new ArrayList<>();
            for (String house :
                    houses) {
                houseList.add(Integer.parseInt(house));
            }

            int ans  = maxHouses(a,b,houseList);


            System.out.println("Case #" + i + ": " + ans);
        }
    }

    private static int maxHouses(int a, int b, ArrayList<Integer> houseList) {
        Collections.sort(houseList);
        int total = 0;
        for (int house :
                houseList) {
            b = b - house;
            if(b>=0){
                total++;
            }else{
                break;
            }
        }

        return total;

    }
}
