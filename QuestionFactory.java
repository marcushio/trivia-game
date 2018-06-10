import java.util.*;
/**
 * Class responsible for generating questions with an API for clients to get sets of them
 *
 * @author Colton Trujillo
 * @version 6.2.2018
 */
public class QuestionFactory
{
  public QuestionSet getQuestionSet(){
      QuestionSet questions = new QuestionSet();
      questions.add(new Question("Who wrote this program?", "Marcus Trujillo and Colton Trujillo", "Linus Torvalds","Todd Johnson"));
      questions.add(new Question("Who is a better Hearthstone player?", "Marcus Trujillo", "Colton Trujillo","They are equal in skill."));
      questions.add(new Question("How many licks does it take to get to the tootsie roll center of a tootsie pop?","3","1","2"));
      questions.add(new Question("What time is it?", "Time to code", "Linus Torvalds","Todd Johnson"));
      questions.add(new Question("What is the nephew's nickname", "Tank", "Marcus Trujillo","They are equal in skill."));
      questions.add(new Question("All your base are belong to us?","Yes","1","2"));
      return questions;
    }

    
}
