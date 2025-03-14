import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class PokemonMapFactory {

    /**
     * Crea y devuelve un mapa de Pokémon según el tipo especificado.
     * @param type Tipo de mapa: "hash", "tree" o "linked"
     * @return Un `Map` vacío listo para ser utilizado.
     */
    public static Map<String, Pokemon> createMap(String type) {
        switch (type.toLowerCase()) {
            case "hash":
                return new HashMap<>();
            case "tree":
                return new TreeMap<>();
            case "linked":
                return new LinkedHashMap<>();
            default:
                throw new IllegalArgumentException("Tipo de mapa no válido: " + type);
        }
    }
}