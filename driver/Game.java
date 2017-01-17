import cs1.Keyboard;

public class Game{
    int choose = 0;
    public void startMenu(){
	System.out.println("Wanna C some wild stuff? press 1 for maps, press 2 for a battle.");
	choose = Keyboard.readInt();
	if(choose < 1 || choose > 2){
	    throw new ClassException("What the hell bro you had 1 job. It's either 1 or 2.");
	}
	if(choose == 1){
	    Map A = new map();
	}
    }
}


