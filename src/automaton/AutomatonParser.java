/*
 * This Automaton Project is made by Ghijs Kilani and Tom Mahieu
 */
package automaton;

import java.io.*;
import java.util.*;

/**
 * Parse een '.aut' bestand.
 *
 * @author Tom Mahieu
 */
public class AutomatonParser {

    private boolean startGevonden = false;
    private boolean finalGevonden = false;
    private String file;
    private Automaton automaton;

    /**
     * Begin het parsen van de Automaton.
     *
     * @param filename deze moet '.aut' extentie bevatten
     */
    AutomatonParser(String filename) {
        if (filename.matches("(.*).aut$")) {
            automaton = new Automaton();
            file = "src/adventures/" + filename;
        } else {
            System.err.println("File extention is not correct.");
        }
    }

    /**
     * Gaat iedere lijn in het in te lezen bestand af om het te verwerken.
     *
     * @throws Exception Error in het parsen.
     */
    public void parse() throws Exception {
        FileInputStream stream = new FileInputStream(file);
        DataInputStream in;
        in = new DataInputStream(stream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String s;
        while ((s = br.readLine()) != null) {
            editAtomaton(s);
        }
        in.close();

        if (!startGevonden && !finalGevonden) {
            throw new Exception();
        }
    }

    /**
     * Controleer een string en voeg het toe aan de automaton.
     *
     * @param s de string die moet gecontroleerd worden.
     */
    private void editAtomaton(String s) throws Exception {
        if (s.matches("^\\(START\\) \\|- [0-9]+") && !startGevonden) {
            s = s.replace("(START) |- ", "");
            automaton.setStart(Integer.parseInt(s));
            startGevonden = true;
        } else if (s.matches("[0-9]+ -\\| \\(FINAL\\)$") && !finalGevonden) {
            s = s.replace(" -| (FINAL)", "");
            automaton.setFinal(Integer.parseInt(s));
            finalGevonden = true;
        } else if (s.matches("[0-9]+ [a-zA-Z] [0-9]+")) {
            parseRoad(s);
        } else if ((startGevonden && s.matches("^\\(START\\) \\|- [0-9]+")) || (finalGevonden && s.matches("[0-9]+ -\\| \\(FINAL\\)$"))) {
            throw new Exception("Overwriting start or finish. This is not possible!");
        } else {
            throw new Exception("File format error!");
        }
    }

    /**
     * Maar een nieuwe connectie aan tussen punten.
     *
     * @param s de bewoording van de connectie opgegeven in het bestand.
     */
    private void parseRoad(String s) throws Exception {
        ArrayList<Integer> start = new ArrayList();
        ArrayList<Integer> end = new ArrayList();
        AutomatonActions action;
        String[] output;
        AutomatonRoad road;
        AutomatonVertex vertex, endNode;

        output = s.split(" ");
        if (output.length == 3) {
            start.add(Integer.parseInt(output[0]));
            end.add(Integer.parseInt(output[2]));
            action = AutomatonActions.getAction((output[1].charAt(0)));

            // Vind of maak een start en eind knoop.
            vertex = automaton.findVertexById(start);
            if (vertex == null) {
                vertex = new AutomatonVertex(start);
                automaton.addVertex(vertex);
            }
            endNode = automaton.findVertexById(start);
            if (endNode == null) {
                endNode = new AutomatonVertex(end);
                automaton.addVertex(endNode);
            }

            // Maak de connectie en voeg het toe.
            road = new AutomatonRoad(endNode, action);
            vertex.addConnection(road);
        } else {
            throw new Exception("There is a road that is incorrect.");
        }
    }

    /**
     * Geeft de berekende automaton terug.
     *
     * @return de berekende automaton.
     */
    public Automaton automaton() {
        return automaton;
    }
}
