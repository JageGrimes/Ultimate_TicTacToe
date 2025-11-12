import java.util.ArrayList;
import java.util.Scanner;

public class UltimateBoard 
{
    private MiniBoard[][] boards;
    private Player winner;
    private MiniBoard nextActiveBoard;

    public UltimateBoard()
    {
        nextActiveBoard = null;
        
        winner = new Player("empty", ' ');

        boards = new MiniBoard[3][3];
        for(int i = 0; i < 9; i++)
        {
            boards[i/3][i%3] = new MiniBoard(i/3, i%3);
        }
    }

    public boolean makeMove(int bigRow, int bigCol, int smallRow, int smallCol, Player p)
    {
        nextActiveBoard.makeMove(smallRow, smallCol, p);

        nextActiveBoard = boards[smallRow][smallCol];

        isGameOver();

        return true;
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
        if(!boards[bigRow][bigCol].isGameOver())
        {
            nextActiveBoard = boards[bigRow][bigCol];
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

    public MiniBoard getNextBoard()
    {
        return nextActiveBoard;
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
    // helper method
    private char getSymbol(MiniBoard smallBoard)
    {
        return smallBoard.checkWinner().getSymbol();
    }

    public boolean isGameOver()
    {
        String multiDirection;
        String temp = "";
        String tempTwo = "";

        // add diagonals
        multiDirection = getSymbol(boards[0][0]) + "" + getSymbol(boards[1][1]) + "" + getSymbol(boards[2][2]) + " ";
        multiDirection += getSymbol(boards[2][0]) + "" + getSymbol(boards[1][1]) + "" + getSymbol(boards[0][2]) + " ";

        for(int i = 0; i < 9; i++)
        {
            temp += getSymbol(boards[i/3][i%3]);
            tempTwo += getSymbol(boards[i%3][i/3]);

            if(i%3 == 0 && i != 0)
            {
                multiDirection = temp + " " + tempTwo + " " + multiDirection;
                temp = "";
                tempTwo = "";
            }
        }

        Scanner chop = new Scanner(multiDirection);

        while(chop.hasNext())
        {
            String holder = chop.next();

            if(holder.equals("XXX"))
            {
                winner.setSymbol('X');
            }else if (holder.equals("OOO")) 
            {
                winner.setSymbol('O');
            }else
            {
                continue;
            }
            chop.close();
            return true;
        }

        chop.close();

        return false;
    }
}