import java.io.*;
import java.util.Queue;

public class MyStackX { //класс Стек.
    private int top; //вершина стека.
    private char[] stackArray; //массив.
    private int maxSize; //размер массива для стека.

    public MyStackX(int maxSize){
        this.maxSize = maxSize;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char v){//вставка
        stackArray[++top] = v;
    }

    public char pop(){//извлечение
        return stackArray[top--];
    }

    public char peek(){//чтение
        return stackArray[top];
    }

    public boolean isEmpty(){
        return(top==(-1));
    }

    public boolean isFull(){
        return (top == maxSize - 1);
    }
}
//////////////////////////////////////////////////////////////////////////

class MyBracketChecker
{
    private String input; //входная строка

    public MyBracketChecker(String input){
        this.input = input;
    }

    public void check(){
        int stackSize = input.length(); //определение размера стека
        MyStackX theStack = new MyStackX(stackSize); //создание стека

        for(int j=0; j<input.length(); j++){ //последовательное чтение
            char ch = input.charAt(j); //чтение символа

            switch(ch){
                case '{':          //открывающие скобки
                case '[':
                case '(':
                    theStack.push(ch);
                    break;

                case '}':          //закрывающие скобки
                case ']':
                case ')':
                    if(!theStack.isEmpty()) {//если стек не пуст
                        char chx = theStack.pop(); //извлечь и проверить
                        if((ch=='}' && chx!='{') ||
                           (ch==']' && chx!='[') ||
                           (ch==')' && chx!='('))

                            System.out.println("Error: "+ch+" at "+j);
                    }
                    else //преждевременная нехватка элементов
                        System.out.println("Error: "+ch+" at "+j);
                    break;

                default: //для других символов действия не выполняются
                    break;
            }
        }
        //в этой точке обработаны все символы
        if(!theStack.isEmpty())
            System.out.println("Error: missing right delimiter");
    }
}
/////////////////////////////////////////////////////////////////////////////

class MyBracketsApp{
    public static void main(String[] args) throws IOException {
        String input;

        while(true){
            System.out.println("Enter string containing delimiters: ");
            System.out.flush();
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            input = r.readLine(); // Чтение строки с клавиатуры
            if(input.equals(""))//завершение, если [Enter]
                break;
            MyBracketChecker theChecker = new MyBracketChecker(input);
            theChecker.check(); //проверка парных скобок
        }
    }
}