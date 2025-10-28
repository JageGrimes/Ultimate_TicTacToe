import java.util.ArrayList;

public class UltimateBoard 
{
    private MiniBoard[][] boards;
    private Player winner;
    private String nextActiveBoard;

    public UltimateBoard()
    {
        nextActiveBoard = "any";
        
        winner = new Player("empty", ' ');

        boards = new MiniBoard[3][3];
        for(int i = 0; i < 9; i++)
        {
            boards[i/3][i%3] = new MiniBoard();
        }
    }

    public boolean makeMove(int bigRow, int bigCol, int smallRow, int smallCol, Player p)
    {
        if(boards[bigRow][bigCol].makeMove(smallRow, smallCol, p))
        {
            nextActiveBoard = smallRow + " " + smallCol;
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
}