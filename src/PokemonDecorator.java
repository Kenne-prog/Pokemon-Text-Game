public abstract class PokemonDecorator extends Pokemon{
private Pokemon pokemon;
 /**
  * This PokemonDecorator will allow us to 
  * attach additional behaviors and responsibilies
  * to the Pokemon object
  * @param p - pokemon object
  * @param extraName - this will allow the name of 
  * the debuff and buff 
  * @param extraHp - will increase or decrease 
  * the hp and maxHp
  */
  public PokemonDecorator(Pokemon p, String extraName, int extraHp){
    super(p.getName() + " " + extraName, p.getHp() + extraHp, p.getMaxHp() + extraHp);
    pokemon = p;
  }
 /**
  * Calls on either the super or 
  * pokemon getAttackMenu()
  * @return attack menu
  */
  @Override
  public String getAttackMenu(int atkType){
    if (atkType == 1){
      return super.getAttackMenu(atkType);
    }
    else{
    return pokemon.getAttackMenu(atkType);
    }
  }

 /**
  * Return the number of attack moves 
  * here or the pokemon's getNumAttackMenuItems
  * @return the number of moves
  */
  @Override
  public int getNumAttackMenuItems(int atkType){
    if (atkType == 1){
      return 3;
    }
    else{
    return pokemon.getNumAttackMenuItems(atkType);
    }
  }
 /**
  * Calls on the method to get the attack string
  * from either the super or pokemon
  * @param atkType - type of attack
  * @param move - the move that the user wants
  * @return the attack string
  */
  @Override
  public String getAttackString(int atkType, int move){
    if (atkType == 1){
      return super.getAttackString(atkType, move);
    }
    else{
    return pokemon.getAttackString(atkType, move);

    }
  }

 /**
  * Calls on the getAttackDamage either from
  * the super or the pokemon
  * @param atkType - type of attack
  * @param move - the move that the user wants
  * @return the amount of damage generated
  */
  @Override
  public int getAttackDamage(int atkType, int move){
    if (atkType == 1){
      return super.getAttackDamage(atkType, move);
    }
    else{
    return pokemon.getAttackDamage(atkType, move);
    }
  }

 /**
  * Calls on super getAttackMultiplier
  * @param p - pokemon object
  * @param atkType - type of attack 
  * @return attack bonus due to enemy pokemon type
  */
  @Override
  public double getAttackMultiplier(Pokemon p, int atkType){
    return super.getAttackMultiplier(p, atkType);
  }

 /**
  * Calls on getAttackBonus method from pokemon
  * @param atkType - type of attack
  * @return the amount of bonus damage
  */
  @Override
  public int getAttackBonus(int atkType){
    return pokemon.getAttackBonus(atkType);
  }

 /**
  * Calls othe getType() from pokemon
  * @return int associated with type
  * of pokemon
  */
  @Override
  public int getType(){
    return pokemon.getType();
  }

}