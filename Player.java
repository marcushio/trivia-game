
/**
 * @author Marcus Trujillo
 * Assignment Number: 
 * Description of program if main/ class otherwise 
 * 
 */
public class Player
{
    int score; 
    int lives; 
    String name; 
    
    public Player(String name){
        this.name = name; 
        score = 0; 
        lives = 0; 
    }
    
    private int getScore(){
        return score; 
    }
    
    private int getLives(){
        return score; 
    }
    
    private String getName(){
        return name; 
    }
    
    private void addPoints(int points){
        score += points; 
    }
    
    private void loseLife(){
        lives -= 1; 
    }
    
}
