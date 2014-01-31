/*
 * This Automaton Project is made by Ghijs Kilani and Tom Mahieu
 */

package automaton;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author .
 */
public class AutomatonParser {
    /**
     * TODO: parse!
     * @param filename 
     */
    public AutomatonParser(String filename) throws Exception{
        FileInputStream stream = new FileInputStream(filename);
        DataInputStream in = new DataInputStream(stream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String s;
        while ((s = br.readLine()) != null)   {
            if(s.matches("(START) |- ")){
                s.replaceFirst("(START) |- ", "");
                int start = Integer.parseInt(s);
            }else if(s.matches(" -| (FINAL) ")){
                s.replaceFirst(" -| (FINAL) ", "");
                int einde = Integer.parseInt(s);
            }else{
                ;
            }
            System.out.println(s);
        }
        in.close();
        
        char c = 'D';
        AutomatonActions aa = AutomatonActions.EMPTY;
        aa = aa.getAction(c);
    }
    
    
    
    /**
     * 
     * @throws Exception 
     */
    public void parse() throws Exception{
        throw new Exception("File not formatted right!");
    }
    
    /**
     * 
     * @return 
     */
    public Automaton automaton(){
        return null;
    }
}
