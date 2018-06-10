import java.util.Scanner;
/**
 * Author: Colton Trujillo
 */
public class Input
{
    String WELCOME = "--== Welcome to Trivia!!! ==--" + System.lineSeparator() + "Answer questions correctly to rack up the points!";
    String NUM_PLAYERS_PROMPT = "";
    String ANSWER_FORMAT = "a|b|c";
    Scanner userInput;
    public Input(){
        try{
            userInput = new Scanner(System.in);
        }
        catch(Exception ex){

        }
    }

    public String getAnswer(String question){
        try{
            System.out.println(question+System.lineSeparator()+"Enter your selection from the options above.");
            return userInput.next(ANSWER_FORMAT).trim();
        }
        catch(Exception ex){
            userInput.next();
            return getAnswer("Invalid input.");
        }
    }

    public String getName(int playerNumber){
        try{
            System.out.print("Aight player "+playerNumber+", "); 
            System.out.println("What is your name player?"); 
            return userInput.next();
        }
        catch(Exception ex){

            return getName(playerNumber);
        }
    }

    public int getNumPlayers(){
        try{
            System.out.println("How many players are playing player?"); 
            return userInput.nextInt(); 
        } catch(Exception ex){
            userInput.next();
            return getNumPlayers(); 
        }
    }

    public void printWelcome(){
        System.out.println(WELCOME); 
    }

    public void close(){
        userInput.close();
    }

    public void printCorrect(String name,int score){
        System.out.println("Correct! "+name+"'s score is now: "+score);   
    }

    public void printWrong(String name, int lives){
        System.out.println("Wrong! "+name+ " just lost a life and has "+lives+" left."); 
    }

    public void printOutOfQuestions (){
        System.out.println("Out of questions...");
    }

    public void printGameOver(){
        System.out.println("Game Over!");
    }

    public void printScores(String scores){
        System.out.println("Final scores are: "+scores);
    }

    public void printQuitMessage(){
        System.out.println("Ok. Thanks for playing!");
    }

    public void printResult(String result){
        System.out.println(result);
    }

    public void printTie(){
        System.out.println("Tie game!");
    }

    public void printDeath(){
        System.out.println("You lost all your lives and are DEAD.");   
    }

    public int getPointsToWin(){
        System.out.println("How many points would you like to play to?");
        try{
        return userInput.nextInt();
    }
    catch(Exception ex){
        System.out.println("Invalid input. Please enter a number.");
        return getPointsToWin();
    }
    }
}

