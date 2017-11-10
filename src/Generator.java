public class Generator {

    private int value;
    private int difficulty;
    private int wins;

    public Generator(int difficulty, int wins) {
        this.difficulty = difficulty;
        this.wins = wins;
        this.value = 0;
    }

    public int getValue() {
        return value;
    }

    public void reGenerate(){
        wins--;
        this.value = ownUtils.Generate(difficulty);
    }


    public int getWins() {
        return wins;
    }

    public int getDifficulty() {
        return difficulty;
    }
}
