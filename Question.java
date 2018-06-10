import java.util.*;
public class Question{
    private String question; 
    private String answer;
    private String answerLetter;
    List<String> distractorList;
    private HashMap<String, String> choices = new HashMap<>();
    Question(String question, String answer, String [] distractors){
        this.question=question;
        this.answer=answer;
        distractorList = Arrays.asList(distractors);
        setChoices();

    }

    public boolean hasAnswer(String answer){
        return this.answerLetter.equals(answer);
    }

    public String toString(){
        String options = "";
        Iterator entries = choices.entrySet().iterator();
        while(entries.hasNext()){
            options+=entries.next()+System.lineSeparator();
        }
        return question+System.lineSeparator()+options.replaceAll("=","  ");
    }

    private void setChoices(){
        ArrayList<String> letters = new ArrayList<>();
        char letter = 'a';
        for(int i = 0; i<distractorList.size()+1;i++){
            letters.add(String.valueOf(letter));
            letter++;
        }
        Random generator = new Random();
        answerLetter = letters.remove(generator.nextInt(letters.size()));
        choices.put(answerLetter,answer);
       for(String distractor : distractorList){
           choices.put(letters.remove(generator.nextInt(letters.size())), distractor);
        }

    }
    public static void test(){
        String[] distractors = {"no","idk"};
        Question question = new Question("Is the sky blue?", "yes", distractors);
        System.out.print(question);
    }
}