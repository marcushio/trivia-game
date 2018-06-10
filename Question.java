import java.util.*;

public class Question{
    private String question; 
    private String answer;
    private String answerLetter;
    private HashMap<String, String> choices = new HashMap<>();
    
    Question(String question, String answer, String distractor1, String distractor2){
        this.question=question;
        this.answer=answer;
        setChoices(answer, distractor1,distractor2);
    }
    
    /**
     * @return the letter of the answer.
     */
    public boolean hasAnswer(String answer){
        return this.answerLetter.equals(answer);
    }
    
    /**
     * @return string representation of the question.
     */
    public String toString(){
        String options = "";
        Iterator entries = choices.entrySet().iterator();
        while(entries.hasNext()){
            options+=entries.next()+System.lineSeparator();
        }
        return question+System.lineSeparator()+options.replaceAll("=","  ");
    }
    
    /**
     * Sets the multiple choices of the question with the correct answer and distractors in random places. 
     */
    private void setChoices(String answer, String distractor1, String distractor2){
        ArrayList<String> letters = new ArrayList<>();
        letters.add("a");
        letters.add("b");
        letters.add("c");
        Random generator = new Random();
        answerLetter = letters.remove(generator.nextInt(letters.size()));
        choices.put(answerLetter,answer);
        choices.put(letters.remove(generator.nextInt(letters.size())), distractor1);
        choices.put(letters.remove(generator.nextInt(letters.size())),distractor2);
    }
    
    /**
     * just a test method to see if questions are being created correctly. 
     */
    public static void test(){
        Question question = new Question("Is the sky blue?", "yes", "no", "idk");
        System.out.print(question);
    }
}