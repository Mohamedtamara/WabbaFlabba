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
	attackName[3]="Butterfly";// attack 4
    } 

     public int attack(Character w){
	int damage = (int)(atk - w.getTempDef());
	w.lowerHP(damage);
	return damage;
    }

    public void defend() {
	tempDef = (int) (def * 1.5);
    }

}
	
