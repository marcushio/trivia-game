
/**
 * Write a description of class HardCodeQuestionFactory here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HardCodeQuestionFactory implements QuestionFactory
{
    public QuestionSet getQuestionSet(){
      QuestionSet questions = new QuestionSet();
      String[] distractors = {"Linus Torvalds","Todd Johnson"};
      questions.add(new Question("Who wrote this program?", "Marcus Trujillo and Colton Trujillo",distractors));
      questions.add(new Question("Who is a better Hearthstone player?", "Marcus Trujillo", distractors));
      questions.add(new Question("How many licks does it take to get to the tootsie roll center of a tootsie pop?","3",distractors));
      questions.add(new Question("What time is it?", "Time to code", distractors));
      questions.add(new Question("What is the nephew's nickname", "Tank",distractors));
      questions.add(new Question("All your base are belong to us?","Yes",distractors));
      return questions;
    }
}
