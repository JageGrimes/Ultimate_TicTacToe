import java.util.Scanner;

public class GameController
{
    private UltimateBoard board;
    private Player currentPlayer;
    private Player one, two;

    public GameController()
    {

    }
    public static void main(String[] args)
    {
        GameController remote = new GameController();
        Scanner kb = new Scanner(System.in);
        
        remote.startGame(kb);
    }

    /*
     * ...
     */
    public void startGame(Scanner kb)
    {
        System.out.print("What is player one's name :: ");
        String nameOne = kb.next();

        System.out.print("What is player two's name :: ");
        String nameTwo = kb.next();

        one = new Player(nameOne, 'X');
        two = new Player(nameTwo, 'O');

        board = new UltimateBoard();

        System.out.println(one.getName() + "'s turn!");
        int bigCol, bigRow, smallCol, smallRow;
        boolean isValid = false;

        do
        {
            System.out.println("where would you like to go on the Big Board");
            System.out.print("(col row)(0-2)(EX: 2 1) Seperate by space:: ");
            bigCol = kb.nextInt();
            bigRow = kb.nextInt();
            isValid = board.isValid(bigRow, bigCol);
            if(!isValid)
            {
                System.out.println("Something is wrong with that input, try again");
            }
        }while(!isValid);

        do
        {
            System.out.println("where would you like to go on the Mini Board");
            System.out.print("(col row)(0-2)(EX: 2 1) :: ");
            smallCol = kb.nextInt();
            smallRow = kb.nextInt();
            isValid = smallCol < 3 && smallCol >= 0 && smallRow < 3 && smallRow >= 0;
            if(!isValid)
            {
                System.out.println("Something is wrong with that input, try again");
            }
        }while(!isValid);

        board.makeMove(bigRow, bigCol, smallRow, smallCol, currentPlayer);
        switchPlayer(one, two);

        kb.close();
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
    public void playTurn(Scanner kb)
    {
        
    }

    /*
     * check if a player has won or is a draw (if game is over, dont store how)
    */
    public boolean isGameOver()
    {
        return board.checkWinner().getSymbol() == ' ';
    }
}