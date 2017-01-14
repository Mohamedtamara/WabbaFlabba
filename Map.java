import java.util.ArrayList;

public class Map {
    int playerXpos = 5;
    int playerYpos = 5;
    int mapLength;
    int mapWidth;

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
	mapLength = 11;
	mapWidth = 11;
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
	test[oldPlayerYpos].add(oldPlayerXpos, 'm');
	test[playerYpos].remove(playerXpos);
	if (movementSignal == 1) {
	    test[playerYpos].add(playerXpos,'o');
	    System.out.println ("Character has moved one unit up");
	}
	else if (movementSignal == 2) {
	    test[playerYpos].add(playerXpos, 'o');
	    System.out.println ("Character has moved one unit right!");
	}
	else if (movementSignal == 3) {
	    test [playerYpos].add(playerXpos, 'o');
	    System.out.println ("Character has moved one down!");
	}
	else {
	    test[playerYpos].add(playerXpos, 'o');
	    System.out.println ("Character has moved one unit to the left!");
	}
	if (test[playerYpos].size()  < mapWidth) {
	    test[playerYpos].add('*');
	}
	System.out.println (this);
    }
	
        
	
    public static void main (String [] args) {
	ArrayList glen = new ArrayList ();
	glen.add("Hello");
        Map one = new Map ();
	System.out.println (glen);
	one.userSpawn();
	one.userMove(4);
	one.userMove(3);
	one.userMove(2);
	one.userMove(3);
	one.userMove(2);
	one.userMove(5);
	one.userMove(4);
	one.userMove(1);
	one.userMove(3);
	one.userMove(4);
	one.userMove(4);
	one.userMove(1);
	one.userMove(2);
	one.userMove(2);
	one.userMove(3);
	one.userMove(4);
	one.userMove(4);
	one.userMove(1);
	one.userMove(1);
	one.userMove(1);
	one.userMove(1);
	one.userMove(4);
	one.userMove(2);
	one.userMove(2);
	one.userMove(2);
	one.userMove(2);
	
    }
}
