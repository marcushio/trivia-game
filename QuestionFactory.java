import java.util.*;
/**
 * Class responsible for generating questions with an API for clients to get sets of them
 *
 * @author Colton Trujillo
 * @version 6.2.2018
 */
public class QuestionFactory
{
  public ArrayList<Question> getQuestions(){
      ArrayList<Question> questions = new ArrayList<>();
      questions.add(new Question("Who wrote this program?", "Marcus Trujillo and Colton Trujillo", "Linus Torvalds","Todd Johnson"));
      questions.add(new Question("Who is a better Hearthstone player?", "Colton Trujillo", "Marcus Trujillo","They are equal in skill."));
      return questions;
    }
}
