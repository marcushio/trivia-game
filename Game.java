
/**
 * Class responsible for holding all objects related to game and calling their methods.
 * @author Marcus Trujillo and Colton Trujillo
 * @version 7.7.18
 */
import java.util.*; 

public class Game
{
    //String Constants

    boolean running;
    Input input = new Input(); 
    int POINTS_TO_WIN = 3;
    int STARTING_LIVES = 3;
    Player player;
    int numPlayers; 
    ArrayList<Player> players = new ArrayList<Player>(); 
    ArrayList<Question> questions;
    QuestionSet questionSet;
    QuestionFactory factory = new HardCodeQuestionFactory();

    private void initialize(){
        questionSet = factory.getQuestionSet();
        input.printWelcome(); 
        running = true; 
        running = true; 
        players = new ArrayList <Player>();
        numPlayers = input.getNumPlayers(); 
        if (numPlayers>1) POINTS_TO_WIN = input.getPointsToWin();
    }

    public void play(){
        initialize();
        for(int i = 0; i < numPlayers; i++){

            String currentPlayerName = input.getName(i+1); 
            player = new Player(currentPlayerName); 
            players.add(player); 
        } 

        while(running){
            try{
                for(Player player : players){

                    Question currentQuestion = questionSet.getQuestion(); 
                    if(currentQuestion.hasAnswer(input.getAnswer(player.getName()+", "+currentQuestion.toString()))){
                        player.addPoints(1); 
                        input.printCorrect(player.getName(),player.getScore());
                    } else {
                        player.loseLife(); 
                        input.printWrong(player.getName(),player.getLives());

                    }
                    endGame();
                }

            }
            catch(Exception ex){
                input.printOutOfQuestions();
                running = false;
            }

        }
        input.printGameOver();
        input.printResult(getResult());
        input.printScores(getScores());
        String playAgain = input.getAnswer("Would you like to play again?"+System.lineSeparator()+"a yes"+System.lineSeparator()+"b no")+System.lineSeparator();
        if (playAgain.contains("a")){
            this.play();
        }
        else input.printQuitMessage();

    }

    private String getScores(){
        String scores = "";
        for (Player player : players){
            scores+=System.lineSeparator()+player.getName()+": "+player.getScore()+System.lineSeparator();
        }
        return scores;
    }

    private String getResult(){
        String result = "Tie";
        int numWinners = 0;
        int highScore = players.get(0).getScore();
        for(Player player : players){
            if (player.getScore()>=highScore) {
                numWinners++;
                result = player.getName()+" won!";
            }
        }
        if (numWinners>1) result = "tie";
        return result;
    }

    private void endGame(){
        if (players.size()==1) {
            if(players.get(0).getLives() == 0) {
                running = false; 
                input.printDeath();
            }
        }
        else for (Player player : players){
                if (player.getScore() == POINTS_TO_WIN) 
                {running = false;
       
            }
            }
    }
}
