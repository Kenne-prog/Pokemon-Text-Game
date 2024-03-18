/**
* Class for Grass moves and damage for Grass type Pokemon Objects
*/
public class Grass extends Pokemon{
  /**
  * Constructs a grass pokemon
  * @param String n is the name
  * @param h is the health 
  * @param m is the maxHp
  */
  public Grass(String n, int h, int m){
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
    if (atkType == 1){
      return super.getAttackMenu(atkType);
    }
    else{
      return "1.Vinewhip\n2.Razorleaf\n3.SolarBeam";
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
    if(atkType == 1){
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
        return " is VINE WHIPPED ";
      }
      else if(move == 2){
        return " is SLASHED with RAZOR LEAF ";
      }
      else{
        return " is dazzled by SOLAR BEAM ";
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
      if (move == 1){
        int vineWhip_damage = (int)((Math.random() * 3) + 1);
        return vineWhip_damage;
      }
      else if(move == 2){
        int razorLeaf_damage = (int)((Math.random() * 3) + 2);
        return razorLeaf_damage;
      }
      else{
        int solarBeam_damage = (int)((Math.random() * 4) + 0);
        return solarBeam_damage;
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
    if(atkType == 1){
      return super.getAttackMultiplier(p, atkType);
    }
    else{
      return p.battleTable[2][p.getType()];
    }
  }
}