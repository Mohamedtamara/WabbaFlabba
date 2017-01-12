import java.util.ArrayList;

public class Map {
    int playerXpos = 5;
    int playerYpos = 5;

    public ArrayList [] test = new ArrayList [11];
   
    public Map () {
       	for (int i = 0; i < test.length; i ++) {
	    test [i] = new ArrayList <Character>();
	}
	for (int x = 0; x < test.length; x ++) {
	    int exes = 0;
	    while (exes < 11) {
		test [x].add('*');
		exes++;
	    }
	}
    }
    
    public String toString() {
	String retStr = "";
	int x = 0;
	while (x < 11) {
	    retStr += test [x];
	    retStr += "\n";
	    x++;
	}
	return retStr;
    }
    
    public void moveUp () {
	playerYpos --; 
    }
    
    public void moveLeft () {
	playerXpos --; 
    }
    
    public void moveRight () {
       	playerXpos ++;
    }
    
    public void moveDown () {
	playerYpos ++;
    }
    
    public void userSpawn () {
	test[playerYpos].remove(playerXpos);
	test[playerYpos].add(playerXpos, 'o');
	System.out.println (this);
    }

    public void userMove(int movementSignal) {
	int oldPlayerYpos = playerYpos;
	int oldPlayerXpos = playerXpos;
	/*
	// Testing	
	System.out.println ("playerXpos = " + playerXpos);
	System.out.println ("playerYpos = " + playerYpos);
	System.out.println ("oldPlayerXpos = " + oldPlayerXpos);
	System.out.println ("oldPlayerYpos = " + oldPlayerYpos);
	System.out.println();
	*/
	test[playerYpos].remove(playerXpos);
	if (movementSignal == 1) {
	    moveUp();
	}
	else if (movementSignal == 2) {
	    moveRight();
	}
	else if (movementSignal == 3) {
	    moveDown();
	}
	else if (movementSignal == 4) {
	    moveLeft();
	}
	else {
	    System.out.println ("NO! follow the instructions\n");
	    return;
	}
	test[playerYpos].remove(playerXpos);
	if (movementSignal == 2) {
	    test[playerYpos].add(playerXpos - 1, 'o');
	    System.out.println ("Character has moved one unit to the right!");
	}
	else if (movementSignal == 4) {
	    test[playerYpos].add(playerXpos, 'o');
	    test[playerYpos].add(playerXpos + 1, '*');
	    System.out.println ("Character has moved one unit to the left!");
	}
	else if (movementSignal == 1) {
	    test [playerYpos].add(playerXpos, 'o');
	    System.out.println ("Character has moved one unit up!");
	}
	else {
	    System.out.println ("Character has moved one unit down!");
	    test[playerYpos].add(playerXpos, 'o');
	}
	test[oldPlayerYpos].add(oldPlayerXpos, 'm');
	System.out.println (this);
		/*
	// Testing	
	System.out.println ("playerXpos = " + playerXpos);
	System.out.println ("playerYpos = " + playerYpos);
	System.out.println ("oldPlayerXpos = " + oldPlayerXpos);
	System.out.println ("oldPlayerYpos = " + oldPlayerYpos);
	System.out.println();
	*/
    }
	
        
	
	

    public static void main (String [] args) {
	ArrayList glen = new ArrayList ();
	glen.add("Hello");
        Map one = new Map ();
	System.out.println (glen);
	one.userSpawn();
	one.userMove(3);
	one.userMove(2);
	one.userMove(3);
	one.userMove(2);
	one.userMove(5);
	one.userMove(4);
	one.userMove(1);
    }
}
