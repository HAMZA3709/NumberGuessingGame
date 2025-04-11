import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    Random random=new Random();
    boolean playAgain=true;
        System.out.println("Welcome to the Number Guessing Game!");
        while (playAgain){
           int maxAttempts=0;
           int range=100;
            System.out.println("Choose difficulty level:");
            System.out.println("1. Easy (10 attempts)");
            System.out.println("2. Medium (7 attempts)");
            System.out.println("3. Hard (5 attempts)");

            int difficulty =0;
            while(difficulty<1||difficulty>3){
                try {
                    System.out.println("Enter your choice(1:3");

                    difficulty = Integer.parseInt(scanner.nextLine());
                    switch (difficulty) {
                        case 1:
                            maxAttempts = 10;
                            range = 50;
                            break;
                        case 2:
                            maxAttempts = 7;
                            range = 100;
                            break;
                        case 3:
                            maxAttempts = 5;
                            range = 150;
                            break;
                        default:
                            System.out.println("Invalid choice. select 1,2 or 3");
                    }
                } catch (NumberFormatException e){
                    System.out.println("❗Please enter a valid number");
                     }
                  }
            int secretNumber = random.nextInt(range)+1;
            int attempts = 0;
            boolean guessedCorrectly =false;

            System.out.println( "I have picked a number between 1 and " + range + ". Try to guess it!");
           while (attempts<maxAttempts) {
           int guess=0;
           try {
               System.out.println("Attempt" + (attempts+1)+"of" +maxAttempts + ":");
               guess =Integer.parseInt(scanner.nextLine());
               attempts++;
               if(guess<secretNumber){
                   System.out.println(" Too low!");
               } else if (guess>secretNumber) {
                   System.out.println(" Too high!");
               } else {
                   System.out.println("🎉 Correct! You guessed the number in " + attempts + " attempts.");
                   guessedCorrectly = true;
                   break;
           }
           }catch (NumberFormatException e){
               System.out.println("❗ Invalid input. Please enter a number.");
           }
           if (!guessedCorrectly){
               System.out.println("Out of attempts! The correct number was: " + secretNumber);
           }
               System.out.print("\nDo you want to play again? (yes/no): ");
               String response = scanner.nextLine().trim().toLowerCase();
               if (!response.equals("yes") && !response.equals("y")) {
                   playAgain = false;
                   System.out.println(" Thanks for playing! See you next time.");
               }
           }
        }
   scanner.close();
    }
}