public class Monster extends Character{

    public Monster(){
	HP = origHP = 65;
	atk = origAtk = tempAtk = 10;
	def = origDef = tempDef = 5;
        evasion = tempEvasion =  origEvasion = 10;
	state = 0;
	attackName[0]="Attack";
	attackName[1]="Stone Gaze"; //attack 2
	attackName[2]="Molest";// attack 3
	attackName[3]="Sting";// attack 4
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
	
