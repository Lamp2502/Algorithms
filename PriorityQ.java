import java.io.IOException;

class MyPriorityQ {
    //Элементы массива сортируются по значению ключа.
    //от максимума (0) до минимума (size-1);
    private int size, nItems;
    private long[] arr;

    //--------------------------------------------Конструктор
    public MyPriorityQ(int size){
        this.size = size;
        arr = new long[size];
        nItems = 0;
    }

    //-------------------------------------------Вставка
    public void insert(long item){
        int j;

        if(nItems==0)
            arr[nItems++]=item;
        else{
            for(j=nItems-1; j>=0; j--) {
                if (item > arr[j])
                    arr[j + 1] = arr[j];
                else
                    break;
            }
            arr[j+1]=item;
            nItems++;
        }
    }

    //------------------------------------------Извлечение минимального элемента
    public long remove(){
        return arr[--nItems];
    }

    //------------------------------------------Чтение минимального элемента
    public long peekMin(){
        return arr[nItems-1];
    }

    //------------------------------------------true, если очередь пуста
    public boolean isEmpty(){
        return nItems==0;
    }

    //------------------------------------------true, если очередь заполнена
    public boolean isFull(){
        return nItems==size;
    }
}
/////////////////////////////////////////////////////////////////////////////

class PriorityQApp{
    public static void main(String[] args) throws IOException{
        MyPriorityQ pq = new MyPriorityQ(5);
        pq.insert(30);
        pq.insert(50);
        pq.insert(10);
        pq.insert(40);
        pq.insert(20);

        while(!pq.isEmpty()){
            long item = pq.remove();
            System.out.print(item+" ");
        }
    }
}
