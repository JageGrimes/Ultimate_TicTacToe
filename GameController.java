import java.util.Scanner;

public class GameController
{
    private UltimateBoard board;
    private Player currentPlayer;

    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);

        System.out.print("What is player one's name :: ");
        String nameOne = kb.next();

        System.out.println("What is player two's name :: ");
        String nameTwo = kb.next();

        Player one = new Player(nameOne, 'X');
        Player two = new Player(nameTwo, 'O');

        /*
        startGame();

        playTurn();

        switchPlayer();
        */

    }

    /*
     * ...
     */
    public void startGame()
    {
    }

    /*
     * Change the current player to next player (X -> O || O -> X)
    */
    public void switchPlayer(Player one, Player two)
    {
        currentPlayer = currentPlayer == one ? two : one;
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