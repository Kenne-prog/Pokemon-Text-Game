import java.util.Scanner;
import java.util.Random;
import java.lang.Math; 
public abstract class Pokemon extends Entity{
  /**
	 * Default constructor will inherit the name
	 * and max hp of the pokemon
   * @param String n is the name of the pokemon
   * @param int mHp is the max hp of the pokemon
	 */
  public Pokemon(String n, int h, int m) {
    super(n, h, m);
  }
  public static final double [][] battleTable = {{1,.5,2}, {2,1,.5}, {.5,2,1}};
  /**
	 * String of the basic moves
	 * @return the basic moves as a string
	 */
  public String getAttackTypeMenu(){
    return "1.Basic Attack\n2.Special Attack";
  }
  /**
	 * Gets the number of moves in the basic moves
	 * @return the amount of basic moves
	 */
  public int getNumAttackTypeMenuItems(){
    return 2;
  }
  /**
  *getAttackMenu - gives the menu listing the options of that pokémon’s moves 
  (ex. slam/tackle/punch).
  *@param atkType - either 1 mor 2 depending on the the attack is special or not.
  *@return - a string of the menu items.
  */
  public String getAttackMenu(int atkType) {
    String attack_menu = "";
    if (atkType == 1){
      attack_menu += "1.Slam\n2.Tackle\n3.Punch";
    }
    return attack_menu;
  }
  /**
  *attack - calculates the total damage, deals it to the defending pokémon, and builds 
  the full attack string that will be returned to be displayed during a fight
  *@param atkType - either 1 mor 2 depending on the the attack is special or not.
  *@param move - will be a number corresponding to the move, either 1, 2 or something.
  *@param pokemon p - the pokemon's used to calculate demage.
  *@return - a string of the attack message.
  */
  public String attack(Pokemon p, int atkType, int move){
    String attack_message = "";
    int attack_dmg;
    String attack_string = "";
    double attack_multiplier;
    int attack_bonus = 0;
    attack_dmg = getAttackDamage(atkType, move);
    attack_string += getAttackString(atkType, move);
    attack_multiplier = getAttackMultiplier(p, atkType);
    int attack_multi = attack_dmg * (int)Math.round(attack_multiplier);
    attack_bonus += getAttackBonus(atkType);
    int total_attack_dmg = attack_multi + attack_bonus;
    if (total_attack_dmg < 0){
      total_attack_dmg = 0;
    }
    p.takeDamage(total_attack_dmg);
    attack_message += p.getName() + attack_string + "by " + getName() + " and takes " + total_attack_dmg + " damage";
    return attack_message;
  }
  /**
  * getAttackString - gives the partial string for the chosen move.
  * @param atkType - either 1 mor 2 depending on the the attack is special or not.
  * @param move - will be a number corresponding to the move, either 1, 2 or something.
  * @return - the attack_string, which is SLAMMED or TACKLED or PUNCHED.
  */
  public String getAttackString(int atkType, int move){
    String attack_string = "";
    if (atkType == 1){
      if(move == 1 ){
        attack_string +=" SLAMMED ";
      }
      else if (move == 2){
        attack_string += " TACKLED ";
      }
      else{
        attack_string += " PUNCHED ";
      }
    }
    return attack_string;
  }
  /**
  *getAttackDamage - gives the randomized damage for the chosen move.
  *@param atkType - either 1 mor 2 depending on the the attack is special or not.
  *@param move - will be a number corresponding to the move, either 1, 2 or something else.
  *@return - returns the damage.  
  */
  public int getAttackDamage(int atkType, int move){
    Random rand = new Random();
    int damage = 0;
    if (atkType == 1){
      if(move == 1){
        damage += rand.nextInt(6);
      }
      else if (move == 2){
        damage += rand.nextInt(2) + 2;
      }
      else{
        damage += rand.nextInt(4) + 1;
      }
      return damage;
    }
    return 0;
  }
  /**
  * getAttackMultiplier - gives the attack multiplier for that class’s moves.
  * @param atkType - either 1 mor 2 depending on the the attack is special or not.
  * @param pokemon p - the pokemon's used to calculate demage.
  * @return - will return the result of the battle table.
  */
  public double getAttackMultiplier(Pokemon p, int atkType){
    return 1.0;
  }
  /**
  * getAttackBonus - gives the attack bonus that will be added to the calculated damage.
  * @param atkType - either 1 mor 2 depending on the the attack is special or not.
  * @return - returns the attack bonuns.
  */
  public int getAttackBonus(int atkType){
    return 0;                                                                      
  }


  /**
	 * getNumAttackMenuItems - Gets the number of types of attacks
	 * @return the amount of types of attacks
	 */
  public int getNumAttackMenuItems(int atkType) {
    return 3;
  }
  
  
  /**
   * getType - Gets the type of the pokemon
   * @return - an int depending on the type of pokemon
   */
  public int getType() {
    int result;
    if ( this instanceof Fire){
      result = 0;
    }
    else if (this instanceof Water){
      result = 1;
    }
    else{
      result = 2;
    }
    return result;
  }
}