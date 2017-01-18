
public class Weapon {
    public String weaponName = "";
    private int equipAttack = 0;
    private int  equipDefense = 0;
    private int  equipEvasion = 0;

    public weapon() {
	weaponName = "Basic Sword";
	equipAttack = 10;
	equipDefense = 5;
	equipEvasion = 5;
    }

    public item (int type) {
	if (type == 1) {
	    weaponName = "a wrench";
	    equipAttack = 5;
	    equipDefense = 5;
	    equipEvasion = 15;
	}
	else if (type == 2) {
	    weaponName = "the Buster Sword";
	    equipAttack = 25;
	    equipDefense = 15;
	    equipEvasion = -10;
	}
	else if (type == 3) {
	    weaponName = "a stick";
	    equipAttack = 5;
	    equipDefense = 0;
	    equipEvasion = 20;
	}
	else if (type == 4) {
	    weaponName = "a rock";
	    equipAttack = 10;
	    equipDefense = 5;
	    equipEvasion = 10;
	}
	else if (type == 5) {
	    weaponName = "the Good Samaritan";
	    equipAttack = 25;
	    equipDefense = 0;
	    equipEvasion = 15;
	}
	else if (type = 6) {
	    weaponName = "a crowbar";
	    equipAttack = 10;
	    equipDefense = 5;
	    equipEvasion = 5;
	}
	else {
	    weapon();
	}
    }

    public String getWeaponName() {
	return this.weaponName;
    }
	
}
    
	
