public class Monster extends Character{

    public void Monster(){
	health = 80;
	attack = 75;
	defense = 50;
    }

    public int attack( Character a){
	health -= ((a.attack/a.defense) + a.attack);
	return health;
	}

    public int defend( Character a){
	health += (.2*defense);
	return health;
    }
    
}
	
