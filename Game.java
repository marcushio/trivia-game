
/**
 * Class responsible for holding all objects related to game and calling their methods.
 * @author Marcus Trujillo and Colton Trujillo
 * @version 7.7.18
 */
import java.util.*; 

public class Game
{
    boolean running;
    Input input; 
    final int POINTS_TO_WIN = 3;
    final int STARTING_LIVES = 3;
    ArrayList<Player> players;
    ArrayList<Question> questions;
    QuestionSet questionSet;
    QuestionFactory factory = new QuestionFactory();
    public Game(){
        players = new ArrayList <Player>();
        players.add(new Player("Marcus"));
        players.add(new Player("Colton"));
        input = new Input(); 
    }

    private void printWelcome(){
        System.out.println("Welcome to Trivia!!! You have "+STARTING_LIVES+" lives. A wrong answer costs a life!" + 
            System.lineSeparator() + "keep answering questions correctly to rack up the points");
    }

    public void play(){
        questionSet = factory.getQuestionSet();
        printWelcome(); 
        running = true; 

        while(running){
            for(Player player : players){
                try{
                    Question currentQuestion = questionSet.getQuestion(); 
                    if(currentQuestion.hasAnswer(input.getAnswer(player.getName()+", "+currentQuestion.toString()))){
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
            }
            endGame();

        }
        System.out.println("Game Over! Final scores are: "+getScores());
        String playAgain = input.getAnswer("Would you like to play again?"+System.lineSeparator()+"a yes"+System.lineSeparator()+"b no")+System.lineSeparator();
        if (playAgain.contains("a"))play();
        else System.out.println("Ok. Thanks for playing!");

    }

    private String getScores(){
        String scores = "";
        for (Player player : players){
            scores+=System.lineSeparator()+player.getName()+": "+player.getScore()+System.lineSeparator();
        }
        return scores;
    }

    private void endGame(){
        if (players.size()==1) {if(players.get(0).getLives() == 0) running = false; }
        else for (Player player : players){
                if (player.getScore() == POINTS_TO_WIN) running = false;
            }
    }
}
