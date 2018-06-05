
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
        lives = 3; 
    }
    
    public int getScore(){
        return score; 
    }
    
    public int getLives(){
        return lives; 
    }
    
    public String getName(){
        return name; 
    }
    
    public void addPoints(int points){
        score += points; 
    }
    
    public void loseLife(){
        lives -= 1; 
    }
    
}
