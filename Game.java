
/**
 * @author Marcus Trujillo and Colton Trujillo
 * Description of program if main/ class otherwise 
 */
import java.util.*; 

public class Game
{
    Input input; 
    Player player; 
    ArrayList<Question> questions; 
    Random randomGenerator = new Random(); 
    QuestionFactory factory = new QuestionFactory();
    public Game(){
        questions = factory.getQuestions();
        input = new Input(); 
    }

    
    private Question getQuestion(){
        int questionNum = 0; 
        if(questions.size() != 0){
            questionNum = randomGenerator.nextInt(questions.size()); 
        } else System.out.println("We haven't made any questions yet"); 
        return questions.get(questionNum); 
    }

    private void printWelcome(){
        System.out.println("Welcome to Trivia!!! You have three lives. A wrong answer costs a life!" + 
            System.lineSeparator() + "keep answering questions correctly to rack up the points");
    }

    
    public void play(){
        Question currentQuestion; 
        printWelcome(); 
        player = new Player(input.getName()); 
        boolean running = true; 

        while(running){
            currentQuestion = getQuestion(); 
            if(currentQuestion.isAnswer(input.getAnswer(currentQuestion.toString()))){
                player.addPoints(1); 
                System.out.println("Correct! "+player.toString()+"'s score is now: "+player.getScore());
            } else {
                player.loseLife(); 
                System.out.println("Wrong! You just lost a life! You have "+player.getLives()+"left");
          
            }
            if(player.getLives() == 0) running = false; 
        }
        String playAgain = input.getAnswer("Game Over! Would you like to play again?"+System.lineSeparator()+"a yes"+System.lineSeparator()+"b no")+System.lineSeparator();
        if (playAgain.equals("a"))play();
        else System.out.println("Ok. Thanks for playing!");
      
    }
}
