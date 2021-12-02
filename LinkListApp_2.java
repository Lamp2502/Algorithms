class MyLink_2 {
    public int id;
    public double dd;
    public MyLink_2 next;

    //--------------------------------------конструктор
    public MyLink_2(int id, double dd){
        this.id=id;
        this.dd=dd; //next по умолчанию
    }

    //--------------------------------------Отображение элемента
    public void displayLink(){
        System.out.print("{"+id+", "+dd+"}");
    }
}
//////////////////////////////////////////////////////////

class MyLinkList_2 {
    private MyLink_2 first;

    //---------------------------------------конструктор
    public MyLinkList_2(){
        first = null;
    }

    //---------------------------------------true, если пусто
    public boolean isEmpty(){
        return (first==null);
    }

    //---------------------------------------вставка
    public void insertFirst(int id, double dd){
        MyLink_2 newLink = new MyLink_2(id,dd);
        newLink.next = first; // next --> first
        first = newLink; // first --> newLink
    }

    //---------------------------------------поиск (предполагается, что список не пуст)
    public MyLink_2 find(int key){
        MyLink_2 current = first; //начинаем с первого элемента.

        while(current.id != key){ //ищем  пока не найдено совпадение
            if(current.next == null) //если элемент не найден, то достаём null
                return null;
            else
                current = current.next; //берём в работу следующий элемент
        }
        return current;
    }

    public MyLink_2 delete(int key){
        MyLink_2 current = first;
        MyLink_2 previous = first;

        while(current.id != key) {
            if (current.next == null)
                return null;
            else {
                previous = current;
                current = current.next;
            }
        }
            if(current==first)
                first=current.next;
            else
                previous.next=current.next;
            return current;
    }

    public void displayList(){
        System.out.print("");
        MyLink_2 temp = first;
        while(temp.next != null){
            temp.displayLink();
            temp=temp.next;
        }
        System.out.println("");
    }
}
/////////////////////////////////////////////////////////////////////

public class MyLinkListApp_2 {
    public static void main(String[] args) {
        MyLinkList_2 theList = new MyLinkList_2(); // Создание нового списка
        theList.insertFirst(22, 2.99); // Вставка 4 элементов
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);
        theList.displayList(); // Вывод содержимого списка

        MyLink_2 f = theList.find(44); // Поиск элемента
        if (f != null)
            System.out.println("Found link with key " + f.id);
        else
            System.out.println("Can’t find link");

        MyLink_2 d = theList.delete(66); // Удаление элемента
        if (d != null)
            System.out.println("Deleted link with key " + d.id);
        else
            System.out.println("Can’t delete link");
        theList.displayList(); // Вывод содержимого списка
    }
}
