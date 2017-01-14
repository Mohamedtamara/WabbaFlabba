public abstract class Character{
    
    protected int HP, atk, def, evasion, state, origHP, origAtk, origDef, origEvasion, tempAtk, tempDef, tempEvasion;

    public abstract int attack(Character w);

    public abstract void defend();

    protected String [] attackName = new String [8];

    public int getHP(){
	return HP;
    }

    public int getDefense(){
	return def;
    }

    public int getTempDef() {
	return tempDef;
    }

    public void origStats(int type) {
	// resets attributes after defend command is used
	if (type == 1) {
	    def = origDef;
	    evasion = origEvasion;
	}
    }

    public void lowerHP(int damage){
	HP-= damage;
    }
    

   
}
			   

