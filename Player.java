
/**
 * @author Marcus Trujillo
 * Represents the player of the trivia game. Starts with a particular number of lives and has a score. 
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
    
    /**
     * @return score
     */
    public int getScore(){
        return score; 
    }
    
    /**
     * @return lives
     */
    public int getLives(){
        return lives; 
    }
    
    /**
     * @return name
     */
    public String getName(){
        return name; 
    }
    
    /**
     * adds to the players point total.
     */
    public void addPoints(int points){
        score += points; 
    }
    
    /**
     * removes one of the players lives
     */
    public void loseLife(){
        lives -= 1; 
    }   
}
