import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MyBubbleSort2 {
    private List<Integer> list = new ArrayList<>(Arrays.asList(4, 2, 9, 3, 1, 3, 11, 8));
    private int[] array = {4, 2, 9, 3, 1, 3, 11, 8};

    int[] sort(int[] array) {
        int min;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[i] > array[j]){
                    min = array[j];
                    array[j] = array[i];
                    array[i] = min;
                }
            }
        }
        return array;
    }

    List<Integer> sort(List<Integer> array) {
        int min;
        for (int i = 0; i < array.size(); i++) {
            for (int j = i + 1; j < array.size(); j++) {
                if (array.get(i) > array.get(j)) {
                    min = array.get(j);
                    array.set(j, array.get(i));
                    array.set(i, min);
                }
            }
        }
        return array;
    }

    public List<Integer> getList() {
        return list;
    }

    public int[] getArray() {
        return array;
    }
}

public class BubbleSortApp2 {


    public static void main(String[] args) {
        MyBubbleSort2 bubbleSort = new MyBubbleSort2();
        bubbleSort.sort(bubbleSort.getArray());
        System.out.println(Arrays.toString(bubbleSort.getArray()));
    }
}