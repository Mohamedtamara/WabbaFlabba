public class TwelveYearOldKid extends Monster{

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
	int determinant = (int) (Math.random() * 6);
	inventory.add ( new Weapon (determinant) );
	equip ((Weapon) inventory.get(0));
    }

    public TwelveYearOldKid(int difficulty){
	if (difficulty == 1){
	    HP = origHP = 420;
	    atk = origAtk = tempAtk = 20;
	    def = origDef = tempDef = 20;
	    evasion = tempEvasion =  origEvasion = 20;
	}
	if (difficulty == 2){
	    HP = origHP = 420;
	    atk = origAtk = tempAtk = 30;
	    def = origDef = tempDef = 30;
	    evasion = tempEvasion =  origEvasion = 30;
	}
	if (difficulty == 3){
	    HP = origHP = 420;
	    atk = origAtk = tempAtk = 40;
	    def = origDef = tempDef = 40;
	    evasion = tempEvasion =  origEvasion = 40;
	}
	name = "Twelve Year Old Kid";

	state = 0;
	attackName[0]="NO SCOPED"; //Attack 1
	attackName[1]="Doritos & Mountain Dew"; //Attack 2
	attackName[2]="Microphone Screech";//Attack 3
	attackName[3]="420 BLAZE IT";//Attack 4
	ID = 3; //For identification purposes
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
	w.poisoned();
        return damage;
    }

    public int attack3(Character w){
	int damage = (int)(atk + w.getTempDefense());
	if (damage <= 0){
	    damage = 0;
	}
	w.lowerHP(damage);
	w.paralyzed();
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
