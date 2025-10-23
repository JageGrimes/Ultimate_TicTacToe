public class Cell
{
    public Player mark;

    public boolean isEmpty()
    {
        return mark.Symbol == ' ';
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