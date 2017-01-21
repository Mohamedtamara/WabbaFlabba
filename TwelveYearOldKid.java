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

}
