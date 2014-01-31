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
    private int m_start;
    private int m_final;
    private Vector<AutomatonRoad> m_roads;
    
    /**
     * 
     * @param aut
     * @return 
     */
    public Automaton intersection(Automaton aut){
        return null;
    }
    
    /**
     * 
     * @param accept
     * @return 
     */
    public String getShortestExample(Boolean accept){
        return null;
    }
    
    public void setStart(int start){
        m_start = start;
    }
    
    public void setFinal(int end){
        m_final = end;
    }
    
    public void addRoad(AutomatonRoad road){
        m_roads.add(road);
    }
}
