/*
 * This Automaton Project is made by Ghijs Kilani and Tom Mahieu
 */
package automaton;

import java.util.*;

/**
 * A class that makes vertices.
 *
 * @author Tom Mahieu
 */
public class AutomatonVertex {

    private ArrayList<Integer> m_Id;
    private ArrayList<AutomatonRoad> m_Connections;

    /**
     * Construct a vertex.
     * @param id
     */
    AutomatonVertex(ArrayList<Integer> id){
        m_Id = id;
        m_Connections = null;
    }
    
    /**
     * 
     * @return The ID of this vertex.
     */
    public ArrayList<Integer> getId(){
        return m_Id;
    }
    
    /**
     * 
     * @param road A road to add to the connections
     */
    public void addConnection(AutomatonRoad road){
        m_Connections.add(road);
    }
}
