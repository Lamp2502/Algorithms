// insertSort.java
// demonstrates insertion sort
// to run this program: C>java InsertSortApp
//--------------------------------------------------------------

import java.util.*;

class MyInsertSort
{
    private long[] a;                 // ref to array a
    private int nElems;               // number of data items
    //--------------------------------------------------------------
    public MyInsertSort(int max)          // constructor
    {
        a = new long[max];                 // create the array
        nElems = 0;                        // no items yet
    }
    //--------------------------------------------------------------
    public void insert(long value)    // put element into array
    {
        a[nElems] = value;             // insert it
        nElems++;                      // increment size
    }
    //--------------------------------------------------------------
    public void display()             // displays array contents
    {
        for(int j=0; j<nElems; j++)       // for each element,
            System.out.print(a[j] + " ");  // display it
        System.out.println("");
    }
    //--------------------------------------------------------------
    public void insertionSort() {
        int out, in;
        long temp;
        long count=0;

        for(out=1; out<nElems; out++){
            temp=a[out];
            in=out;
            while(in>0 && a[in-1]>=temp) {
                a[in] = a[in-1];
                in--;
            }
            a[in]=temp;
          //  System.out.println(count);
        }
    }  // end insertionSort()
//--------------------------------------------------------------
}  // end class ArrayIns
////////////////////////////////////////////////////////////////
class MyInsertSortApp
{
    public static void main(String[] args)
    {

        int maxSize = 100000;            // array size
        MyInsertSort arr;                 // reference to array
       arr = new MyInsertSort(maxSize);  // create the array


 //////////////////////////////////////////////////////////////////////////////////////////LinkList

/*
        arr.insert(77);               // insert 10 items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        arr.display();                // display items

        arr.insertionSort();          // insertion-sort them

        arr.display();                // display them again
 */



        for(int j=100000; j>0; j--) //вставка значений по убыванию.
            arr.insert(j);

        arr.display();

        Date currentTime = new Date(); //получаем текущее время.
        arr.insertionSort();//сортировка.
        Date newTime = new Date(); //получаем новое текущее время.
        long msDelay = newTime.getTime() - currentTime.getTime(); //вычисляем разницу
        System.out.println("Длительность сортировки " + msDelay + " мс");
        System.out.println("");

        arr.display();



    }  // end main()
}  // end class InsertSortApp

