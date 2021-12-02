import java.util.Arrays;

class MySelectSort2 {
    private int[] array = {4, 2, 9, 3, 1, 3, 11, 8};

    int[] sort(int[] array) {
        int min, temp;
        for (int i = 0; i < array.length; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++) {
                if(array[j] < array[min]){
                    min = j;
                }
            }
            temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public int[] getArray() {
        return array;
    }
}

public class SelectSortApp2 {


    public static void main(String[] args) {
        MySelectSort2 selectSort2 = new MySelectSort2();
        selectSort2.sort(selectSort2.getArray());
        System.out.println(Arrays.toString(selectSort2.getArray()));
    }
}
