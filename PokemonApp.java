import java.util.Scanner;
import java.util.List;

public class PokemonApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Elegir el tipo de map (Hash, Tree, Linked)
        System.out.println("Logger personal de Pokemons");
        System.out.println("Selecciona el tipo de almacenamiento:");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");
        System.out.print("Opción: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        String mapType = switch (choice) {
            case 1 -> "hash";
            case 2 -> "tree";
            case 3 -> "linked";
            default -> "hash";
        };

        PokemonManager manager = new PokemonManager(mapType);

        boolean running = true;
        while (running) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar Pokémon");
            System.out.println("2. Buscar Pokémon");
            System.out.println("3. Mostrar Pokémon ordenados por tipo");
            System.out.println("4. Mostrar toda la colección");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addPokemonFlow(manager, scanner);
                    break;

                case 2:
                    searchPokemonFlow(manager, scanner);
                    break;

                case 3:
                    displaySortedByTypeFlow(manager);
                    break;

                case 4:
                    displayCollectionFlow(manager);
                    break;

                case 5:
                    running = false;
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }

    /**
     * Agrega Pokémon
     */
    private static void addPokemonFlow(PokemonManager manager, Scanner scanner) {
        System.out.print("\n Nombre del Pokémon: ");
        String name = scanner.nextLine();

        System.out.print("Número de la Pokedex: ");
        int pokedexNumber = scanner.nextInt();
        scanner.nextLine();

        // Tipo 1
        String type1 = selectFromList(scanner, new String[]{"Acero", "Agua", "Bicho", "Dragón", "Eléctrico", "Fantasma", "Fuego",
                    "Hada", "Hielo", "Lucha", "Normal", "Planta", "Psíquico", "Roca",
                    "Siniestro", "Tierra", "Veneno", "Volador"}, " Selecciona el tipo primario:");

        // Tipo 2
        String classification = selectFromList(scanner, new String[]{"Acero", "Agua", "Bicho", "Dragón", "Eléctrico", "Fantasma", "Fuego",
                    "Hada", "Hielo", "Lucha", "Normal", "Planta", "Psíquico", "Roca",
                    "Siniestro", "Tierra", "Veneno", "Volador"}, " Selecciona la clasificación:");

        System.out.print(" Ingresa la altura en metros: ");
        double height = scanner.nextDouble();
        scanner.nextLine();

        System.out.print(" Ingresa el peso en kilogramos: ");
        double weight = scanner.nextDouble();
        scanner.nextLine();

        System.out.print(" Ingresa la habilidad del Pokémon (separada por comas si tiene varias): ");
        String[] abilities = scanner.nextLine().split(",");

        System.out.print(" Ingresa la generación del Pokémon: ");
        int generation = scanner.nextInt();
        scanner.nextLine();

        System.out.print(" ¿Es legendario? (1 = Sí, 0 = No): ");
        boolean isLegendary = scanner.nextInt() == 1;

        // Crear y agregar el Pokémon
        Pokemon pokemon = new Pokemon(name, pokedexNumber, type1, null, classification, height, weight, abilities, generation, isLegendary);
        System.out.println(manager.addPokemon(pokemon));
    }

    /**
     * Buscar Pokémon por nombre.
     */
    private static void searchPokemonFlow(PokemonManager manager, Scanner scanner) {
        System.out.print("\n🔎 Ingresa el nombre del Pokémon a buscar: ");
        String searchName = scanner.nextLine();
        System.out.println(manager.getPokemon(searchName));
    }

    /**
     * Mostrar Pokémon ordenados por tipo.
     */
    private static void displaySortedByTypeFlow(PokemonManager manager) {
        List<Pokemon> sortedPokemon = manager.getPokemonSortedByType();
        if (sortedPokemon.isEmpty()) {
            System.out.println(" No hay Pokémon en la colección.");
            return;
        }
        System.out.println("\n Pokémon ordenados por tipo:");
        for (Pokemon p : sortedPokemon) {
            System.out.println(p);
        }
    }

    /**
     * Muestra la colección de Pokémon.
     */
    private static void displayCollectionFlow(PokemonManager manager) {
        System.out.println("\n Colección completa:");
        manager.displayCollection();
    }

    
    private static String selectFromList(Scanner scanner, String[] options, String message) {
        System.out.println("\n" + message);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.print("Opción: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();
        return options[index];
    }
}