// objectSort.java
// demonstrates sorting objects (uses insertion sort)
// to run this program: C>java ObjectSortApp
////////////////////////////////////////////////////////////////
class MyPersonInsSort {
    private String lastName;
    private String firstName;
    private int age;

    //---------------------------------------------------------- Конструктор.
    public MyPersonInsSort(String last, String first, int age){
        this.lastName = last;
        this.firstName = first;
        this.age = age;
    }

    //---------------------------------------------------------- Вывод содержимого на экран.
    public void display(){
        System.out.println(" Last name: "+ lastName);
        System.out.println(", First name:"+ firstName);
        System.out.println(", Age: "+ age);
    }

    //---------------------------------------------------------- Получение фамилии.
    public String getLast(){
        return lastName;
    }
}
//////////////////////////////////////////////////////////////////////////////////////////////

class MyArrayInOd{
    private MyPersonInsSort[] a;
    private int nElem;

    //---------------------------------------------------------- Конструктор.
    public MyArrayInOd(int size){
        a = new MyPersonInsSort[size];
        nElem = 0;
    }

    //---------------------------------------------------------- Включение записи в массив.
    public void insert(String last, String first, int age){
        a[nElem] = new MyPersonInsSort(last, first, age);
        nElem++;
    }

    //---------------------------------------------------------- Сортировка.
    public void insertSort(){
        int out, in;
        MyPersonInsSort temp;

        for(out=1; out<nElem; out++){
            in = out;
            temp = a[out];

            while(in>0 && a[in-1].getLast().compareTo(temp.getLast())>0){
                a[in]=a[in-1];
                in--;
            }
            a[in]=temp;
        }
    }
}