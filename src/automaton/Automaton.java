/*
 * This Automaton Project is made by Ghijs Kilani and Tom Mahieu
 */
package automaton;

import java.util.*;

/**
 *
 * @author .
 */
public class Automaton {

    private ArrayList<Integer> m_Start = new ArrayList();
    private ArrayList<Integer> m_Final = new ArrayList();
    private Vector<AutomatonRoad> m_Roads = new Vector();

    /**
     *
     * @param aut
     * @return
     */
    public Automaton intersection(Automaton aut) {
        Automaton a = new Automaton();
        for (int i=0; i<this.m_Roads.size(); i++){
            m_Start.add(i);
            m_Final.add(i);
            AutomatonRoad road = new AutomatonRoad(i,i,AutomatonActions.EMPTY);
            m_Roads.add(road);
        }
        return a;
    }
    
    /**
     *
     * @param accept
     * @return
     */
    public String getShortestExample(Boolean accept) {
        return null; // TODO: Vergeet niet er maar 1 terug te geven!
    }
    
    /**
     * Waar moet de Automaton starten.
     *
     * @param start het start punt.
     */
    public void setStart(int start) {
        m_Start.add(start);
    }

    /**
     * Waar moet de Automaton stoppen.
     *
     * @param end het final punt.
     */
    public void setFinal(int end) {
        m_Final.add(end);
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
