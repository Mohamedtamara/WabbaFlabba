import java.util.ArrayList;

public class Map {
    int playerXpos = 5;
    int playerYpos = 5;

    public ArrayList [] test = new ArrayList [9];
   
    public Map () {
       	for (int i = 0; i < test.length; i ++) {
	    test [i] = new ArrayList <Character>();
	}
	for (int x = 0; x < test.length; x ++) {
	    int exes = 0;
	    while (exes < 10) {
		test [x].add('*');
		exes++;
	    }
	}
    }
    
    public String toString() {
	String retStr = "";
	int x = 0;
	while (x < 9) {
	    retStr += test [x];
	    retStr += "\n";
	    x++;
	}
	return retStr;
    }
    
    public void moveUp () {
	playerYpos = playerYpos + 1;
    }
    
    public void moveLeft () {
	playerXpos = playerXpos - 1;
    }
    
    public void moveRight () {
	playerYpos = playerXpos + 1;
    }
    
    public void moveDown () {
	playerYpos = playerYpos - 1;
    }
    
    public void visualMove () {
	test[playerYpos].remove(playerXpos);
	test[playerYpos].add(playerXpos, 'o');
    }
	

    public static void main (String [] args) {
	ArrayList glen = new ArrayList ();
	glen.add("Hello");
        Map one = new Map ();
	System.out.println (one);
	System.out.println (glen);
	one.visualMove ();
	System.out.println (one);
	one.moveLeft();
	System.out.println (one);
    }
}
