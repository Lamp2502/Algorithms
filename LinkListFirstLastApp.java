class MyLinkFL{
    public long ld;
    public MyLinkFL next;

    //----------------------------------------------------Конструктор
    MyLinkFL(long ld){
        this.ld=ld;
    }

    //----------------------------------------------------Отображение элемента
    public void displayLink(){
        System.out.print("{ "+ld+" }");
    }
}

/////////////////////////////////////////////////////////////////////////////
class MyLinkListFL{
    private MyLinkFL first;
    private MyLinkFL last;

    //---------------------------------------------------Конструктор
    public MyLinkListFL(){
        first = null;
        last = null;
    }

    //---------------------------------------------------true, если пуст
    public boolean IsEmpty(){
        return (first==null);
    }

    //---------------------------------------------------вставка первого элемента
    public void insertFirst(long ld){
        MyLinkFL newLink = new MyLinkFL(ld);

        if(IsEmpty())
            last=newLink;
        newLink.next=first;
        first=newLink;
    }

    //--------------------------------------------------вставка последнего элемента
    public void insertLast(long ld){
        MyLinkFL newLink = new MyLinkFL(ld);

        if(IsEmpty())
            first=newLink;
        last.next=newLink;
        last=newLink;
    }

    //-------------------------------------------------удаление первого элемента
    public long deleteFirst(){
        long temp=first.ld;

        if(first.next==null)
            last=null;
        first=first.next;
        return temp;
    }

    //-------------------------------------------------Отображение
    public void displayList(){
        System.out.print("List (first-->last): ");
        MyLinkFL current = first;
        while(current != null){
            current.displayLink();
            current=current.next;
        }
        System.out.println("");
    }
}

////////////////////////////////////////////////////////////////////////////////////
public class LinkListFirstLastApp {
    public static void main(String[] args)
    { // Создание нового списка
        MyLinkListFL theList = new MyLinkListFL();
        theList.insertFirst(22); // Вставка в начало списка
        theList.insertFirst(44);
        theList.insertFirst(66);
        theList.insertLast(11); // Вставка в конец списка
        theList.insertLast(33);
        theList.insertLast(55);
        theList.displayList(); // Вывод содержимого списка
        theList.deleteFirst(); // Удаление первых двух элементов
        theList.deleteFirst();
        theList.displayList(); // Повторный вывод
    }
}
