import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int minRange = 2;
        int maxRange = 20;
        int bestGuess = 0;
        int attempts = 1;
        int maxAttempts = 10;
        int randomInt = randomInteger(minRange, maxRange);

        // Instructions
        System.out.println("\nHello, challenger! I am the \"Guess the Number\" game, ready to test your wits.\nI've hidden a number within a secret range—your mission is to uncover it within limited attempts. \nSharpen your guessing skills, trust your instincts, and let the thrill of discovery begin. \nCan you conquer the challenge? Let's play! \uD83C\uDFB2");

        // Feedback
        do {
            // Max Attempt Watchdog
            if (attempts >= maxAttempts) {
                System.out.println("\nSo close, yet so far! \uD83D\uDE1C \nYou’ve run out of attempts, and my secret number was "+randomInt+". \nYou had "+attempts+" shots to crack the code, \nbut I’m still the reigning champion this round.");

                // Play Again
                System.out.println();
                System.out.println("Dust yourself off, gear up, \nand let’s see if you can outsmart me in the next challenge! \uD83C\uDFAF");
                System.out.println("Do you want to play again? (Y/N)");
                String answer = sc.nextLine().toUpperCase();
                if (answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("YES")) {
                    randomInt = randomInteger(minRange, maxRange);
                    bestGuess = 0;
                    attempts = 0;
                } else {
                    break;
                }

            }

            boolean validInteger = false;
            while (!validInteger) {
                try {
                    System.out.print("\nThink carefully! \nI've hidden a number within the range. \nCan you uncover my secret? \n\nTake your best shot and type your guess: ");
                    bestGuess = Integer.parseInt(sc.nextLine());
                    if (bestGuess >= minRange && bestGuess <= maxRange) {
                        validInteger = true;
                    } else {
                        System.out.println("\nOops! That’s not what I was looking for. \uD83D\uDEAB \nLet’s try again—enter a whole number that’s within the range. \nI know you’ve got this! \uD83D\uDCAA");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("\nUh-oh! \uD83D\uDEAB \nThat doesn’t look like a valid number. \nLet’s try again—enter a proper integer, and let’s keep the game rolling! \uD83C\uDFAF");
                }
            }

            // Feedback
            if (bestGuess != randomInt) {
                if (bestGuess < randomInt) {
                    System.out.println("\nNice try, but your guess is too low! \uD83D\uDE0F \nThink bigger—I’m aiming higher than that. \nGive it another shot and show me what you've got!");
                } else {
                    System.out.println("\nWhoa, slow down! \uD83D\uDE80 \nYour guess is soaring too high above my secret number. \nTry aiming a bit lower—I promise you're getting warmer. \nGive it another shot and show me your guessing genius!");
                }
            } else {
                System.out.println("\nBravo! \uD83C\uDF89 \nYou've cracked the code and uncovered my secret number! \nYour instincts are razor-sharp—well done, mastermind!");
                System.out.println("\nYou unraveled my secret number—"+randomInt+"—after just "+attempts+" attempts! Persistence and sharp thinking led you here.");

                // Play Again
                System.out.println();
                System.out.println("Will you bask in your glory or challenge yourself to an even tougher round? \nThe game is yours to command!");
                System.out.println("Do you want to play again? (Y/N)");
                String answer = sc.nextLine().toUpperCase();
                if (answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("YES")) {
                    randomInt = randomInteger(minRange, maxRange);
                    bestGuess = 0;
                    attempts = 0;
                }
            }
            attempts++;
        }
        while (bestGuess != randomInt);

        System.out.println("\nThanks for playing! \uD83C\uDF89 \nYou’ve been an amazing contender in the 'Guess the Number' game. \nWhether you’re leaving victorious or ready to challenge yourself again, remember—the numbers never sleep! \nSee you next time for more guessing fun!");
        sc.close();
    }

    private static int randomInteger(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }
}