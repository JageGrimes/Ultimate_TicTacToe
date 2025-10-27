import java.util.ArrayList;

public class UltimateBoard 
{
    private MiniBoard[][] boards;
    private Player winner;
    private String nextActiveBoard;

    public UltimateBoard()
    {
        for(int i = 0; i < 9; i++)
        {
            boards[i/3][i%3] = new MiniBoard();
        }
    }

    public boolean makeMove(int bigRow, int bigCol, int smallRow, int smallCol, Player p)
    {
        return false;
    }

    public Player checkWinner()
    {
        return winner;
    }

    public boolean isValid(int bigRow, int bigCol)
    {
        return false;
    }

    public ArrayList<String> getValidMoves()
    {
        return null;
    }
}
