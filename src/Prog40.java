import java.util.ArrayList;
import java.util.Collections;

public class Prog40 extends BaseTestClass {

    public static void main(String... args){
        MedianFinder obj = new MedianFinder();
        addNums(new int[]{6,10,2,6,5},obj);

    }

    public static void addNums(int nums[],MedianFinder obj){
        for (int a : nums) {
            obj.addNum(a);
            print("ans median : " +obj.findMedian()+" list : "+obj.list +"\n" );

        }
    }
}
class MedianFinder {

    ArrayList<Integer> list;
    int i=-1;
    boolean odd= false;
    /** initialize your data structure here. */
    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        boolean added = false;
        for(int k=0;k<list.size();k++){
            if(list.get(k)>num){
                list.add(k,num);
                added = true;
                break;
            }
        }
        if(!added) {
            list.add(num);
        }
        odd = !odd;
        if(odd) {
            i++;
        }
    }

    public double findMedian() {
        if(list.isEmpty()) return 0;
//        Collections.sort(list);

        if(odd){
            return list.get(i);
        }else{
            return (list.get(i)+list.get(i+1))/2D;
        }
    }

    public ArrayList<Integer> getList() {
        return list;
    }

    public void setList(ArrayList<Integer> list) {
        this.list = list;
    }
}

