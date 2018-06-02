import java.util.*;
public class Question{
    private String question; 
    private String answer;
    private HashMap<String, String> choices = new HashMap<>();
    Question(String question, String answer, String distractor1, String distractor2){
        this.question=question;
        this.answer=answer;
        setChoices(answer, distractor1,distractor2);
    }
    public boolean isAnswer(String answer){
        return this.answer==answer;
    }
    public String toString(){
        String options = "";
        Iterator entries = choices.entrySet().iterator();
        while(entries.hasNext()){
            options+=entries.next()+System.lineSeparator();
        }
        return question+options;
    }
    private void setChoices(String answer, String distractor1, String distractor2){
        ArrayList<String> data = new ArrayList<>();
        data.add(answer);
        data.add(distractor1);
        data.add(distractor2);
        Random generator = new Random();
        choices.put("a",data.remove(generator.nextInt(data.size())));
        choices.put("b", data.remove(generator.nextInt(data.size())));
        choices.put("c", data.remove(generator.nextInt(data.size())));
    }
}