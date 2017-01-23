/* Weapons that are generated with random attributes
alveit having different base attributes. Weapons provide
increases to a character's attributes as long as they are 
equipped */
public class Weapon extends Equipment{
    private int equipAttack = 0;
    private int equipDefense = 0;
    private int equipEvasion = 0;

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
	stats = getName() + "\tAttack: "+ getEquipAttack() + "  Defense: " + getEquipDefense() + "  Evasion: " + getEquipEvasion();
    }

    // instantaites different weapons based on number
    public Weapon (int type) {
	if (type == 0) {
	    name = "a wrench";
	    equipAttack = (int) ( 5 + (Math.random() * 10)); ;
	    equipDefense = (int) ( 5 + (Math.random() * 5));
	    equipEvasion = (int) ( 15 + (Math.random() * 5));
	    stats = getName() +"\tAttack: "+ getEquipAttack() + "  Defense: " + getEquipDefense() + "  Evasion: " + getEquipEvasion();
	}
	else if (type == 1) {
	    name = "the Buster Sword";
	    equipAttack = (int) ( 30 + (Math.random() * 10));
	    equipDefense = (int) ( 20 + (Math.random() * 5));
	    equipEvasion =  (int) ( -10 - (Math.random() * 10));
	    stats = getName() +"\tAttack: "+ getEquipAttack() + "  Defense: " + getEquipDefense() + "  Evasion: " + getEquipEvasion();
	}
	else if (type == 2) {
	    name = "a stick";
	    equipAttack = (int) ( 5 + (Math.random() * 10));
	    equipDefense = (int) ( 0 + (Math.random() * 3));
	    equipEvasion = (int) ( 40+ (Math.random() * 10));
	    stats = getName() +"\tAttack: "+ getEquipAttack() + "  Defense: " + getEquipDefense() + "  Evasion: " + getEquipEvasion();
	}
	else if (type == 3) {
	    name = "a rock";
	    equipAttack = (int) ( 10 + (Math.random() * 10));
	    equipDefense = (int) ( 5 + (Math.random() * 5));
	    equipEvasion = (int) ( 20 - (Math.random() * 15));
	    stats = getName() +"\tAttack: "+ getEquipAttack() + "  Defense: " + getEquipDefense() + "  Evasion: " + getEquipEvasion();
	}
	else if (type == 4) {
	    name = "the Good Samaritan";
	    equipAttack = (int) ( 25 + (Math.random() * 10));
	    equipDefense = (int) ( 0 + (Math.random() * 5));
	    equipEvasion = (int) ( 20 + (Math.random() * 10));
	    stats = getName() +"\tAttack: "+ getEquipAttack() + "  Defense: " + getEquipDefense() + "  Evasion: " + getEquipEvasion();
	}
	else if (type == 5) {
	    name = "a crowbar";
	    equipAttack = (int) ( 10 + (Math.random() * 10));
	    equipDefense = (int) ( 5 + (Math.random() * 5));
	    equipEvasion = (int) ( 20 + (Math.random() * 5));
	    stats = getName() +"\tAttack: "+ getEquipAttack() + "  Defense: " + getEquipDefense() + "  Evasion: " + getEquipEvasion();
	}
	else {
	    System.out.println ("Wrong number");
	}
    }
	
}
    
	
