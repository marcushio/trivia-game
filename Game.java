
/**
 * @author Marcus Trujillo
 * Description of program if main/ class otherwise 
 */
import java.util.*; 

public class Game
{
    Input input; 
    Player player; 
    ArrayList<Question> questions; 
    Random randomGenerator; 
    
    public Game(){
        input = new Input(); 
        player = new Player("Player1"); 
        fillQuestions(); 
    }
    
    private void fillQuestions(){
        questions = new ArrayList<Question>(); 
    }
    
    private Question getQuestion(){
        int questionNum = randomGenerator.nextInt(questions.size()+1); 
        return questions.get(questionNum); 
    }
    
    private void printWelcome(){
      System.out.println("Welcome to Trivia!!! You have three lives. A wrong answer costs a life!" + 
                      System.lineSeparator() + "keep answering questions correctly to rack up the points");
    }
    
    private String getPlayerName(){
        System.out.println("What is your name player?"); 
        //add input method to get player name
        return "player1";
    }
    
    private String getPlayerAnswer(){
        System.out.println("What is your final answer: "); 
        //input method for getting answer
        String answer = " "; 
        return answer; 
    }
    
    public void play(){
        Question currentQuestion; 
        printWelcome(); 
        getPlayerName(); 
        boolean running = true; 
        
        while(running){
            currentQuestion = getQuestion(); 
            if(currentQuestion.isAnswer(getPlayerAnswer())){
                player.addPoints(1); 
            } else player.loseLife(); 
            if(player.lives = 0) running = false; 
        }
    }
}
