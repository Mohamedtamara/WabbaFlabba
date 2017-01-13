public class Player extends Character{

    public void Player(){
	health = 100;
	attack = 100;
	defense = 100;
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
	
