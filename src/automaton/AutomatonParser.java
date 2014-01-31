/*
 * This Automaton Project is made by Ghijs Kilani and Tom Mahieu
 */

package automaton;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Parse een '.aut' bestand.
 * @author Tom Mahieu
 */
public class AutomatonParser {
    private boolean startGevonden = false;
    private boolean finalGevonden = false;
    private String file;
    private Automaton automaton;
    
    /**
     * Begin het parsen van de Automaton.
     * @param filename deze moet '.aut' extentie bevatten
     */
    public AutomatonParser(String filename){
        if (filename.matches(".aut")){
            file = filename;
            try {
                parse();
            }catch(Exception e){
                System.err.println("File not formatted right!");
            }
            
        } else
            System.err.println("File extention is not correct.");
    }
    
    
    
    /**
     * Gaat iedere lijn in het in te lezen bestand af om het te verwerken.
     * @throws Exception Error in het parsen.
     */
    public void parse() throws Exception{
        FileInputStream stream = new FileInputStream(file);
        DataInputStream in = new DataInputStream(stream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String s;
        while ((s = br.readLine()) != null)   {
            editAtomaton(s);
            System.out.println(s);
        }
        in.close();
        
        if(!startGevonden && !finalGevonden){
            throw new Exception();
        }
    }
    
    /**
     * Controleer een string en voeg het toe aan de automaton.
     * @param s de string die moet gecontroleerd worden.
     */
    private void editAtomaton(String s) throws Exception{
        if(s.matches("(START) |- ")){
            s = s.replaceFirst("(START) |- ", "");
            automaton.setStart(Integer.parseInt(s));
            startGevonden = true;
        }else if(s.matches(" -| (FINAL) ")){
            s = s.replaceFirst(" -| (FINAL) ", "");
            automaton.setFinal(Integer.parseInt(s));
            finalGevonden = true;
        }else{
            int start,end;
            AutomatonActions action;
            String[] output = new String[3];
            AutomatonRoad road;
            
            output = s.split(" "); //TODO: safe & correct???
            start = Integer.parseInt(output[0]);
            end = Integer.parseInt(output[1]);
            action = AutomatonActions.getAction((output[2].charAt(0)));
            road = new AutomatonRoad(start,end,action);
            
            automaton.addRoad(road);
        }
    }
    
    /**
     * Geeft de berekende automaton terug.
     * @return de berekende automaton.
     */
    public Automaton automaton(){
        return automaton;
    }
}
