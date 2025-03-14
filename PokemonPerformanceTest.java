import java.util.*;

public class PokemonPerformanceTest {
    public static void main(String[] args) {
        int testSize = 100000;
        Random random = new Random();

        // Crear los mapas
        Map<String, Pokemon> hashMap = new HashMap<>();
        Map<String, Pokemon> treeMap = new TreeMap<>();
        Map<String, Pokemon> linkedHashMap = new LinkedHashMap<>();

        // Poblar mapas con datos aleatorios
        System.out.println("Poniendo " + testSize + " Pokemons en las maps");
        long hashTime = testInsert(hashMap, testSize, random);
        long treeTime = testInsert(treeMap, testSize, random);
        long linkedTime = testInsert(linkedHashMap, testSize, random);

        System.out.println("\nTiempos de inserción:");
        System.out.println("HashMap: " + hashTime + " ns");
        System.out.println("TreeMap: " + treeTime + " ns");
        System.out.println("LinkedHashMap: " + linkedTime + " ns");

        // Medir tiempos de búsqueda
        long hashSearchTime = testSearch(hashMap, testSize, random);
        long treeSearchTime = testSearch(treeMap, testSize, random);
        long linkedSearchTime = testSearch(linkedHashMap, testSize, random);

        System.out.println("\nTiempos de búsqueda:");
        System.out.println("HashMap: " + hashSearchTime + " ns");
        System.out.println("TreeMap: " + treeSearchTime + " ns");
        System.out.println("LinkedHashMap: " + linkedSearchTime + " ns");
    }

    private static long testInsert(Map<String, Pokemon> map, int size, Random random) {
        long start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            String name = "Pokemon" + random.nextInt(size);
            Pokemon p = new Pokemon(name, i, "Tipo" + random.nextInt(18), null, "Clasificación", 1.0, 10.0, new String[]{"Habilidad"}, 1, false);
            map.put(name, p);
        }
        return System.nanoTime() - start;
    }

    private static long testSearch(Map<String, Pokemon> map, int size, Random random) {
        long start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {  // Busca 10000 veces
            String name = "Pokemon" + random.nextInt(size);
            map.get(name);
        }
        return System.nanoTime() - start;
    }
}