package exercise2;
import javax.swing.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //the user chooses a number between 3 and 27
        String input = JOptionPane.showInputDialog(null, "Choose a number between 3 and 27:");
        int userInput = Integer.parseInt(input);

        //initial the result
        boolean lottoResult = false;

        //The user runs the lotto up to 5 times and each time the sum of lotto numbers is calculated.
        for (int i = 0; i < 5; i++) {
            Lotto lotto = new Lotto();
            int[] returnArray = lotto.getValues();
            int sum = lotto.eachSum();
            JOptionPane.showMessageDialog(null, "Lotto numbers: " + Arrays.toString(returnArray) + " = " + sum);
            //If the number chosen by the user matches the sum, the user wins
            if (sum == userInput) {
                JOptionPane.showMessageDialog(null, "Congratulations! You win!");
                lottoResult = true;
                // and the game ends.
                break;
            }
        }
        //If the number does not match the sum within five rolls, the computer wins.
        if (!lottoResult) {
            JOptionPane.showMessageDialog(null, "Sorry, the computer wins.");
        }
    }
}
