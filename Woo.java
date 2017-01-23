import cs1.Keyboard;
import java.util.ArrayList;

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
    /* variables for holding the player's stats 
       for carrying on to the next map
    */
    private String playerName;
    private int hpHolder;
    private int atkHolder;
    private int defHolder;
    private int evasionHolder;
    /* player's base stats
     */
    private int playerHP;
    private int playerAtk;
    private int playerDef;
    private int playerEvasion;
    private int level;
    private Map A;
    private boolean start = false;
    private int difficulty;
    private int equipNum;
    private ArrayList <Equipment>  inventorySave = new ArrayList <Equipment> ();

    // default contructor
    public Woo(){
	gameover = false;
	level = 1;
	playerHP = 400;
	playerAtk = 35;
	playerDef = 15;
	playerEvasion = 30;
	inventorySave.add(new Weapon (0));
	inventorySave.add(new Item(4));
	inventorySave.add(new Item(1));
    }
    private void newGame(){
	String s;
	A = new Map(level);
	A.playerName2 = this.playerName;
	hero = new Player(playerHP,playerAtk,playerDef,playerEvasion,inventorySave);
    }

    public void runLevel() {
	drag = new Monster(); // this is to avoid a bug, serves no other functional purpose
	A.userSpawn();
	System.out.println(A);
	while (start == true) {
	    while (this.level < 6) {
		double chance;
		chance = .1;//in case someone misclicks, give them easy mode
		//(if diff = 1 chance it .1 if diff = 2 then .2 if diff is 3 then .3;
		if (difficulty == 1){
		    chance = .1;
		}
		else if (difficulty == 2){
		    chance = .2;
		}
		 else if (difficulty == 3){
		     chance = .3;
		 }
		 else {
		 }
		 
		System.out.println ();
		System.out.print (" Choose a direction to move, or select (i) for movement instructions: ");
		String instructions = (" Press w to move up\n Press a to move right\n Press d to move right\n Press s to move down\n Press J to view inventory\n Press E to equip a weapon or to use an item\n Press p to print map, if not displayed\n  Travel to the nearest 'l' or 'b' to advance to the next level.");
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
		else if (direction == 'e') {
		    hero.equipScreen();
		    System.out.println (A);
		}
		else if (direction == 'p') {
		    System.out.println (A);
		}
		else if (direction == 'j') {
		    System.out.println(hero.displayInventory());
		    System.out.println (A);
		}
		else {
		    System.out.println ("THAT IS NOT AN OPTION. PAY THE PRICE");
		    battle();
		}
		if(Math.random() < chance){
		    monsterChoose();
		    battle();
		}
		
		if (hero.getHP() <=0){
		    level = 10;
		    start = false;
		}
		if (A.success == true) {
		    inventorySave = hero.inventory;
		    level++;
		    hpHolder = hero.HP + 100;
		    atkHolder = hero.atk;
		    defHolder = hero.def;
		    evasionHolder = hero.evasion;
		    if (level < 6) {
			A = new Map (level);
			A.playerName2 = this.playerName;
			A.userSpawn();
			System.out.println (A);
			hero = new Player(hpHolder,atkHolder,defHolder,evasionHolder,inventorySave);
		        if (level == 2) {
			    System.out.println (" You arrive at a town. Everyone is dead. It smells of his odor. You find a trail of blood. You start following it");
			}
			else if (level == 3) {
			    System.out.println (" You arrive at an abandoned PetLand. All the dogs are dead. That monster. He has to be stopped.");
			}
			else if (level == 4) {
			    System.out.println (" His house. There it is. Bayridge, Brooklyn. Typical. You lift up your " + hero.inventory.get(0).getName()+ ".");
			    System.out.println (" You walk inside.");
			}
			else {
			    System.out.println (" You feel it. It's him. The guy who did not care about your group project.");
			    System.out.println (" The guy that had to do his APUSH homework when you had a deadline the next day.");
			    System.out.println (" The guy who never did anything. ");
			    System.out.println (" You remember those dogs in Pentland.");
			    System.out.println (" It's time to get revenge. ");
			}
		    }
		}
		if( A.bossBattle == true){
		    drag = new Ganondorf(difficulty);
		    battle();
		}
		if(drag.getName() == "Ganondorf" && drag.getHP() <= 0){
		    level = 10;
		    start = false;
		    System.out.println("And with that, the journey has come to an end.");
		}
	    }
	}
    }
    
    // randomly instantiates a monster based on the difficulty chosen
    public void monsterChoose(){
	double prop = (Math.random() * 10);
	if (prop < 2.0)
	    drag = new Monster(difficulty);
	else if (prop < 4.0)
	    drag = new Goblin(difficulty);
	else if (prop < 6.0)
	    drag = new Shrek(difficulty);
	else if (prop < 8.0)
	    drag = new Shark(difficulty);
	else if (prop < 10.0)
	    drag = new TwelveYearOldKid(difficulty);
    }

    // method for running battles 
    public void battle(  ) {
	boolean battling = true;
	System.out.println("\n\n\n\n\n\n To battle, press a to do an attack against the monster and press d to defend instead.");
	System.out.println("A " + drag.getName() + " has appeared!");
	while(battling == true){
	    // next two blocks of code for checking for poisoning and/or paralysis
	    if (hero.poisoned == true){
		int poisonDamage = (int) (0.1 * hero.HP);
		hero.HP -= poisonDamage;
		hero.poisonedTurns -=1;
		System.out.println (" " + playerName + " loses " + poisonDamage + " from poison!!!");
		if (hero.poisonedTurns == 0) {
		    hero.poisoned = false;
		    System.out.println (" The poison has run out");
		}
	    }
	    if (hero.paralyzed == true){
		System.out.println(" " + playerName +" is paralyzed!\n " + playerName + " cannot attack or run!!!");
		hero.paralyzedTurns -=1;
		if (hero.paralyzedTurns == 0) {
		    hero.paralyzed = false;
		    System.out.println ((playerName) + " can move again!");
		}
		else {
		    System.out.print (" Would " + playerName + "  like to equip or use something?\n\t(y) yes\t(n)no\n " + playerName + " chooses: ");
		    char choose;
		    choose = Keyboard.readChar();
		    if (choose == 'y') {
			hero.equipScreen();
		    }
		    else {
			System.out.println (" You made your choice ;(");
		    }
		}
		dragAttack(hero);
	    }
	    // if hero is not paralyzed
	    else{
		    System.out.println("\n Hero's HP: "+ hero.getHP() + ".\n Enemy's HP: "+drag.getHP()+".");
		    System.out.println(" What will " + playerName + " do: \n\t(a) Attack\n\t(d) Defend\n\t(r) Run\n\t(s) Scan\n\t(e) Equip/Use ");
		    System.out.print (playerName +" will choose: ");
		    char choose;
		    choose = Keyboard.readChar();
		    if (choose == 'a'){
			String choices = "";
			int attackChoice;
			choices = "\n " + playerName+ " chooses  attack:\n" ;
			choices += "\t1: " + hero.attackName[0] + "\n";
			choices += "\t2: " + hero.attackName[1] + "\n";
			choices += "\t3: " + hero.attackName[2] + "\n";
			choices += "\t4: " + hero.attackName[3] + "\n";;
			System.out.println (choices);
			// player is choosing one of his moves
			System.out.print (" Selection: ");
			attackChoice = Keyboard.readInt();
			int damage = 0;
			if (attackChoice == 1) {
			    if (drag.getEvasion() < (int) (Math.random () * 100) ){
				damage = hero.attack1 (drag);
				System.out.print( "\n " + playerName + " used " + hero.attackName[attackChoice - 1] + ". " + playerName+ " dealt " + damage  +" points of damage." + "\n");
			    }
			    else { System.out.println (playerName + " missed the attack!!!");}
			}
			else if (attackChoice == 2) {
			    if (drag.getEvasion() < (int) (Math.random ()* 100) ){
				damage = hero.attack2 (drag);
				System.out.print( "\n " + playerName + " used " + hero.attackName[attackChoice - 1] + ". " + playerName + " dealt" + damage  +" points of damage." + "\n");
			    }
			    else { System.out.println (" " + playerName + " missed the attack!!!");}
			}
			else if (attackChoice == 3) {
			    if (drag.getEvasion() < (int) (Math.random ()* 100) ){
				damage = hero.attack3 (drag);
				System.out.print( "\n " + playerName + " used " + hero.attackName[attackChoice - 1]+ ". " + playerName+ " dealt" + damage  +" points of damage." + "\n");
			    }
			    else { System.out.println (" " + playerName + " missed the attack!!!");}
			}
			else if (attackChoice == 4) {
			    if (drag.getEvasion() < (int) (Math.random ()*100) ){
			    damage= hero.attack4 (drag);
			    System.out.print( "\n " + playerName + " used " + hero.attackName[attackChoice - 1] + ". " + playerName+ " dealt" + damage   +" points of damage." + "\n");
			    }
			    else { System.out.println (" " + playerName + " missed the attack!!!");}
			}
			else {
			    System.out.println (" " + playerName + "  doesn't know that move....");
			}
			dragAttack(hero);
		    }
		    else if (choose == 'd'){
			hero.defend();
			dragAttack(hero);
		    }
		    else if (choose == 'r'){
			if (hero.run() == true) {
			    if (hero.HP < 500) {
				hero.HP += 50;
			    }
			    System.out.println(hero.getName() + " escaped! Sadly, you dropped your XP and potential loot behind.");
			    battling = false;
			    System.out.println(A);
			}
			else {
			    dragAttack(hero);
			}
		    }
		    else if (choose == 's'){
			System.out.println(" Time for some stats: ");
			hero.seeStats();
			drag.seeStats();
		    }
		    else if (choose== 'e') {
			hero.equipScreen();
		    }
		    else {
			System.out.println (" THAT IS NOT AN OPTION. PAY THE PRICE\n");
			dragAttack(hero);
		    }
	    }
	    if (hero.getHP() <= 0) {
		System.out.println ("\n " + playerName + " loses");
		battling = false; 
	    }else
		if (drag.getHP() <= 0) {
		    System.out.println (" You won");
		    hero.inventoryCheck(drag);
		    if (hero.getEXP() >= hero.getNeededEXP()){
			hero.levelUp();
		    }
		    System.out.println(A);
		    battling=false;
		    if (hero.HP < 500) {
			hero.HP += 100;
		    }
		}
	}
    }
    
    //incorporate random attacks into here
    public void dragAttack(Character opponent) {
	if (drag.poisoned == true){
	    drag.HP -= (int) (0.1 * hero.HP);
	    drag.poisonedTurns -=1;
	    if (drag.poisonedTurns == 0) {
		drag.poisoned = false;
		System.out.println (" " + drag.getName() + " is no longer poisoned");
	    }
	}
	if (drag.paralyzed == true){
	    System.out.println(" " + drag.getName() + "  can't move!");
	    drag.paralyzedTurns -=1;
	    if (drag.paralyzedTurns == 0) {
		drag.paralyzed = false;
		System.out.println (" " + drag.getName() + " can move again!");
	    }
	}
	else {
	    if (opponent.getEvasion() < (int) (Math.random() * 100)) {
		int monDam = 0;
		int determinant = (int) (Math.random() * 4);
		if (determinant == 0){
		    monDam = drag.attack1(hero);
		}
		else if (determinant == 1) {
		    monDam = drag.attack2(hero);
		}
		else if (determinant == 2) {
		    monDam = drag.attack3(hero);
		}
		else if (determinant == 3) {
		    monDam = drag.attack4(hero);
		}
		else {
		    monDam = drag.attack1 (hero);
		}
		System.out.print( "\n "+drag.getName()+" used " + drag.attackName[0] + ". It dealt " + monDam + " points of damage." + "\n");
	    }
	    else {
		System.out.println (playerName + " dodged " + drag.getName() + "'s attack!!");
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
	System.out.print(" I choose: ");
	choice1 = Keyboard.readInt();
	if (choice1 == 0) {
	    return;
	}
	else if (choice1 != 1 && choice1 != 0) {
	    System.out.println ("restart\n");
	    start = false;
	}
	else {
	    start = true;
	    System.out.println (" WHAT IS YOUR NAME?");
	    System.out.print (" It is: ");
	    choice2= Keyboard.readString();
	    this.playerName = choice2;
	    System.out.println (" How is " + playerName + " feeling today?\n (1) crappy\n (2) okay\n (3) hard \n");
	    System.out.print (" " + playerName + " feels: ");
	    choice3 = Keyboard.readInt();
	    difficulty = choice3;
	    if (choice3 > 3 || choice3 < 1) {
		System.out.println ("Restart the game b");
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

	    
	
    

	    
	
    


	    

	
    
