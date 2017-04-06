package JarGame;

import java.util.Random;

/**
 * Created by jorgeotero on 4/5/17.
 */
public class JarLogic {
    private String itemName;
    private Integer maxAmount;
    private Integer itemQuantity;
    private Integer guess;
    private Integer guessAttempts;
    private boolean winGame = false;
    private static JarLogic instance;


    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(maxAmount) + 1;
    }

    public String analysingGuess() {
        String analysis = "";
//        It's a possible better option to return a String insteaas of a variable.
        if (guess == itemQuantity) {
            newAttempt();
            analysis = "win";
        } else if (guess > maxAmount) {
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

    public Integer getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Integer maxAmount) {
        this.maxAmount = maxAmount;
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

    public static JarLogic getJarLogic() {
        if (instance == null) {
            instance = new JarLogic();
        }
        return instance;
    }
}
