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
	int determinant = (int) (Math.random() * 6);
	inventory.add ( new Weapon (determinant) );
	equip ((Weapon) inventory.get(0));
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
        return damage;
    }

    public int attack3(Character w){
	int damage = (int)(atk + w.getTempDefense());
	if (damage <= 0){
	    damage = 0;
	}
	w.lowerHP(damage);
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

    public static void main (String [] args) {
	Monster Alitquan = new Monster();
	System.out.println (Alitquan.displayInventory ());
    }
	
	
}
	
