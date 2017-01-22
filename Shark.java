public class Shark extends Monster{

    public Shark(){
	HP = origHP = 80;
	atk = origAtk = tempAtk = 22;
	def = origDef = tempDef = 8;
	evasion = tempEvasion =  origEvasion = 5;
	state = 0;
	attackName[0]="Great White Bite"; //Attack 1
	attackName[1]="Hammerhead"; //Attack 2
	attackName[2]="A Whale of a Time";//Attack 3
	attackName[3]="Splash";//Attack 4
	ID = 4; //For identification purposes
	name = "Shark";
	int determinant = (int) (Math.random() * 6);
	inventory.add ( new Weapon (determinant) );
	equip ((Weapon) inventory.get(0));
    }

    public Shark(int difficulty){
	if (difficulty == 1){
	    HP = origHP = 80;
	    atk = origAtk = tempAtk = 22;
	    def = origDef = tempDef = 8;
	    evasion = tempEvasion =  origEvasion = 5;
	}
	if (difficulty == 2){
	    HP = origHP = 120;
	    atk = origAtk = tempAtk = 24;
	    def = origDef = tempDef = 12;
	    evasion = tempEvasion =  origEvasion = 10;
	}
	if (difficulty == 3){
	    HP = origHP = 160;
	    atk = origAtk = tempAtk = 26 ;
	    def = origDef = tempDef = 16;
	    evasion = tempEvasion =  origEvasion = 15;
	}
	name = "Shark";
	state = 0;
	attackName[0]="Great White Bite"; //Attack 1
	attackName[1]="Hammerhead"; //Attack 2
	attackName[2]="A Whale of a Time";//Attack 3
	attackName[3]="Splash";//Attack 4
	ID = 4; //For identification purposes
	int determinant = (int) (Math.random() * 6);
	inventory.add ( new Weapon (determinant) );
	equip ((Weapon) inventory.get(0));
    }

    public int attack1(Character w){
	int damage = (int)(atk - w.getTempDefense());
	if (damage <= 0){
	    damage = 0;
	}
	w.lowerHP(damage);
	w.poisoned();
        return damage;
    }

    public int attack2(Character w){
	int damage = (int)(atk + w.getAttack());
	if (damage <= 0){
	    damage = 0;
	}
	w.lowerHP(damage);
        return damage;
    }

    public int attack3(Character w){
	int damage = (int)(atk + w.getTempDefense());
	if (damage <= 0){
	    damage = 0;
	}
	w.lowerHP(damage);
        return damage;
    }

    public int attack4(Character w){
	int damage = (int)(atk + (2 * w.getTempDefense()));
	if (damage <= 0){
	    damage = 0;
	}
	w.lowerHP(damage);
	w.poisoned();
	w.paralyzed();
        return damage;
    }
    
}
