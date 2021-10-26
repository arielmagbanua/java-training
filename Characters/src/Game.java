import java.util.ArrayList;

public class Game {
    public ArrayList<Character> generateCharacters () {
        // wizards
        Wizard gandalf = new Wizard("Gandalf", 100, 100.0);
        gandalf.setLevel(new Level("Grey", 5));

        Wizard saruman = new Wizard("Saruman", 100, 90.0);
        gandalf.setLevel(new Level("White", 4));

        // monsters
        Weakness holyWater = new Weakness("Holy Water", "Holy water", 70);
        Weakness veryHolyWater = new Weakness(holyWater);
        veryHolyWater.setDescription("A very holy water");
        veryHolyWater.setAmount(120);
        Monster monster1 = new Monster("Monster 1", 90, 25.0, holyWater);
        Monster monster2 = new Monster("Monster 2", 120, 50.5, veryHolyWater);

        // add wizards and monsters in the list
        ArrayList<Character> characterList = new ArrayList<>();
        characterList.add(gandalf);
        characterList.add(saruman);
        characterList.add(monster1);
        characterList.add(monster2);

        return characterList;
    }

    void everyoneSpeak(ArrayList<Character> characters) {
        for (Character character : characters) {
            System.out.println(character.speak());
        }
    }

    public static void main(String[] args) {
        Game game = new Game();

        // generated the characters
        ArrayList<Character> characters = game.generateCharacters();

        // call the everyoneSpeak
        game.everyoneSpeak(characters);
    }
}
