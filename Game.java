
/**
 * Class responsible for holding all objects related to game and calling their methods.
 * @author Marcus Trujillo and Colton Trujillo
 * @version 7.7.18
 */
import java.util.*; 

public class Game
{
    Input input; 
    Player player;
    final int STARTING_LIVES = 3;
    int numPlayers; 
    ArrayList<Player> players = new ArrayList<Player>(); 
    ArrayList<Question> questions;
    QuestionSet questionSet;
    QuestionFactory factory = new QuestionFactory();
    
    public Game(){
        input = new Input(); 
    }

    private void printWelcome(){
        System.out.println("--== Welcome to Trivia!!! ==--" + System.lineSeparator() + 
                            "Answer questions correctly to rack up the points!"); 
    }
    
    public void play(){
        questionSet = factory.getQuestionSet();
        printWelcome(); 
        numPlayers = Integer.parseInt(input.getNumPlayers()); 
        for(int i = 0; i < numPlayers; i++){
            String currentPlayerName = input.getName(); 
            player = new Player(currentPlayerName); 
            players.add(player); 
        } 
        
        
        boolean running = true; 

        while(running){
            try{
            Question currentQuestion = questionSet.getQuestion(); 
                   if(currentQuestion.hasAnswer(input.getAnswer(currentQuestion.toString()))){
                player.addPoints(1); 
                System.out.println("Correct! "+player.getName()+"'s score is now: "+player.getScore());
            } else {
                player.loseLife(); 
                System.out.println("Wrong! You just lost a life! You have "+player.getLives()+" left");
          
            }
        }
        catch(Exception ex){
            System.out.println("Out of questions");
            running = false;
        }
     
            if(player.getLives() == 0) running = false; 
        }
        String playAgain = input.getAnswer("Game Over! Final score is "+player.getScore()+". Would you like to play again?"+System.lineSeparator()+"a yes"+System.lineSeparator()+"b no")+System.lineSeparator();
        if (playAgain.contains("a"))play();
        else System.out.println("Ok. Thanks for playing!");
      
    }
}
