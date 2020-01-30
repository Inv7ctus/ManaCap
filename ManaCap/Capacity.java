
/**
 * Write a description of class Capacity here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Capacity
{
    private int manaCap;
    private int currentMana;
    private int rank;
    private int restCounter;
    public Capacity(int mana)
    {
        manaCap=mana;
        if(this.manaCap<60)
        {this.rank=20;}
        else if(this.manaCap<360)
        {this.rank=40;}
        else if(this.manaCap<2160)
        {this.rank=80;}
        else if(this.manaCap<12960)
        {this.rank=160;}
        else if(this.manaCap<77760)
        {this.rank=320;}
        restCounter=0;
        currentMana=mana;
    }
    public void draw(int draw)
    {
        
    }
    public void add(int add)
    {
    }
    
}
