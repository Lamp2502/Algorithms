class MyHighArray {
    private long a[];
    private int nElem;

    //-------------------------------------------------- конструктор.
    public MyHighArray(int max) {
        a = new long[max];
        nElem = 0;
    }

    //---------------------------------------------------  вставка значения.
    public void insert(long value) {
        a[nElem] = value;
        nElem++;
    }

    //---------------------------------------------------  поиск значения.
    public boolean find(long searchKey) {
        int j;
        for (j = 0; j < nElem; j++)
            if (a[j] == searchKey)
                break;
        if (j == nElem)
            return false;
        else
            return true;
    }

    //----------------------------------------------------  удаление значения.
    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElem; j++)
            if (a[j] == value)
                break;
        if (j == nElem)
            return false;
        else {
            for (; j < nElem; j++)
                a[j] = a[j + 1];
            nElem--;
            return true;
        }
    }

    //----------------------------------------------------  показать содержимое массива.
    public void display() {
        for (int j = 0; j < nElem; j++)
            System.out.println(a[j]);
        System.out.println("");
    }

    //----------------------------------------------------  удаление дубликатов.
    public void noDups() {
        int j;
        int count = 0;
        for (j = 0; j < this.nElem; j++) {
            for (int k = j+1; k < this.nElem; k++) {
                if (a[j] == a[k]) {
                    count++;
                }
            }
            if (count > 0) {
                for (int f = j + 1; count>0; f++) {
                    if (a[f] == a[j]) {
                        for (int l=f; l < this.nElem; l++) {
                            a[l] = a[l + 1];
                        }
                        f = j;
                        this.nElem--;
                        count--;
                    }
                }
            }
        }
    }
}
////////////////////////////////////////////////////////////////////////////////////

class MyHighArrayApp {
    public static void main(String[] args){
        MyHighArray arr = new MyHighArray(100); // создание массива.

        arr.insert(55); // вставка элементов.
        arr.insert(15);
        arr.insert(77);
        arr.insert(15);
        arr.insert(18);
        arr.insert(15);
        arr.insert(54);
        arr.insert(55);
        arr.insert(34);
        arr.insert(11);

        arr.display();         // отображение элементов массива.

        int searchKey = 1;
        if(arr.find(searchKey)) // поиск элемента по ключу.
            System.out.println("Надено значение: "+searchKey);
        else
            System.out.println("Не найдено значение: "+searchKey);

        arr.delete(77); // удаление трёх элементов.
        arr.delete(1);
        arr.delete(33);

        arr.display();        // отображение элементов массива.
        arr.noDups();
        arr.display();        // отображение элементов массива.
    }
}
