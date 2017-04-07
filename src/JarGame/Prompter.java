package JarGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jorgeotero on 4/5/17.
 */
public class Prompter {
    private static Prompter instance;
    private Jar jar;
    private BufferedReader bufferedReader;

    public Prompter() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String ask(String question) {
        System.out.println(question);
        String answer = "";
        try {
            answer = bufferedReader.readLine();
        } catch (IOException ioe) {
            System.out.println("Problem with input, try again.%s");
            ioe.printStackTrace();
        }
        return answer;
    }

    public Integer askInt(String question) {
        Integer answer = 0;
        while (answer < 1) {
            try {
                answer = Integer.valueOf(ask(question));
            } catch (NumberFormatException nfe) {
                System.out.println("Input must be numeric.");
                answer = 0;
            }
            if (answer < 1) {
                System.out.println("Input must be equal or higher than 1.");
            }
        }
        return answer;
    }

    public void administrator() {
        System.out.println("-------------- ADMINISTRATOR --------------");
        String itemName = ask("What type of item is in the Jar?");
        Integer maxAmount = askInt("What is the maximum amount of " + itemName + "?");
        jar = Jar.getJar(itemName, maxAmount);
    }

    public void askingForGuess() {
        Integer guess = askInt("How many " + jar.getItemName()
                + " are in the jar? Pick a number between 1 and " + jar.getMaximunNumber() + ".");
        jar.setGuess(guess);
    }

    public void outputOfResult(String result) {
        switch (result) {
            case "win":
                System.out.println("Congrats, You won the game. You got it in " + jar.getGuessAttempts() + " attempt(s)");
                jar.setWinGame(true);
            break;
            case "overTheTop":
                System.out.println("Your guess must be less than " + jar.getMaximunNumber());
                break;
            case "high":
                System.out.println("Your guess is too high");
                break;
            case "low":
                System.out.println("Your guess is too low");
                break;
            case "error":
                System.out.println("THERE IS AN ERROR IN JARLOGIC.");
                break;
            default:
                System.out.println("THERE IS AN ERROR IN JARPROMPTER.");
                break;
        }
    }

    public void promptLoop() {
        while (!jar.isWinGame()) {
            askingForGuess();
            String result = jar.analysingGuess();
            outputOfResult(result);
        }
    }

    public void player() {
        System.out.println("-------------- PLAYER --------------");
        promptLoop();
    }

    public void play() {
        administrator();
        player();
    }

    public static Prompter getPrompter() {
        if (instance == null) {
            instance = new Prompter();
        }
        return instance;
    }
}
