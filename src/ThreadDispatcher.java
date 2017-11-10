import java.util.concurrent.Semaphore;

public class ThreadDispatcher {

    public static void main(String[] args) {
        Semaphore controlSemaphore = new Semaphore(1, true);
        Generator generator = new Generator(10, 7);
        int players = 4;
        for(int i = 0; i < players; i++)
            new Thread(new Gamer(controlSemaphore,i,generator)).start();
    }


}
