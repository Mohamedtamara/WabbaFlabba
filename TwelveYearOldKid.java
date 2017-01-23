public class TwelveYearOldKid extends Monster{

    /*
      The Deadliest enemy you'll ever face on
      your encounters. If you meet this enemy,
      it's better just to run. If you battle, 
      you'll be rewarded enormously. Be careful,
      the 360 no-scopes don't stop. Insults only
      power him up.
    */

    //default constructor
    public TwelveYearOldKid(){
	HP = origHP = 420;
	atk = origAtk = tempAtk = 20;
	def = origDef = tempDef = 20;
	evasion = tempEvasion =  origEvasion = 20;
	state = 0;
	attackName[0]="NO SCOPED"; //Attack 1
	attackName[1]="Doritos & Mountain Dew"; //Attack 2
	attackName[2]="Microphone Screech";//Attack 3
	attackName[3]="420 BLAZE IT";//Attack 4
	ID = 3; //For identification purposes
	name = "Twelve Year Old Kid";
	EXP = 25;
	level = 1;
	neededEXP = 100;
	int determinant = (int) (Math.random() * 6);
	inventory.add ( new Weapon (determinant) );
	equip ((Weapon) inventory.get(0));
    }

    //overriden constructor with difficulty
    public TwelveYearOldKid(int difficulty){
	if (difficulty == 1){
	    HP = origHP = 300;
	    atk = origAtk = tempAtk = 15;
	    def = origDef = tempDef = 5;
	    evasion = tempEvasion =  origEvasion = 15;
	    EXP = 30;
	    level = 1;
	}
	if (difficulty == 2){
	    HP = origHP = 350;
	    atk = origAtk = tempAtk = 25;
	    def = origDef = tempDef = 10;
	    evasion = tempEvasion =  origEvasion = 20;
	    EXP = 60;
	    level = 2;
	}
	if (difficulty == 3){
	    HP = origHP = 420;
	    atk = origAtk = tempAtk = 30;
	    def = origDef = tempDef = 15;
	    evasion = tempEvasion =  origEvasion = 25;
	    EXP = 90;
	    level = 3;
	}
	name = "Twelve Year Old Kid";
	state = 0;
	attackName[0]="NO SCOPED"; //Attack 1
	attackName[1]="Doritos & Mountain Dew"; //Attack 2
	attackName[2]="Microphone Screech";//Attack 3
	attackName[3]="420 BLAZE IT";//Attack 4
	ID = 3; //For identification purposes
	neededEXP = 100;
	int determinant = (int) (Math.random() * 6);
	inventory.add ( new Weapon (determinant) );
	equip ((Weapon) inventory.get(0));
    }

    //NO SCOPED
    public int attack1(Character w){
	int damage = (int)(atk - ( w.getTempDefense()) - 10);
	if (damage <= 0){
	    damage = 0;
	}
	w.lowerHP(damage);
        return damage;
    }

    //Doritos & Mountain Dew
    public int attack2(Character w){
	int damage = (int)(atk - (.5*  w.getAttack()) - 15);
	if (damage <= 0){
	    damage = 0;
	}
	w.lowerHP(damage);
	poison(w);
        return damage;
    }

    //Microphone Screech
    public int attack3(Character w){
	int damage = (int)(atk +  ( .1 * w.getTempDefense()) - 5);
	if (damage <= 0){
	    damage = 0;
	}
	w.lowerHP(damage);
	paralyze(w);
        return damage;
    }

    //420 BLAZE IT
    public int attack4(Character w){
	int damage = (int)(atk + (.5 * w.getTempDefense()) - 10);
	if (damage <= 0){
	    damage = 0;
	}
	w.lowerHP(damage);
        return damage;
    }
}
