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

    private AutomatonVertex m_Final;
    private AutomatonActions m_Action;

    /**
     * Maak een nieuwe connectie aan.
     *
     * @param end Het eindpunt van de connectie.
     * @param action De actie die uitgevoerd moet worden uitgevoerd bij het gebruiken van de connectie.
     */
    AutomatonRoad(AutomatonVertex end, AutomatonActions action) {
        m_Final = end;
        m_Action = action;
    }

    /**
     * Vraag het einde op.
     *
     * @return de finish.
     */
    public AutomatonVertex getEndNode() {
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
    
    /**
     * 
     * @return De string die uitgeprint zal worden.
     */
    public String getRoadActionChar(){
        return AutomatonActions.getPrintValue(m_Action);
    }
}
