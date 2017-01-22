public class Shrek extends Monster{

    /*
      The king of the swamps. He's one of the most 
      feared creatures out there. He's also one of
      the most popular, gaining 5 of his own movies
      for whatever reason. 
    */

    //default constructor
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
	EXP = 20;
	level = 1;
	neededEXP = 100;
	int determinant = (int) (Math.random() * 6);
	inventory.add ( new Weapon (determinant) );
	equip ((Weapon) inventory.get(0));
    }

    //overriden constructor with difficulty
    public Shrek(int difficulty){
	if (difficulty == 1){
	    HP = origHP = 120;
	    atk = origAtk = tempAtk = 25;
	    def = origDef = tempDef = 10;
	    evasion = tempEvasion =  origEvasion = 16;
	    EXP = 20;
	    level = 1;
	}
	if (difficulty == 2){
	    HP = origHP = 240;
	    atk = origAtk = tempAtk = 36;
	    def = origDef = tempDef = 20;
	    evasion = tempEvasion =  origEvasion = 32;
	    EXP = 40;
	    level = 2;
	}
	if (difficulty == 3){
	    HP = origHP = 360;
	    atk = origAtk = tempAtk = 42;
	    def = origDef = tempDef = 20;
	    evasion = tempEvasion =  origEvasion = 48;
	    EXP = 80;
	    level = 3;
	}
	name = "Shrek";
	state = 0;
	attackName[0]="Layers of Onions"; //Attack 1
	attackName[1]="The Fibonacchi Sequence"; //Attack 2
	attackName[2]="DON KAY";//Attack 3
	attackName[3]="Shrek Super-Slam";//Attack 4
	ID = 5; //For identification purposes
	neededEXP = 100;
	int determinant = (int) (Math.random() * 6);
	inventory.add ( new Weapon (determinant) );
	equip ((Weapon) inventory.get(0));
    }

    //Layers of Onions
    public int attack1(Character w){
	int damage = (int)(atk - (0.5 * w.getTempDefense()));
	if (damage <= 0){
	    damage = 0;
	}
	w.lowerHP(damage);
        return damage;
    }

    //The Fibonacchi Sequence
    public int attack2(Character w){
	int damage = (int)(atk + w.getAttack());
	if (damage <= 0){
	    damage = 0;
	}
	w.lowerHP(damage);
	paralyze(w);
        return damage;
    }

    //DON KAY
    public int attack3(Character w){
	int damage = (int)(atk + w.getTempDefense());
	if (damage <= 0){
	    damage = 0;
	}
	w.lowerHP(damage);
        return damage;
    }

    //Shrek Super-Slam
    public int attack4(Character w){
	int damage = (int)(atk + (2 * w.getTempDefense()));
	if (damage <= 0){
	    damage = 0;
	}
	w.lowerHP(damage);
        return damage;
    }
    
}
