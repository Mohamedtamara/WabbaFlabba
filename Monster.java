public class Monster extends Character{

    public Monster(){
	HP = origHP = 70;
	atk = origAtk = tempAtk = 10;
	def = origDef = tempDef = 5;
        evasion = tempEvasion =  origEvasion = 10;
	state = 0;
	attackName[0]="Attack"; //Attack 1
	attackName[1]="Stone Gaze"; //Attack 2
	attackName[2]="Molest";//Attack 3
	attackName[3]="Sting";//Attack 4
	ID = 1; //For identification purposes
    }

    public Monster(int difficulty){
	if (difficulty == 1){
	    HP = origHP = 70;
	    atk = origAtk = tempAtk = 10;
	    def = origDef = tempDef = 5;
	    evasion = tempEvasion =  origEvasion = 10;
	}
	if (difficulty == 2){
	    HP = origHP = 140;
	    atk = origAtk = tempAtk = 15;
	    def = origDef = tempDef = 10;
	    evasion = tempEvasion =  origEvasion = 15;
	}
	if (difficulty == 3){
	    HP = origHP = 210;
	    atk = origAtk = tempAtk = 20;
	    def = origDef = tempDef = 15;
	    evasion = tempEvasion =  origEvasion = 15;
	}
	state = 0;
	attackName[0]="Attack"; //Attack 1
	attackName[1]="Stone Gaze"; //Attack 2
	attackName[2]="Molest";//Attack 3
	attackName[3]="Sting";//Attack 4
	ID = 1; //For identification purposes
    }
    /*
      public Goblin(){
      HP = origHP = 40;
      atk = origAtk = tempAtk = 12;
      def = origDef = tempDef = 6;
      evasion = tempEvasion =  origEvasion = 8;
      state = 0;
      attackName[0]="Attack"; //Attack 1
      attackName[1]="Multi Bite"; //Attack 2
      attackName[2]="Sheer Heart Attack";//Attack 3
      attackName[3]="Pin Strike";//Attack 4
      ID = 2; //For identification purposes
      }

      public TwelveYearOldKid(){
      HP = origHP = 420;
      atk = origAtk = tempAtk = 20;
      def = origDef = tempDef = 20;
      evasion = tempEvasion =  origEvasion = 20;
      state = 0;
      attackName[0]="NO SCOPED"; //Attack 1
      attackName[1]="Doritoes & Mountain Dew"; //Attack 2
      attackName[2]="Microphone Screech";//Attack 3
      attackName[3]="420 BLAZE IT";//Attack 4
      ID = 3; //For identification purposes
      }

      public Shark(){
      HP = origHP = 80;
      atk = origAtk = tempAtk = 18;
      def = origDef = tempDef = 8;
      evasion = tempEvasion =  origEvasion = 5;
      state = 0;
      attackName[0]="Great White Bite"; //Attack 1
      attackName[1]="Hammerhead"; //Attack 2
      attackName[2]="A Whale of a Time";//Attack 3
      attackName[3]="Splash";//Attack 4
      ID = 4; //For identification purposes
      }

      public Shrek(){
      HP = origHP = 120;
      atk = origAtk = tempAtk = 14;
      def = origDef = tempDef = 10;
      evasion = tempEvasion =  origEvasion = 16;
      state = 0;
      attackName[0]="Layers of Onions"; //Attack 1
      attackName[1]="The Fibonacchi Sequence"; //Attack 2
      attackName[2]="DON KAY";//Attack 3
      attackName[3]="Shrek Super-Slam";//Attack 4
      ID = 5; //For identification purposes
      }
    */
    public void attack(Character w){
	int damage = (int)(Math.abs(atk - w.getTempDefense()));
	w.lowerHP(damage);
	System.out.println("Ouch! The Monster did " + damage + "damage to you. Better watch out!");
    }

    public void defend() {
	tempDef = (int) (def * 1.5);
    }

    public void seeStats(){
	System.out.println("For da bad dude: ");
	System.out.println("HP: " + this.getHP() + ".");
	System.out.println("Attack: " + this.getAttack() + ".");
	System.out.println("Defense: " + this.getDefense() + ".");
	System.out.println("Evasion: " + this.getEvasion() + ".\n");
    }
    
}
	
