import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MyLinkIter{
    public long dd; //данные
    public MyLinkIter next;

    //------------------------------------------------------конструктор
    public MyLinkIter(long dd){
        this.dd=dd;
    }
    //------------------------------------------------------вывод содержимого
    public void displayLink(){
        System.out.print(dd+" ");
    }
}

//////////////////////////////////////////////////////////////////////////////
class MyLinkListIter{
    private MyLinkIter first; //сылка на первый элемент списка

    //-------------------------------------------------------получение первого элемента
    public MyLinkIter getFirst(){
        return first;
    }
    //-------------------------------------------------------присваивание нового значения first
    public void setFirst(MyLinkIter f){
        first=f;
    }
    //-------------------------------------------------------true, если список пусе
    public boolean isEmpty(){
        return first==null;
    }
    //-------------------------------------------------------получение итератора
    public MyListIterator getIterator(){
        return new MyListIterator (this); //инициализация списком this
    }
    //-------------------------------------------------------отображение списка
    public void displayList(){
        MyLinkIter current = first; //от начала списка
        while(current != null){  //перемещение до конца списка
            current.displayLink(); //отображение текущего элемента
            current=current.next;  //переход к следующему элементу
        }
        System.out.println();
    }
}
//////////////////////////////////////////////////////////////////////////////////////////
class MyListIterator{
    private MyLinkIter current; //текущий элемент
    private MyLinkIter previous; //предыдущий элемент
    private MyLinkListIter ourList; //связанный список

    //--------------------------------------------------------конструктор
    public MyListIterator(MyLinkListIter list){
        ourList=list;
        reset();
    }
    //--------------------------------------------------------возврат к first
    public void reset(){
        current = ourList.getFirst();
        previous = null;
    }
    //--------------------------------------------------------true, если текущим является последний элемент
    public boolean atEnd(){
        return current.next==null;
    }
    //--------------------------------------------------------переход к следующему элементу
    public void nextLink(){
        previous = current;
        current = current.next;
    }
    //--------------------------------------------------------получение текущего элемента
    public MyLinkIter getCurrent(){
        return current;
    }
    //--------------------------------------------------------вставка после текущего элемента
    public void insertAfter(long dd){
        MyLinkIter newLink = new MyLinkIter(dd);

        if(ourList.isEmpty()){ //пустой список
            ourList.setFirst(newLink); //присваиваем first значение newLink
            current = newLink;
        }
        else{
            newLink.next = current.next;
            current.next = newLink;
            nextLink(); //переход на новый элемент
        }
    }
    //--------------------------------------------------------вставка перед текущим элементом
    public void insertBefore(long dd){
        MyLinkIter newLink = new MyLinkIter(dd);

        if(previous == null){ //в начале списка или пустой список
            newLink.next = ourList.getFirst();
            ourList.setFirst(newLink);
            reset();
        }
        else{ //не в начале списка
            newLink.next = previous.next;
            previous.next = newLink;
            current = newLink;
        }
    }
    //--------------------------------------------------------удаление текущего элемента
    public long deleteCurrent(){
        long value = current.dd;

        if(previous == null) { //если в начале списка
            ourList.setFirst(current.next);
            reset();
        }
        else{
            previous.next = current.next;
            if(atEnd())
                reset();
            else
                current = current.next;
        }
        return  value;
    }
}
////////////////////////////////////////////////////////////////////////////////////////////

public class InterIterApp {
    public  static void main(String[] args) throws IOException{
        MyLinkListIter theList = new MyLinkListIter(); //создание списка
        MyListIterator iter1 = theList.getIterator(); //создание итератора
        long value;

        iter1.insertAfter(20);
        iter1.insertAfter(40);
        iter1.insertAfter(80);
        iter1.insertAfter(60);

        while(true){
            String choice;

            System.out.print("Enter first letter of show, reset, ");
            System.out.print("next, get, before, after, delete: ");
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            choice=r.readLine();

            switch (choice){
                case "s":                   //Вывод списка
                    if(!theList.isEmpty())
                        theList.displayList();
                    else
                        System.out.println("List is empty");
                    break;
                case "r":                   //возврат к первому элементу
                    iter1.reset();
                    break;
                case "n":                   //переход к следующему элементу
                    if(!theList.isEmpty()&& !iter1.atEnd())
                        iter1.nextLink();
                    else
                        System.out.println("Can’t go to next link");
                    break;
                case "g": // Получение текущего элемента
                    if( !theList.isEmpty() )
                    {
                        value = iter1.getCurrent().dd;
                        System.out.println("Returned " + value);
                    }
                    else
                        System.out.println("List is empty");
                    break;
                case "b": // Вставка перед текущим элементом
                    System.out.print("Enter value to insert: ");
                    System.out.flush();
                    value = getInt();
                    iter1.insertBefore(value);
                    break;
                case "a": // Вставка после текущего элемента
                    System.out.print("Enter value to insert: ");
                    System.out.flush();
                    value = getInt();
                    iter1.insertAfter(value);
                    break;
                case "d": // Удаление текущего элемента
                    if( !theList.isEmpty() )
                    {
                        value = iter1.deleteCurrent();
                        System.out.println("Deleted " + value);
                    }
                    else
                        System.out.println("Can’t delete");
                    break;
                default:
                    System.out.println("Invalid entry");
            }
        }
    }
    //--------------------------------------------------------------
    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        String s = br.readLine();
        return s;
    }
    //-------------------------------------------------------------
    public static char getChar() throws IOException
    {
        String s = getString();
        return s.charAt(0);
    }
    //-------------------------------------------------------------
    public static int getInt() throws IOException
    {
        String s = getString();
        return Integer.parseInt(s);
    }
//-------------------------------------------------------------
} // Конец класса InterIterApp
////////////////////////////////////////////////////////////////

