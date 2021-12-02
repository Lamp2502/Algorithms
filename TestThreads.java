//Создать второй поток исполнения, расширив класс Thread

class NewThread extends Thread {
    NewThread() {
        // создать новый поток исполнения
        super("Демонстрационный поток");
        System.out.println("Дoчepний поток: " + this);
        start(); // запустить поток на исполнение
    }
        // Точка входа во второй поток исполнения
        public void run(){
            try {
                for (int i = 5; i > 0; i--) {
                    System.out.println("Дoчepний поток: " + i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException е) {
                System.out.println("Дoчepний поток прерван.");
              }
            System.out.println("Дoчepний поток завершен.");
        }
    }

class ExtendThread {
    public static void main(String args[]) {
        new NewThread(); // создать новый поток исполнения
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Глaвный поток: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException е) {
            System.out.println("Глaвный поток прерван.");
        }
        System.out.println("Глaвный поток завершен.");
    }
}




