/* a subclass of equipment that provides permanent 
attribute boosts to a character
*/
public class Item extends Equipment {

    private int healthBoost = 0;
    private int attackBoost = 0;
    private int evasionBoost = 0;
    private int defenseBoost = 0;
    private int cure = 0;
   
    public int getHealthBoost() {return healthBoost;}
    public  int getAttackBoost() {return attackBoost;}
    public int getDefenseBoost() {return defenseBoost;}
    public  int getEvasionBoost() {return evasionBoost;}
    public int getCure() {return cure;}

    public Item() {
         name = " Potion";
         healthBoost = 100;
    }

    public Item (int type) {
	if (type == 0) {
	    name = "Red Bull";
	    healthBoost = 100;
	    attackBoost = 5;
	    defenseBoost = 5;
	    evasionBoost = 5;
	    stats = getName() + "\t" + "Increases health. Also boosts  attack, defense, and evasion.";
	}
	else if (type == 1) {
	    name = "Ambrosia";
	    healthBoost += (int) ( 50 + (Math.random() * 10));
	    cure = 1;
	    stats = getName() + "\t" + "Cures paralysis";
	}
	else if (type == 2) {
	    name = "RadaAway";
	    cure = 2;
	    stats = getName() + "\t"  + "Cures poison";
	}
	else if (type == 3) {
	    name = "Buffout";
	    attackBoost = (int) ( 15 + (Math.random() * 15));
	    stats = getName() + "\t" + "Increases strength tremendously.";
	}
	else if (type == 4) {
	    name = "Senzu Bean";
	    healthBoost = (int) ( 200 + (Math.random() * 100));
	    attackBoost = (int) ( 10 + (Math.random() * 10));
	    evasionBoost = (int) ( 5 + (Math.random() * 10));
	    stats= getName() + "\t"  + "Increases health and strength.";
	}
	else if (type == 5) {
	    name = "Med-X";
	    defenseBoost = (int) ( 10 + (Math.random() * 10));
	    stats= getName() + "\t"  + "Raises defense";
	}
	else {
	    System.out.println ("NO, that is not an item.");
	}
    }
	    

    }
    
	
	    
    
	
	
