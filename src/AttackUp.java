import java.util.Random;
 /**
  * This will give the pokemon a buff
  * @param p - pokemon gets passed into the constructor
  */
public class AttackUp extends PokemonDecorator{
  public AttackUp(Pokemon p){
    super(p, " +ATK", 0);
  }
  /**
  * Buffs pokemon
  * @param atkType - the attak type 
  * @return the total buff
  */
  @Override
  public int getAttackBonus(int atkType){
    int counter_bonus = super.getAttackBonus(atkType);
    Random rand = new Random();
    int buff = rand.nextInt(2) + 1;
    int total_buff = buff + counter_bonus;
    return total_buff;
  }
}