public class Shark extends Monster{

    /*
      Deadly Swimmer of the Seven Seas, and
      the other bodies of water as well. 
      The species has adapted to go on land,
      which is why you see them roaming the 
      map.
    */

    //default constructor
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
	EXP = 25;
	level = 1;
	neededEXP = 100;
	int determinant = (int) (Math.random() * 6);
	inventory.add ( new Weapon (determinant) );
	equip ((Weapon) inventory.get(0));
    }
    
    //overriden constructor with difficulty
    public Shark(int difficulty){
	if (difficulty == 1){
	    HP = origHP = 80;
	    atk = origAtk = tempAtk = 22;
	    def = origDef = tempDef = 8;
	    evasion = tempEvasion =  origEvasion = 5;
	    EXP = 20;
	    level = 1;
	}
	if (difficulty == 2){
	    HP = origHP = 120;
	    atk = origAtk = tempAtk = 24;
	    def = origDef = tempDef = 12;
	    evasion = tempEvasion =  origEvasion = 10;
	    EXP = 40;
	    level = 2;
	    
	}
	if (difficulty == 3){
	    HP = origHP = 160;
	    atk = origAtk = tempAtk = 26 ;
	    def = origDef = tempDef = 16;
	    evasion = tempEvasion =  origEvasion = 15;
	    EXP = 60;
	    level = 3;
	}
	name = "Shark";
	state = 0;
	attackName[0]="Great White Bite"; //Attack 1
	attackName[1]="Hammerhead"; //Attack 2
	attackName[2]="A Whale of a Time";//Attack 3
	attackName[3]="Splash";//Attack 4
	neededEXP = 100;
	ID = 4; //For identification purposes
	int determinant = (int) (Math.random() * 6);
	inventory.add ( new Weapon (determinant) );
	equip ((Weapon) inventory.get(0));
    }

    //Great White Bite
    public int attack1(Character w){
	int damage = (int)(atk - (1.75 * w.getTempDefense()) - 5);
	if (damage <= 0){
	    damage = 0;
	}
	w.lowerHP(damage);
	poison(w);
        return damage;
    }

    //Hammerhead
    public int attack2(Character w){
	int damage = (int)(atk - w.getAttack());
	if (damage <= 0){
	    damage = 0;
	}
	w.lowerHP(damage);
        return damage;
    }

    //A Whale of a Time
    public int attack3(Character w){
	int damage = (int)(atk   + ( -.5 *  w.getTempDefense()));
	if (damage <= 0){
	    damage = 0;
	}
	w.lowerHP(damage);
        return damage;
    }

    //Splash
    public int attack4(Character w){
	int damage = (int)(atk +  w.getTempDefense());
	if (damage <= 0){
	    damage = 0;
	}
	w.lowerHP(damage);
	poison(w);
	paralyze(w);
        return damage;
    }
    
}
