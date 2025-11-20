import java.util.Scanner;

public class GameController
{
    private UltimateBoard board;
    private Player currentPlayer;
    private Player one, two;

    public GameController() {   } // help calling outside static main
    public static void main(String[] args)
    {
        GameController remote = new GameController();

        Scanner kb = new Scanner(System.in);
        
        remote.startGame(kb);

        while(!remote.isGameOver())
        {
            remote.playTurn(kb);
        }

        kb.close();

        remote.switchPlayer();

        System.out.println("Game Over");
        System.out.println("Player " + remote.currentPlayer.getName() + " Wins!");
    }

    /*
     * Ask for player one and two's names and ask where player one want sto go from big board to small board
     */
    public void startGame(Scanner kb)
    {
        System.out.print("What is player one's name :: ");
        String nameOne = kb.next(); 

        System.out.print("What is player two's name :: ");
        String nameTwo = kb.next();

        one = new Player(nameOne, 'X');
        two = new Player(nameTwo, 'O');

        currentPlayer = one;

        board = new UltimateBoard();

        System.out.println(currentPlayer.getName() + "'s turn!");
        int bigCol, bigRow, smallCol, smallRow;
        boolean isValid = false;

        board.printBoard();

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

        board.getNextBoard().printBoard();

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
        switchPlayer();
    }

    /*
     * Change the current player to next player (X -> O || O -> X)
    */
    public void switchPlayer()
    {
        currentPlayer = currentPlayer == one ? two : one;
    }

    /*
     * Play a turn (may change when computers added)
     * Ask and input where the player wants to play
    */
    public void playTurn(Scanner kb)
    {
        System.out.println("\n" + currentPlayer.getName() + "'s turn");

        // board.isValid(row of next board, col of next board)
        if(!board.isValid(Integer.parseInt(board.getNextBoard().checkWinner().getName().substring(0, 1)), Integer.parseInt(board.getNextBoard().checkWinner().getName().substring(2))))
        {
            //allow the player to go anywhere within the big board
            System.out.println("\nThe next board is full");
            int bigCol, bigRow;
            boolean isValid = false;

            board.printBoard();

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
        }

        if(true) // redundtant but seperates variables
        {   
            board.getNextBoard().printBoard();

            int smallCol, smallRow;
            boolean isValid;

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

            board.makeMove(-1, -1, smallRow, smallCol, currentPlayer); // -1 means its not changing big board
        }

        switchPlayer();
    }

    /*
     * check if a player has won or is a draw (if game is over, dont store how)
    */
    public boolean isGameOver()
    {
        // bigboard -> winner object -> see if they have a symbol representing a winner
        return !(board.checkWinner().getSymbol() == ' ');
    }
}