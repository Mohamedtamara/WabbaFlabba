public class Player extends Character{

    public Player(){
	HP = origHP = 100;
	atk = origAtk = tempAtk = 30;
	def = origDef = tempDef = 15;
        evasion = tempEvasion =  origEvasion = 30;
	state = 0;
	attackName[0]="Shoryuken";//Attack 1
	attackName[1]="Vash the Stampede";//Attack 2
	attackName[2]="Tae Kwon Do Kick";//Attack 3
	attackName[3]="Butterfly";//Attack 4
	ID = 0;
    } 

     public void attack(Character w){
	int damage = (int)(atk - w.getTempDefense());
	w.lowerHP(damage);
	System.out.println("Ooh! You dealt " + damage + "damage to the Monster! Great Strike!");
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
	while (success == false){
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
	}
	if ((Math.random() * 100) <= runChance) {
	    success = true;
	}
	return success;
    }
    
}
	
