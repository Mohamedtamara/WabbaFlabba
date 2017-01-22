import java.util.ArrayList;

public class Map {
    int playerXpos;
    int playerYpos;
    int mapLength;
    int mapWidth;
    boolean success = false;
    boolean bossBattle = false;

    public ArrayList [] test = new ArrayList [20];

    public Map(int mapNum) {
	if (mapNum == 1) {
	    mapWidth = 11;
	    playerXpos = 5;
	    playerYpos = 5;
	    border(); 
	    levelPlace(1,9);
	}
	//actually for 5
	// actually for 2
	else if (mapNum == 2) {
	    mapWidth = 12;
	    playerXpos = 1;
	    playerYpos = 6;
	    border();
	    swapPlace (8,1);
	    swapPlace (8,3);
	    swapPlace (9,3);
	    swapPlace (10,3);
	    swapPlace (10,8);
	    swapPlace (9,8);
	    swapPlace (8,8);
	    swapPlace (8,10);
	    swapPlace (1,3);
	    swapPlace (2,3);
	    swapPlace (3,3);
	    swapPlace (3,1);
	    swapPlace (1,8);
	    swapPlace (2,8);
	    swapPlace (3,8);
	    swapPlace (3,10);
	    levelPlace(10,10);
	}
	// actually for 3
	else if (mapNum == 3) {
	    mapWidth = 13;
	    playerXpos = 1;
	    playerYpos = 6;
	    border();
	    swapPlace (4,3);
	    swapPlace (5,3);
	    swapPlace (7,3);
	    swapPlace (8,3);
	    swapPlace (4,4);
	    swapPlace (4,7);
	    swapPlace (4,8);
	    swapPlace (5,8);
	    swapPlace (7,8);
	    swapPlace (8,8);
	    swapPlace (8,7);
	    swapPlace (8,4);
	    swapPlace (9,4);
	    swapPlace (11,4);
	    swapPlace (11,7);
	    swapPlace (9,7);
	    swapPlace (8,7);
	    swapPlace (3,4);
	    swapPlace (1,4);
	    swapPlace (3,7);
	    levelPlace (11,11);
	}
	else if (mapNum == 4) {
	    mapWidth = 15;
	    playerXpos = 1;
	    playerYpos = 13;
	    border();
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
	    swapPlace(3,10);
	    swapPlace(4,11);
	    swapPlace(5,11);
	    swapPlace(6,11);
	    swapPlace(7,11);
	    swapPlace(8,11);
	    swapPlace(9,11);
	    swapPlace(10,11);
	    swapPlace(11,11);
	    swapPlace(11,10);
	    swapPlace(11,9);
	    swapPlace(11,8);
	    swapPlace(11,7);
	    swapPlace(12,7);
	    swapPlace(13,7);
	    levelPlace(13,13);
	}
	else if (mapNum == 5) {
	    mapWidth = 15;
	    border();
	    playerXpos = 7;
	    playerYpos = 6;
	    finalAnimation();
	}
	    
	else {
	    return;
	}
    }

    public void border() {
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
		test [x].add('.');
		filler++;
	    }
	}
	for (int x = 0; x <mapWidth-1; x++) {
	    test[x].remove(0);
	    test[x].remove(test[x].size() - 1);
	    test[x].add(0,'x');
	    test[x].add('x');
	}
    }
	
    public void swapPlace(int index, int index2) {
	test[index].remove(index2);
	test[index].add(index2,'x');
    }

    public void levelPlace (int index, int index2) {
	test[index].remove(index2);
	test[index].add(index2,'l');
    }

    public void bossPlace (int index, int index2) {
	test[index].remove(index2);
	test[index].add(index2,'b');
    }

    
    public String toString() {
	String retStr = "";
	int x = 0;
	while (x < mapWidth) {
	    retStr += arrayListToString(test[x]);
	    retStr += "\n";
	    x++;
	}
	return retStr;
    }

    public String arrayListToString (ArrayList felipe) {
	String result = "[";
	for (int i = 0; i < felipe.size(); i++) {
	    if (i == felipe.size() - 1) {
		result += felipe.get(i);
	    }
	    else {
		result += felipe.get(i) + "  ";
	    }
	}
	result += "]";
	return result;
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
	if ((char) test[playerYpos].get(playerXpos) == 'l') {
	    this.success = true;
	    System.out.println ("You have moved on to the next level!!!");
	}
	if ((char) test[playerYpos].get(playerXpos) == 'b') {
	    this.bossBattle = true;
	    System.out.println ("He has awoken");
	}
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
	if ((char) test[playerYpos].get(playerXpos) == 'l') {
	    this.success = true;
	    System.out.println ("You have moved on to the next level!!!");
	}
        
	System.out.println (this);
    }

    public void finalAnimation() {
	swapPlace(3,4);
	transition();
	//
	swapPlace(3,3);
	transition();
	swapPlace(3,2);
	transition();
	swapPlace(4,2);
	transition();
	swapPlace(5,2);
	transition();
	swapPlace(6,2);
	transition();
	swapPlace(7,2);
	transition();
	swapPlace(8,2);
	transition();
	swapPlace(9,2);
	transition();
	swapPlace(10,2);
	transition();
	swapPlace(10,3);
	transition();
	swapPlace(10,4);
	transition();
	swapPlace (9,4);
	transition();
	swapPlace(8,4);
	transition();
	swapPlace(8,3);
	transition();
	//
	swapPlace(10,6);
	transition();
	swapPlace(10,7);
	transition();
	swapPlace(10,8);
	transition();
	swapPlace(9,6);
	transition();
	swapPlace(8,6);
	transition();
	swapPlace(8,7);
	transition();
	swapPlace(8,8);
	transition();
	swapPlace(9,8);
	transition();
	swapPlace(7,6);
	transition();
	swapPlace(6,6);
	transition();
	swapPlace(5,6);
	transition();
	swapPlace(4,6);
	transition();
	swapPlace(3,6);
	transition();
	swapPlace(3,7);
	transition();
	swapPlace(3,8);
	transition();
	//
	swapPlace(3,10);
	transition();
	swapPlace(3,11);
	transition();
	swapPlace(3,12);
	transition();
	swapPlace(4,10);
	transition();
	swapPlace(5,10);
	transition();
	swapPlace(6,10);
	transition();
	swapPlace(7,10);
	transition();
	swapPlace(8,10);
	transition();
	swapPlace(9,10);
	transition();
	swapPlace(10,10);
	transition();
	swapPlace(10,11);
	transition();
	swapPlace(10,12);
	transition();
	swapPlace(9,12);
	transition();
	swapPlace(8,12);
	transition();
	swapPlace(8,11);
	transition();
	bossPlace (13,7);
	transition();
    }

    public void transition() {
        try {
	    Thread.sleep(500);
	}
	catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
	System.out.println (this);
    }
	
	
        
	
    public static void main (String [] args) {
	//testing methods, replace the integer in the constructor with a number less than or equal to the highest possible
	/* testing method for final map
	Map five = new Map (5);
	five.userSpawn();
	System.out.println (five);
	five.finalAnimation();
	System.out.println (five);
	*/

	Map four = new Map (4);
	four.userSpawn();
	System.out.println(four);
	
	
    }
}
