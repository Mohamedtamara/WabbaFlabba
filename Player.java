import cs1.Keyboard;
import java.util.ArrayList;

/*
  This is the only playable subclass in the game. 
  The leveling up system has been abandoned, due 
  to a lack of dedication of time by the Character
  level Progression development team
*/

public class Player extends Character{
    private int equipNo, EXP, neededEXP, level;

    public Player () {
	inventory.add (  new Weapon(0) );
	HP = origHP = 350;
	atk = origAtk = tempAtk = 50;
	def = origDef = tempDef = 20;
        evasion = tempEvasion =  origEvasion = 30;
	state = 0;
	attackName[0]="Shoryuken";//Attack 1
	attackName[1]="Vash the Stampede";//Attack 2
	attackName[2]="Tae Kwon Do Kick";//Attack 3
	attackName[3]="Butterfly";//Attack 4
	ID = 0;
	EXP = 0;
	level = 1;
	neededEXP = 100;
	name ="";
    }
    public Player(String targetName){
	name = targetName;
	inventory.add (  new Weapon(0) );
	HP = origHP = 350;
	atk = origAtk = tempAtk = 50;
	def = origDef = tempDef = 20;
        evasion = tempEvasion =  origEvasion = 30;
	state = 0;
	attackName[0]="Shoryuken";//Attack 1
	attackName[1]="Vash the Stampede";//Attack 2
	attackName[2]="Tae Kwon Do Kick";//Attack 3
	attackName[3]="Butterfly";//Attack 4
	ID = 0;
	EXP = 0;
	level = 1;
	neededEXP = 100;
	name ="";
    }

    public Player ( int holdHP,int holdAtk,int  holdDef,int holdEvasion, ArrayList <Equipment> holdInventory) {
	inventory = holdInventory;
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
	EXP = 0;
	level = 1;
	neededEXP = 100;
	name = "";
    }

    // prompts user to check inventory of enemy for desirable items
    public void inventoryCheck (Monster dude) {
	System.out.println(" Here is your inventory. The first slot is your currently equipped weapon: " + this.displayInventory());
	char yesno;
	System.out.println (dude.displayInventory());
	System.out.print ("Do you want want any of these?\n\t(y) yes \t(n) no\nSelection: ");
	yesno = Keyboard.readChar();
	if (yesno == 'y') {
	    for (int x = 0; x < dude.inventory.size(); x++) {
		if (this.inventory.size() < 11) {
		    char decision;
		    System.out.println (" Do you want to add " + dude.inventory.get(x).getName()+ " to your inventory? ");
		    System.out.println ("\t(y) yes \t(n) no");
		    System.out.print ("Selection: ");
		    decision = Keyboard.readChar();
		    if (decision == 'y') {
			this.inventory.add(dude.inventory.get(x));
		    }
		    else if(decision == 'n') {
		    }
		    else {}
		}
		else {
		    System.out.println ("Your inventory is full.");
		}
	    }
	}
	else {
	    System.out.println ("You resume your journey.");
	}
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

    // used by user to equip or use a weapon or item
     public void equipScreen() {
	 System.out.println ("These are your stats right now: ");
	 this.seeStats();
	 System.out.println ("This is what you have equipped at this moment: " + this.inventory.get(0).stats);
	 System.out.println (this.displayInventory());
	 System.out.println ("What would you like to equip / use?");
	 System.out.print("Please choose the number of the equipment that you want to equip or use: ");
	 equipNo = Keyboard.readInt();
	 if (equipNo <= this.inventory.size() && equipNo > -1 && this.inventory.get(equipNo) instanceof Weapon) {
	     this.unequip((Weapon)inventory.get(0));
	     this.inventory.add (0, inventory.get(equipNo));
	     this.inventory.remove (equipNo + 1);
	     this.equip ((Weapon)inventory.get(0));
	     System.out.println ("You equipped " + inventory.get(0).getName() + ".");
	 }
	 else if (equipNo <= this.inventory.size() && equipNo > -1 && this.inventory.get(equipNo) instanceof Item) {
	     use((Item)inventory.get(equipNo));
	     this.inventory.remove(equipNo);
	 }
	 else {
	     System.out.println ("ERROR in equipScreen");
	 }
	 this.seeStats();
     }

    /*
      This checks if the EXP of the Player
      is enough for him to level up.
    */
    
    public void levelUp(){
	EXP -= neededEXP;
	neededEXP *= 2;
	level++;
    }

    public static void main (String [] args) {
	Player Maximillian = new Player();
	System.out.println (Maximillian.displayInventory ());
    }
    
}
	
