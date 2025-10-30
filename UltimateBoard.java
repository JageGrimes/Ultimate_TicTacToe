import java.util.ArrayList;

public class UltimateBoard 
{
    private MiniBoard[][] boards;
    private Player winner;
    private MiniBoard nextActiveBoard;

    public UltimateBoard()
    {
        nextActiveBoard = new MiniBoard(0, 0);
        
        winner = new Player("empty", ' ');

        boards = new MiniBoard[3][3];
        for(int i = 0; i < 9; i++)
        {
            boards[i/3][i%3] = new MiniBoard(i/3, i%3);
        }
    }

    public boolean makeMove(int bigRow, int bigCol, int smallRow, int smallCol, Player p)
    {
        if(boards[bigRow][bigCol].makeMove(smallRow, smallCol, p))
        {
            nextActiveBoard = boards[smallRow][smallCol];
            return true;
        }
        return false;
    }

    public Player checkWinner()
    {
        return winner;
    }

    public boolean isValid(int bigRow, int bigCol)
    {
        if(bigRow > 3 || bigRow < 0 || bigCol > 3 || bigCol < 0)
        {
            return false;
        }
        return boards[bigRow][bigCol].checkWinner().getSymbol() == ' ';
    }

    public ArrayList<String> getValidMoves()
    {
        ArrayList<String> moves = new ArrayList<>();

        for(int i = 0; i < 9; i++)
        {
            if(boards[i/3][i%3].checkWinner().getSymbol() == ' ')
            {
                moves.add(i/3 + " " + i%3);
            }
        }

        return moves;
    }

    public void printBoard()
    {
        for(int i = 0; i < 3; i++)
        {
            System.out.print(boards[i/3][i%3].checkWinner().getSymbol());
            if(i%3 == 0)
            // ...

            if(i%3 == 0 && i != 0)
            System.out.println("_____"); // print 5 _
        }
    }
}