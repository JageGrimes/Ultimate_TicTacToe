public class Cell
{
    private Player mark;

    public Cell()
    {
        mark = new Player(); // initalize an empty player (no name/char)
    }

    // redundant/not used
    public boolean isEmpty()
    {
        return mark.getSymbol() == ' ';
    }

    public void setMark(Player p)
    {
        mark = p;
    }

    public Player getMark() 
    {
        return mark;
    }
}