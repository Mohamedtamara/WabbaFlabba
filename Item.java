public class Item extends Equipment {
    private int healthBoost = 0;
    private int attackBoost = 0;
    private int defenseBoost = 0;
    private int evasionBoost = 0;
    private int cure = 0;
    private int numTurns = 0;
    private String info = "";

   
    public int getHealthBoost() {return healthBoost;}
    public  int getAttackBoost() {return attackBoost;}
    public int getDefenseBoost() {return defenseBoost;}
    public  int getEvasionBoost() {return evasionBoost;}
    public int getCure() {return cure;}
    public  int getNumTurns() {return numTurns;}

    public Item() {
         name = "Potion";
         healthBoost = 100;
	 info = "Raises HP by 100.";
    }

    public Item (int type) {
	if (type == 1) {
	    name = "Red Bull";
	    healthBoost = 200;
	    attackBoost = 15;
	    defenseBoost = 10;
	    evasionBoost = 10;
	    numTurns = 3;
	    info = "Increases health. Also boosts  attack, defense, and evasion for three turns.";
	}
	else if (type == 2) {
	    name = "Ambrosia";
	    cure = 1;
	    info = "Cures paralysis";
	}
	else if (type == 3) {
	    name = "RadaAway";
	    cure = 2;
	    info = "Cures poison";
	}
	else if (type == 4) {
	    name = "Buffout";
	    attackBoost = 65;
	    info = "Increases strength tremendously for 2 turns.";
	    numTurns = 2;
	}
	else if (type == 5) {
	    name = "Senzu Bean";
	    healthBoost = 200;
	    attackBoost = 50;
	    evasionBoost = 10;
	    info = " Increases health and provides a temporary boost in strength for 5 turns.";
	}
	else if (type == 6) {
	    name = "Med-X";
	    defenseBoost = 35;
	}
	else {
	    System.out.println ("NO, that is not an item.");
	}
    }
	    

    }
    
	
	    
    
	
	
