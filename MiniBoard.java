public class MiniBoard
{
    public Cell[][] cells;
    public String position;
    public Player winner;

    /*
     * place the current player's character(X or O) at the position (row, col)
    */
    public boolean makeMove(int row, int col, Player p)
    {
        return false;
    }

    /*
     * check all squares if there is a winner or a tie in the 3x3 small board
    */
    public Player checkWinner()
    {
        return null;
    }
}