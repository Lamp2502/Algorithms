//Рекурсивная реализация сортировки слиянием.

class DArray{
    private long[] theArray; //ссылка на массив
    private int nElems; //количество элементов

    //---------------------------------------------------конструктор
    public DArray(int max){
        theArray=new long[max]; //создание массива
        nElems = 0;
    }
    //---------------------------------------------------занесение элемента в массив
    public void insert(long value){
        theArray[nElems] = value; //вставка элемента
        nElems++;
    }
    //---------------------------------------------------вывод содержимого массива
    public void display(){
        for(int j=0; j<nElems; j++){
            System.out.print(theArray[j]+" ");
            System.out.println();
        }
        System.out.println();
    }
    //---------------------------------------------------
    public void mergeSort(){
        long[] workSpace = new long[nElems]; //рабочая область
        recMergeSort(workSpace,0, nElems-1);
    }
    //---------------------------------------------------сортировка слиянием
    private void recMergeSort(long[] workSpace, int lower, int upper){
        if(lower==upper)  //если только один элемент,
            return; //то сортировка не требуется
        else{
            int mid = (lower+upper)/2; //поиск нижней половины
            recMergeSort(workSpace, lower, mid); //сортировка нижней половины
            recMergeSort(workSpace, mid+1, upper); //сортировка верхней половины
            merge(workSpace, lower,mid+1, upper); //слияние
        }
    }
    //---------------------------------------------------- слияние
    private void merge(long[] workSpace, int lowPtr, int highPtr, int upper){
        int j=0; //индекс в рабочей области
        int lower=lowPtr;
        int mid=highPtr-1;
        int n=upper-lower+1; //количество элементов;

        while(lowPtr <= mid && highPtr <= upper)
            if(theArray[lowPtr]<theArray[highPtr])
                workSpace[j++]=theArray[lowPtr++];
            else
                workSpace[j++]=theArray[highPtr++];

        while(lowPtr<=mid)
            workSpace[j++]=theArray[lowPtr++];
        while(highPtr<= upper)
            workSpace[j++] = theArray[highPtr++];
        for(j=0; j<n; j++)
            theArray[lower+j]=workSpace[j];
    }
}

///////////////////////////////////////////////////////////////////////////////////////
public class MergeSortApp {
    public static void main(String[] args){
        int maxsize=100; //размер массива
        DArray arr; //ссылка на массив
        arr = new DArray(maxsize); //создание массива

        arr.insert(64); //вставка элементов
        arr.insert(21);
        arr.insert(33);
        arr.insert(70);
        arr.insert(12);
        arr.insert(85);
        arr.insert(44);
        arr.insert(3);
        arr.insert(99);
        arr.insert(0);
        arr.insert(108);
        arr.insert(36);

        arr.display(); //вывод содержимого массива

        arr.mergeSort(); //сортировка слиянием

        arr.display(); //вывод содержимого массива
    }
}
