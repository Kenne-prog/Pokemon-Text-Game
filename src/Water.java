/**
* Class for Water moves and damgage of Water type pokemon
*/
public class Water extends Pokemon{
 /**
  * Constructs a water pokemon
  * @param String n is the name
  * @param h is the health 
  * @param m is the maxHp
  */
  public Water(String n, int h, int m){
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
      return "1.Watergun\n2.Bubble Beam\n3.Waterfall";
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
    if(atkType == 1){
      return super.getAttackString(atkType, move);
    }
    else{
      if(move == 1){
        return " is shot with WATER GUN ";
        }
        else if(move == 2){
        return " is blasted with BUBBLES ";
        }
        else{
        return " is splashed with a WATERFALL ";
      }
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
    if(atkType == 1){
      return super.getAttackDamage(atkType, move);
    }
    else{
      if(move == 1){
        int waterGun_damage = (int)((Math.random() * 4) + 2);
        return waterGun_damage;
      }
      else if(move== 2){
        int bubbleBeam_damage = (int)((Math.random() * 3) + 1);
        return bubbleBeam_damage;
      }
      else{
        int waterfall_damage = (int)((Math.random() * 4) + 1);
        return waterfall_damage;
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
      return p.battleTable[1][p.getType()];
    }
  }
}