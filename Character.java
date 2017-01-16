public abstract class Character{
    
    protected int HP, atk, def, evasion, state, origHP, origAtk, origDef, origEvasion, tempAtk, tempDef, tempEvasion, ID;

    public abstract void attack(Character w);

    public abstract void defend();

    protected String [] attackName = new String [8];

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
    

   
}
			   

