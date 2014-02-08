/*
 * This Automaton Project is made by Ghijs Kilani and Tom Mahieu
 */

import automaton.*;

/**
 * Vind een uitgang van een adventure in God Mode. God Mode wilt zeggen dat men
 * niet kan dood gaan.
 *
 * @author Tom Mahieu
 */
public class Level0 {

    /**
     * Vind een willekeurig pad dat geldig is.
     *
     * @param args Er zal 1 argument worden meegegeven, dit is het bestands
     * naam.
     */
    public static void main(String[] args) {
        AutomatonParser parse = new AutomatonParser("adventure1.aut");
        Automaton aut = parse.automaton();

        String output = aut.getShortestExample(false);

        System.out.println(output);
    }
}
