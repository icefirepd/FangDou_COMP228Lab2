package exercise1;

import javax.swing.JOptionPane;
import java.util.Random;

public class Test {
    //The test contains at least five questions about first three lectures of this course.
    private String[] questions = {
            "Which one of the following terms is correct for a Java class that creates object of another class, then calls the object’s methods?",
            "Which of the following statement is false about Java instance variables?",
            "Which of the following statements is true about Java constructors?",
            "How many significant digits does a floating-point number have?",
            "How many significant digits does a double precision number have?"
    };

    //Each question should be a multiple-choice question with 4 options.
    private String[][] options = {
            {"1. Abstract class", "2. Subscriber class.", "3. Driver class", "4. Concrete class"},
            {"1. The value of th instance variables are not shared among objects of the same class.", "2. The default value for an instance variable of type String is null", "3. Instance variables are not automatically initialized", "4. Every instance variable has a default initial value - a value provided by Java when you do not specify the instance variable’s initial value."},
            {"1. You must create a user-defined constructor in all Java applications which would help to construct objects from a class.", "2. User-defined constructors may have any name of your choice as long as the name follows the naming rules of Java class.", "3. You can make use of the default constructor supplied by the compiler without any additional code even if you declared user-defined constructor or constructors.", "4. User-defined constructors must not have a return type, not even a void."},
            {"1. 5", "2. 7", "3. 10", "4. 15"},
            {"1. 5", "2. 8", "3. 15", "4. 16"}
    };

    //the correct answers
    private int[] result = {3, 3, 4, 2, 3};

    //initial the correct and wrong count, at the first both 0
    private int correctCount = 0;
    private int wrongCount = 0;
    Random random = new Random();

    //-	create a method to simulate the questions – simulateQuestion
    public void simulateQuestion(int number) {
        //Use a loop to show all the questions.
        String output = questions[number] + "\n";
        for (int i = 0; i < options[number].length; i++) {
            output += options[number][i] + "\n";
        }
        String userInput = JOptionPane.showInputDialog(null, output, "Question " + (number + 1), JOptionPane.QUESTION_MESSAGE);
        int ans = Integer.parseInt(userInput); //convert to int
        checkAnswer(number, ans);
    }

    //-	create a method to check the answer – checkAnswer
    public void checkAnswer(int number, int ans) {
        //check if correct using generateMessage method and counter calculate
        if (ans == result[number]) {
            String congratsMessage = generateMessage(true);
            correctCount++;
            //Show the congrats code
            JOptionPane.showMessageDialog(null, congratsMessage , "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
        }
        //check when wrong using generateMessage method and counter calculate
        else {
            String errorMessage = generateMessage(false);
            wrongCount++;
            //Show the correct answer and display the error code
            JOptionPane.showMessageDialog(null, errorMessage + "\nCorrect answer: " + result[number], "Wrong Answer", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //-	create a method to display a random message for the user – generateMessage
    public String generateMessage(boolean check) {

        //-	If the user finds the right answer, display a random congratulatory message (“Excellent!”,”Good!”,”Keep up the good work!”, or “Nice work!”).
        if (check) {
            switch (random.nextInt(4)) {
                case 0:
                    return ("Excellent!");
                case 1:
                    return ("Good!");
                case 2:
                    return ("Keep up the good work!");
                case 3:
                    return ("Nice work!");
            }
        }
        //-	If the user responds incorrectly, display an appropriate message and the correct answer (“No. Please try again”, “Wrong. Try once more”, “Don't give up!”, “No. Keep trying..”).
        else {
            switch (random.nextInt(4)) {
                case 0:
                    return ("No. Please try again.");
                case 1:
                    return ("Wrong. Try once more");
                case 2:
                    return ("Don't give up!");
                case 3:
                    return ("No. Keep trying.");
            }
        }

        //output the message
        String output = generateMessage(check);
        return output;
    }

    //-	create a method to interact with the user - inputAnswer
    public void inputAnswer() {
        //for loop to simulate all the questions
        for (int i = 0; i < questions.length; i++) {
            simulateQuestion(i);
        }
        //calculate the percentage of the correct answers
        double percentage = ((double) correctCount / questions.length) * 100;

        //At the end of the test display the number of correct and incorrect answers, and the percentage of the correct answers.
        JOptionPane.showMessageDialog(null, "Correc answer(s): " + correctCount + "\nIncorrect answer(s): " + wrongCount + "\nCorrect Percentage: " + percentage + "%", "Result Overview", JOptionPane.INFORMATION_MESSAGE);
    }
}
