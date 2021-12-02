import java.util.Date;

class MyBubbleSort {
    private int nElem;
    private long[] a;

    public MyBubbleSort(int size) {
        a = new long[size];
        nElem = 0;
    }

    public void display() {
        for (int j = 0; j < nElem; j++)
            System.out.println(a[j]);
        System.out.println("");
    }

    public int size() {
        return nElem;
    }

    public void insert(long value) { //вставка.
        a[nElem] = value;
        nElem++;
    }

    public void sort() { //сортировка
        int in, out;
        long temp;

        for (out = nElem - 1; out > 1; out--)
            for (in = 0; in < out; in++)
                if (a[in] > a[in + 1]) {
                    swap(in, in+1);
                }
    }

    public void swap(int one, int two) {
        long temp = a[two];
        a[two] = a[one];
        a[one] = temp;
    }

    public void sort2() { //сортировка.
        int in, out;
        long temp;
        long count=0;

        for (out = nElem - 1; out > 1; out--) {
            for (in = 0; in < out; in++)
                if (a[in] > a[in + 1]) {
                    temp = a[in + 1];
                    a[in + 1] = a[in];
                    a[in] = temp;
                    count++;
                }
        }
        System.out.println(count);
    }


}

//////////////////////////////////////////////////////////////////
class MyBubbleSortApp{
    static public void main(String[] args){
        int maxSize = 4;
        MyBubbleSort arr = new MyBubbleSort(maxSize);

        arr.insert(35);
        arr.insert(85);
        arr.insert(1);
        arr.insert(45);
      //  arr.insert(22);

        arr.display();
        arr.sort();
        arr.display();


/*
        for(int j=0; j<maxSize; j++) {//Заполнение массива случайными числами.
            long n = (long) (java.lang.Math.random() * (maxSize - 1));
            arr.insert(n);
        }
 */

/*
        for(int j=100000; j>0; j--) //вставка значений по убыванию.
            arr.insert(j);

        Date currentTime = new Date(); //получаем текущее время.
        arr.sort2();//сортировка.
        Date newTime = new Date(); //получаем новое текущее время.
        long msDelay = newTime.getTime() - currentTime.getTime(); //вычисляем разницу
        System.out.println("Длительность сортировки " + msDelay + " мс");
        System.out.println("");
        */
    }
}
