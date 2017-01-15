import java.util.ArrayList;

public class Map {
    int playerXpos = 5;
    int playerYpos = 5;
    int mapLength;
    int mapWidth;

    public ArrayList [] test = new ArrayList [20];
   
    public Map () {
	mapWidth = 11;
       	for (int i = 0; i <mapWidth; i ++) {
	    test [i] = new ArrayList <Character>();
	}
	for (int x = 0; x<mapWidth; x++) {
	    test[0].add('x');
	    test[mapWidth-1].add('x');
	}
	for (int x = 1; x <mapWidth-1; x ++) {
	    int filler = 0;
	    while (filler < mapWidth) {
		test [x].add('*');
		filler++;
	    }
	}
	for (int x = 0; x <mapWidth-1; x++) {
	    test[x].remove(0);
	    test[x].remove(test[x].size() - 1);
	    test[x].add(0,'x');
	    test[x].add('x');
	}
	levelPlace(1,9);
	
    }

     public Map(int mapNum) {
	if (mapNum == 1) {
	    mapWidth = 15;
	    for (int i = 0; i <mapWidth; i ++) {
		test [i] = new ArrayList <Character>();
	    }
	    for (int x = 0; x<mapWidth; x++) {
		test[0].add('x');
		test[mapWidth-1].add('x');
	    }
	    for (int x = 1; x <mapWidth-1; x ++) {
		int filler = 0;
		while (filler < mapWidth) {
		    test [x].add('*');
		    filler++;
		}
	    }
	    for (int x = 0; x <mapWidth-1; x++) {
		test[x].remove(0);
		test[x].remove(test[x].size() - 1);
		test[x].add(0,'x');
		test[x].add('x');
	    }
	    swapPlace(9,2);
	    swapPlace(8,2);
	    swapPlace(7,2);
	    swapPlace(7,3);
	    swapPlace(7,4);
	    swapPlace(7,5);
	    swapPlace(8,5);
	    swapPlace(9,5);
	    swapPlace(9,2);
	    swapPlace(1,2);
	    swapPlace(1,6);
	    swapPlace(2,2);
	    swapPlace(2,6);
	    swapPlace(2,3);
	    swapPlace(2,5);
	    swapPlace(3,6);
	    swapPlace(6,6);
	    swapPlace(7,7);
	    swapPlace(8,7);
	    swapPlace(9,7);
	    swapPlace(3,7);
	    swapPlace(3,9);
	    levelPlace(13,13);
	}
	else {
	    return;
	}
	mapWidth = 15;
    }
	
    public void swapPlace(int index, int index2) {
	test[index].remove(index2);
	test[index].add(index2,'x');
    }

    public void levelPlace (int index, int index2) {
	test[index].remove(index2);
	test[index].add(index2,'l');
    }

    
    public String toString() {
	String retStr = "";
	int x = 0;
	while (x < mapWidth) {
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
	    if ((char) test[playerYpos - 1].get(playerXpos) == 'x') {
		System.out.println ("ERROR 404: access denied");
		return;
	    }
	}
	else if (movementSignal == 2) {
	    if ((char) test[playerYpos].get(playerXpos+1) == 'x') {
		System.out.println ("ERROR 404: access denied");
		return;
	    }
	}
	else if (movementSignal == 3) {
	    if ((char) test[playerYpos + 1].get(playerXpos) == 'x') {
		System.out.println ("ERROR 404: access denied");
		return;
	    }
	}
	else if (movementSignal == 4) {
	    if ((char) test[playerYpos].get(playerXpos - 1) == 'x') {
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
        Map one = new Map ();
	System.out.println (one);
	Map two = new Map (1);
	System.out.println (two);
	
	
    }
}
