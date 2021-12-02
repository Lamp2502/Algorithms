import java.util.Date;

// listInsertionSort.java
// Применение сортированного списка для сортировки массива
// Запуск программы: C>java ListInsertionSortApp
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
class SortedLink
{
    public long dData; // Данные
public SortedLink next; // Следующий элемент списка

    // -------------------------------------------------------------Конструктор
    public SortedLink(long dd)
    { dData = dd; }
}
class SortedList
{

    private SortedLink first; // Ссылка на первый элемент списка

    // -------------------------------------------------------------Конструктор (без аргументов)
    public SortedList()
    { first = null; } // Инициализация списка

    // -------------------------------------------------------------Конструктор (аргумент - массив)
    public SortedList(SortedLink[] linkArr)
    {
        first = null; // Инициализация списка
        for(int j=0; j<linkArr.length; j++) // Копирование массива
            insert( linkArr[j] ); // в список
    }
    // -------------------------------------------------------------Вставка (в порядке сортировки)
    public void insert(SortedLink k)
    {
        SortedLink previous = null; // От начала списка
        SortedLink current = first; // До конца списка

        while(current != null && k.dData > current.dData) // или если ключ > current,
        {
            previous = current;
            current = current.next; // Перейти к следующему элементу
        }
        if(previous==null) // В начале списка
            first = k; // first --> k
        else // Не в начале
            previous.next = k; // старое значение prev --> k
        k.next = current; // k --> старое значение current
    }
/*
    ////////////////////////////////////////////////////////////////////
    //-----------------------------------------------------------------Обычная сортировка
    public void insertOld(SortedLink[] linkArr) {
        int out, in;
        SortedLink temp;
       // long count=0;

        for(out=1; out<linkArr.length; out++){
            temp=linkArr[out];
            in=out;
            while(in>0 && linkArr[in-1].dData>=temp.dData) {
                linkArr[in] = linkArr[in-1];
                in--;
            }
            linkArr[in]=temp;
            //  System.out.println(count);
        }
    }
    //-----------------------------------------------------------------------
    /////////////////////////////////////////////////////////////////////////
*/
    // -------------------------------------------------------------Возвращает и удаляет первую ссылку
    public SortedLink remove()
    { // (assumes non-empty list)
        SortedLink temp = first; // Сохранение ссылки
        first = first.next; // Удаление первого элемента
        return temp; // Метод возвращает ссылку
    } // на удаленный элемент
}

////////////////////////////////////////////////////////////////
class SortListInsertionApp
{
    public static void main(String[] args)
    {
        int size = 40000;
        // Создание массива
 /*       SortedLink[] linkArray = new SortedLink[size];
        for(int j=0; j<size; j++) // Заполнение массива
        {
            int n = (int)(java.lang.Math.random()*99); // Случайные числа
            SortedLink newLink = new SortedLink(n); // Создание элемента
            linkArray[j] = newLink; // Сохранение в массиве
        }
        */

        Date currentTime = new Date(); //получаем текущее время.
        // Создание массива
        SortedLink[] linkArray = new SortedLink[size];
        for(int j=0; j<size; j++) // Заполнение массива
        {
            int n = (int)(java.lang.Math.random()*99); // Случайные числа
            SortedLink newLink = new SortedLink(n); // Создание элемента
            linkArray[j] = newLink; // Сохранение в массиве
        }

        // Вывод содержимого массива
        System.out.print("Unsorted array: ");
        for(int j=0; j<size; j++)
            System.out.print( linkArray[j].dData + " " );
        System.out.println("");
        // Создание нового списка,
        // инициализированного содержимым массива

        SortedList theSortedList = new SortedList(linkArray);
        for(int j=0; j<size; j++) // links from list to array
            linkArray[j] = theSortedList.remove();
        Date newTime = new Date(); //получаем новое текущее время.
        long msDelay = newTime.getTime() - currentTime.getTime(); //вычисляем разницу
        System.out.println("Длительность сортировки " + msDelay + " мс");
        System.out.println("");

        // Вывод содержимого массива
        System.out.print("Sorted Array: ");
        for(int j=0; j<size; j++)
            System.out.print(linkArray[j].dData + " ");
        System.out.println("");

/*
        //////////////////////////////////////////////////////////////////////////////////////////////////
        //-----------------------------------------------------------------------обыная сортировка массива

        Date currentTime1 = new Date(); //получаем текущее время.
        // Создание массива
        SortedLink[] linkArray1 = new SortedLink[size];
        for(int j=0; j<size; j++) // Заполнение массива
        {
            int n = (int)(java.lang.Math.random()*99); // Случайные числа
            SortedLink newLink = new SortedLink(n); // Создание элемента
            linkArray1[j] = newLink; // Сохранение в массиве
        }

        // Вывод содержимого массива
        System.out.print("Unsorted array: ");
        for(int j=0; j<size; j++)
            System.out.print( linkArray1[j].dData + " " );
        System.out.println("");
        // Создание нового списка,
        // инициализированного содержимым массива

     //   for(int j=0; j<size; j++) // links from list to array
       //     linkArray[j] = theSortedList1.remove();
        SortedList theSortedList1 = new SortedList();
        theSortedList1.insertOld(linkArray1);
        Date newTime1 = new Date(); //получаем новое текущее время.
        long msDelay1 = newTime1.getTime() - currentTime1.getTime(); //вычисляем разницу
        System.out.println("Длительность сортировки " + msDelay1 + " мс");
        System.out.println("");

        // Вывод содержимого массива
        System.out.print("Sorted Array: ");
        for(int j=0; j<size; j++)
            System.out.print(linkArray1[j].dData + " ");
        System.out.println("");
*/
       ///////////////////////////////////////////////////////////////////////////////////////////////////////

    }
}