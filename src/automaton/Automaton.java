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
            for (int j = 0; j < aut.m_Roads.size(); j++) {
            rstart.clear();
            rfinish.clear();
                if ((this.m_Roads.elementAt(i).getAction() == aut.m_Roads.elementAt(j).getAction()) || (aut.m_Roads.elementAt(j).getStart() == aut.m_Roads.elementAt(j).getFinal())) { //als de intersectie klopt, road combineren en toevoegen
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
        Queue<ArrayList<Integer>> holder = new LinkedList();
        List<ArrayList<Integer>> visited = new LinkedList();
        Map<ArrayList<Integer>, ArrayList<Integer>> vertmap = new HashMap<ArrayList<Integer>, ArrayList<Integer>>();

        ArrayList<Integer> cur = m_Start;
        holder.add(cur);
        while (!holder.isEmpty()) {
            cur = holder.remove();
            if (cur.equals(m_Final)) {
                break;
            } else {
                for (ArrayList<Integer> vert : getConnectedVertices(cur)) {
                    if (!visited.contains(vert)) {
                        holder.add(vert);
                        visited.add(vert);

                        vertmap.put(vert, cur);
                    }

                }
            }
        }
        if (!(cur.equals(m_Final) && accept) || (cur.equals(m_Final) && accept)) {
            ArrayList<Integer> prev = m_Final;
            ArrayList<Integer> next;
            for (next = m_Final; !next.equals(m_Start); next = vertmap.get(next)) {
                path = path + getRoadActionChar(next, prev);
                prev = next;
            }
            path = path + getRoadActionChar(next, prev);
            path = new StringBuilder(path).reverse().toString();
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
