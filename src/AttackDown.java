import java.util.Random;

public class AttackDown extends PokemonDecorator{
  /**
  * Will give a debuff to the pokemon
  * @param p - pokemon object is being passed
  */
  public AttackDown(Pokemon p){
    super(p, " -ATK", 0);
  }
 /***
  * Gives the debuff
  * @param the attack type
  * @return returnts the total debuff
  */
  @Override
  public int getAttackBonus(int atkType){
    int counter_bonus = super.getAttackBonus(atkType);
    Random rand = new Random();
    int debuff_pos = rand.nextInt(1) + 2;
    int debuff = 0 - debuff_pos;
    int total_debuff = counter_bonus + debuff;

    return total_debuff;
  }




}