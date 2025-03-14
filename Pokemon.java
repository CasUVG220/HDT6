import java.util.Arrays;

public class Pokemon {
    private String name;
    private int pokedexNumber;
    private String type1;
    private String type2;
    private String classification;
    private double height;
    private double weight;
    private String[] abilities;
    private int generation;
    private boolean isLegendary;

    /**
     * Constructor de la clase Pokemon
     * @param name Nombre del Pokémon
     * @param pokedexNumber Número en la Pokedex Nacional
     * @param type1 Tipo primario
     * @param type2 Tipo secundario (puede ser null si no tiene)
     * @param classification Clasificación en la Pokedex
     * @param height Altura en metros
     * @param weight Peso en kilogramos
     * @param abilities Lista de habilidades
     * @param generation Generación en la que apareció
     * @param isLegendary Estado legendario (true = sí, false = no)
     */
    public Pokemon(String name, int pokedexNumber, String type1, String type2, 
                   String classification, double height, double weight, 
                   String[] abilities, int generation, boolean isLegendary) {
        this.name = name;
        this.pokedexNumber = pokedexNumber;
        this.type1 = type1;
        this.type2 = type2;
        this.classification = classification;
        this.height = height;
        this.weight = weight;
        this.abilities = abilities;
        this.generation = generation;
        this.isLegendary = isLegendary;
    }

    // Getters
    public String getName() { return name; }
    public int getPokedexNumber() { return pokedexNumber; }
    public String getType1() { return type1; }
    public String getType2() { return type2; }
    public String getClassification() { return classification; }
    public double getHeight() { return height; }
    public double getWeight() { return weight; }
    public String[] getAbilities() { return abilities; }
    public int getGeneration() { return generation; }
    public boolean isLegendary() { return isLegendary; }

    // Método toString para mostrar los datos del Pokémon
    @Override
    public String toString() {
        return "Pokemon{" +
                "Nombre='" + name + '\'' +
                ", Pokedex No.=" + pokedexNumber +
                ", Tipo1='" + type1 + '\'' +
                ", Tipo2='" + (type2 != null ? type2 : "Ninguno") + '\'' +
                ", Clasificación='" + classification + '\'' +
                ", Altura=" + height + "m" +
                ", Peso=" + weight + "kg" +
                ", Habilidades=" + Arrays.toString(abilities) +
                ", Generación=" + generation +
                ", Legendario=" + (isLegendary ? "Sí" : "No") +
                '}';
    }
}