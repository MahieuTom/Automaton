/*
 * This Automaton Project is made by Ghijs Kilani and Tom Mahieu
 */

import automaton.*;

/**
 * Vind een uitgang van een adventure in het Cohan Level.
 *
 * @author Tom Mahieu
 */
public class Level2 {

    /**
     * Vind een pad dat geldig is in dit level.
     *
     * @param args niet gebruikt
     */
    public static void main(String[] args) {
        try {
            // De bestanden afleiden.
            AutomatonParser parse = new AutomatonParser("adventure1.aut");
            AutomatonParser parse1 = new AutomatonParser("dubbleTreasure.aut");
            AutomatonParser parse2 = new AutomatonParser("keyGate.aut");
            AutomatonParser parse3 = new AutomatonParser("dragonRiver.aut");
            AutomatonParser parse4 = new AutomatonParser("swordDragon.aut");
            AutomatonParser parse5 = new AutomatonParser("archer.aut");
            AutomatonParser parse6 = new AutomatonParser("treasuresDragon.aut");
            AutomatonParser parse7 = new AutomatonParser("noDragons.aut");
            parse.parse();
            parse1.parse();
            parse2.parse();
            parse3.parse();
            parse4.parse();
            parse5.parse();
            parse6.parse();
            parse7.parse();

            // Verkrijg de automaten.
            Automaton adventure = parse.automaton();
            Automaton treasures = parse1.automaton();
            Automaton keyGate = parse2.automaton();
            Automaton dragonRiver = parse3.automaton();
            Automaton swordDragon = parse4.automaton();
            Automaton archer = parse5.automaton();
            Automaton treasuresDragon = parse6.automaton();
            Automaton noDragons = parse7.automaton();

            // Maak een graaf met alle mogelijkheden.
            Automaton result = adventure.intersection(treasures);
            result = result.intersection(keyGate);
            result = result.intersection(archer);

            // 1 van deze 2 acties moeten gebeuren bij het tegenkomen van een draag.
            Automaton dragonTest = result.intersection(dragonRiver);
            if (dragonTest == null) {
                dragonTest = result.intersection(swordDragon);
                if (dragonTest == null) {
                    dragonTest = result.intersection(noDragons);
                } else {
                    dragonTest = dragonTest.intersection(treasuresDragon);
                }
            } else {
                dragonTest = dragonTest.intersection(treasuresDragon);
            } // Test dan of er 2 treasures gevonden worden na een draak!
            result = dragonTest;

            // schrijft een string uit die wordt aanvaard
            // (true staat voor aanvaarden)
            // indien er zo geen string is wordt null
            // uitgeschreven
            System.out.println(result.getShortestExample(true));
        } catch (Exception e) {
            System.out.print("Error: ");
            System.out.println(e.toString());
            System.out.println(e.getMessage());
        }
    }
}
