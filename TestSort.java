import java.util.Date;

public class TestSort {
    private long[] a;
    int nElem;

    public TestSort(int size){
        a=new long[size];
        nElem=0;
    }

    public void display(){
        for(int j=0; j<nElem; j++)
            System.out.println(a[j]);
        System.out.println();
    }

    public void insert(long v){
        a[nElem]=v;
        nElem++;
    }

    public int size(){
        return nElem;
    }

    public void sortBubble(){
        int out, in;
        long temp;

        for(out=nElem-1; out>0; out--)
            for(in=0; in<out; in++)
                if(a[in]>a[in+1]){
                    temp=a[in];
                    a[in]=a[in+1];
                    a[in+1]=temp;
                }

    }

    public void sortSelect(){
        int out, in, min;
        long temp;

        for(out=0; out<nElem-1; out++){
            min=out;
            for(in=out+1; in<nElem; in++)
                if(a[min]>a[in])
                    min=in;
                temp=a[out];
                a[out]=a[min];
                a[min]=temp;
        }
    }

    public void sortInsert(){
        int out, in;
        long temp;

        for(out=1; out<nElem; out++){
            temp=a[out];
            in=out;

            while(in>0 && a[in-1]>temp){
                a[in]=a[in-1];
                in--;
            }
            a[in]=temp;
        }
    }
}

//////////////////////////////////////////////////////////////////
class MyBubbleSortApp1{
    static public void main(String[] args){
        int maxSize = 7;
        TestSort arr = new TestSort(maxSize);

        arr.insert(35);
        arr.insert(85);
        arr.insert(1);
        arr.insert(45);
        arr.insert(22);

        arr.display();
        arr.sortInsert();
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

