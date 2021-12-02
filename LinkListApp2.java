
class Link_2
{
    public int iData; // Данные (ключ)
    public double dData; // Данные
    public Link_2 next; // Следующий элемент в списке
    // -------------------------------------------------------------Конструктор
    public Link_2(int id, double dd)
    {
        iData = id;
        dData = dd;
    }
    // -------------------------------------------------------------Вывод содержимого элемента
    public void displayLink()
    {
        System.out.print("{" + iData + ", " + dData + "} ");
    }
}
//////////////////////////////////////////////////////////////

class LinkList_2
{
    private Link_2 first; // Ссылка на первый элемент списка
    // -----------------------------------------------Конструктор
    public LinkList_2()
    {
        first = null; // Список пока не содержит элементов
    }

    // ------------------------------------------------Вставка
    public void insertFirst(int id, double dd)
    { // Создание нового элемента
        Link_2 newLink = new Link_2(id, dd);
        newLink.next = first; // newLink --> старое значение first
        first = newLink; // first --> newLink
    }

    //--------------------------------------------------Поиск элемента с заданным ключом
    public Link_2 find(int key){
        Link_2 current = first; //начинаем с first
        while(current.iData != key){ //пока совпадение не найдено
            if(current.next == null)
                return  null;  //если достигнут конец списка и совпадений не найдено
            else
                current = current.next; //если ещё остались элементы, то переходи к следующему
        }
        return current; //совпадение обнаружено
    }

    //--------------------------------------------------Удаление элем. с заданным ключом (список не пуст)
    public Link_2 delete(int key){
        Link_2 current = first;
        Link_2 previous = first;

        while(current.iData != key){
            if(current.next == null)
                return null; //элемент не найден
            else{
                previous = current; // перейти к следующему элемента
                current = current.next;
            }
        }
        if(current == first) //Совпадение найдено.
            first = first.next; //Если первый элемент, то меняем first
        else
            previous.next = current.next; //иначе обойти его в списке
        return current;
    }

    // -------------------------------------------------------------Вывод содержимого списка
    public void displayList()
    {
        System.out.print("List (first-->last): ");
        Link_2 current = first; // От начала списка
        while(current != null) // Перемещение до конца списка
        {
            current.displayLink(); // Вывод данных
                current = current.next; // Переход к следующему элементу
        }
        System.out.println("");
    }
}
/////////////////////////////////////////////////////////////////////

public class LinkListApp2 {
    public static void main(String[] args) {
        LinkList_2 theList = new LinkList_2(); // Создание нового списка
        theList.insertFirst(22, 2.99); // Вставка 4 элементов
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);
        theList.displayList(); // Вывод содержимого списка
        Link_2 f = theList.find(44); // Поиск элемента
        if (f != null)
            System.out.println("Found link with key " + f.iData);
        else
            System.out.println("Can’t find link");
        Link_2 d = theList.delete(66); // Удаление элемента
        if (d != null)
            System.out.println("Deleted link with key " + d.iData);
        else
            System.out.println("Can’t delete link");
        theList.displayList(); // Вывод содержимого списка
    }
}
