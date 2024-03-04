import java.util.Scanner;
import java.util.Random;

public class Guesser {

    Scanner myScanner = new Scanner(System.in);

    int current_guess = 0;
    int last_guess;
    int totalGuesses = 0;
    int randomNum;
    boolean notGuessed = true;

    public void guesser(){
        Random rand = new Random();
        randomNum = rand.nextInt(100);

        while(notGuessed){
            last_guess = current_guess;
            current_guess = getInput();
            if(current_guess != last_guess){
                totalGuesses++;
            }
            int check_result = check(randomNum, current_guess);
            if(check_result == 0){
                notGuessed = false;
            }
        }
    }
    public int check(int secret_num, int guessed_num) {
        System.out.println("Enter a guess");
        if (guessed_num > secret_num) {
            System.out.println("Too high");
            return 1;
        }
        else if(guessed_num < secret_num){
            System.out.println("Too low");
            return -1;
        }
        System.out.println("correct guess");
        System.out.println("Total guesses = " + this.totalGuesses);
        return 0;
    }

    public int getInput(){
        Scanner myScanner = new Scanner(System.in);
        int input = myScanner.nextInt();
        myScanner.nextLine(); // Clears the \n from the iStream

        return input;
    }

}
