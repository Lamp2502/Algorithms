public class TestQueue {
    private long arr[];
    private int size, nElems, rear, front;

    public TestQueue(int size){
        this.size=size;
        arr=new long[size];
        nElems=front=0;
        rear=-1;
    }

    public void insert(long value){
        if(rear==size-1)
            rear=-1;
        arr[++rear]=value;
        nElems++;
    }

    public long remove(){
        long temp=arr[front++];
        nElems--;
        if(front==size)
            front=0;
        return temp;
    }

    public long peek(){
        return arr[front];
    }

    public int size(){
        return nElems;
    }

    public boolean isEmpty(){
        return nElems==0;
    }

    public boolean isFull(){
        return nElems==size-1;
    }
}
///////////////////////////////////////////////////////////////

class TestQueueApp{
    public static void main(String[] args){
        TestQueue queue = new TestQueue(5);
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);

        queue.remove();
        queue.remove();
        queue.remove();

        queue.insert(50);
        queue.insert(60);
        queue.insert(70);
        queue.insert(80);

        while(!queue.isEmpty()) { //извлечение и вывод всех элементов
            long n = queue.remove();
            System.out.print(n);
            System.out.print(" ");
        }
        System.out.println();
    }
}
