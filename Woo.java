import cs1.Keyboard;

public class Woo{
    


    public static void main(String[] args){
	char choose;
	Monster drag = new Monster();
	Player hero = new Player();
        String instructions = "Press (w) to move upwards.\nPress (a) to move towards the left\nPress (s) to move towards the right\nPress (d) to move down";
	Map A = new Map();
	A.userSpawn();
        char direction;
	boolean battle = false;
	boolean exit = false;
	if (battle == false) {
	    System.out.println (instructions);
	}
	while(!exit){
	    System.out.println ();
	    System.out.print ("Choose a direction to move, or select (i) for movement instructions: ");
	    direction = Keyboard.readChar();
	    if(direction == 'w'){
		A.userMove(1);
	    }else
	    if(direction == 'd'){
		A.userMove(2);
	    }else
	    if(direction == 's'){
		A.userMove(3);
	    }else
	    if(direction == 'a'){
		A.userMove(4);
	    }else
	    if(direction == 'i'){
	        System.out.println (instructions);
	    } else
	    if(direction == 'e'){
		battle = true;
		exit = true;
	    }
	}
	   System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n To battle, press a to do an attack against the monster and press d to defend instead.");
        while(battle){
	    System.out.println("Hero's HP: "+ hero.getHP() + ".\nEnemy's HP: "+drag.getHP()+".");
	    System.out.println("Will you Attack (a) or Defend (d)? ");
	    choose = Keyboard.readChar();
	    if(choose == 'a'){
		hero.attack();
       	}else
        if(choose == 'd'){
       	    hero.defend();
       	}

       	hero.attack(drag);
       	drag.attack(hero);
       	if(hero.getHP() < 0 || drag.getHP() < 0){
       	    battle = false;
	    System.out.println("You "+hero.getHP() + ". The enemy had " + drag.getHP());
	}
	}
    }
}
		
	       

	    
	
    


	    

	
    



