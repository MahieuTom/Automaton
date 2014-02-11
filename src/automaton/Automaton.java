/*
 * This Automaton Project is made by Ghijs Kilani and Tom Mahieu
 */
package automaton;

import java.util.Vector;

/**
 *
 * @author .
 */
public class Automaton {

    private int m_Start;
    private int m_Final;
    private Vector<AutomatonRoad> m_Roads = new Vector();

    /**
     *
     * @param aut
     * @return
     */
    public Automaton intersection(Automaton aut) {
        return null;
    }

    /**
     *
     * @param accept
     * @return
     */
    public String getShortestExample(Boolean accept) {
        return null;
    }

    /**
     * Waar moet de Automaton starten.
     *
     * @param start het start punt.
     */
    public void setStart(int start) {
        m_Start = start;
    }

    /**
     * Waar moet de Automaton stoppen.
     *
     * @param end het final punt.
     */
    public void setFinal(int end) {
        m_Final = end;
    }

    /**
     * Voeg een extra connectie toe.
     *
     * @param road een gemaakte weg.
     */
    public void addRoad(AutomatonRoad road) {
        m_Roads.add(road);
    }
}
