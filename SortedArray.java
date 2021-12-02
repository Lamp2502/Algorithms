class MySorted2 {
    private long[] a;
    private int nElem;

    public MySorted2(int size){
        a=new long[size];
        nElem=0;
    }

    public void insert(long v){
        int j;
        for(j=0; j<nElem; j++)
            if(a[j]>v)
                break;
        for(int k=nElem; k>j; k--)
            a[k]=a[k-1];
        a[j]=v;
        nElem++;
    }

    public void display(){
        for(int j=0; j<nElem; j++)
            System.out.println(a[j]);
        System.out.println("");
    }

    public int find(long v){
        int lower=0;
        int upper=nElem-1;
        int curIn;

        while(true){
            curIn=(lower+upper)/2;

            if(a[curIn]==v)
                return curIn;
            if(lower>upper)
                return nElem;
            if(a[curIn]>v)
                upper=curIn-1;
            else
                lower=curIn+1;
        }
    }

    public boolean delete(long v){
        int j;

        for(j=0; j<nElem; j++)
            if(a[j]==v)
                break;
            if(j==nElem)
                return false;
            for(int k=j; k<nElem; k++)
                a[k]=a[k+1];
            nElem--;
            return true;
    }

    public int size(){
        return nElem;
    }

    public void merge(long[] arr){
        for(long v : arr)
            if(find(v)==nElem)
                insert(v);
    }
}

///////////////////////////////////////////////////
class MySortedApp2{
    public static void main(String[] args){
        MySorted2 arr=new MySorted2(100);

        arr.insert(43);
        arr.insert(1);
        arr.insert(88);
        arr.insert(15);

        arr.display();

/*        long v=16;
        if(arr.find(v)==arr.size())
            System.out.println("Не найден");
        else
            System.out.println("Найден");*/

        arr.delete(15);

        arr.display();

        long[] arr2=new long[]{22,99};
        arr.merge(arr2);

        arr.display();
    }
}
