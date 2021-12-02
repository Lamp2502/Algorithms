import java.util.*;

public class MySelectSort {
    private long[] a;
    private int nElem;

    public MySelectSort(int size){
        a=new long[size];
        nElem=0;
    }

    public void insert(long v){
        a[nElem]=v;
        nElem++;
    }

    public void sort(){
        int in, out, min;
        long temp;
        long count=0;

        for(out=0; out<nElem-1; out++) {
            min = out;
            for(in=out+1; in<nElem; in++)
                if(a[min]>a[in])
                    min = in;
            temp = a[out];
            a[out] = a[min];
            a[min] = temp;
        }
        System.out.println(count);
    }

    public void swoap(int one, int two){
        long temp=a[two];
        a[two]=a[one];
        a[one]=temp;
    }

    public void display(){
        for(int j=0; j<nElem; j++)
            System.out.println(a[j]);
        System.out.println("");
    }
}
////////////////////////////////////////////////////////////////
class MySelectSortApp
{
    public static void main(String[] args)
    {
        int maxSize = 10;            // array size
        MySelectSort arr;                 // reference to array
        arr = new MySelectSort(maxSize);  // create the array

        arr.insert(77);               // insert 10 items
        arr.insert(12);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        arr.display();                // display items

        arr.sort();          // selection-sort them

        arr.display();                // display them again

/*
        for(int j=0; j<maxSize; j++){ //вставка в массив случайных значений.
            long n = (long) (java.lang.Math.random() * (maxSize -1));
            arr.insert(n);
        }

*/
/*
        for(int j=100000; j>0; j--) //вставка значений по убыванию.
            arr.insert(j);


        Date currentTime = new Date(); //получаем текущее время.
        arr.sort();//сортировка.
        Date newTime = new Date(); //получаем новое текущее время.
        long msDelay = newTime.getTime() - currentTime.getTime(); //вычисляем разницу
        System.out.println("Длительность сортировки " + msDelay + " мс");
        System.out.println("");
*/
    }  // end main()
}  // end class SelectSortApp
////////////////////////////////////////////////////////////////
