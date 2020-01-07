public class Prog1 {

    public static final int SHIFT_ARRAY_BY = 2;

    public static void main(String... args){
        int[] arr = getArray();
        int[] shifted = shiftArrayBy(SHIFT_ARRAY_BY,arr);

        System.out.println("original array");
        for (int i =0;i<arr.length; i++){
            System.out.print(arr[i]+",");
        }

        System.out.println("\nshifted array");

        for (int i =0;i<arr.length; i++){
            System.out.print(shifted[i]+",");

        }
    }

    private static int[] getArray(){
        return new int[]{1,2,3,4,5};
    }

    private static int[] shiftArrayBy(int shiftArrayBy, int[] arr) {
        int[] newArr = new int[arr.length];
        for (int i =0;i<arr.length; i++){
            int newPosition = i + shiftArrayBy;
            if(newPosition<=arr.length-1){
                newArr[newPosition] = arr[i];
            }else{
                newPosition = newPosition%arr.length;
                newArr[newPosition] = arr[i];
            }

//            System.out.println(i +" shifted to pos " +newPosition);

        }

        return newArr;

    }

}
