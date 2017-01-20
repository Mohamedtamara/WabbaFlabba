public class Player extends Character{

    public Player(){
	HP = origHP = 200;
	atk = origAtk = tempAtk = 50;
	def = origDef = tempDef = 20;
        evasion = tempEvasion =  origEvasion = 30;
	state = 0;
	attackName[0]="Shoryuken";//Attack 1
	attackName[1]="Vash the Stampede";//Attack 2
	attackName[2]="Tae Kwon Do Kick";//Attack 3
	attackName[3]="Butterfly";//Attack 4
	ID = 0;
	name ="";
    }

    public Player (String holdName, int holdHP,int holdAtk,int  holdDef,int holdEvasion) {
	HP = origHP = holdHP;
	atk = origAtk = tempAtk = holdAtk;
	def = origDef = tempDef = holdDef;
        evasion = tempEvasion =  origEvasion = holdEvasion;
	state = 0;
	attackName[0]="Shoryuken";//Attack 1
	attackName[1]="Vash the Stampede";//Attack 2
	attackName[2]="Tae Kwon Do Kick";//Attack 3
	attackName[3]="Butterfly";//Attack 4
	ID = 0;
	name = "";
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
	int damage = (int)(atk + (2 * w.getTempDefense());
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
	System.out.println("For da good dude: ");
	System.out.println("HP: " + this.getHP() + ".");
	System.out.println("Attack: " + this.getAttack() + ".");
	System.out.println("Defense: " + this.getDefense() + ".");
	System.out.println("Evasion: " + this.getEvasion() + ".\n");
    }

    public boolean run() {
	int runTimes = 0;
	int runChance = 50;
	boolean success = false;
	if ((Math.random() * 100) <= runChance) {
	    success = true;
	}
	else{
	    if (runTimes == 1) {
		runChance = 40;
	    }
	    else if (runTimes == 2) {
		runChance = 30;
	    }
	    else if (runTimes == 3) {
		runChance = 20;
	    }
	    else if (runTimes == 4) {
		runChance = 10;
	    }
	    else if (runTimes >= 5) {
		runChance = 5;
	    }
	    runTimes++;
	    System.out.println("Nah, you can't escape that easily");
	}
	return success;
    }
    
}
	
