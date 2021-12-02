import java.util.ArrayList;

class MyArraySh{
    private long[] theArray; //ссылка на массив
    private int nElems; // Количество элементов

    //-------------------------------------------------конструктор
    public MyArraySh(int max){
        theArray = new long[max]; //Создание массива
        nElems = 0; //пока нет ни одного элемента
    }
    //-------------------------------------------------Вставка
    public void insert(long value){
        theArray[nElems] = value; //вставка
        nElems++; //увеличение размера
    }
    //-------------------------------------------------Вывод
    public void desplay(){
        System.out.print("A=");
        for(int j=0; j<nElems; j++)
            System.out.print(theArray[j]+" "); //Вывод
        System.out.println();
    }
    //-------------------------------------------------Сортировка
    public void shellSort(){
        int outer, inner;
        int h=1;
        long temp;

        while (h<=nElems/3)
            h=h*3+1;

        while (h>0){
            for(outer=h; outer<nElems; outer++){
                temp=theArray[outer];
                inner=outer;

                while(inner > h-1 && theArray[inner-h] > temp){
                    theArray[inner]=theArray[inner-h];
                    inner-=h;
                }
                theArray[inner]=temp;
            }
            h=(h-1)/3;
        }
    }
}

///////////////////////////////////////////////////////////////////////////////////
public class ShellSortApp {
    public  static void main(String[] args){
        int maxSize = 20; //размер массива
        MyArraySh arr;
        arr = new MyArraySh(maxSize); //Создание массива

        for(int j=0; j<maxSize; j++){ //Заполнение массива случайными числами
            long n = (int)(java.lang.Math.random()*99);
            arr.insert(n);
        }
        arr.desplay(); //вывод несортированного массива
        arr.shellSort(); //сортировка массива
        arr.desplay(); //вывод отсортированного массива
    }
}