import cs1.Keyboard;

public class Woo{

    //Instance Variables
    private Player hero;
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
    private int playerHP;
    private int playerAtk;
    private int playerDef;
    private int playerEvasion;
    private int level;
    private Map A;
    private boolean start = false;
    private String playerName = "player";
    // default contructor
    public Woo(){
	gameover = false;
	level = 1;
	newGame();
	playerHP = 100;
	playerAtk = 30;
	playerDef = 15;
	playerEvasion = 30;
    }
    private void newGame(){
	String s;
	A = new Map(level);
	hero = new Player(playerHP,playerAtk,playerDef,playerEvasion);
	drag = new Monster();
	A.userSpawn();
    }

    public void runLevel() {
	while (start == true) {
	    while (this.level < 3) {
		System.out.println ();
		System.out.print ("Choose a direction to move, or select (i) for movement instructions: ");
		String instructions = ("Press w to move up\nPress a to move right\nPress d to move right\nPress s to move down");
		char direction;
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
		else if (direction == 'e'){
		    battle();
		}
		else {
		    System.out.println ("THAT IS NOT AN OPTION. PAY THE PRICE");
		}
		if (A.success == true) {
		    level++;
		    if (level < 3) {
			drag = new Monster();
			A = new Map (level);
			A.userSpawn();
			System.out.println(A);
			hero = new Player(playerHP,playerAtk,playerDef,playerEvasion);
		    }
		}
	    }
	    if (level == 3) {
		return;
	    }
	}
    }
	
    public void battle() {
	boolean battling = true;
	System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n To battle, press a to do an attack against the monster and press d to defend instead.");
	while(battling == true){
	    if (hero.getState() == 1){
		System.out.println("Oh no! You've been poisoned!");
		
	    }
	    if (hero.getState() == 2){
		System.out.println("You can't move!");
	    }
	    else{
		System.out.println("Hero's HP: "+ hero.getHP() + ".\nEnemy's HP: "+drag.getHP()+".");
		System.out.println("Will you Attack (a), Defend (d), Run (r), or see your stats (s) ? ");
		char choose;
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
			battling = false;
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
	    }
	    if (hero.getHP() <= 0) {
		start = false;
		System.out.println ("You lose");
	    }
	    if (drag.getHP() <= 0) {
		System.out.println ("You won");
		System.out.println(A);
		battling=false;
	    }
		
	}
    }
    
   
        
	    
	

    public void title () {
	String s; 
	int choice1;
	String choice2;
	int choice3;
	String titleScreen = "";
	titleScreen += "\n\n\n\t\t\t\t\t\t\t\t\t$$$$    $   $$$$   $$$$$$$$$$     $$$$$$$$$$     $$$$$$$$$$       $$$$$$$$$\n";
	titleScreen += "\t\t\t\t\t\t\t\t\t$$$$   $$$  $$$$  $$$$$$$$$$$$    $$$$$$$$$$$    $$$$$$$$$$$     $$$$$$$$$$$$\n";
	titleScreen += "\t\t\t\t\t\t\t\t\t$$$$  $$$$  $$$$  $          $    $$        $$   $$        $$    $          $\n";  
	titleScreen += "\t\t\t\t\t\t\t\t\t$$$$ $$$$$  $$$$ $$          $$   $$        $$   $$        $$   $$          $$\n"; 
	titleScreen += "\t\t\t\t\t\t\t\t\t$$$$ $$$$$  $$$$ $$          $$   $$        $$   $$        $$   $$          $$\n"; 
	titleScreen += "\t\t\t\t\t\t\t\t\t$$$$$$$$$$$$$$$$ $$$$$$$$$$$$$$   $$$$$$$$$$$    $$$$$$$$$$$    $$$$$$$$$$$$$$\n";
	titleScreen += "\t\t\t\t\t\t\t\t\t$$$$$$   $$$$$$  $$$$$$$$$$$$$$   $$        $$   $$        $$   $$$$$$$$$$$$$$\n";
	titleScreen += "\t\t\t\t\t\t\t\t\t$$$$$    $$$$   $$$$        $$$$  $$        $$   $$        $$  $$$$        $$$$\n";
	titleScreen += "\t\t\t\t\t\t\t\t\t$$$$    $$$$$   $$$$        $$$$  $$        $$   $$        $$  $$$$        $$$$\n"; 
	titleScreen += "\t\t\t\t\t\t\t\t\t$$$$    $$$$    $$$$        $$$$  $$$$$$$$$$$    $$$$$$$$$$$   $$$$        $$$$\n";
	titleScreen += "\t\t\t\t\t\t\t\t\t$$$    $$$$     $$$$        $$$$  $$$$$$$$$$     $$$$$$$$$$    $$$$        $$$$\n\n\n";

	titleScreen += "\t\t\t\t\t\t\t\t   $$$$$$$$$$$$$$$$  $$$$            $$$$$$$$$$     $$$$$$$$$$     $$$$$$$$$$       $$$$$$$$$$\n";
	titleScreen += "\t\t\t\t\t\t\t\t   $$$$$$$$$$$$$$    $$$$           $$$$$$$$$$$$    $$$$$$$$$$$    $$$$$$$$$$$     $$$$$$$$$$$$\n";
	titleScreen += "\t\t\t\t\t\t\t\t   $$$$$$$$$$$$      $$$$           $          $    $$        $$   $$        $$    $          $\n";  
	titleScreen += "\t\t\t\t\t\t\t\t   $$$$              $$$$          $$          $$   $$        $$   $$        $$   $$          $$\n"; 
	titleScreen += "\t\t\t\t\t\t\t\t   $$$$$$$$$$$$      $$$$          $$          $$   $$        $$   $$        $$   $$          $$\n"; 
	titleScreen += "\t\t\t\t\t\t\t\t   $$$$$$$$$$        $$$$          $$$$$$$$$$$$$$   $$$$$$$$$$$    $$$$$$$$$$$    $$$$$$$$$$$$$$\n";
	titleScreen += "\t\t\t\t\t\t\t\t   $$$$$$$$          $$$$          $$$$$$$$$$$$$$   $$        $$   $$        $$   $$$$$$$$$$$$$$\n";
	titleScreen += "\t\t\t\t\t\t\t\t   $$$$$             $$$$         $$$$        $$$$  $$        $$   $$        $$  $$$$        $$$$\n";
	titleScreen += "\t\t\t\t\t\t\t\t   $$$$              $$$$         $$$$        $$$$  $$        $$   $$        $$  $$$$        $$$$\n"; 
	titleScreen += "\t\t\t\t\t\t\t\t   $$$$              $$$$$$$$$$$  $$$$        $$$$  $$$$$$$$$$$$   $$$$$$$$$$$$  $$$$        $$$$\n";
	titleScreen += "\t\t\t\t\t\t\t\t   $$$               $$$$$$$$$$$  $$$$        $$$$  $$$$$$$$$$$    $$$$$$$$$$$   $$$$        $$$$\n";
	titleScreen += "\n\t\t\t\t\t\t\t\t\t\t\t\t\t        THE  GAME";
        System.out.println( titleScreen);
	System.out.println("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t     WILL YOU ENTER?");
	System.out.println("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t  CHOOSE: (1) YES  (2) NO");
	System.out.print("I choose: ");
	choice1 = Keyboard.readInt();
	if (choice1 == 0) {
	    return;
	}
	else if (choice1 != 1 && choice1 != 0) {
	    System.out.println ("retart\n");
	    start = false;
	}
	else {
	    start = true;
	    System.out.println ("WHAT IS YOUR NAME?");
	    System.out.print ("It is: ");
	    choice2= Keyboard.readString();
	    playerName = choice2;
	    System.out.println ("pick your difficulty out of these: easy (1), medium (2), hard (3)");
	    System.out.print ("I feel: ");
	    choice3 = Keyboard.readInt();
	    if (choice3 > 3 || choice3 < 1) {
		System.out.println ("retart");
		start = false;
	    }
	}
    }

    /*
    
      s= " ~~~ Welcome to the Game. ~~~\n";
      s+="How to play\n MAP\n Press w to move up\n press d to move right\npress s to move down\n press a to move left\n";
      s+=" BATTLE\n press a to attack\n and d to dodge\n";
        
      System.out.print ("Choose a direction to move, or select (i) for movement instructions: ");
      A.userSpawn();
    */


    public static void main(String[] args){
	Woo Alitquan = new Woo();
	Alitquan.title();
	Alitquan.newGame();
	Alitquan.runLevel();
    }
    
}
/*
  int level = 1;
  while (level < 3) {
  char choose;// stores the read user's input for selection of attack
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
  }*/
    

    
    


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

	    
	
    


	    

	
    



