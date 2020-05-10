import java.util.HashMap;
import java.util.Map;

public class Prog92 extends BaseTestClass {
    public static void main(String... args) {

    }

    public boolean isValidSudoku(char[][] board) {
        boolean isValid = true;
        Map<Integer, StringBuilder> rowMap = new HashMap<>();
        Map<Integer, StringBuilder> columnMap = new HashMap<>();
        Map<Integer, StringBuilder> boxMap = new HashMap<>();

        int i = 0;
        int boxCount;
        for (char[] row :
                board) {
            int j = 0;
            for (char element :
                    row) {
                if(element!=' ') {
                    StringBuilder elString = new StringBuilder(String.valueOf(element));
                    if(rowMap.containsKey(i)){
                        StringBuilder values = rowMap.get(i);
                        if(values.toString().contains(elString)){
                            println("RowMap");
                            printMap(rowMap);
                            return false;
                        }
                        values.append(element);
                        rowMap.put(i,values);
                    }else{
                        rowMap.put(i,elString);
                    }

                    boxCount = getBoxNumber(i, j);
                    if(boxMap.containsKey(boxCount)){
                        StringBuilder values = boxMap.get(boxCount);
                        if(values.toString().contains(elString)){
                            println("boxMap");
                            printMap(boxMap);
                            return false;
                        }
                        values.append(element);
                        boxMap.put(boxCount,values);
                    }else{
                        boxMap.put(boxCount,elString);
                    }

                    if(columnMap.containsKey(j)){
                        StringBuilder values = columnMap.get(j);
                        if(values.toString().contains(elString)){
                            println("columnMap");
                            printMap(columnMap);
                            return false;
                        }
                        values.append(element);
                        columnMap.put(j,values);
                    }else{
                        columnMap.put(j,elString);
                    }
                }
                j++;
            }
            i++;
        }


        return isValid;
    }

    private int getBoxNumber(int i, int j) {
        if (i < 3) {
            if (j < 3) {
                return 0;
            } else if (j < 6) {
                return 1;
            } else {
                return 2;
            }
        } else if (i < 6) {
            if (j < 3) {
                return 3;
            } else if (j < 6) {
                return 4;
            } else {
                return 5;
            }
        } else {
            if (j < 3) {
                return 6;
            } else if (j < 6) {
                return 7;
            } else {
                return 8;
            }
        }
    }

}
