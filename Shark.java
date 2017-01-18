public class Shark extends Monster{

    public Shark(){
	HP = origHP = 80;
	atk = origAtk = tempAtk = 18;
	def = origDef = tempDef = 8;
	evasion = tempEvasion =  origEvasion = 5;
	state = 0;
	attackName[0]="Great White Bite"; //Attack 1
	attackName[1]="Hammerhead"; //Attack 2
	attackName[2]="A Whale of a Time";//Attack 3
	attackName[3]="Splash";//Attack 4
	ID = 4; //For identification purposes
	name = "Shark";
    }

    public Shark(int difficulty){
	if (difficulty == 1){
	    HP = origHP = 80;
	    atk = origAtk = tempAtk = 18;
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
	    atk = origAtk = tempAtk = 30;
	    def = origDef = tempDef = 16;
	    evasion = tempEvasion =  origEvasion = 15;
	}
	state = 0;
	attackName[0]="Great White Bite"; //Attack 1
	attackName[1]="Hammerhead"; //Attack 2
	attackName[2]="A Whale of a Time";//Attack 3
	attackName[3]="Splash";//Attack 4
	ID = 4; //For identification purposes
    }
    
}
