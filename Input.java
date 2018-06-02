import java.util.Scanner;
/**
 * Author: Colton Trujillo
 */
public class Input
{
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
         return userInput.next();
        }
     catch(Exception ex){
         return "";
        }
    }
    public void close(){
        userInput.close();
    }
}
