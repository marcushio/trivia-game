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
    public String getAnswer(){
     try{
         System.out.println("Enter your selection from the options above.");
         return userInput.next(ANSWER_FORMAT);
        }
     catch(Exception ex){
         userInput.next();
         return getAnswer();
        }
    }
    public void close(){
        userInput.close();
    }
}
