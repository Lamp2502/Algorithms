import java.util.Arrays;

class MyInsertSort2 {
    private int[] array = {4, 2, 9, 3, 1, 3, 11, 8};

    int[] sort(int[] array) {
        int min, in;
        min = array[0];

        for (int i = 1; i < array.length; i++) {
            in = i;
            while (in > 0 && array[in] > array[in - 1]){
                min = array[in - 1];
                array[in - 1] = array[in];
                array[in] = min;
                in--;
            }
        }

        return array;
    }

    public int[] getArray() {
        return array;
    }
}

public class InsertSortApp2 {


    public static void main(String[] args) {
        MySelectSort2 selectSort2 = new MySelectSort2();
        selectSort2.sort(selectSort2.getArray());
        System.out.println(Arrays.toString(selectSort2.getArray()));
    }
}
