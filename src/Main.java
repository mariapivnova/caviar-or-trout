public class Main {
    public static void main(String[] args) {
        AnimalThread caviar = (new AnimalThread("Икра"));
        AnimalThread trout = (new AnimalThread("Форель"));
        caviar.start();
        trout.start();

        try {
            caviar.join();
            if(trout.isAlive()){
                System.out.println("Выиграла Форель");
            }else {
                trout.join();
                System.out.println("Выиграла Икра");
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }
}
class AnimalThread extends Thread {
    String Name;
    final int distance = 6;
    public AnimalThread(String Name) {

        this.Name = Name;
    }
    @Override
    public void run() {
        Thread.currentThread().setName(Name);
        for (int i = 0; i < distance; i++) {
            try {
                Thread.sleep(500);
                System.out.println(getName());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}