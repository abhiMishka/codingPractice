public class Prog39 extends BaseTestClass {

    public static void main(String... args) {
        print("ans : " + compress(new char[]{}));
    }

    public static int compress(char[] chars) {
        if(chars.length==0) return 0;
        int count = 0;
        char old = chars[0];
        char x;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=1;i<chars.length;i++){
            x = chars[i];
            if(x==old){
                count++;

            }else{
                if(count>0){
                    stringBuilder.append(""+old).append(count + 1);
                    chars[i-1] = (char)(count + 1);
                }else{
                    stringBuilder.append(""+old);
                }
                count = 0;
            }

            old = x;
        }
        if(count>0){
            stringBuilder.append(""+old).append(count + 1);
        }else{
            stringBuilder.append(""+old);
        }

        return stringBuilder.length();
    }
}
