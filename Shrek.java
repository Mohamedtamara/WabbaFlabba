public class Shrek extends Monster{

    public Shrek(){
	HP = origHP = 120;
	atk = origAtk = tempAtk = 25;
	def = origDef = tempDef = 10;
	evasion = tempEvasion =  origEvasion = 16;
	state = 0;
	attackName[0]="Layers of Onions"; //Attack 1
	attackName[1]="The Fibonacchi Sequence"; //Attack 2
	attackName[2]="DON KAY";//Attack 3
	attackName[3]="Shrek Super-Slam";//Attack 4
	ID = 5; //For identification purposes
	name = "Shrek";
	int determinant = (int) (Math.random() * 6);
	inventory.add ( new Weapon (determinant) );
	equip ((Weapon) inventory.get(0));
    }

    public Shrek(int difficulty){
	if (difficulty == 1){
	    HP = origHP = 120;
	    atk = origAtk = tempAtk = 25;
	    def = origDef = tempDef = 10;
	    evasion = tempEvasion =  origEvasion = 16;
	}
	if (difficulty == 2){
	    HP = origHP = 240;
	    atk = origAtk = tempAtk = 36;
	    def = origDef = tempDef = 20;
	    evasion = tempEvasion =  origEvasion = 32;
	}
	if (difficulty == 3){
	    HP = origHP = 360;
	    atk = origAtk = tempAtk = 42;
	    def = origDef = tempDef = 20;
	    evasion = tempEvasion =  origEvasion = 48;
	}
	name = "Shrek";

	state = 0;
	attackName[0]="Layers of Onions"; //Attack 1
	attackName[1]="The Fibonacchi Sequence"; //Attack 2
	attackName[2]="DON KAY";//Attack 3
	attackName[3]="Shrek Super-Slam";//Attack 4
	ID = 5; //For identification purposes
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
	w.paralyzed();
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
        return damage;
    }
    
}
