class MyOrdered {
    private long[] a;
    private int nElem;

    public MyOrdered(int size) {
        a = new long[size];
        nElem = 0;
    }

    //--------------------------------------------------- Вставка с линейным поиском.
    public void insert(long value) {
        int j;
        for (j = 0; j < nElem; j++)
            if (a[j] > value)
                break;
        for (int k = nElem; k > j; k--)
            a[k] = a[k - 1];
        a[j] = value;
        nElem++;
    }

    //--------------------------------------------------- Вставка с двоичным поиском.
    public void insertBi(long value) {
        int lowerBound = 0;
        int upperBound = nElem - 1;
        int curIn;

        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == value) {
                break;
            } else if (lowerBound > upperBound) {
                if (value >= a[curIn]) {
                    if (a[curIn] == 0 && nElem == 0) {
                        curIn = 0;
                    } else {
                        curIn++;
                    }
                }
                break;
            } else {
                if (a[curIn] < value) {
                    lowerBound = curIn + 1;
                } else {
                    upperBound = curIn - 1;
                }
            }
        }

        for (int j = nElem; j > curIn; j--) {
            a[j] = a[j - 1];
        }

        a[curIn] = value;
        nElem++;
    }

    //---------------------------------------------------
    public int find(long searchKey) {
        int lowBound = 0;
        int upperBound = nElem - 1;
        int curIn;

        while (true) {
            curIn = (lowBound + upperBound) / 2;
            if (a[curIn] == searchKey)
                return curIn;
            if (lowBound > upperBound)
                return nElem;
            if (a[curIn] > searchKey)
                upperBound = curIn - 1;
            else if (a[curIn] < searchKey)
                lowBound = curIn + 1;
        }
    }

    //--------------------------------------------------------------------
    public void display() {
        for (int j = 0; j < nElem; j++) {
            System.out.println(a[j]);
        }
    }

    //--------------------------------------------------------------------
    public boolean delete(long value) {
        int j = find(value);
        if (j == nElem)
            return false;
        else {
            for (int k = j; k < nElem; k++)
                a[k] = a[k + 1];
            nElem--;
            return true;
        }
    }

    //------------------------------------------------------------------- Размер массива.
    public int size() {
        return nElem;
    }

    //------------------------------------------------------------------- Объединение 2х упорядоченных массивов.
    public void merge(long[] arr)
    {
        for(long value : arr)
        {
            if(find(value)==nElem)
            {
                insert(value);
            }
        }
    }
}

    //////////////////////////////////////////////////////////////////////
    class MyOrderedApp {
        public static void main(String[] args) { /*
        MyOrdered arr = new MyOrdered(100);

        arr.insertBi(15);
        arr.insertBi(1);
        arr.insertBi(99);
        arr.insertBi(66);
        arr.insertBi(33);
        arr.insertBi(11);
        arr.insertBi(10);
        arr.insertBi(8);
        arr.insertBi(24);
        arr.insertBi(67);

        arr.display();

        long searchKey=33;
        if(arr.find(searchKey)==arr.size())
            System.out.println("Не обнаружено элемента с ключом № "+searchKey);
        else
            System.out.println("Наден элемент с ключом: "+searchKey);

        arr.delete(1);
        arr.delete(99);
        arr.delete(66);

        arr.display();
*/
        MyOrdered arr1 = new MyOrdered(50);
        long[] arr2 = new long[]{10, 20, 30};

        arr1.insert(33);
        arr1.insert(22);
        arr1.insert(1);
        arr1.insert(3);
        arr1.insert(99);

        arr1.merge(arr2);
        }
    }

