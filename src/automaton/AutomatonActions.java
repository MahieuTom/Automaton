/*
 * This Automaton Project is made by Ghijs Kilani and Tom Mahieu
 */

package automaton;

/**
 * Acties omzetten naar 
 * @author Tom Mahieu
 */
public enum AutomatonActions {
    DRAGON,
    SWORD,
    ARC,
    RIVER,
    KEY,
    GATE,
    TREASURE,
    EMPTY;
    
    /**
     * Karakter die in de file staat wordt omgezet tot een actie.
     * @param c karakter die in de file staat wordt omgezet tot een actie.
     * @return actie die een traject heeft.
     * @throws java.lang.Exception als het karakter niet herkent word.
     */
    public AutomatonActions getAction(char c) throws Exception{
        switch(c){
            case 'D':
            case 'd':
                return DRAGON;
            case 'S':
            case 's':
                return SWORD;
            case 'A':
            case 'a':
                return ARC;
            case 'R':
            case 'r':
                return RIVER;
            case 'K':
            case 'k':
                return KEY;
            case 'G':
            case 'g':
                return GATE;
            case 'T':
            case 't':
                return TREASURE;
            case '$':
                return EMPTY;
        } throw new Exception("File not formatted right!");
    }
}
