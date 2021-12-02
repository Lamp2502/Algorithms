import java.util.Queue;

class MyQueue {
    private int size;
    private int rear;
    private int front;
    private int nItems;
    private long[] queArr;

    //------------------------------------------------ конструктор
    public MyQueue(int size){
        this.size = size;
        queArr = new long[size];
        rear = -1;
        front = 0;
        nItems = 0;
    }

    //------------------------------------------------ вставка элемента в конец очереди
    public void insert(long v){
        if(rear == size-1) //циклический перенос
            rear = -1;
        if(isFull()) //проверка на переполение очереди
            System.out.println("Опередь переполнена!");
        else {
            queArr[++rear] = v;
            nItems++;
        }
    }

    //------------------------------------------------ извлечение элемента из начала очереди
    public long remove(){
        long temp = queArr[front++];
        if(front == size) //циклический перенос
            front = 0;
        if(isEmpty()) { //проверка на отсутсвие элементов
            System.out.println("");
            System.out.print("Опередь пуста! Количество элементов в очереди = ");
            return 0;
        }
        else {
            nItems--;
            return temp;
        }
    }

    //------------------------------------------------ true, если массив пуст.
    public boolean isEmpty(){ //версия с счётчиком элементов
        return nItems==0;
    }

 /*
      public boolean isEmpty(){ //версия без счёткика элементов.
          return (rear+1 == front || (front+size-1 == rear));
      }
  */
    //------------------------------------------------ true, если массив полон.
    public boolean isFull(){ //версия с счётчиком элементов
        return nItems==size;
    }
 /*
    public boolean isFull(){ //версия без счёткика элементов.
        return (rear+2 == front || (front+size-2 == rear));
    }

  */
    //------------------------------------------------ количество заполненных элементов.
/*    public int size(){ //версия с счётчиком элементов
        return nItems;
    }
*/

}
////////////////////////////////////////////////////////////////////////////////////////////

class QueueApp{
    public static void main(String[] args){
        MyQueue theQueue = new MyQueue(5); //очередь из 5 ячеек

        theQueue.insert(10); //вставка 4х элементов
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);

        theQueue.remove(); //извлечение 3х элементов
        theQueue.remove();

        theQueue.insert(50); //вставка ещё 4х элементов с циклическим переносом
        theQueue.insert(60);
        theQueue.insert(70);
      //  theQueue.insert(80);

        while (!theQueue.isEmpty()){ //извлечение и вывод всех элементов
            long n = theQueue.remove();
            System.out.print(n);
            System.out.print(" ");
        }
        System.out.println();
    }
}
