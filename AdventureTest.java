
import java.io.*;
import automaton.*;

public class AdventureTest {

    public static void main(String[] args) {
        try {
            // leest de automaat a.aut in
            AutomatonParser parse1 = new AutomatonParser("adventure2.aut");
            // leest de automaat b.aut in
            AutomatonParser parse2 = new AutomatonParser("dubbleTreasure.aut");
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
