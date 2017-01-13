import cs1.Keyboard;

public class Woo{


    public static void main(String[] args){
	int choose = 0;
	System.out.println("To move on the map, press the w key to move up, the a key to move left, s to move down, and d to move down. To exit the game, write the word exit.");
	Map A = new Map();
	A.userSpawn();
	
	boolean exit = false;
	while(!exit){
	    String direction = Keyboard.readString();
	    if(direction == "w"){
		A.userMove(1);
		System.out.println(A);
	    }else
	    if(direction == "d"){
		A.userMove(2);
		System.out.println(A);
	    }else
	    if(direction == "s"){
		A.userMove(3);
		System.out.println(A);
	    }else
	    if(direction == "a"){
		A.userMove(4);
		System.out.println(A);
	    }else
	    if(direction == "exit"){
		exit = true;
	    }
	}
    }
}

	    

	
    



