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
        a.m_Start.addAll(this.m_Start);
        a.m_Start.addAll(aut.m_Start);
        a.m_Final.addAll(this.m_Final);
        a.m_Final.addAll(aut.m_Final);  //zorgen dat begin en eind gekend zijn
        ArrayList<Integer> rstart = new ArrayList();
        ArrayList<Integer> rfinish = new ArrayList();
        for (int i=0; i<this.m_Roads.size(); i++){
            rstart.clear();
            rfinish.clear();
            for(int j = 0; j<aut.m_Roads.size();j++){
                if (this.m_Roads.elementAt(i).getAction() == aut.m_Roads.elementAt(j).getAction()){ //als de intersectie klopt, road combineren en toevoegen
                    rstart.addAll(this.m_Roads.elementAt(i).getStart());
                    rstart.addAll(aut.m_Roads.elementAt(j).getStart());
                    rfinish.addAll(this.m_Roads.elementAt(i).getFinal());
                    rfinish.addAll(aut.m_Roads.elementAt(j).getFinal());
                    AutomatonRoad road = new AutomatonRoad(rstart,rfinish,this.m_Roads.elementAt(i).getAction()); //nieuwe road toegevoegd
                    a.addRoad(road);
                }
            }
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
