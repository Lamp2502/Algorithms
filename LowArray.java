class MyLowArray {
    private long[] a;

    public MyLowArray(int size){      //конструктор.
     a = new long[size];
    }
    public void setElems(int index, long value){ //запись.
        a[index]=value;
    }
    public long getElems(int index){ //чтение.
        return a[index];
    }
}
////////////////////////////////////////////////////////////////////////////////
class MyLowArrayApp {
    public static void main(String[] args) {
        int j; // переменная цикла.
        int nElem; // количество элементов в массиве.
        int searchKey;
        MyLowArray arr = new MyLowArray(100); // создание массива.
//------------------------------------------------------------------------------- добавление 10-ти элементов в массив.
        arr.setElems(0, 11);
        arr.setElems(1, 72);
        arr.setElems(2, 3);
        arr.setElems(3, 44);
        arr.setElems(4, 5);
        arr.setElems(5, 66);
        arr.setElems(6, 34);
        arr.setElems(7, 88);
        arr.setElems(8, 43);
        arr.setElems(9, 11);
        nElem = 10;                     // присвоение переменной количества элементов в массиве.

//------------------------------------------------------------------------------- печать элементов на консоли.
        for (j = 0; j < nElem; j++)   //печать элементов в консоле.
            System.out.println(arr.getElems(j));

//------------------------------------------------------------------------------- поиск элемента по значению ключа.
        searchKey = 72;  // значение ключа.
        for (j = 0; j < nElem; j++)
            if (arr.getElems(j) == searchKey)  // нужный элемент найден.
                break;
            if (j == nElem)
                System.out.println("Элемент с ключом: " + searchKey + " не найден.");
            else
                System.out.println("Найден элемент с ключом: " + searchKey);

//------------------------------------------------------------------------------- удаление элемента по значению ключа.
        searchKey = 5;  // задаём значение ключа по которому ищем элемен массива.
        for (j = 0; j < nElem; j++)
            if (arr.getElems(j) == searchKey) { // элемент массива найден.
                nElem--;                        // уменьшаем количество элементов массива.
                break;
            }
            if (j == nElem) // проверены все элементы?
                System.out.println("Элемент с ключом: " + searchKey + " не найден."); // да
            else for(; j<nElem; j++)                                                  // нет
                arr.setElems(j, arr.getElems(j+1));

//------------------------------------------------------------------------------- печать элементов на консоли.
        for (j = 0; j < nElem; j++)  // печать элементов в консоле.
            System.out.println(arr.getElems(j));
    }
}