public class Goblin extends Monster{

    public Goblin(){
	HP = origHP = 40;
	atk = origAtk = tempAtk = 20;
	def = origDef = tempDef = 6;
	evasion = tempEvasion =  origEvasion = 8;
	state = 0;
	attackName[0]="Storm of Needles"; //Attack 1
	attackName[1]="Multi Bite"; //Attack 2
	attackName[2]="Sheer Heart Attack";//Attack 3
	attackName[3]="Pin Strike";//Attack 4
	ID = 2; //For identification purposes
	name = "Goblin";
	int determinant = (int) (Math.random() * 6);
	inventory.add ( new Weapon (determinant) );
	equip ((Weapon) inventory.get(0));
    }

    public Goblin(int difficulty){
	if (difficulty == 1){
	    HP = origHP = 40;
	    atk = origAtk = tempAtk = 20;
	    def = origDef = tempDef = 6;
	    evasion = tempEvasion =  origEvasion = 8;
	}
	if (difficulty == 2){
	    HP = origHP = 60;
	    atk = origAtk = tempAtk = 22;
	    def = origDef = tempDef = 12;
	    evasion = tempEvasion =  origEvasion = 12;
	}
	if (difficulty == 3){
	    HP = origHP = 80;
	    atk = origAtk = tempAtk = 24;
	    def = origDef = tempDef = 18;
	    evasion = tempEvasion =  origEvasion = 16;
	}
	name = "Goblin";
	state = 0;
	attackName[0]="Storm of Needles"; //Attack 1
	attackName[1]="Multi Bite"; //Attack 2
	attackName[2]="Sheer Heart Attack";//Attack 3
	attackName[3]="Pin Strike";//Attack 4
	ID = 2; //For identification purposes
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
        return damage;
    }
}
