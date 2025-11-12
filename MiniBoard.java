import java.util.ArrayList;
import java.util.Scanner;

public class MiniBoard 
{
    Cell[][] cells;
    Player winner;

    public MiniBoard(int row, int col)
    {
        cells = new Cell[3][3];

        winner = new Player(row + " " + col, ' ');
        
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
        ArrayList<String> moves = new ArrayList<>();

        for(int i = 0; i < 9; i++)
        {
            if(cells[i/3][i%3].getMark().getSymbol() == ' ')
            {
                moves.add(i/3 + " " + i%3); 
            }
        }

        return moves;
    }

    public void printBoard()
    {
        System.out.println("Small Board at " + winner.getName() + ":");
        System.out.println();
        System.out.println(getSymbol(cells[0][0]) + "|" + getSymbol(cells[0][1]) + "|" + getSymbol(cells[0][2]));
        System.out.println("-----");
        System.out.println(getSymbol(cells[1][0]) + "|" + getSymbol(cells[1][1]) + "|" + getSymbol(cells[1][2]));
        System.out.println("-----");
        System.out.println(getSymbol(cells[2][0]) + "|" + getSymbol(cells[2][1]) + "|" + getSymbol(cells[2][2]));

    }
    // helper method of printBoard
    private char getSymbol(Cell cell)
    {
        return cell.getMark().getSymbol();
    }

    public boolean isGameOver()
    {
        String multiDirection;
        String temp = "";
        String tempTwo = "";

        // add diagonals
        multiDirection = getSymbol(cells[0][0]) + "" + getSymbol(cells[1][1]) + "" + getSymbol(cells[2][2]) + " ";
        multiDirection += getSymbol(cells[2][0]) + "" + getSymbol(cells[1][1]) + "" + getSymbol(cells[0][2]) + " ";

        for(int i = 0; i < 9; i++)
        {
            temp += getSymbol(cells[i/3][i%3]);
            tempTwo += getSymbol(cells[i%3][i/3]);

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
        return false || isFull(8);
    }
}

