import java.util.Arrays;

public class Prog10 extends BaseTestClass {

    private static int[] getArray1() {
        return new int[]{1,2};
    }
    private static int[] getArray2() { return new int[]{3,4}; }

    public static void main(String... args) {

        int[] arr1 = (getArray1());
        int[] arr2 = (getArray2());

        double ans = findMedianSortedArrays(arr1,arr2);

        print(String.valueOf(ans));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

//        int total = nums1.length +nums2.length;
//
//        int midIndex = total/2;
//        int prevEle = nums1[0]; int currentElement = 0;
//
////        int[] finalArr = new int[nums1.length+nums2.length];
//
//        int i =0; int j =0;
//        int fIndex = 0;
//
//        while(i<nums1.length && j<nums2.length){
//            if(nums1[i]<nums2[j]){
////                finalArr[fIndex] = nums1[i];
//                currentElement = nums1[i];
//                i++;
//                fIndex++;
//            }else{
////                finalArr[fIndex] = nums2[j];
//                currentElement = nums2[j];
//
//                j++;
//                fIndex++;
//            }
//
//            print("current element : " +currentElement +"\n");
//
//            if(fIndex+1==midIndex) break;
//
//            prevEle = currentElement;
//        }
//
//        if(i>=nums1.length){
//            while(j<nums2.length){
////                finalArr[fIndex] = nums2[j];
//                j++;
//                fIndex++;
//                if(fIndex==midIndex) break;
//            }
//
//        }
//
//        if(j>=nums2.length){
//            while(i<nums1.length){
////                finalArr[fIndex] = nums1[i];
//                i++;
//                fIndex++;
//                if(fIndex==midIndex) break;
//
//            }
//        }
//
////        print("finalArray  : " + Arrays.toString(finalArr) + " \n");
//
//        if(total%2==0){
////            int mid = finalArr.length/2;
//            return (double) (prevEle+currentElement)/2;
//        }else{
//            return (double) currentElement;
//        }


        int[] finalArr = new int[(nums1.length+nums2.length)/2 + 1];

        int i =0; int j =0;
        int fIndex = 0;

        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                finalArr[fIndex] = nums1[i];
                i++;
                fIndex++;
            }else{
                finalArr[fIndex] = nums2[j];
                j++;
                fIndex++;
            }

            if(fIndex>(nums1.length+nums2.length)/2) break;
        }

        if(fIndex<=(nums1.length+nums2.length)/2){
            if(i>=nums1.length){
                while(j<nums2.length){
                    finalArr[fIndex] = nums2[j];
                    j++;
                    fIndex++;
                    if(fIndex>finalArr.length-1) break;
                }
            }

            if(j>=nums2.length){
                while(i<nums1.length){
                    finalArr[fIndex] = nums1[i];
                    i++;
                    fIndex++;
                    if(fIndex>finalArr.length-1) break;
                }
            }
        }

//        print("finalArray  : " + Arrays.toString(finalArr) + " \n");

        if((nums1.length+nums2.length)%2==0){
            int mid = finalArr.length/2;
            return (double) (finalArr[finalArr.length-1]+finalArr[finalArr.length-2])/2;
        }else{
            return (double) finalArr[finalArr.length/2];
        }


    }



}
