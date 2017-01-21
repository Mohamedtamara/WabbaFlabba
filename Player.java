import cs1.Keyboard;
public class Player extends Character{
    private int equipNo;

    public Player(){
	inventory.add (  new Weapon(0) );
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
	inventory.add (  new Weapon(0) );
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

    public void inventoryCheck (Monster dude) {
	char yesno;
	System.out.println (dude.displayInventory());
	System.out.print ("Do you want want any of these?\n(y) yes \t(n) no\nSelection: ");
	yesno = Keyboard.readChar();
	if (yesno == 'y') {
	    for (int x = 0; x < dude.inventory.size(); x++) {
		if (this.inventory.size() < 11) {
		    char decision;
		    System.out.println ("Do you want to add " + dude.inventory.get(x).getName()+ "to your inventory? ");
		    System.out.println ("(y) yes \t(n) no");
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

     public void equipScreen() {
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
    }

    public static void main (String [] args) {
	Player Alitquan = new Player();
	System.out.println (Alitquan.displayInventory ());
    }
    
}
	
