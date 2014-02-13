/*
 * This Automaton Project is made by Ghijs Kilani and Tom Mahieu
 */
package automaton;

import java.util.*;

/**
 *
 * @author Ghijs Kilani
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
        for (int i = 0; i < this.m_Roads.size(); i++) {
            rstart.clear();
            rfinish.clear();
            for (int j = 0; j < aut.m_Roads.size(); j++) {
                if (this.m_Roads.elementAt(i).getAction() == aut.m_Roads.elementAt(j).getAction()) { //als de intersectie klopt, road combineren en toevoegen
                    rstart.addAll(this.m_Roads.elementAt(i).getStart());
                    rstart.addAll(aut.m_Roads.elementAt(j).getStart());
                    rfinish.addAll(this.m_Roads.elementAt(i).getFinal());
                    rfinish.addAll(aut.m_Roads.elementAt(j).getFinal());
                    AutomatonRoad road = new AutomatonRoad(rstart, rfinish, this.m_Roads.elementAt(i).getAction()); //nieuwe road toegevoegd
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

        String path = "";
        List<ArrayList<Integer>> vert;
        Queue<ArrayList<Integer>> holder = new LinkedList();
        List<ArrayList<Integer>> visited = new LinkedList();
        Map<ArrayList<Integer>, List<ArrayList<Integer>>> vertmap = new HashMap<ArrayList<Integer>, List<ArrayList<Integer>>>();

        ArrayList<Integer> cur = m_Start;
        holder.add(cur);
        while (!holder.isEmpty()) {
            cur = holder.remove();
            if (cur.equals(m_Final)) {
                break;
            } else {
                vert = getConnectedVertices(cur);
                for (ArrayList<Integer> test : vert) {
                    if (!visited.contains(test)) {
                        holder.add(test);
                        visited.add(test);
                    }
                }
                vertmap.put(cur, vert);
            }
        }
        if (!(cur.equals(m_Final) && accept) || (cur.equals(m_Final) && accept)) {
            ArrayList<Integer> prev = m_Start;
            for () {
                List<ArrayList<Integer>> index = vertmap.get(prev.get(0));
                int i = 0;
                for (ArrayList<Integer> next = index.get(i); !next.isEmpty(); next = index.get(i)) {
                    path = path + getRoadActionChar(prev, next);
                    ++i;
                }
            }
            return path;
        }
        return null;
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

    public String getRoadActionChar(ArrayList<Integer> start, ArrayList<Integer> end) {
        if (start.equals(end)) {
            return "";
        }
        for (int i = 0; i < m_Roads.size(); i++) {
            if (m_Roads.elementAt(i).getStart().equals(start) && m_Roads.elementAt(i).getFinal().equals(end)) {
                return (m_Roads.elementAt(i).getRoadActionChar());
            }
        }
        return "";
    }

    public List<ArrayList<Integer>> getConnectedVertices(ArrayList<Integer> vertex) {
        List<ArrayList<Integer>> result = new LinkedList();
        for (int i = 0; i < m_Roads.size(); i++) {
            if (m_Roads.elementAt(i).getStart().equals(vertex)) {
                result.add(m_Roads.elementAt(i).getFinal());
            }
        }
        return result;
    }
}
