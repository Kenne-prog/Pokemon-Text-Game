import java.util.Random;
/**
/**
* Class for Fire moves and damage of a Fire type Pokemon object
*/
public class Fire extends Pokemon{
  /**
  * Constructs a fire pokemon
  * @param String n is the name
  * @param h is the health 
  * @param m is the maxHp
  */
  public Fire(String n, int h, int m){
    super(n, h, m);
  }
  /**
  * Displays the moves based on the atkType
  * @param atkType - either 1 or 2 depending on the 
  * the attack is special or not.
  * @return the menus of the moves as a string
  */
  @Override
  public String getAttackMenu(int atkType){
    if(atkType == 1){
      return super.getAttackMenu(atkType);
    }
    else{
      String special_menu = "";
      special_menu += "1.Ember\n2.Fire Blast\n3.Fire Punch";
      return special_menu;
    }
  }
  /**
  * The number of moves the trainer can choose from
  * @param atkType - either 1 or 2 depending on the 
  * the attack is special or not.
  * @return the number of moves the pokemon has
  */
  @Override
  public int getNumAttackMenuItems(int atkType){
    if (atkType == 1){
      return super.getNumAttackMenuItems(atkType);
    }
    else{
      return 3;
    }
  }
  /**
  * Displays the attack based on the move the trainer 
  * chose
  * @param atkType - either 1 or 2 depending on the 
  * the attack is special or not.
  * @param move is the move the trainer chose
  * @return the attack of the pokemon
  */
  @Override
  public String getAttackString(int atkType, int move){
    if (atkType == 1){
      return super.getAttackString(atkType, move);
    }
    else{
      String fire_string = "";
      int poke_type = getType();
      if (poke_type == 0){
        if (move == 1){
          fire_string += " is encased in EMBERS ";
        }
        else if (move == 2){
          fire_string += " is BLASTED with FIRE ";
        }
        else {
          fire_string += " is PUNCHED with FIRE ";
        }
      }
      return fire_string;
    }
  }
  /**
  * Gets the damage of the move
  * @param atkType - either 1 or 2 depending on the 
  * the attack is special or not.
  * @param move is the move the trainer chose
  * @return the damage the move does
  */
  @Override
  public int getAttackDamage(int atkType, int move){
    if (atkType == 1){
      return super.getAttackDamage(atkType, move);
    }
    else{
      if (move == 1){
        Random rand = new Random();
        int ember_damage = rand.nextInt(4);
        return ember_damage;
      }
      else if(move == 2){
        int fireBlast_damage = (int)((Math.random() * 4) + 1);
        return fireBlast_damage;
      }
      else{
        int firePunch_damage = (int)((Math.random() * 3) + 1);
        return firePunch_damage;
      }
    }
  }
  /**
  * Based on the typing the damage of the move will be 
  * halved or doubled
  * @param Pokemon p is the pokemon getting attacked
  * @param atkType - either 1 or 2 depending on the 
  * the attack is special or not.
  * @return is the multiplier 
  */
  @Override
  public double getAttackMultiplier(Pokemon p, int atkType){
    if (atkType == 1){
      return super.getAttackMultiplier(p, atkType);
    }
    else{
      return p.battleTable[0][p.getType()];
    }
  }
}