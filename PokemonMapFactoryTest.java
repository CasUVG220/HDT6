import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;

public class PokemonMapFactoryTest {

    @Test
    void testCreateMap() {
        Map<String, Pokemon> hashMap = PokemonMapFactory.createMap("hash");
        Map<String, Pokemon> treeMap = PokemonMapFactory.createMap("tree");
        Map<String, Pokemon> linkedHashMap = PokemonMapFactory.createMap("linked");

        assertTrue(hashMap instanceof HashMap, "Debe devolver un HashMap");
        assertTrue(treeMap instanceof TreeMap, "Debe devolver un TreeMap");
        assertTrue(linkedHashMap instanceof LinkedHashMap, "Debe devolver un LinkedHashMap");

        // Crear Pokémon con la firma correcta del constructor
        Pokemon pikachu = new Pokemon("Pikachu", 25, "Eléctrico", null, "Ratón", 0.4, 6.0, new String[]{"Static"}, 1, false);
        Pokemon charizard = new Pokemon("Charizard", 6, "Fuego", "Volador", "Llama", 1.7, 90.5, new String[]{"Blaze"}, 1, false);

        hashMap.put(pikachu.getName(), pikachu);
        treeMap.put(charizard.getName(), charizard);
        linkedHashMap.put(pikachu.getName(), pikachu);

        assertEquals(pikachu, hashMap.get("Pikachu"));
        assertEquals(charizard, treeMap.get("Charizard"));
        assertEquals(pikachu, linkedHashMap.get("Pikachu"));
    }
}