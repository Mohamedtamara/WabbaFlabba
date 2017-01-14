public class Player extends Character{

    public Player(){
	HP = 100;
	atk = 100;
	def = 100;
    }

    public void attack( ){
        atk +=5;
	def -=5;
	}

    public void defend( ){
        def+=5;
	atk-=5;
    }
    
}
	
