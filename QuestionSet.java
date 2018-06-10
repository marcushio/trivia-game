import java.util.*;
/**
 * Write a description of class QuestionSet here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class QuestionSet
{
    ArrayList<Question> questions = new ArrayList<>();
        Random randomGenerator = new Random(); 
      public Question getQuestion() throws Exception{
          if (questions.size() == 0) throw new Exception();
            int questionNum = randomGenerator.nextInt(questions.size()); 
            return questions.remove(questionNum); 
    }
    public void add(Question question){
        questions.add(question);
    }
}
