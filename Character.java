import java.util.ArrayList;
public abstract class Character{
    
    protected int HP, atk, def, evasion, state, origHP, origAtk, origDef, origEvasion, tempAtk, tempDef, tempEvasion, ID, boostState, stateTurns,space;

    protected String name;

    public abstract int attack1(Character w);

    public abstract int attack2(Character w);

    public abstract int attack3(Character w);

    public abstract int attack4(Character w);

    public abstract void defend();

    protected String [] attackName = new String [4];

    protected ArrayList <Equipment>  inventory = new ArrayList <Equipment> ();
   

    /*
      Whole lotta get methods up ahead. 
      Beware.
    */

    public int getHP() {
	return HP;
    }

    public int getAttack() {
	return atk;
    }

    public int getDefense() {
	return def;
    }

    public int getEvasion() {
	return evasion;
    }

    public int getState() {
	return state;
    }

    public int getOrigHP() {
	return origHP;
    }

    public int getOrigAttack() {
	return origAtk;
    }

    public int getOrigDefense() {
	return origDef;
    }

    public int getOrigEvasion(){
	return origEvasion;
    }

    public int getTempAttack() {
	return tempAtk;
    }

    public int getTempDefense() {
	return tempDef;
    }

    public int getTempEvasion() {
	return tempEvasion;
    }

    public int getID() {
	return ID;
    }

    public String getName() {
	return name;
    }

    public void origStats(int type) {
	// resets attributes after defend command is used
	if (type == 1) {
	    def = origDef;
	    evasion = origEvasion;
	}
    }
    
    //Allows for the character to see their stats
    public abstract void seeStats();
	
    public void lowerHP(int damage){
	HP-= damage;
    }
    
    //Attack #2
    public void poisoned(){ 
	state = 1;
	HP -= (HP * .05);
    }

    //Attack #3
    public void paralyzed(){
	state = 2;
    }

    //Attack/option #4
    public void heal(){
	HP += (0.5 * HP);
    }

    public String addInventory (Equipment thing) {
	String info = "";
	if (space < 10) {
	    info = "You added " + thing.name + "to your inventory.";
	    inventory.add(thing);
	    space -= 1;
	}
	else {
	    info = "You do not have enough space in your inventory";
	}
	return info;
    }
    
    public String removeInventory (int index) {
	String info = "You removed " + inventory.get(index).name + "from your inventory.";
	inventory.remove(index);
	return info;
    }
		

    public String equip (Weapon tool) {
	String info = "\nYou equipped " + tool.getName() + "!!!\n";
	origAtk += tool.getEquipAttack();
	origDef += tool.getEquipDefense();
	origEvasion += tool.getEquipEvasion();
	return info;
    }
    
    public String unequip (Weapon tool) {
	String info = "\nYou equipped " + "tool.name" + "!!!\n";
        origAtk -= tool.getEquipAttack();
	origDef -= tool.getEquipDefense();
	origEvasion -= tool.getEquipEvasion();
	return info;
    }
    

    public String use (Item tool) {
	String info = "\nYou used " + tool.name + "!!!\n";
	HP += tool.getHealthBoost();
	tempAtk += tool.getAttackBoost();
	tempDef += tool.getDefenseBoost();
	tempEvasion += tool.getEvasionBoost();
	boostState += tool.getNumTurns();
	if (tool.getCure() == 1 && state == 1) {
 	    state = 0;
	}
	else if ( tool.getCure() == 2 && state == 2) {
	    state = 0;
	}
	else {
	}
	return info;
    }
    
    public String displayInventory () {
	String records = "Nothing here!";
	if (this instanceof Player) {
	    int counter = 0;
	    if ( inventory.size() == 0) { return "\nYou have nothing."; }
	    records = "Here is what is inside your backpack:\n";
	    for (int x = 0; x < inventory.size(); x++) {
		records += "(" + counter + ") " + inventory.get(x).name + "\n";
		counter++;
	    }
	    return records;
	}
	else if (this instanceof Monster) {
	    int counter = 0;
	    records = "The enemy drops:\n";
	    for (int x = 0; x < this.inventory.size(); x++) {
		records += "(" + counter + ") " + this.inventory.get(x).name + "\n";
		counter++;
	    }
	    return records;
	}
	else {
	    System.out.println ("ERROR: Target must be subclass of 'player'.");
	}
	return records;
    }
    
    public void resetStats (){
	if (boostState <= 0) {
	    tempAtk = atk;
	    tempDef = def;
	    tempEvasion = evasion;
	}
    }
    
    // if 
    
    
    
    
   
}
			   

