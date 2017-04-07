package JarGame;

import java.util.Random;

/**
 * Created by jorgeotero on 4/5/17.
 */
public class Jar {
    private String itemName;
    private int maximunNumber;
    private int itemQuantity;
    private int guess;
    private int guessAttempts;
    private boolean winGame = false;

    public Jar(String itemName, int maximunNumber) {
        this.itemName = itemName;
        this.maximunNumber = maximunNumber;
        setItemQuantity();
    }

    public int fill() {
        Random random = new Random();
        return random.nextInt(maximunNumber) + 1;
    }

    public String analysingGuess() {
        String analysis = "";
        if (guess == itemQuantity) {
            newAttempt();
            analysis = "win";
        } else if (guess > maximunNumber) {
            analysis = "overTheTop";
        } else if (guess > itemQuantity) {
            newAttempt();
            analysis = "high";
        } else if (guess < itemQuantity) {
            newAttempt();
            analysis = "low";
        } else {
            newAttempt();
            analysis = "error";
        }
        return analysis;
    }

    public void newAttempt() {
        guessAttempts++;
    }

    public String getItemName() {
        return itemName;
    }

    public int getMaximunNumber() {
        return maximunNumber;
    }

    public void setItemQuantity() {
        this.itemQuantity = fill();
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }

    public int getGuessAttempts() {
        return guessAttempts;
    }

    public boolean isWinGame() {
        return winGame;
    }

    public void setWinGame(boolean winGame) {
        this.winGame = winGame;
    }
}
