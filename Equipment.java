/* just a holder class so that Weapon and Item 
can be part of the same class, which is vital for
the inventory */
public class Equipment {
    protected String stats;
    
    protected String name;
    
    public String getName(){
	return name;
    }

    public String getStats() {
	return stats;
    }

}
