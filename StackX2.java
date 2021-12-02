import java.io.*;

public class MyStackX2 {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public MyStackX2(int maxSize){
        this.maxSize = maxSize;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char v){
        stackArray[++top]=v;
    }

    public char pop(){
        return stackArray[top--];
    }

    public  char peek(){
        return stackArray[top];
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public  boolean isFull(){
        return top==maxSize-1;
    }
}
///////////////////////////////////////////////

class MyBracketChecker2 {
    private String input;

    public MyBracketChecker2(String input){
        this.input = input;
    }

    public void check(){
        int stackSize = input.length();
        MyStackX2 theStack = new MyStackX2(stackSize);

        for(int j=0; j<input.length(); j++){
            char ch = input.charAt(j);

            switch (ch){
                case '[':
                case '{':
                case '(':
                    theStack.push(ch);
                    break;

                case ']':
                case '}':
                case ')':
                    if(!theStack.isEmpty()){
                        char chx = theStack.pop();

                        if( (ch==']' && chx!='[') ||
                            (ch=='}' && chx!='{') ||
                            (ch==')' && chx!='(')   )

                        System.out.println("Error");
                        break;
                    }
                default: break;
            }
        }
        if(!theStack.isEmpty())
            System.out.println("Error");
        else System.out.println("All ok!");
    }
}

//////////////////////////////////////////////////////////////////////////////////

class MyBracketsApp2 {
    public static void main(String[] args) throws IOException {
        String input;

        while (true){
            System.out.println("Enter string containing delimiters: ");
            System.out.flush();
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            input = r.readLine(); // Чтение строки с клавиатуры
            if(input.equals(""))
                break;
            MyBracketChecker2 theChecker = new MyBracketChecker2(input);
            theChecker.check();
        }
    }
}

