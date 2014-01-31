/*
 * This Automaton Project is made by Ghijs Kilani and Tom Mahieu
 */

package automaton;

/**
 * Een connectie tussen twee punten opslaan.
 * @author Tom Mahieu
 */
public class AutomatonRoad {
    private int m_start;
    private int m_final;
    private AutomatonActions m_action;
    
    /**
     * Maak een nieuwe connectie aan.
     * @param start
     * @param end
     * @param action 
     */
    AutomatonRoad(int start, int end, AutomatonActions action){
        m_start = start;
        m_final = end;
        m_action = action;
    }
    
    /**
     * Vraag het startnummer op.
     * @return startnummer.
     */
    public int getStart(){
        return m_start;
    }
    
    /**
     * Vraag het einde op.
     * @return de finish.
     */
    public int getFinal(){
        return m_final;
    }
    
    /**
     * Vraag de actie op die op het pad gebeurt.
     * @return de actie die er gebeurt.
     */
    public AutomatonActions getAction(){
        return m_action;
    }
}
