public abstract class Character{
    
    protected int HP, atk, def;

    public abstract void attack();

    public abstract  void defend();

    protected String [] attackName = new String [8];

    public int getHP(){
	return HP;
}

    public int getDefense(){
	return def;
    }
    public void lowerHP(int damage){
	HP-= damage;
    }
    public int attack(Character w){
	int damage = (int)(atk - w.getDefense());
	w.lowerHP(damage);
	return damage;
    }
}
			   

