package ch07pc06;

/**
 *
 * @author Frank
 */
public class DriverExam {
    //fields
    private final String[] correctAnswers = {
            "B", "D", "A", "A", "C",
            "A", "B", "A", "C", "D",
            "B", "C", "D", "A", "D",
            "C", "C", "B", "D", "A"
        };
    
    //constructor
    public DriverExam()
    {
        
    }
    
    ///methods
        
    public int getLength()
    {
        //variable
        int length;
        length = correctAnswers.length;
        
        return length;
    }
    
    public int totalCorrect (String[] userAnswer)
    {
        //variables
        int correct = 0;
        
        for (int i = 0; i < userAnswer.length; i++)
        {
            if (correctAnswers[i].equalsIgnoreCase(userAnswer[i]))
            {
                correct++;
            }
        }
        
        return correct;
    }
    
    public boolean passed (String[] userAnswer)
    {
        //variable
        boolean pass = false;
        
        if (totalCorrect(userAnswer) >= 15)
            pass = true;
        
        return pass;
    }
    
    public int totalIncorrect (String[] userAnswer)
    {
        //variable
        int incorrect = 0;
        
        for (int i = 0; i < correctAnswers.length; i++)
        {
            if (!correctAnswers[i].equalsIgnoreCase(userAnswer[i]))
                incorrect++;
        }
        
        return incorrect;
    }
    
    public int[] questionsMissed (String[] userAnswer)
    {
        //variable
        int[] missed;
        int miss = 0;
        
        missed = new int[totalIncorrect(userAnswer)];
        
        for (int i = 0; i < correctAnswers.length; i++)
        {
            if (!correctAnswers[i].equalsIgnoreCase(userAnswer[i]))
            {
                missed[miss] = i +1;
                miss++;
            }
        }
        
        return missed;
    }
}
