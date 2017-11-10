import java.util.concurrent.Semaphore;

public class Gamer implements Runnable{
    private Semaphore semaphore;
    private Generator generator;
    private int id;

    public Gamer(Semaphore semaphore, int id, Generator generator) {
        this.semaphore = semaphore;
        this.id = id;
        this.generator = generator;
    }

    @Override
    public void run() {
        while(generator.getWins() > 0) {
            try {
                semaphore.acquire();
                int answer = ownUtils.Generate(generator.getDifficulty());
                System.out.print("Поток " + id + " назвал число " + answer);
                if (answer == generator.getValue()) {
                    System.out.println(" и угадал");
                    generator.reGenerate();
                } else System.out.println(" и не угадал");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release();
        }
    }
}
