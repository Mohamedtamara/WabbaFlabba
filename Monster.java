public class Monster extends Character{

    public Monster(){
	HP = origHP = 65;
	atk = origAtk = tempAtk = 10;
	def = origDef = tempDef = 5;
        evasion = tempEvasion =  origEvasion = 10;
	state = 0;
	attackName[0]="Attack"; //Attack 1
	attackName[1]="Stone Gaze"; //Attack 2
	attackName[2]="Molest";//Attack 3
	attackName[3]="Sting";//Attack 4
	ID = 1; //For identification purposes
    } 

    public void attack(Character w){
	int damage = (int)(atk - w.getTempDefense());
	w.lowerHP(damage);
        System.out.print("Ouch! The Monster did " + damage + "damage to you. Better watch out!");
    }

    public void defend() {
	tempDef = (int) (def * 1.5);
    }

    public void seeStats(){
	System.out.println("Time for some stats: ");
	System.out.println("HP: " + this.getHP() + ".");
	System.out.println("Attack: " + this.getAttack() + ".");
	System.out.println("Defense: " + this.getDefense() + ".");
	System.out.println("Evasion: " + this.getEvasion() + ".");
    }
    
}
	
