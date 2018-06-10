
/**
 * Class responsible for holding all objects related to game and calling their methods.
 * @author Marcus Trujillo and Colton Trujillo
 * @version 7.7.18
 */
import java.util.*; 

public class Game
{
    boolean running;
    Input input = new Input(); 
    final int POINTS_TO_WIN = 3;
    final int STARTING_LIVES = 3;
    Player player;
    int numPlayers; 
    ArrayList<Player> players = new ArrayList<Player>(); 
    ArrayList<Question> questions;
    QuestionSet questionSet;
    QuestionFactory factory = new QuestionFactory();

    private void printWelcome(){
        System.out.println("--== Welcome to Trivia!!! ==--" + System.lineSeparator() + 
                            "Answer questions correctly to rack up the points!"); 
    }
    private void initialize(){
        questionSet = factory.getQuestionSet();
        printWelcome(); 
        running = true; 
        running = true; 
        players = new ArrayList <Player>();
        numPlayers = Integer.parseInt(input.getNumPlayers()); 
    }
    public void play(){
        initialize();
        for(int i = 0; i < numPlayers; i++){
            System.out.print("Aight player" + Integer.toString(i+1) + " "); 
            String currentPlayerName = input.getName(); 
            player = new Player(currentPlayerName); 
            players.add(player); 
        } 

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
        if (playAgain.contains("a")){
            this.play();
        }
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
