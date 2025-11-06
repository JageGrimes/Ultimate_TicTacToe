public class Player 
{
    private String name; // (computer or human)
    private char symbol; // (X or O)

    public Player()
    {
        name = "empty";
        symbol = ' ';
    }
    public Player(String nick, char let)
    {
        setName(nick);
        setSymbol(let);
    }

    public void setName(String nick)
    {
        name = nick;
    }

    public void setSymbol(char let)
    {
        symbol = let;
    }

    public String getName()
    {
        return name;
    }

    public char getSymbol()
    {
        return symbol;
    }
}
