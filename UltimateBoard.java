public class UltimateBoard
{
    public MiniBoard[][] boards;
    public Player winner;
    public Position nextActiveBoard;

    public boolean makeMove(int bigRow, int bigCol, int smallRow, int smallCol, Player p)
    {
        return false;
    }

    public Player checkWinner()
    {
        return null;
    }

    public boolean isValid(int bigRow, int bigCol)
    {
        return false;
    }

    public ArrayList<Move> getValidMoves()
    {
        return false;
    }
}