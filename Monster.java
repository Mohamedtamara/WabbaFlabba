public class Monster extends Character{

    public Monster(){
	HP = origHP = 70;
	atk = origAtk = tempAtk = 10;
	def = origDef = tempDef = 5;
        evasion = tempEvasion =  origEvasion = 10;
	state = 0;
	attackName[0]="Attack"; //Attack 1
	attackName[1]="Stone Gaze"; //Attack 2
	attackName[2]="Molest";//Attack 3
	attackName[3]="Sting";//Attack 4
	ID = 1; //For identification purposes
	name = "Monster";
    }

    public Monster(int difficulty){
	if (difficulty == 1){
	    HP = origHP = 70;
	    atk = origAtk = tempAtk = 10;
	    def = origDef = tempDef = 5;
	    evasion = tempEvasion =  origEvasion = 10;
	}
	if (difficulty == 2){
	    HP = origHP = 140;
	    atk = origAtk = tempAtk = 15;
	    def = origDef = tempDef = 10;
	    evasion = tempEvasion =  origEvasion = 15;
	}
	if (difficulty == 3){
	    HP = origHP = 210;
	    atk = origAtk = tempAtk = 20;
	    def = origDef = tempDef = 15;
	    evasion = tempEvasion =  origEvasion = 20;
	}
	state = 0;
	attackName[0]="Attack"; //Attack 1
	attackName[1]="Stone Gaze"; //Attack 2
	attackName[2]="Molest";//Attack 3
	attackName[3]="Sting";//Attack 4
	ID = 1; //For identification purposes
	name = "Monster";
    }
    
    public void attack(Character w){
	int damage = (int)(Math.abs(atk - w.getTempDefense()));
	w.lowerHP(damage);
	System.out.println("Ouch! The Monster did " + damage + " damage to you. Better watch out!");
    }

    public void defend() {
	tempDef = (int) (def * 1.5);
    }

    public void seeStats(){
	System.out.println("For da bad dude: ");
	System.out.println("HP: " + this.getHP() + ".");
	System.out.println("Attack: " + this.getAttack() + ".");
	System.out.println("Defense: " + this.getDefense() + ".");
	System.out.println("Evasion: " + this.getEvasion() + ".\n");
    }
    
}
	
