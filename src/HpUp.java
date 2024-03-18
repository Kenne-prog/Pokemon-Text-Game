import java.util.*;
 /**
  * This class will bring the Hp 
  * of the pokemon up
  */
public class HpUp extends PokemonDecorator{
 /**
  * This will bring the Hp and maxHp 
  * up by a random number
  * @param p - pokemon object will be passed on 
  * and updates the hp and maxHp
  */
  public HpUp(Pokemon p){
    super(p, " +HP", (int) ((Math.random() * (2-1)) + 1));
  }

}