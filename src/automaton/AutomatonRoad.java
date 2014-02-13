/*
 * This Automaton Project is made by Ghijs Kilani and Tom Mahieu
 */
package automaton;

import java.util.*;

/**
 * Een connectie tussen twee punten opslaan.
 *
 * @author Tom Mahieu
 */
public class AutomatonRoad {

    private ArrayList<Integer> m_Start = new ArrayList();
    private ArrayList<Integer> m_Final = new ArrayList();
    private AutomatonActions m_Action;

    /**
     * Maak een nieuwe connectie aan.
     *
     * @param start Het startpunt van de connectie.
     * @param end Het eindpunt van de connectie.
     * @param action De actie die uitgevoerd moet worden uitgevoerd bij het gebruiken van de connectie.
     */
    AutomatonRoad(int start, int end, AutomatonActions action) {
        m_Start.add(start);
        m_Final.add(end);
        m_Action = action;
    }
    AutomatonRoad(ArrayList<Integer> start, ArrayList<Integer> end, AutomatonActions action) {
        m_Start.addAll(start);
        m_Final.addAll(end);
        m_Action = action;
    }

    /**
     * Vraag het startnummer op.
     *
     * @return startnummer.
     */
    public ArrayList<Integer> getStart() {
        return m_Start;
    }

    /**
     * Vraag het einde op.
     *
     * @return de finish.
     */
    public ArrayList<Integer> getFinal() {
        return m_Final;
    }

    /**
     * Vraag de actie op die op het pad gebeurt.
     *
     * @return de actie die er gebeurt.
     */
    public AutomatonActions getAction() {
        return m_Action;
    }
    
    public String getRoadActionChar(){
        return AutomatonActions.getPrintValue(m_Action);
    }
}
