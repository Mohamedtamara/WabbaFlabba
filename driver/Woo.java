import cs1.Keyboard;

public class Woo{


    public static void main(String[] args){
	int choose = 0;
	System.out.println("Wanna C some wild stuff?\nPress 1 for maps, press 2 for a battle.");
choose = Keyboard.readInt();
	if(choose < 1 || choose > 2){
	    throw new ClassException("What the hell bro you had 1 job. It's either 1 or 2.");
	}
	if(choose == 1){
	    Map A = new Map();
	    for( int i = 0; i < 4; i++){
		A.move();
	    }
	}
    }
}

