import cs1.Keyboard;

public class Woo{

    //Instance Variables
    private Character hero;
    private Monster scary;
    //  private Map A = new Map();
    private boolean gameover;

    // default contructor
    public Woo(){
	gameover = false;
	newGame();
    }
    private void newGame(){
	String s;
	Map A = new Map();
	hero = new Player();
	
	s= " ~~~ Welcome to the Game. ~~~\n";
	s+="How to play\n MAP\n Press w to move up\n press d to move right\npress s to move down\n press a to move left\n";
	s+=" BATTLE\n press a to attack\n and d to dodge\n";
        
         System.out.print ("Choose a direction to move, or select (i) for movement instructions: ");
	 A.userSpawn();
	/* functionallity to be added
	   1. choose class
	   2. choose difficulty
	   3. choose name
	*/
    }

    /* this will be the running map code*/
    /* private boolean runMap(){
	char direction;
	 direction = Keyboard.readChar();
         if(direction == 'w'){
	     A.userMove(1);
	     return true;
         }else
	 if(direction == 'd'){
	     A.userMove(2);
	     return true;
	 }else
         if(direction == 's'){
	     A.userMove(3);
	     return true;
	 }else
         if(direction == 'a'){
	     A.userMove(4);
	     return true;
	 }else
         if(direction == 'i'){
	     System.out.println (instructions);
	     return true;
        } else
        if(direction == 'e'){
	    return false;
	}
}
    */
    /* possible issues
	Map A might not be able to be intialzied the way it is. Yet, we need to not be made a new each time this method is ran.
	not quite sure How I want to use its variable, But I definitely need it to. */

    

	
	


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
		hero.attack(drag);
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
		
	       

	    
	
    


	    

	
    



