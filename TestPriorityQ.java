import java.io.IOException;

public class TestPriorityQ {
    long[] arr;
    int nElems, size;

    TestPriorityQ(int size){
        this.size=size;
        arr=new long[size];
        nElems=0;
    }

    public void insert(long v){
        int j;
        if(nElems==0)
            arr[nElems++]=v;
        else {
            for (j = nElems - 1; j >= 0; j--) {
                if (arr[j] < v)
                    arr[j + 1] = arr[j];
            }
            arr[j+1]=v;
            nElems++;
        }
    }

    public long remove(){
        return arr[--nElems];
    }

    public long peek(){
        return arr[nElems];
    }

    //------------------------------------------true, если очередь пуста
    public boolean isEmpty(){
        return nElems==0;
    }

    //------------------------------------------true, если очередь заполнена
    public boolean isFull(){
        return nElems==size;
    }
}
/////////////////////////////////////////////////////////////////////////////

class TestPriorityQApp{
    public static void main(String[] args) throws IOException {
        TestPriorityQ pq = new TestPriorityQ(5);
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
