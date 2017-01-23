public class Ganondorf extends Monster{
    public Ganondorf(){
	HP = origHP = 500;
	atk = origAtk = tempAtk = 32;
	def = origDef = tempDef = 20;
	evasion = tempEvasion = origEvasion = 19;
	state = 0;
	attackName[0]="Slash"; // basic attack
	attackName[1]= "Eye Lasers";//If possible chance to paralyze, or set #
	attackName[2] = "Bottle Volley";// literally nothing but makes you question everything;
	attackName[3] = "Drink Milk";// heals him for like 20 HP
	ID = 5;
	name = "Ganondorf";
	int determinant = (int) (Math.random() * 6);
	inventory.add ( new Weapon (determinant) );
	equip ((Weapon) inventory.get(0));
    }

      public Ganondorf(int difficulty){
	  if (difficulty == 1){
	      HP = origHP = 500;
	      atk = origAtk = tempAtk = 32;
	      def = origDef = tempDef = 20;
	      evasion = tempEvasion = origEvasion = 19;
	  }else
	  if (difficulty == 2){
	      HP = origHP = 700;
	      atk = origAtk = tempAtk = 38;
	      def = origDef = tempDef = 25;
	      evasion = tempEvasion = origEvasion = 25;
	  }else
	  if (difficulty == 3){
	      HP = origHP = 900;
	      atk = origAtk = tempAtk = 44;
	      def = origDef = tempDef = 30;
	      evasion = tempEvasion = origEvasion = 31;
	  }
	  state = 0;
	  attackName[0]="Slash"; // basic attack
	  attackName[1]= "Eye Lasers";//If possible chance to paralyze, or set #
	  attackName[2] = "Bottle Volley";// literally nothing but makes you question everything;
	  attackName[3] = "Drink Milk";// heals him for like 20 HP
	  ID = 5;
	  name = "Ganondorf";
	  int determinant = (int) (Math.random() * 6);
	  inventory.add ( new Weapon (determinant) );
	  equip ((Weapon) inventory.get(0));
    }
    

    public int attack1(Character w){
	int damage = (int)(atk - w.getTempDefense());
	if (damage <= 0){
	    damage = 0;
	}
	w.lowerHP(damage);
        return damage;
    }

    public int attack2(Character w){
	int damage = (int)(atk - w.getTempDefense());
	if (damage <= 0){
	    damage = 0;
	}
	w.lowerHP(damage);
	poison(w);
        return damage;
    }

    public int attack3(Character w){
	int damage = (int)(atk - w.getTempDefense());
	if (damage <= 0){
	    damage = 0;
	}
	w.lowerHP(damage);
	paralyze(w);
        return damage;
    }

    public int attack4(Character w){
	int heal = 20;
	if (HP + heal >= origHP){
	    HP = origHP;
	}
	
        return 0;
    }
}


    
    
	
    
    
