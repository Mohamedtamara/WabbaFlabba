public class Monster extends Character{

    public Monster(){
	HP = 80;
	atk = 75;
	def = 50;
    }

    public void attack( ){
        atk +=5;
	def -=5;
	}

    public void defend( ){
	def +=5;
	atk -=5;

    }
    
}
	
