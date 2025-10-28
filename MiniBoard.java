import java.util.ArrayList;

public class MiniBoard 
{
    Cell[][] cells;
    Player winner;

    public MiniBoard()
    {
        cells = new Cell[3][3];

        winner = new Player("empty", ' ');
        
        for(int i = 0; i < 9; i++)
        {
            cells[i/3][i%3] = new Cell();
        }
    }

    public boolean makeMove(int row, int col, Player p)
    {
        if(cells[row][col].getMark().getSymbol() == ' ')
        {
            cells[row][col].setMark(p); // change the player object at row/col to player object p
            return true;
        }
        return false;
    }

    public Player checkWinner()
    {
        return winner;
    }

    /*
     * recursion:
     * check cell : empty = false ; !empty = go to next board (i - 1)
     */
    public boolean isFull(int i)
    {
        if(i == -1)
        {
            return true;
        }

        return cells[i/3][i%3].getMark().getSymbol() == ' ' ? false : isFull(i - 1);
    }

    /*
     * loop through all cells, add all "cordinates" of empty spaces
     */
    public ArrayList<String> getAvailableMoves()
    {
        ArrayList<String> moves = new ArrayList();

        for(int i = 0; i < 9; i++)
        {
            if(cells[i/3][i%3].getMark().getSymbol() == ' ')
            {
                moves.add(i/3 + " " + i%3);
            }
        }

        return moves;
    }
}
