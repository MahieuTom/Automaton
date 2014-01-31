/*
 * This Automaton Project is made by Ghijs Kilani and Tom Mahieu
 */

package automaton;

import java.io.FileInputStream;

/**
 *
 * @author .
 */
public class AutomatonParser {
    /**
     * TODO: parse!
     * @param filename 
     */
    public AutomatonParser(String filename){
        FileInputStream inputStream = new FileInputStream(filename);
        try {
            String everything = IOUtils.toString(inputStream);
        } finally {
            inputStream.close();
        }
        
        char = 'D';
        AutomatonActions aa = aa.getAction(c);
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
