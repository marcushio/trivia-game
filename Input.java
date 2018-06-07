import java.util.Scanner;
/**
 * Author: Colton Trujillo
 */
public class Input
{
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

    public String getName(){
        try{
            System.out.println("What is your name player?"); 
            return userInput.next();
        }

        catch(Exception ex){
            return getName();
        }
    }

    public void close(){
        userInput.close();
    }
}
