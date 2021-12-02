public class Towers2 {
    static int nDisks = 3;

    public static void main(String[] args){
        doTowers(nDisks, 'A', 'B', 'C');
    }
    //----------------------------------------------------------------
    public static void doTowers(int topN, char from, char inter, char to){
        if(topN==1)
            System.out.println("Диск 1 из "+from+" в "+to);
        else{
            doTowers(topN-1, from, to, inter);
            System.out.println("Диск "+topN+" from "+from+" to "+to);
            doTowers(topN-1,inter,from,to);
        }
    }
}
