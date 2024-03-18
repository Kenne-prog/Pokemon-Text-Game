import java.util.*;
 /**
  * Class will bring HP down
  *
  */
public class HpDown extends PokemonDecorator{
  /**
  * This will bring the hp and maxHp of the
  * pokemon down 
  * @param p - takes in pokemon ob
  */
  public HpDown(Pokemon p){
    super(p, " -HP", 0 - (int) ((Math.random() * (2-1)) + 1));
  }
}