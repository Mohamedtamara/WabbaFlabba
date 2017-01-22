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
	    attackBoost = 15;
	    defenseBoost = 10;
	    evasionBoost = 10;
	    stats = "\t" + this.name + "Increases health. Also boosts  attack, defense, and evasion for three turns.";
	}
	else if (type == 1) {
	    name = "Ambrosia";
	    cure = 1;
	    stats = "\t" + this.name + "Cures paralysis";
	}
	else if (type == 2) {
	    name = "RadaAway";
	    cure = 2;
	    stats = "\t" + this.name + "Cures poison";
	}
	else if (type == 3) {
	    name = "Buffout";
	    attackBoost = 65;
	    stats = "\t" + this.name + "Increases strength tremendously.";
	}
	else if (type == 4) {
	    name = "Senzu Bean";
	    healthBoost = 200;
	    attackBoost = 50;
	    evasionBoost = 10;
	    stats= "\t" + this.name + "Increases health and strength.";
	}
	else if (type == 5) {
	    name = "Med-X";
	    defenseBoost = 35;
	    stats= "\t" + this.name + "Raises defense";
	}
	else {
	    System.out.println ("NO, that is not an item.");
	}
    }
	    

    }
    
	
	    
    
	
	
