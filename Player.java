public class Player extends Character{

    public Player(){
	HP = origHP = 100;
	atk = origAtk = tempAtk = 30;
	def = origDef = tempDef = 15;
        evasion = tempEvasion =  origEvasion = 30;
	state = 0;
	attackName[0]="Attack";
	attackName[1]="Kung Fu Fist"; //attack 2
	attackName[2]="Tae Kwon Do Kick";// attack 3
	attackName[3]="Double Karate Chop";// attack 4
	identity=1;
    } 

    public attack( ){
        super.attack();
    }

    public defend( ){
        super.defend();
    }

}
	
