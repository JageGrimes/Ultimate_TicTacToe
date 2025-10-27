import java.util.Scanner;

public class GameController
{
    private UltimateBoard board;
    private Player currentPlayer;

    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        
    }

    /*
     * ...
     */
    public void startGame()
    {
        board = new UltimateBoard();
    }

    /*
     * Change the current player to next player (X -> O || O -> X)
    */
    public void switchPlayer()
    {
        if (currentPlayer.getSymbol() == 'X')
        {
            currentPlayer.setSymbol('O');
        }
        else
        {
            currentPlayer.setSymbol('X');
        }
    }

    /*
     * Play a turn (may change when computers added)
     * Ask and input where the player wants to play
    */
    public void playTurn()
    {

    }

    /*
     * check if a player has won or is a draw
    */
    public boolean isGameOver()
    {
        return false;
    }
}