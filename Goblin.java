public class Goblin extends Monster{

    /*
      Not as cool as the ones from Harry Potter,
      but still as grumpy. They're small, but 
      deadly, and are rampant. You shouldn't get
      too close, they're easier to beat from
      afar. 
    */

    //default constructor
    public Goblin(){
	HP = origHP = 100;
	atk = origAtk = tempAtk = 20;
	def = origDef = tempDef = 6;
	evasion = tempEvasion =  origEvasion = 20;
	state = 0;
	attackName[0]="Storm of Needles"; //Attack 1
	attackName[1]="Multi Bite"; //Attack 2
	attackName[2]="Sheer Heart Attack";//Attack 3
	attackName[3]="Pin Strike";//Attack 4
	ID = 2; //For identification purposes
	name = "Goblin";
	EXP = 15;
	level = 1;
	neededEXP = 100;
	int determinant = (int) (Math.random() * 6);
	inventory.add ( new Weapon (determinant) );
	equip ((Weapon) inventory.get(0));
    }

    //overriden constructor with difficulty
    public Goblin(int difficulty){
	if (difficulty == 1){
	    HP = origHP = 80;
	    atk = origAtk = tempAtk = 20;
	    def = origDef = tempDef = 6;
	    evasion = tempEvasion =  origEvasion = 8;
	    EXP = 15;
	    level = 1;
	}
	if (difficulty == 2){
	    HP = origHP = 95;
	    atk = origAtk = tempAtk = 22;
	    def = origDef = tempDef = 12;
	    evasion = tempEvasion =  origEvasion = 12;
	    EXP = 30;
	    level = 2;
	}
	if (difficulty == 3){
	    HP = origHP = 120;
	    atk = origAtk = tempAtk = 24;
	    def = origDef = tempDef = 18;
	    evasion = tempEvasion =  origEvasion = 16;
	    EXP = 45;
	    level = 3;
	}
	name = "Goblin";
	state = 0;
	attackName[0]="Storm of Needles"; //Attack 1
	attackName[1]="Multi Bite"; //Attack 2
	attackName[2]="Sheer Heart Attack";//Attack 3
	attackName[3]="Pin Strike";//Attack 4
	ID = 2; //For identification purposes
	neededEXP = 100;
	int determinant = (int) (Math.random() * 6);
	inventory.add ( new Weapon (determinant) );
	equip ((Weapon) inventory.get(0));
    }

    //Storm of Needles
    public int attack1(Character w){
	int damage = (int)(atk - (1.5* w.getTempDefense()) - 5);
	if (damage <= 0){
	    damage = 0;
	}
	w.lowerHP(damage);
        return damage;
    }

    //Multi Bite
    public int attack2(Character w){
	int damage = (int)(atk + w.getAttack());
	if (damage <= 0){
	    damage = 0;
	}
	w.lowerHP(damage);
        return damage;
    }

    //Sheer Heart Attack
    public int attack3(Character w){
	int damage = (int)(atk +  w.getTempDefense());
	if (damage <= 0){
	    damage = 0;
	}
	w.lowerHP(damage);
        return damage;
    }

    //Pin Strike
    public int attack4(Character w){
	int damage = (int)(atk + (0.5 * w.getTempDefense()));
	if (damage <= 0){
	    damage = 0;
	}
	w.lowerHP(damage);
	poison(w);
        return damage;
    }
}

