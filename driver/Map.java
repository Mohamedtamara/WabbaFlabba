import java.util.ArrayList;

public class Map {
    public ArrayList [] test = new ArrayList [9];
   
    public Map () {
       	for (int i = 0; i < test.length; i ++) {
	    test [i] = new ArrayList <Character>();
	}
	/*	test [0] = new ArrayList <Character>();
	test [1] = new ArrayList <Character>();
	test [2] = new ArrayList <Character>();
	test [3] = new ArrayList <Character>();
	test [4] = new ArrayList <Character>();
	test [5] = new ArrayList <Character>();
	test [6] = new ArrayList <Character>();
	test [7] = new ArrayList <Character>();
	test [8] = new ArrayList <Character>();
	*/

	    //	}
	/*	test[0].add('*');
	test[1].add('*');
	test[2].add('*');
	test[3].add('*');
	test[4].add('*');
	test[5].add('*');
	test[6].add('*');
	test[7].add('*');
       	test[8].add('*');
	*/
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

    public static void main (String [] args) {
	ArrayList glen = new ArrayList ();
	glen.add("Hello");
        Map one = new Map ();
	System.out.println (one);
	System.out.println (glen);
    }
}
