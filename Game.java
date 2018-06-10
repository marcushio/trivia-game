
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
    ArrayList<Question> questions;
    Random randomGenerator = new Random(); 
    QuestionFactory factory = new QuestionFactory();
    
    public Game(){
        questions = factory.getQuestions();
        input = new Input(); 
    }

    /**
     * Randomly selects a question from the arraylist
     * @return question 
     */
    private Question getQuestion(){
        int questionNum = 0; 
        if(questions.size() != 0){
            questionNum = randomGenerator.nextInt(questions.size()); 
        } else System.out.println("There are no questions left to answer."); 
        return questions.get(questionNum); 
    }

    private void printWelcome(){
        System.out.println("Welcome to Trivia!!! You have "+STARTING_LIVES+" lives. A wrong answer costs a life!" + 
            System.lineSeparator() + "keep answering questions correctly to rack up the points");
    }

    /**
     * The primary method that runs the game calling the necessary methods from other places. 
     */
    public void play(){
        Question currentQuestion; 
        printWelcome(); 
        player = new Player(input.getName()); 
        boolean running = true; 

        while(running){
            currentQuestion = getQuestion(); 
            if(currentQuestion.hasAnswer(input.getAnswer(currentQuestion.toString()))){
                player.addPoints(1); 
                System.out.println("Correct! "+player.getName()+"'s score is now: "+player.getScore());
            } else {
                player.loseLife(); 
                System.out.println("Wrong! You just lost a life! You have "+player.getLives()+" left");
          
            }
            if(player.getLives() == 0) running = false; 
        }
        String playAgain = input.getAnswer("Game Over! You died with a score of: "+player.getScore()+". Would you like to play again?"+System.lineSeparator()+"a yes"+System.lineSeparator()+"b no")+System.lineSeparator();
        if (playAgain.contains("a"))play();
        else System.out.println("Ok. Thanks for playing!");
    }
}
