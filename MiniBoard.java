import java.util.ArrayList;

public class MiniBoard 
{
    Cell[][] cells;
    Player winner;

    public MiniBoard()
    {
        for(int i = 0; i < 9; i++)
        {
            cells[i/3][i%3] = new Cell();
        }
    }

    public void makeMove(int row, int col, Player p)
    {

    }

    public Player checkWinner()
    {
        return winner;
    }

    public boolean isFull()
    {
        return true;
    }

    public ArrayList<Object /* To Be Replaced */> getAvailableMoves()
    {
        return null;
    }
}
