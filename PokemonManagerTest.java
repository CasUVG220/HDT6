import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class PokemonManagerTest {
    private PokemonManager manager;

    @BeforeEach
    void setUp() {
        manager = new PokemonManager("hash");
    }

    @Test
    void testAddPokemon() {
        Pokemon pikachu = new Pokemon("Pikachu", 25, "Eléctrico", null, "Ratón", 0.4, 6.0, new String[]{"Static"}, 1, false);
        String result = manager.addPokemon(pikachu);
        assertEquals("Pokémon Pikachu agregado correctamente.", result);

        // Intentar agregar el mismo Pokémon de nuevo
        String duplicateResult = manager.addPokemon(pikachu);
        assertEquals("El Pokémon Pikachu ya está en la colección.", duplicateResult);
    }

    @Test
    void testSearchAndSortByType() {
        Pokemon pikachu = new Pokemon("Pikachu", 25, "Eléctrico", null, "Ratón", 0.4, 6.0, new String[]{"Static"}, 1, false);
        Pokemon charizard = new Pokemon("Charizard", 6, "Fuego", "Volador", "Llama", 1.7, 90.5, new String[]{"Blaze"}, 1, false);
        Pokemon bulbasaur = new Pokemon("Bulbasaur", 1, "Planta", "Veneno", "Semilla", 0.7, 6.9, new String[]{"Overgrow"}, 1, false);

        manager.addPokemon(pikachu);
        manager.addPokemon(charizard);
        manager.addPokemon(bulbasaur);

        // Buscar un Pokémon que existe
        String foundPokemon = manager.getPokemon("Pikachu");
        assertTrue(foundPokemon.contains("Pikachu"));

        // Buscar un Pokémon que no existe
        String notFoundPokemon = manager.getPokemon("Mewtwo");
        assertEquals("Pokémon no encontrado.", notFoundPokemon);

        // Ordenar por tipo y verificar el orden
        List<Pokemon> sortedList = manager.getPokemonSortedByType();
        assertEquals("Eléctrico", sortedList.get(0).getType1());
        assertEquals("Fuego", sortedList.get(1).getType1());
        assertEquals("Planta", sortedList.get(2).getType1());
    }
}