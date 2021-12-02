import java.io.*;
//-------------------------------------------------Стек
 class MyStack_Infix{
    private int size, top;
    private char[] arr;

    //---------------------------------------------Конструктор
    public MyStack_Infix(int size){
        this.size=size;
        arr=new char[size];
        top = -1;
    }
    //---------------------------------------------Вставка значения
    public void push(char v){
        arr[++top]=v;
    }
    //---------------------------------------------Извлечение значения
    public char pop(){
        return arr[top--];
    }
    //---------------------------------------------Чтение значения
    public char peek(){
        return arr[top];
    }
    //---------------------------------------------Если пуст.
    public boolean isEmpty(){
        return top==-1;
    }
    //---------------------------------------------Текущий размер.
    public int size(){
        return size;
    }
    //---------------------------------------------Чтение элемента с индексом n
    public char peekN(int n){
        return arr[n];
    }
    //---------------------------------------------Вывод на экран стека
    public void desplayStack(String s){
        System.out.print(s);
        System.out.print("Stack (bottom-->top): ");
        for(int j=0; j<size(); j++){
            System.out.print(peekN(j));
            System.out.println(' ');
        }
    }
}

/////////////////////////////////////////////////////////////////////////
//-------------------------------------------------Преобразование инфиксой записи в постфиксную
class MyInToPost{
    private MyStack_Infix stack;
    private String input;
    private String output="";

    //---------------------------------------------Конструктор
    public MyInToPost(String input){
        this.input=input;
        int stackSize = input.length();
        stack=new MyStack_Infix(stackSize);
    }
    //---------------------------------------------Преобразование в постфиксную форму
    public String doTrans(){
        for (int j=0; j<input.length(); j++){
            char ch=input.charAt(j);
            stack.desplayStack("For "+ch+" ");  // *диагностика*
            switch(ch){
                case '+':
                case '-':
                    gotOper(ch,1); //Извлечение операторов с приоритетом 1
                    break;
                case '*':
                case '/':
                    gotOper(ch,2); //Извлечение операторов с приоритетом 2
                    break;
                case '(':
                    stack.push(ch); //Занести в стек
                    break;
                case ')':
                    gotParen(ch); //Извлечение операторов
                default:  //Остаётся операнд
                    output=output+ch; //Записать в выходную строку
                    break;
            }
        }
        while(!stack.isEmpty()) { //Извлечение оставшихся операторов
            stack.desplayStack("While "); // *диагностика*
            output=output+stack.pop(); //write to output
        }
        stack.desplayStack("End "); // *диагностика*
        return output; //возвращение постфиксного выражения
    }

    //---------------------------------------------Чтение оператора из входной строки
    public void gotOper(char opThis, int prec1){
        while(!stack.isEmpty()){
            char opTop = stack.pop();
            if(opTop=='('){         //Если это '('
                stack.push(opTop);  //Вернуть '('
                break;
            }
            else {     //оператор
                int prec2; //Приоритет нового оператора
                if (opTop == '+' || opTop == '-') //определение приоритета
                    prec2 = 1;
                else
                    prec2 = 2;
                if (prec2 < prec1) { //Если приоритет нового оператора меньше приоритета старого
                    stack.push(opTop); //Сохранить новый оператор
                    break;
                }
                else
                    output = output + opTop; //Приоритет нового оператора не меньше старого
            }
        }
        stack.push(opThis); //Занесение в стек нового оператора
    }

    //---------------------------------------------Прочитана закрывающая скобка
    public void gotParen(char ch){
        while(!stack.isEmpty()){
            char chx=stack.pop();
            if(chx==')')              //Если извлечен элемент ')'
                break;                //Прервать выполнение
            else                      //Если извлечен оператор
                output=output+chx;    //Вывести в постфиксную строку
        }
    }
}

/////////////////////////////////////////////////////////////////////////////////////
public class MyInfixApp {
    public static void main(String[] args) throws IOException {
        String input, output;
        while (true) {
            System.out.print("Enter infix: ");
            System.out.flush();
            input = getString(); //Чтение строки с клавиатура
            if (input.equals("")) //Выход, если нажата клавиша Enter
                break;
            MyInToPost theTrans = new MyInToPost(input);
            output = theTrans.doTrans(); //Преобразование
            System.out.println("Postfix is " + output + '\n');
        }
    }
        //--------------------------------------------------
        public static String getString() throws IOException{
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            String s = r.readLine();
            return s;
    }
}
