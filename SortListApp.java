// sortedList.java
// Работа с сортированным списком
////////////////////////////////////////////////////////////////

class MySortLink {
    public long ld;
    public MySortLink next;

    //-----------------------------------------конструктор
    MySortLink(long ld){
        this.ld=ld;
    }

    //-----------------------------------------Отображение
    public void display(){
        System.out.print("{ "+ld+" }");
    }
}

//////////////////////////////////////////////////////////////////////////////
class MySortList {
    private MySortLink first;

    //--------------------------------------------------------Конструкторы
    public MySortList(){
        first = null;
    }

    public MySortList(MySortLink[] arr){
        first = null;
        for(int j=0; j<arr.length; j++)
            insert(arr[j]);
    }

    //--------------------------------------------------------Вставка
    public void insert(MySortLink k){
        MySortLink previous = null;
        MySortLink current = first;

        while(current != null && k.ld>current.ld){
            previous = current;
            current = current.next;
        }
        if(previous == null)
            first = k;
        else{
            previous = k;
            k.next = current;
        }
    }

    //--------------------------------------------------------Возвращение и удаление первой ссылки.
    public MySortLink remove(){
        MySortLink temp = first;
        first = first.next;
        return temp;
    }
}

///////////////////////////////////////////////////////////////////////////////////////////////////
public class MySortListApp {
    public static void main(String[] args){
        int size = 10;
        MySortLink[] arr = new MySortLink[size];

        //------------------------------------------------заполнение массива
        for(int j=0; j<size; j++){
            int n = (int) (java.lang.Math.random()*99);
            MySortLink newLink = new MySortLink(n);
            arr[j]=newLink;
        }

        //------------------------------------------------вывод содержимого
        System.out.println("Unsorted array: ");
        for(int j=0; j<size; j++)
            System.out.print(arr[j].ld+" ");
        System.out.println("");

        //------------------------------------------------создание нового списка
        MySortList theList = new MySortList(arr);

        for(int j=0; j<size; j++)
            arr[j]=theList.remove();

        //------------------------------------------------вывод содержимого
        System.out.println("Sorted array: ");
        for(int j=0; j<size; j++)
            System.out.print(arr[j].ld+" ");
        System.out.println("");
    }
}
