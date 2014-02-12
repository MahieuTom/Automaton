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
public class Level1 {

    /**
     * Vind een willekeurig pad dat geldig is.
     *
     * @param args Er zal 1 argument worden meegegeven, dit is het bestands
     * naam.
     */
    public static void main(String[] args) {
        try {
            // leest de automaat a.aut in
            AutomatonParser parse1 = new AutomatonParser("adventure1.aut");
            // leest de automaat b.aut in
            AutomatonParser parse2 = new AutomatonParser("adventure1.aut");
            parse1.parse();
            parse2.parse();
            Automaton aut1 = parse1.automaton();
            Automaton aut2 = parse2.automaton();
            // berekent de intersectie van aut1 en aut2
            Automaton result = aut1.intersection(aut2);
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
