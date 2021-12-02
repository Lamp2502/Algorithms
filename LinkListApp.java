class MyLink { //Элемент связанного списка
    public int iData; //Данные (ключ)
    public double dData; //Данные
    public MyLink next; //Ссылка на следующий элемент

    //--------------------------------------------------Конструктор
    public MyLink(int iData, double dData){
        this.iData = iData;
        this.dData = dData; //next инициализируем по умолчанию.
    }

    //--------------------------------------------------Отображение MyLink
    public void displayLink(){
        System.out.print("{ "+iData+", "+dData+" }");
    }
}
////////////////////////////////////////////////////////////////////////////////////

class MyLinkList{ //Связанный список
     private MyLink first; //Ссылка на первый элемент.

    //--------------------------------------------------Конструктор
    public MyLinkList(){
        first=null; //Устанавливаем по умолчанию.
    }

    //--------------------------------------------------true, если пустой.
    public boolean isEmpty(){
        return (first==null);
    }

    //--------------------------------------------------Вставка первого элемента
    public void insertFirst(int iData, double dData){
        MyLink newLink = new MyLink(iData, dData); //Создание нового элемента
        newLink.next = first; //newLink --> first
        first = newLink; //first --> newLink
    }

    //--------------------------------------------------Удаление первого элемента
    public MyLink deleteFirst(){
        MyLink temp = first; //Сохраняем удаляемый элемент для дальнейшего возврата
        first = first.next; //Делаем первым элементом вторым по счёту элементом
        return temp; //Возвращаем удалённый элемент
    }

    //--------------------------------------------------Отображение всего списка
    public void displayList(){
        System.out.print("List (first-->last): ");
        MyLink current = first;
        while(current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}
/////////////////////////////////////////////////////////////////////////////////

public class LinkListApp {
    public static void main(String[] args){
        MyLinkList theList = new MyLinkList(); //Создание нового списка
        theList.insertFirst(22, 2.99);
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);

        theList.displayList(); //Вывод содержимого списка

        while( !theList.isEmpty()){ //Пока остаются элументы.
            MyLink aLink = theList.deleteFirst(); //Удаление элемента
            System.out.print("Deleted "); //Вывод удаленного элемента
            aLink.displayLink();
            System.out.println("");
        }
        theList.displayList(); //Вывод содержимого
    }
}
