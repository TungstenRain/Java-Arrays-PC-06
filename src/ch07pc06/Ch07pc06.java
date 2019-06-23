package ch07pc06;
import java.util.Scanner;

/**
 *
 * @author Frank
 * date 11/15/2017
 * purpose: to determine if a user passed an exam
 */
public class Ch07pc06 {

    public static void main(String[] args) {
        //variables
        String userInput;
        String[] userAnswers;
        int[] questionsMissed;
        
        //create keyboard Scanner for input
        Scanner keyboard = new Scanner(System.in);
        
        //instantiate DriverExam class
        DriverExam exam = new DriverExam();
        
        //initialize userAnswers
        userAnswers = new String[exam.getLength()];
        
        //Request input from user
        System.out.println("Please enter your answer to the question.");
        for (int i = 0; i < exam.getLength(); i++)
        {
            System.out.printf("Answer to question %d.  ", (i +1));
            userInput = keyboard.nextLine();
            
            if (!validInput(userInput))
            {
                i--;
                System.out.println("Please enter a valid answer (A, B, C, D).");
            }
            else 
            {
                userAnswers[i] = userInput;
            }
        }
        
        //Determine if passed, the total amount correct, the total missed, and the questions that were missed.
        if (exam.passed(userAnswers))
        {
            System.out.println("Congratulations!  You passed the exam.");
        }
        else
        {
            System.out.println("Unfortunately, you did not pass the exam.");
        }
        
        System.out.printf("You had %d correct and %d questions incorrect.\n", exam.totalCorrect(userAnswers), exam.totalIncorrect(userAnswers));
        
        if (exam.totalIncorrect(userAnswers) == 0)
        {
            System.out.println("Congratulations! you didn't miss any questions.\n");
        }
        else
        {
            //questionsMissed = new int[exam.totalIncorrect(userAnswers)];
            questionsMissed = exam.questionsMissed(userAnswers);
            
            for (int i = 0; i < questionsMissed.length; i++)
            {
                System.out.printf("You missed question %d.\n", questionsMissed[i]);
            }
        }
        
    }
    
    private static boolean validInput (String character)
    {
        //variable
        boolean valid = false;
        
        if (character.equalsIgnoreCase("A") || character.equalsIgnoreCase("B") || character.equalsIgnoreCase("C") || character.equalsIgnoreCase("D"))
            valid = true;
        
        return valid;
    }
    
    
}
