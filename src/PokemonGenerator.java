import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.util.Random;

public class PokemonGenerator{
  private HashMap<String, String> pokemon;
  private static PokemonGenerator instance = null;



  /**
  * constructor should read from the file into a HashMap to store the different pokémon names and their associated elemental type. 
  *
  * **/  
  private PokemonGenerator(){
    pokemon = new HashMap<String,String>();
    BufferedReader br = null;
    try{
      File file = new File("PokemonList.txt");
      br = new BufferedReader(new FileReader(file));
      String line = null;
      while((line = br.readLine()) != null){
        String [] parts = line.split(",");
        String pokemonName = parts[0].trim();
        String pokemonType = parts[1].trim();
        if(!pokemonName.equals("") && !pokemonType.equals("")){
          pokemon.put(pokemonName, pokemonType);
        }
      }
    }
    catch(Exception e){
      e.printStackTrace();
    }
    finally{
      if(br != null){
        try { 
        br.close(); 
        }catch(Exception e){};
      }
    }        
    
  }
  /**
  *gets the single PokemonGenerator instance
  *@return static PokemonGenerator object
  */
  public static PokemonGenerator getInstance(){
    if (instance == null){
      instance = new PokemonGenerator();
    }
    return instance;
  }
  /**
  *generateRandomPokemon should randomly pick a pokémon from 
  the HashMap, and then construct a pokémon of the corresponding
  elemental base type.
  *@param level - the level pokemon 
  */
  public Pokemon generateRandomPokemon(int level){
    ArrayList<String> ppokemon = new ArrayList<>();
    for ( String key : pokemon.keySet() ) {
    ppokemon.add(key);
    }
    Random rand = new Random();
    int randomIndex = rand.nextInt(pokemon.size());
    Pokemon RandomPokemon;
    String poke_name = "";
    int y = 0;
    for (String key : pokemon.keySet()){
      poke_name = key;
      if (y == randomIndex){
        break;
      }
      y++;
    }
    RandomPokemon = getPokemon(poke_name);
    if (level > 1){
      for (int x = 1; x < level; x++){
      RandomPokemon = addRandomBuff(RandomPokemon);
      }
    }
    return RandomPokemon;
  }
  /**
  *getPokemon - passes in a string with the name of a pokémon and 
  constructs an object of the correct corresponding type.
  *@param name - the string name of the pokemon.
  *@return - a special type pokemon with 25 hp.
  */
  public Pokemon getPokemon(String name){
    if (name.equals("Charmander") ||  name.equals("Ponyta") ||  name.equals("Vulpix") ||  name.equals("Growlithe") ||  name.equals("Moltres")){
      return new Fire(name, 25, 25);
    }
    else if (name.equals("Squirtle") ||  name.equals("Staryu") ||  name.equals("Poliwag") ||  name.equals("Tentacool") ||  name.equals("Goldeen") ||  name.equals("Seel") ||  name.equals("Shellder") ||  name.equals("Krabby") ||  name.equals("Lapras") ||  name.equals("Magikarp") ||  name.equals("Horsea")||  name.equals("Slowpoke")){
      return new Water(name, 25, 25);
    }
    else{
      return new Grass(name, 25, 25);
    }
  }
  /**
  *add a random buff to a given Pokemon
  *@param Pokemon p- The pokemon that will have a random buff applied to.
  *@return - Gives back a pokemon object with an applied buff.
  */
  public Pokemon addRandomBuff(Pokemon p){
    Random rand = new Random();
    int random_num = rand.nextInt(2);
    if (random_num == 0){
      p = new AttackUp(p);
    }
    else{
      p = new HpUp(p);
    }
    return p;
  }
  /**
  *add a random debuff to a given Pokemon
  *@param pokemon p - The pokemon that will have a random debuff applied to.
  *@return - Gives back a pokemon object with an applied debuff.
  */
  public Pokemon addRandomDebuff(Pokemon p){
    Random rand = new Random();
    int random_num = rand.nextInt(2);
    if (random_num == 0){
      p = new AttackDown(p);
    }
    else{
      p = new HpDown(p);
    }
    return p;
  }


}