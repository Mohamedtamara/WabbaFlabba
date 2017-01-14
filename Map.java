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
	for (int x = 0; x< test.length; x++) {
	    test[0].add('x');
	    test[10].add('x');
	}
	for (int x = 1; x < test.length-1; x ++) {
	    int filler = 0;
	    while (filler < 11) {
		test [x].add('*');
		filler++;
	    }
	}
	for (ArrayList o : test) {
	    o.remove(0);
	    o.remove(o.size()-1);
	    o.add(0,'x');
	    o.add('x');
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
	if (movementSignal == 1) {
	    if (test[playerYpos - 1].get(playerXpos) == 'x') {
		System.out.println ("ERROR 404: access denied");
		return;
	    }
	}
		else if (movementSignal == 2) {
	    if (test[playerYpos].get(playerXpos+1) == 'x') {
		System.out.println ("ERROR 404: access denied");
		return;
	    }
	}
	else if (movementSignal == 3) {
	    if (test[playerYpos + 1].get(playerXpos) == 'x') {
		System.out.println ("ERROR 404: access denied");
		return;
	    }
	}
	else if (movementSignal == 4) {
	    if (test[playerYpos].get(playerXpos - 1) == 'x') {
		System.out.println ("ERROR 404: access denied");
		return;
	    }
	}
	else {
	    System.out.println ("NO! follow the instructions\n");
	    return;
	}
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
	System.out.println (one);
	
    }
}
