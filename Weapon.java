public class Weapon extends Equipment{
    
    private int equipAttack = 0;
    private int  equipDefense = 0;
    private int  equipEvasion = 0;

    public int getEquipAttack() {
	return equipAttack;
    }
    
    public int getEquipDefense() {
	return equipDefense;
    }
    
    public int getEquipEvasion() {
	return equipEvasion;
    }

    public Weapon() {
	name = "Basic Sword";
	equipAttack = 10;
	equipDefense = 5;
	equipEvasion = 5;
    }

    public Weapon (int type) {
	if (type == 0) {
	    name = "a wrench";
	    equipAttack = 5;
	    equipDefense = 5;
	    equipEvasion = 15;
	}
	else if (type == 1) {
	    name = "the Buster Sword";
	    equipAttack = 25;
	    equipDefense = 15;
	    equipEvasion = -10;
	}
	else if (type == 2) {
	    name = "a stick";
	    equipAttack = 5;
	    equipDefense = 0;
	    equipEvasion = 20;
	}
	else if (type == 3) {
	    name = "a rock";
	    equipAttack = 10;
	    equipDefense = 5;
	    equipEvasion = 10;
	}
	else if (type == 4) {
	    name = "the Good Samaritan";
	    equipAttack = 25;
	    equipDefense = 0;
	    equipEvasion = 15;
	}
	else if (type == 5) {
	    name = "a crowbar";
	    equipAttack = 10;
	    equipDefense = 5;
	    equipEvasion = 5;
	}
	else {
	    System.out.println ("Wrong number");
	}
    }
	
}
    
	
