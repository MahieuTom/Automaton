/*
 * This Automaton Project is made by Ghijs Kilani and Tom Mahieu
 */

package automaton;

/**
 * Een connectie tussen twee punten opslaan.
 * @author Tom Mahieu
 */
public class AutomatonRoad {
    private int m_Start;
    private int m_Final;
    private AutomatonActions m_Action;
    
    /**
     * Maak een nieuwe connectie aan.
     * @param start
     * @param end
     * @param action 
     */
    AutomatonRoad(int start, int end, AutomatonActions action){
        m_Start = start;
        m_Final = end;
        m_Action = action;
    }
    
    /**
     * Vraag het startnummer op.
     * @return startnummer.
     */
    public int getStart(){
        return m_Start;
    }
    
    /**
     * Vraag het einde op.
     * @return de finish.
     */
    public int getFinal(){
        return m_Final;
    }
    
    /**
     * Vraag de actie op die op het pad gebeurt.
     * @return de actie die er gebeurt.
     */
    public AutomatonActions getAction(){
        return m_Action;
    }
}
