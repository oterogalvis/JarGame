package JarGame;

import java.util.Random;

/**
 * Created by jorgeotero on 4/5/17.
 */
public class Jar {
    private String itemName;
    private Integer maximunNumber;
    private Integer itemQuantity;
    private Integer guess;
    private Integer guessAttempts;
    private boolean winGame = false;
    private static Jar instance;

    public Jar(String itemName, Integer maximunNumber) {
        this.itemName = itemName;
        this.maximunNumber = maximunNumber;
        setItemQuantity();
    }

    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(maximunNumber) + 1;
    }

    public String analysingGuess() {
        String analysis = "";
//        It's a possible better option to return a String insteaas of a variable.
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
        if (guessAttempts == null) {
            guessAttempts = 0;
        }
        guessAttempts++;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getMaximunNumber() {
        return maximunNumber;
    }

    public void setMaximunNumber(Integer maximunNumber) {
        this.maximunNumber = maximunNumber;
    }

    public Integer getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity() {
        this.itemQuantity = generateRandomNumber();
    }

    public Integer getGuess() {
        return guess;
    }

    public void setGuess(Integer guess) {
        this.guess = guess;
    }

    public int getGuessAttempts() {
        return guessAttempts;
    }

    public void setGuessAttempts(int guessAttempts) {
        this.guessAttempts = guessAttempts;
    }

    public boolean isWinGame() {
        return winGame;
    }

    public void setWinGame(boolean winGame) {
        this.winGame = winGame;
    }

    public static Jar getJar(String itemName, Integer maximunNumber) {
        if (instance == null) {
            instance = new Jar(itemName, maximunNumber);
        }
        return instance;
    }
}
