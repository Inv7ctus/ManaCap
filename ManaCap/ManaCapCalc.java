import java.util.Scanner;
import java.util.ArrayList; 
/**
 * Write a description of class ManaCapCalc here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ManaCapCalc
{
    private int expend;
    private int manaCap;
    private int currentMana;
    private int rank;
    private int restCounter;

    /**
     * Creates a mana capacity object to store relevant values
     */
    public ManaCapCalc()
    {
        expend=0;
        manaCap=0;
        rank=0;
        currentMana=0;
        restCounter=0;
    }
    /**
     * This method initiates the calc process
     */
    public static void newCalc()
    {
        ManaCapCalc newManaCap = new ManaCapCalc();
        newManaCap.calc();
    }
    
    public void calc()
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter starting Capacity: ");
        this.manaCap=s.nextInt();
        currentMana=manaCap;
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
        /*
         * Loop:
         *  input amount spent
         *  incrment expenditures
         *  display current value
         *  sentinel value input
         *      calc new cap
         *      display new cap, reset expend.
         */
        boolean rest =false;
        int increase=0;
        ArrayList<Integer> expenditures = new ArrayList(rank/2); 
        ArrayList<Integer> overExpend = new ArrayList(rank/4);
        while(!rest)
        {
            System.out.print("Enter amount spent, or 0 for a rest: ");
            int valSpent = s.nextInt();
            String a="";
            if(this.expend<=rank/2)
            {
                expenditures.add(valSpent);
            }
            else if(this.expend>=rank/2)
            {
                overExpend.add(valSpent);
            }
            if(valSpent==0)
            {
                System.out.print("Enter 'srest' for short or 'rest' for long: ");
                a=s.next();
            }
            if(a.equals("rest"))
            {
                rest=true;
                int x =0;
                while(x<=expend && x<=rank/2)
                {  
                    int i = (rank-(x*2));
                    if(i ==0){i=1;}
                    increase+=(expenditures.get(x)/i);
                    if(!(expenditures.get(x)==0) && (expenditures.get(x)/(i)==0))
                    { increase+=1;}
                    x++;
                }
                int y =0;
                while(x<=expend&&x>=rank/2)
                {
                    if(y==0) {System.out.println("You have overexpended");y++;}
                    int i = (rank-(x*2));
                    int decrease=(overExpend.get(x-rank/2-1)*(i/2));
                    increase+= decrease;
                    if(!(overExpend.get(x-rank/2-1)==0) && (overExpend.get(x-rank/2-1)/(i)==0))
                    { increase+=-1;}
                    x++;
                }
               
                this.manaCap += increase;
                if(this.currentMana<0)
                {
                    this.manaCap +=this.currentMana;
                    System.out.println("Mana Scarring: " +this.currentMana); 
                }
                System.out.println("Increase: " + increase);
                System.out.println("New capacity: " + this.manaCap);
                this.currentMana=this.manaCap;
                System.out.println("Current Mana: " + this.currentMana);
                increase=0;
                this.restCounter=0;
                this.expend=0;
                expenditures.clear();
                System.out.print("Would you like to continue y/n: ");
                String q =s.next();
                if(q.equals("y"))
                {rest=false;}
                else if(q.equals("n"))
                {rest=true;}
            }
            else if(a.equals("srest"))
            {
                int x =0;
                while(x<=expend && x<=rank/2)
                {  
                    int i = (rank-(x*2));
                    if(i ==0){i=1;}
                    increase+=(expenditures.get(x)/i);
                    if(!(expenditures.get(x)==0) && (expenditures.get(x)/i)==0)
                    { increase+=1;}
                    x++;
                }
                int y = 0;
                while(x<=expend&&x>=rank/2)
                {
                    
                    if(y==0) {System.out.println("You have overexpended"); y++;}
                    int i = (rank-(x*2));
                    increase+=(overExpend.get(x-rank/2-1)*(i/2));
                    if(!(overExpend.get(x-rank/2-1)==0) && (overExpend.get(x-rank/2-1)/(i)==0))
                    { increase+=-1;}
                    x++;
                }
                this.manaCap += increase;
                if(this.currentMana<0)
                {
                    this.manaCap +=this.currentMana;
                    System.out.println("Mana Scarring: " +this.currentMana); 
                }
                System.out.println("Increase: " + increase);
                System.out.println("New capacity: " + this.manaCap);
                this.currentMana = this.currentMana+(this.manaCap/(2+restCounter));
                System.out.println("Current Mana: " + this.currentMana);
                this.restCounter++;
                expenditures.clear();
                increase=0;
                this.expend=0;
            }
            else
            {   
                currentMana-=valSpent;
                if(!(valSpent==0)){this.expend++;}
                valSpent=0;
                System.out.println("Current mana: " + currentMana);
                System.out.println("Spells remaining: " + (rank/2-expend));
            }
        }
        
        
    }
   
}
