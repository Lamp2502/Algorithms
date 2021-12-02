class Home {
      private int length;
      private int height;
      private int width;
      private static int constant = 5;
      private Room room = new Room();
      private RoomS roomS = new RoomS();

      //-----------------------------------------------------------конструктор
      public Home(int length, int height, int width){
          this.length=length;
          this.height=height;
          this.width=width;
      }
      //-------------------------------------подкласс
      class Room {
         int length = 4;
         int height = 3;
         int width = 3;
         int floor = 2;
         int count = 8;

         //----------------------------------метод подкласса
          void volume(){
            System.out.println("ROOM: ");
            System.out.println("Total length: "+ length);
         }
      }
      //-------------------------------------------------------------статический подкласс
    public static class RoomS{
          int constant1 = constant+1;
          void volumeS(){
              System.out.println("constant= "+ constant);
          }
    }
    //---------------------------------------------------------------метод реализующий метод подкласса
      void display(){
         Room room = new Room();
         room.volume();
    }
    //---------------------------------------------------------------метод реализующий метод подкласса
    void displayS(){
        RoomS roomS = new RoomS();
        roomS.volumeS();
    }
}
/////////////////////////////////////////////////////////////////////////////////

public class HomeApp {
    static int st = 6;
    Home home = new Home(15,10,10);
    Home.RoomS roomS = new Home.RoomS();


    public static void main(String[] args){
        Home home = new Home(8,6,6);
        st = 8;
   //     home.display();
      //  home.displayS();
    }

    public void m(){
        roomS.volumeS();
    }
}

