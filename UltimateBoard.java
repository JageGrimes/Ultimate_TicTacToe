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
        System.out.println("Big Board:");
        System.out.println();
        System.out.println(getSymbol(boards[0][0]) + "|" + getSymbol(boards[0][1]) + "|" + getSymbol(boards[0][2]));
        System.out.println("-----");
        System.out.println(getSymbol(boards[1][0]) + "|" + getSymbol(boards[1][1]) + "|" + getSymbol(boards[1][2]));
        System.out.println("-----");
        System.out.println(getSymbol(boards[2][0]) + "|" + getSymbol(boards[2][1]) + "|" + getSymbol(boards[2][2]));

    }
    // helper method of printBoard
    private String getSymbol(MiniBoard smallBoard)
    {
        return smallBoard.checkWinner().getSymbol() + "";
    }
}