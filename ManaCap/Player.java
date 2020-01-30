
/**
 * This class represents a player, Who can have 1 or more capacities.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    private int numCap;
    private Capacity a;
    private Capacity b;
    private Capacity c;
    public Player(int mana)
    {        
            this.a = new Capacity(mana);
    }
    public Player(int mana, int mana2)
    {        
           this.a = new Capacity(mana);
           this.b = new Capacity(mana2);
    }
    public Player(int mana, int mana2, int mana3)
    {        
            this.a = new Capacity(mana);
            this.b = new Capacity(mana2);
            this.c = new Capacity(mana3);
    }
    public void rest()
    {
    }
}
