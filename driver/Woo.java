import cs1.Keyboard;

public class Woo{
    


    public static void main(String[] args){
	char choose;
	
	Monster drag = new Monster();
	Player hero = new Player();
	System.out.println("To move on the map, press the w key to move up, the a key to move left, s to move down, and d to move down. To exit the map and go to a battle, write e.");
	Map A = new Map();
	A.userSpawn();
        char direction;
	boolean battle = false;
	boolean exit = false;
	while(!exit){
	    direction = Keyboard.readChar();
	    if(direction == 'w'){
		A.userMove(1);
		System.out.println(A);
	    }else
	    if(direction == 'd'){
		A.userMove(2);
		System.out.println(A);
	    }else
	    if(direction == 's'){
		A.userMove(3);
		System.out.println(A);
	    }else
	    if(direction == 'a'){
		A.userMove(4);
		System.out.println(A);
	    }else
	    if(direction == 'e'){
		battle = true;
		exit = true;
	    }
	}
	   System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n To battle, press a to do an attack against the monster and press d to defend instead.");
        while(battle){
	    System.out.println("you have "+ hero.getHP() + ". The enemy has "+drag.getHP()+".");
	    System.out.println("Will you attack (a) or defend (d)?");
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
	    System.out.println("you had "+hero.getHP() + ". The enemy had " + drag.getHP());
	}
	}
    }
}
		
	       

	    
	
    


	    

	
    



