import cs1.Keyboard;

public class Woo{

    //Instance Variables
    private Character hero;
    /*
      The Protagonist of the plot!
      Currently only one available
    */
    private Monster drag;
    /*
      The Antagonist of the Plot!
      Again, only one available
    */
    //  private Map A = new Map();
    private boolean gameover;
    /*
      How to determine when a game ended
      Don't die please
    */
    private String state;// shows if the user is currently battling or in the map
    // default contructor
    public Woo(){
	gameover = false;
	newGame();
    }
    private void newGame(){
	String s;
	Map A = new Map(1);
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

    /*

    public static void battle() {

	char choose;// stores the read user's input for selection of attack
	Monster drag = new Monster(); // initializes monster
	if(Math.random() < .1){
	    state = "battle";
	    System.out.println("Time to d-d-d-d-duel!");
	}
	else {
	    system.out.println("You are safe... for now");
	}

       	System.out.println("\nTo battle, press a to do an attack against the monster and press d to defend instead.");
       	while(state == "battle"){
       	    if (hero.getState() == 1){
       		System.out.println("Oh no! You've been poisoned!");
       	    }
       	    if (hero.getState() == 2){
       		System.out.println("You can't move!");
       	    }
       	    else{
       		System.out.println("Hero's HP: "+ hero.getHP() + ".\nEnemy's HP: "+drag.getHP()+".");
       		System.out.println("Will you Attack (a), Defend (d), Run (r), or see your stats (s) ? ");
       		choose = Keyboard.readChar();
       		if (choose == 'a'){
       		    hero.attack(drag);
       		    drag.attack(hero);
       		}
       		else if (choose == 'd'){
       		    hero.defend();
       		    drag.attack(hero);
       		}
       		else if (choose == 'r'){
       		    if (hero.run() == true) {
       			System.out.println("You escaped! Sadly, you dropped your XP and potential loot behind.");
       			state = "map";
       		    }
       		}
       		else if (choose == 's'){
       		    System.out.println("Time for some stats: ");
		    hero.seeStats();
       		    drag.seeStats();
       		}
       		else {
	       	    System.out.println ("THAT IS NOT AN OPTION. PAY THE PRICE");
	       	}
	       	if (hero.getHP() <= 0) {
	       	    System.out.println ("Take this L brodie");
	       	    state = "map";
	       	    gameover = true;
	       	}
	       	if (drag.getHP() <= 0) {
	       	    System.out.println ("You have beaten the monster!!!");
	       	    System.out.println (A);
	       	    State = "map";
	       	}
	       	System.out.println();
       	    }
       	}
    }

    
    */


    public static void main(String[] args){
	int level = 1;
	while (level < 3) {
	    char choose;// stores the read user's input for selection of attack
	    Monster drag = new Monster(); // initializes monster
	    Player hero = new Player(); // initializes player
	    // ins
	    String instructions = "Press (w) to move upwards.\nPress (a) to move towards the left\nPress (s) to move towards the right\nPress (d) to move down";
	    Map A = new Map(level); // constructor that initializes depending on the map that the user has just finished
	    A.userSpawn(); // spawns location of user on respective map
	    char direction;// stores user's input for direction that they want to move on the map
	    boolean battle = false;// user's battle status is off (user is moving around map, not in battle currently 
	    boolean exit = false;// user is not dead and has not finished the current map
	    if (battle == false) {
		System.out.println (instructions); //No battle? Time to read!
	    }
	    while(exit == false){
		System.out.println ();
		System.out.print ("Choose a direction to move, or select (i) for movement instructions: ");
		direction = Keyboard.readChar();
		if(direction == 'w'){ //Looking up because she down
		    A.userMove(1);
		}
		else if(direction == 'd'){ //Looking right because you left
		    A.userMove(2);
		}
		else if(direction == 's'){ // Looking down because you're up
		    A.userMove(3);
		}
		else if(direction == 'a'){ //Looking left because you're right
		    A.userMove(4);
		}
		else if(direction == 'i'){ //More reading?
		    System.out.println (instructions);
		}
		else if(direction == 'e'){ //Bye bye
		    battle = true;
		    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n To battle, press a to do an attack against the monster and press d to defend instead.");
		    while(battle == true){
			if (hero.getState() == 1){
			    System.out.println("Oh no! You've been poisoned!");
			}
			if (hero.getState() == 2){
			    System.out.println("You can't move!");
			}
			else{
			    System.out.println("Hero's HP: "+ hero.getHP() + ".\nEnemy's HP: "+drag.getHP()+".");
			    System.out.println("Will you Attack (a), Defend (d), Run (r), or see your stats (s) ? ");
			    choose = Keyboard.readChar();
			    if (choose == 'a'){
				hero.attack(drag);
				drag.attack(hero);
			    }
			    else if (choose == 'd'){
				hero.defend();
				drag.attack(hero);
			    }
			    else if (choose == 'r'){
				if (hero.run() == true) {
				    System.out.println("You escaped! Sadly, you dropped your XP and potential loot behind.");
				    battle = false;
				}
			    }
			    else if (choose == 's'){
				System.out.println("Time for some stats: ");
				hero.seeStats();
				drag.seeStats();
			    }
			    else {
				System.out.println ("THAT IS NOT AN OPTION. PAY THE PRICE");
			    }
			    if (hero.getHP() <= 0) {
				System.out.println ("Take this L brodie");
				battle = false;
				exit= true;
				return;
			    }
			    if (drag.getHP() <= 0) {
				System.out.println ("You have beaten the monster!!!");
				System.out.println (A);
				battle = false;
			    }
			    System.out.println();
			}
		    }
		}
		else {
		    System.out.println("You are dumb. Here are the instructions, which you can press i to see again:\n" + instructions);
		}
		if (A.success == true){
		    exit = true;
		    level++;
		    drag = new Monster();
		}
	    }
	}
    }
}
    

    
    


/* This will be a template for the new main method using the other methods
the template will include randomness

public static void main(String[] args){
 state = "map";


while(!gameover){
if(state == "map"){
runMap();
if (randomint > .2){
state == "battle";
}
}
if(state = battle){
battle();
- take a look at play turn to see how to model batle. perhaps with this methodology it will simlify how to make bttle() code?
}

if(hero.getHP() <= 0 || Boss == killed){
gameover = true;
}
}
if(hero.getHP() <= 0){
SOP(ur bad);
}
if(boss == kill){
SOP(Wow ur good);
}
}
*/

	    
	
    


	    

	
    



