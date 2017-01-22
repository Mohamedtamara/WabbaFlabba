import java.util.ArrayList;

/*
  WELCOME

  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  Here, you can witness the process of a Character!
  There are two paths to be taken, the Player route,
  or the Monster route.

  Choose wisely.
*/

public abstract class Character{

    /*
      STATISTICS!!!! Necessary for any RPG, these
      statistics, or stats for short, tell you more
      about the Player or Monster you're dealing
      with. These reveal how they attack, how they
      defend, how the go to work everyday, and what
      their favorite color is. Well, maybe not that
      much detail. Int is the way to go with these,
      as stats are numerical but not decimals.
    */
    
    protected int HP, atk, def, evasion, state, origHP, origAtk, origDef, origEvasion, tempAtk, tempDef, tempEvasion, ID, boostState, poisonedTurns,
	paralyzedTurns, space, EXP,neededEXP, level;

    /*
      Name of each monster will differ, but will
      be the same name as of the file name, except
      for the hero.
    */

    protected boolean poisoned, paralyzed;

    protected String name;

    /*
      Every Character is to have multiple attacks,
      with the Player being able to choose his, 
      and the Monster getting a random attack.
      Each subclass of Character will have its
      own variant to the attacks. Return type is
      int as to return the damage done.
    */

    public abstract int attack1(Character w);

    public abstract int attack2(Character w);

    public abstract int attack3(Character w);

    public abstract int attack4(Character w);

    /*
      Defending is a great way to slow down the
      damage done to you. This only changes your
      temp defense, so no need to return anything.
    */

    public abstract void defend();

    /*
      This is the list of attacks a Character.
      Making it an ArrayList of Strings 
      allows for easyreference of the attack 
      names.
    */

    protected String [] attackName = new String [4];

    /*
      This is the list of items available to a Character.
    */

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

    public int getEXP() {
	return EXP;
    }

    public int getNeededEXP() {
	return neededEXP;
    }

    public int getLevel() {
	return level;
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
    
    //Effect #1
    public void poison(Character opponent){ 
	opponent.poisoned = true;
	opponent.poisonedTurns = 5;
	if (this instanceof Player) {
	    System.out.println ("You poisoned " + opponent.getName() + "!!!");
	}
	else {
	    System.out.println ("You have been poisoned by " + opponent.getName() + "!!!");
	}
    }

    //Effect #2
    public void paralyze(Character opponent){
	opponent.paralyzed = true;
	opponent.paralyzedTurns = 3;
	if (this instanceof Player) {
	    System.out.println ("You paralyzed " + opponent.getName() + "!!!");
	}
	else {
	    System.out.println ("You have been paralyzed by " + opponent.getName() + "!!!");
	}
    }

    //Effect #3
    public void heal(){
	HP += (0.5 * HP);
    }

    //increase your inventory
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

    //decrease your inventory
    public String removeInventory (int index) {
	String info = "You removed " + inventory.get(index).name + "from your inventory.";
	inventory.remove(index);
	return info;
    }

    //time for action!
    public String equip (Weapon tool) {
	String info = "\nYou equipped " + tool.getName() + "!!!\n";
	origAtk += tool.getEquipAttack();
	origDef += tool.getEquipDefense();
	origEvasion += tool.getEquipEvasion();
	return info;
    }

    //time to settle down!
    public String unequip (Weapon tool) {
	String info = "\nYou equipped " + "tool.name" + "!!!\n";
        origAtk -= tool.getEquipAttack();
	origDef -= tool.getEquipDefense();
	origEvasion -= tool.getEquipEvasion();
	return info;
    }

    //what's the good of equipping without using?
    public String use (Item tool) {
	String info = "\nYou used " + tool.name + "!!!\n";
	HP += tool.getHealthBoost();
	tempAtk += tool.getAttackBoost();
	tempDef += tool.getDefenseBoost();
	tempEvasion += tool.getEvasionBoost();
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

    //lets you see what you got
    public String displayInventory () {
	String records = "Nothing here!";
	if (this instanceof Player) {
	    int counter = 0;
	    if ( inventory.size() == 0) { return "\nYou have nothing."; }
	    records = "Here is what is inside your backpack:\n";
	    for (int x = 0; x < inventory.size(); x++) {
		records += "(" + counter + ") " + this.inventory.get(x).name + this.inventory.get(x).getStats();;
		counter++;
	    }
	    return records;
	}
	else if (this instanceof Monster) {
	    int counter = 0;
	    records = "The enemy drops:\n";
	    for (int x = 0; x < this.inventory.size(); x++) {
		records += "(" + counter + ") " + this.inventory.get(x).stats  + "\n";
		counter++;
	    }
	    return records;
	}
	else {
	    System.out.println ("ERROR: Target must be subclass of 'player'.");
	}
	return records;
    }

    //after an effect wears off
    public void resetStats (){
	if (boostState <= 0) {
	    tempAtk = atk;
	    tempDef = def;
	    tempEvasion = evasion;
	}
    }
    
    // if 
    
    
    
    
   
}
			   

